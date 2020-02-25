package trailer_view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import trailer_view.domain.Trailer_view;
import trailer_view.persistence.Trailer_view_DAOMyBatis;

public class Trailer_view_cklist extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Trailer_view_DAOMyBatis dao = new Trailer_view_DAOMyBatis();
		
		String num = req.getParameter("idx");
		System.out.println("idx 체크"+num);
		Trailer_view mvo = dao.selectTest(num);
		
		List<Trailer_view> arr=dao.selectPoster(num);
		
		req.setAttribute("mvo", mvo);
		req.setAttribute("arr", arr);
		this.setViewPage("mList/new.jsp");
		this.setRedirect(false); 
		
	
	}

}
