package admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

public class TrailerInsertEndController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("[trailerInsertEndController] ## FROM. trailerInsertEnd.do");
			
		/* 여기에 인서트문 작성하고 setAttribute()한 후에 돌아간다 */
		
		
		//이거는 임시로 contentList 보이게 해놓은거---------
//		List<ContentVO> arr= contentDAO.listContent(start, end);
//		
//		req.setAttribute("listContent", arr);
		//---------------------------------------------
		
		this.setViewPage("trailerInsert.do");
		this.setRedirect(false);
		
	}

}
