package admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

public class TrailerInsertPreviewController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String title= req.getParameter("title");
		String director= req.getParameter("director");
		String release= req.getParameter("release");
		String info= req.getParameter("info");
		
		req.setAttribute("title", title);
		req.setAttribute("director", director);
		req.setAttribute("release", release);
		req.setAttribute("info", info);
		
		/* 컨텐츠등록 수정해야함 */
		this.setRedirect(false);
		this.setViewPage("admin/contentPreview.jsp");
	}

}
