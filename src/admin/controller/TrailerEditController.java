package admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.persistence.TrailerDAO;
import common.controller.AbstractAction;
import common.domain.TrailerVO;

public class TrailerEditController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("[TrailerEditController] executed ####");
		
		String idx= req.getParameter("idx");
		//유효성
		if(idx==null || idx.trim().isEmpty()) {
			String msg="잘못된 경로입니다";
			String loc="javascript:history.back()";
			req.setAttribute("msg", msg);
			req.setAttribute("loc", loc);
			
			this.setViewPage("/message.jsp");
			this.setRedirect(true);
			
			return;
		}
		
		TrailerDAO dao= new TrailerDAO();
		TrailerVO trailer= dao.selectOneTrailer(idx);
		//유효성-파라미터조작
		if(trailer==null) {
			String msg="잘못된 접근입니다 [parameter:none]";
			String loc="index.do";
			req.setAttribute("msg", msg);
			req.setAttribute("loc", loc);
			this.setViewPage("/message.jsp");
			return;
		}
		
		req.setAttribute("trailer", trailer);
		
		this.setViewPage("/admin/trailerEdit.jsp");
		this.setRedirect(false);
	}

}
