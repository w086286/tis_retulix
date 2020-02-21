package trailer_view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import trailer_view.domain.Trailer_view;
import trailer_view.persistence.Trailer_view_DAOMyBatis;

public class Trailer_view_rdlist extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Trailer_view_DAOMyBatis dao = new Trailer_view_DAOMyBatis();
		
		Trailer_view big = dao.selectOne();
		List<Trailer_view> arr=dao.selectPoster(big.getIdx());
		
		req.setAttribute("mvo", big);
		req.setAttribute("arr", arr);
		System.out.println(arr);
		this.setViewPage("new.jsp");
		this.setRedirect(false); 

	}

}
