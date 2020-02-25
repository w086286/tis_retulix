package admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.persistence.TrailerDAO;
import common.controller.AbstractAction;
import common.domain.PagingVO;
import common.domain.TrailerVO;

public class TrailerSearchFormController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("[TrailerSearchFormController] ## FROM. trailerSearch.do");
				
		String cpageStr= req.getParameter("cpage");
		if(cpageStr==null || cpageStr.trim().isEmpty()) {
			cpageStr="1";
		}
		int cpage= Integer.parseInt(cpageStr);
		
		TrailerDAO dao= new TrailerDAO();
		PagingVO paging= new PagingVO(cpage, 10, 5);
		paging.setSelectBox(req.getParameter("selectBox"));
		paging.setSearchInput(req.getParameter("searchInput"));
		paging.setTotalCount(dao.getTotalSearchTrailer(paging.getSelectBox(),paging.getSearchInput()));
		paging.init();
		
		//검색이 공란이면 전체리스트로 돌아간다
		if(paging.getSelectBox()==null || paging.getSelectBox().trim().isEmpty()) {
			this.setViewPage("trailerList.do");
			this.setRedirect(true);
			return;
		}
		if(paging.getSearchInput()==null || paging.getSearchInput().trim().isEmpty()) {
			this.setViewPage("trailerList.do");
			this.setRedirect(true);
			return;
		}
		
		List<TrailerVO> arr= dao.searchTrailer(paging.getSelectBox(),paging.getSearchInput(),paging.getStart(),paging.getEnd());
		//유효성-파라미터조작
		if(arr.size()<=0) {
			String msg="목록을 찾을 수 없습니다 [result:none]";
			String loc="javascript:history.back()";
			req.setAttribute("msg", msg);
			req.setAttribute("loc", loc);
			this.setViewPage("/message.jsp");
			return;
		}
		
		req.setAttribute("paging", paging);
		req.setAttribute("pageNavi", paging.getPageNavi(req.getContextPath(), "trailerSearch.do", false));
		req.setAttribute("searchTrailer", arr);
		
		this.setViewPage("/admin/trailerSearch.jsp");
		this.setRedirect(false);
	}

}
