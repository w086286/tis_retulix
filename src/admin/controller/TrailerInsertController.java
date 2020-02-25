package admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

public class TrailerInsertController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("[TrailerInsertController] ## FROM.. trailerInsert.do");
		String email= req.getParameter("email");
		System.out.println(email);
		
		
		this.setViewPage("/admin/trailerInsert.jsp");
		this.setRedirect(false);
	}

}
