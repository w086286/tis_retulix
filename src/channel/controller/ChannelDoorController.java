package channel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

public class ChannelDoorController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse res) throws Exception {
		this.setViewPage("/channel/chDoor.jsp");	//jsp파일은 실제 디렉토리 경로로 작성
		this.setRedirect(false);
	}

}
