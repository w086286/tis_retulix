package admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.domain.MemberContentVO;
import admin.persistence.TrailerDAO;
import common.controller.AbstractAction;
import common.domain.PagingVO;

public class MemberContentSearchFormController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("[MemberContentSearchFormController] ## FROM. memberContentSearch.do");
		
		String cpageStr= req.getParameter("cpage");
		if(cpageStr==null || cpageStr.trim().isEmpty()) {
			cpageStr="1";
		}
		int cpage= Integer.parseInt(cpageStr);

		TrailerDAO dao= new TrailerDAO();
		PagingVO paging= new PagingVO(cpage,10,5);
		paging.setSelectBox(req.getParameter("selectBox"));
		paging.setSearchInput(req.getParameter("searchInput"));
		paging.setTotalCount(dao.getTotalSearchMemberContent(paging.getSelectBox(),paging.getSearchInput()));
		paging.init();
		
		/* 인풋이 널일때-회원업로드 전체목록을 보여준다 */
		if(paging.getSelectBox()==null || paging.getSelectBox().trim().isEmpty()) {
			this.setViewPage("memberAllContent.do");
			this.setRedirect(true);
			return;
		}
		if(paging.getSearchInput()==null || paging.getSearchInput().trim().isEmpty()) {
			this.setViewPage("memberAllContent.do");
			this.setRedirect(true);
			return;
		}
		
		List<MemberContentVO> arr= dao.searchMemberContent(paging.getSelectBox(),paging.getSearchInput(),paging.getStart(),paging.getEnd());
		//유효성
		if(arr.size()<=0) {
			String msg="검색결과를 찾을 수 없습니다 [result:none]";
			String loc="javascript:history.back()";
			req.setAttribute("msg", msg);
			req.setAttribute("loc", loc);
			this.setViewPage("/message.jsp");
			return;
		}
		
		req.setAttribute("paging", paging);
		req.setAttribute("pageNavi", paging.getPageNavi(req.getContextPath(), "memberContentSearch.do", false));
		req.setAttribute("searchMemberContent", arr);
		
		this.setViewPage("/admin/memberContentSearch.jsp");
		this.setRedirect(false);
		
	}

}
