package main.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import main.domain.TrailerVO;
import main.persistence.searchDAOMyBatis;

public class searchController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String keyword=req.getParameter("findKeyWord");
		
		
		searchDAOMyBatis dao=new searchDAOMyBatis();
		List<TrailerVO> arr=dao.searchList(keyword);
		
		req.setAttribute("findKeyWord", keyword);
		
		this.setViewPage("test.jsp");
		this.setRedirect(false);

	}

}
