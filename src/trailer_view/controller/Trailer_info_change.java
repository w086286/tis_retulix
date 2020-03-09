package trailer_view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import trailer_view.persistence.Trailer_view_DAOMyBatis;

public class Trailer_info_change extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String tmp[] =req.getParameterValues("tdArr");
		/*
		 * System.out.println("제목"+tmp[0]); System.out.println("내용 "+tmp[1]);
		 * System.out.println("개봉일 "+tmp[2]); System.out.println("원제목 "+tmp[3]);
		 * System.out.println("api번호 "+tmp[4]);
		 */
		String tmp2[]= {tmp[0],tmp[4],tmp[5]};
		Trailer_view_DAOMyBatis dao = new Trailer_view_DAOMyBatis();
		int result = dao.find_update(tmp2);
		System.out.println("트레일러 변경 "+result);
		req.setAttribute("result", result);
		this.setViewPage("mList/dbRefresh.jsp");
		this.setRedirect(false);
		
		
	}

}
