package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.domain.MemberVO;
import common.persistence.LoginDAOMyBatis;

public class LoginCheckController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String email=req.getParameter("email");
		String pwd=req.getParameter("pwd");
		String saveId=req.getParameter("saveId");
		//System.out.println(userId+"/"+userPwd+"/"+saveId);
		
		
		if(email==null || pwd==null || email.trim().isEmpty() || pwd.trim().isEmpty()) {
			req.setAttribute("msg", "잘못 된 경로입니다");
			req.setAttribute("loc", "index.do");
			this.setViewPage("message.jsp");
			this.setRedirect(false);
			return;
		}
		
		LoginDAOMyBatis dao=new LoginDAOMyBatis();
		MemberVO user=dao.loginCheck(email, pwd);
		if(user==null) {
			req.setAttribute("msg", "잘못된 로그인 정보입니다.");
			req.setAttribute("loc", "javascript:history.back()");
			this.setViewPage("message.jsp");
			this.setRedirect(false);
			return;
		}
		
		HttpSession session=req.getSession();
		session.setAttribute("loginUser", user);
		this.setViewPage("index.do");
		this.setRedirect(true);
	}

}