package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import user.model.NotUserException;
import user.model.UserDAO;
import user.model.UserVO;

public class LoginController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 1. ���̵�, ���, ���̵����� ���� �� �ޱ�
		String userid = req.getParameter("userid");
		String pwd = req.getParameter("pwd");
		String saveId = req.getParameter("saveId");
		// 2. ��ȿ�� üũ
		if (userid == null || pwd == null) {
			req.setAttribute("msg", "�߸� ���� ����Դϴ�.");
			req.setAttribute("loc", "index.do");
			this.setRedirect(false);
			this.setViewPage("message.jsp");
			return;
		}

		// 3. UserDAO���� loginCheck()ȣ�� =>���� �߻�
		UserDAO udao = new UserDAO();

		try {
			UserVO user = udao.loginCheck(userid, pwd);
			// ���̵�,��� Ʋ�� ��� NotUserException�� �߻���

			// 4. �α��� ������ �޾Ҵٸ� UserVO�� ���ǿ� �����Ѵ�.
			HttpSession ses = req.getSession();
			if (user != null) {
				ses.setAttribute("loginUser", user);

			}

			this.setViewPage("index.do");
			this.setRedirect(true);
		} catch (NotUserException e) {
			//5. �α��� ���н�
			req.setAttribute("msg", e.getMessage());
			req.setAttribute("loc", "index.do");
			this.setRedirect(false);
			this.setViewPage("message.jsp");
			return;
		}

	}

}
