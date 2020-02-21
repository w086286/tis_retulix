package trailer_view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import trailer_view.domain.Trailer_view;
import trailer_view.persistence.Trailer_view_DAOMyBatis;

public class Trailer_view_viewlist extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Trailer_view_DAOMyBatis dao = new Trailer_view_DAOMyBatis();
		Trailer_view mvo=dao.selectTest();
	
		
		req.setAttribute("mvo", mvo);
		
		
		this.setViewPage("new.jsp");
		this.setRedirect(false); 
	}
}

/*
 * //String tmp = mvo.getIdx_num();
		
		//List<Movies> arr=dao.selectPoster(tmp);
		//req.setAttribute("poster", arr);
 */
