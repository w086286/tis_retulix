package main.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import common.domain.TrailerVO;
import main.domain.subscribeVO;
import main.persistence.mainDAOMyBatis;

public class mainController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		mainDAOMyBatis dao=new mainDAOMyBatis();
		String email_subs="";
		List<subscribeVO> arr=dao.listMain(email_subs);
		req.setAttribute("email_subs", arr);
		
		String url="";
		List<TrailerVO> arr2=dao.most_Good(url);
		req.setAttribute("url", arr2);

		String SF_title="";
		List<TrailerVO> arr3=dao.SF_Movie(SF_title);
		req.setAttribute("title", arr3);
		
		
		
	}

}
