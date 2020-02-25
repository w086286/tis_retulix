package admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.persistence.TrailerDAO;
import common.controller.AbstractAction;
import common.domain.PagingVO;
import common.domain.TrailerVO;

public class TrailerListController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("[ContentListController] ## contentList.do 에서 넘어옴");
		
		String cpageStr= req.getParameter("cpage");
		if(cpageStr==null) {
			cpageStr="1";
		}
		int cpage= Integer.parseInt(cpageStr);
		
		TrailerDAO dao= new TrailerDAO();
		PagingVO paging= new PagingVO(dao.getTotalTrailer(), cpage, 10, 10);
		
		List<TrailerVO> arr= dao.listTrailer(paging.getStart(), paging.getEnd());
		//유효성
		if(arr.size()<=0) {
			String msg="목록을 찾을 수 없습니다 [result:none]";
			String loc="javascript:history.back()";
			req.setAttribute("msg", msg);
			req.setAttribute("loc", loc);
			this.setViewPage("/message.jsp");
			return;
		}
		
		req.setAttribute("listTrailer", arr);
		req.setAttribute("paging", paging);
		req.setAttribute("pageNavi", paging.getPageNavi(req.getContextPath(),"trailerList.do",false));
		
		this.setViewPage("/admin/trailerList.jsp");
		this.setRedirect(false);

	}

}
