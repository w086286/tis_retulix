package admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.persistence.TrailerDAO;
import common.controller.AbstractAction;
import common.domain.TrailerVO;

public class TrailerEditPreviewController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("[TrailerEditPreviewController] ## FROM. trailerEditPreview.do");
		
		/* 트레일러 수정은 다시 만져야함 api받아오는거에 따라서 */
		String idx= req.getParameter("idx");
		//유효성
		if(idx==null || idx.trim().isEmpty()) {
			String msg="목록을 찾을 수 없습니다 [result:none]";
			String loc="javascript:history.back()";
			req.setAttribute("msg", msg);
			req.setAttribute("loc", loc);
			this.setViewPage("/message.jsp");
			return;
		}
		TrailerDAO dao= new TrailerDAO();
		TrailerVO isTrailer= dao.selectOneTrailer(idx);
		if(isTrailer==null) {
			String msg="잘못된 접근입니다 [parameter:none]";
			String loc="index.do";
			req.setAttribute("msg", msg);
			req.setAttribute("loc", loc);
			this.setViewPage("/message.jsp");
			return;
		}
		
		String title= req.getParameter("title");
		String director= req.getParameter("director");
		String release= req.getParameter("release");
		String info= req.getParameter("info");
		
		
		TrailerVO trailer= new TrailerVO(null,null,null,null,null,null,title,0,0,0,"admin@admin.com");
		req.setAttribute("trailer", trailer);
		
		this.setViewPage("admin/trailerPreview.jsp");
		this.setRedirect(false);
		
	}

}
