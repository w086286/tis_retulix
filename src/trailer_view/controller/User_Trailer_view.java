package trailer_view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

public class User_Trailer_view extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		this.setViewPage("mList/new.jsp");
		this.setRedirect(false); 

	}

}
