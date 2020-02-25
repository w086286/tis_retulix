package channel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

import common.domain.MemberVO;
import channel.persistence.ChannelDAOmybatis;

public class ChannelInfoController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String email=req.getParameter("email");
		String pwd=req.getParameter("pwd");
		//System.out.println(email+"/"+pwd);
		
		if(email==null || pwd==null || email.trim().isEmpty() || pwd.trim().isEmpty()) {
			req.setAttribute("msg", "잘못된 접근: 로그인해야 이용할 수 있습니다");
			req.setAttribute("loc", "index.do");
			this.setRedirect(false);
			this.setViewPage("message.jsp");
			System.out.println("!!--nullPointer @ChannelInfoController.execute()--!!");
			return;
		}
		
		ChannelDAOmybatis dao=new ChannelDAOmybatis();
		MemberVO vo=dao.showUserInfo(email);

		req.setAttribute("userInfo", vo);
		
		this.setViewPage("/channel/chInfo.jsp");
		this.setRedirect(false);
	}

}
