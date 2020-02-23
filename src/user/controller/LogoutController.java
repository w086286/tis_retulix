package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;

public class LogoutController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession ses=req.getSession();
		ses.invalidate();//���Ǻ��� ��� ����
		this.setRedirect(true);
		this.setViewPage("index.do");
	}

}
