package admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.persistence.NoticeDAO;
import common.controller.AbstractAction;
import common.domain.NoticeVO;

public class NoticeEditEndController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("[NoticeEditEndController] ## FROM.. noticeEditEnd.do");
		
		String idx= req.getParameter("idx");
		String title= req.getParameter("title");
		String info= req.getParameter("info");
		String click= req.getParameter("click");
		String name= req.getParameter("name");
		
		NoticeDAO dao= new NoticeDAO();
		//유효성
		NoticeVO isNotice= dao.selectOneNotice(idx);
		if(isNotice==null) {
			String msg="잘못된 접근입니다 [parameter:none]";
			String loc="index.do";
			req.setAttribute("msg", msg);
			req.setAttribute("loc", loc);
			this.setViewPage("/message.jsp");
			return;
		}

		NoticeVO notice= new NoticeVO(Integer.parseInt(idx),title,info,null,Integer.parseInt(click),name);
		
		int n= dao.updateNotice(notice);

		String msg= (n>0)?"게시글이 수정되었습니다":"수정에 실패하였습니다";
		String loc= (n>0)?"noticeMain.do":"javascript:history.back()";
		
		req.setAttribute("msg", msg);
		req.setAttribute("loc", loc);
		
		this.setViewPage("message.jsp");
		this.setRedirect(false);
	}

}
