package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.domain.MemberVO;

//index.jsp로 가기위한 첫걸음
public class IndexController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//세션에서 이메일 가져오기
		HttpSession session=req.getSession();
		MemberVO vo=(MemberVO) session.getAttribute("loginUser");
		String email=vo.getEmail();
		//System.out.println(email);
		
		req.setAttribute("email", email);
		
		this.setViewPage("/index.jsp");
		this.setRedirect(false);
	}

}
