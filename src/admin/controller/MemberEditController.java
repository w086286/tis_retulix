package admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.persistence.MemberDAO;
import common.controller.AbstractAction;
import common.domain.MemberVO;

public class MemberEditController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("[MemberEditController] ## FROM.. memberEdit.do");
		
		String email= req.getParameter("email");
		//유효성
		if(email==null || email.trim().isEmpty()) {
			String msg="잘못된 경로입니다";
			String loc="index.do";
			req.setAttribute("msg", msg);
			req.setAttribute("loc", loc);
			this.setViewPage("/message.jsp");
			this.setRedirect(true);
			return;
		}
		
		MemberDAO dao= new MemberDAO();
		//잘못된 email입력된 경우
		MemberVO member= dao.listOneMember(email);
		if(member==null) {
			String msg="잘못된 접근입니다";
			String loc="index.do";
			req.setAttribute("msg", msg);
			req.setAttribute("loc", loc);
			this.setViewPage("/message.jsp");
			
			return;
		}
		
		req.setAttribute("member", member);
		
		this.setViewPage("/admin/memberInfoEdit.jsp");
		this.setRedirect(false);
	}

}
