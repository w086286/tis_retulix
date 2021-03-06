package trailer_view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import common.domain.ReviewVO;
import trailer_view.domain.Trailer_view;
import trailer_view.persistence.Trailer_view_DAOMyBatis;

public class Trailer_view_rdlist extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Trailer_view_DAOMyBatis dao = new Trailer_view_DAOMyBatis();
		
		Trailer_view big = dao.selectOne();
		List<Trailer_view> arr=dao.selectPoster(big.getIdx());
		List<ReviewVO> arr2 = dao.selectReview(big.getIdx());
		req.setAttribute("mvo", big);
		req.setAttribute("arr", arr);
		req.setAttribute("reviews", arr2);
		System.out.println("idx뭐냐"+arr2.get(0).getIdx());
		this.setViewPage("mList/new.jsp");
		this.setRedirect(false); 

	}

}
