package admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.persistence.TrailerDAO;
import common.controller.AbstractAction;
import common.domain.TrailerVO;

public class TrailerViewController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("[TrailerViewController] ## FROM. trailerView.do");
		
		String idx= req.getParameter("idx");
		if(idx==null || idx.trim().isEmpty()) {
			String msg="결과를 찾을 수 없습니다 [result:none]";
			String loc="javascript:history.back()";
			req.setAttribute("msg", msg);
			req.setAttribute("loc", loc);
			this.setViewPage("/message.jsp");
			return;
		}
		
		TrailerDAO dao= new TrailerDAO();
		TrailerVO trailer= dao.selectOneTrailer(idx);
		//유효성
		if(trailer==null) {
			String msg="잘못된 접근입니다 [parameter:none]";
			String loc="index.do";
			req.setAttribute("msg", msg);
			req.setAttribute("loc", loc);
			this.setViewPage("/message.jsp");
			return;
		}
		
		req.setAttribute("trailer", trailer);
		
		this.setViewPage("/admin/trailerView.jsp");
		this.setRedirect(false);
	}

}
