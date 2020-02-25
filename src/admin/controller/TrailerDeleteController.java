package admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

public class TrailerDeleteController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("[TrailerDeleteController] ## FROM .. trailerDelete.do");
		
		String idx= req.getParameter("idx");
		if(idx==null || idx.trim().isEmpty()) {
			String msg="잘못된 접근입니다 [parameter:none]";
			String loc="index.do";
			req.setAttribute("msg", msg);
			req.setAttribute("loc", loc);
			this.setViewPage("/message.jsp");
			this.setRedirect(false);
		}
		
		System.out.println(idx+"   !!!아직 컨트롤러 DAO MAPPER 뷰페이지등등 구현안함!!!!!");
		/* 컨텐츠삭제 구현 해야함*/
		
	}

}
