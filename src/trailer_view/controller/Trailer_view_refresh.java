package trailer_view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import common.domain.ReviewVO;
import trailer_view.domain.Trailer_view;
import trailer_view.persistence.Trailer_view_DAOMyBatis;

public class Trailer_view_refresh extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Trailer_view_DAOMyBatis dao = new Trailer_view_DAOMyBatis();
		String num=req.getParameter("title");
		//System.out.println("idx 체크2 "+num);
		Trailer_view mvo = dao.selectTest(num);
		
		req.setAttribute("mvo", mvo);
		this.setViewPage("mList/display_Refresh.jsp");
		this.setRedirect(false); 
		
	
	}

}
