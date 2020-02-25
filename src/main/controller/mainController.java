package main.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import main.domain.TrailerVO;
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

		String MS_title=""; //sf영화
		List<TrailerVO> SFdao=dao.SF_Movie(MS_title);
		req.setAttribute("MS_title", SFdao);
		
		String MC_title=""; //코미디 영화
		List<TrailerVO> MCdao=dao.CO_Movie(MC_title);
		req.setAttribute("MC_title", MCdao);
		
		String MA_title=""; //액션 영화
		List<TrailerVO> MAdao=dao.AC_Movie(MA_title);
		req.setAttribute("MA_title", MAdao);
		
		String MH_title=""; //호러 영화
		List<TrailerVO> MHdao=dao.HO_Movie(MH_title);
		req.setAttribute("MH_title", MHdao);

		String MR_title=""; //로맨스 영화
		List<TrailerVO> MRdao=dao.RO_Movie(MR_title);
		req.setAttribute("MR_title", MRdao);
		
		String D_title=""; //드라마
		List<TrailerVO> Ddao=dao.Drama(D_title);
		req.setAttribute("D_title", Ddao);
		
		
	}

}
