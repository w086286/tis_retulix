package channel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import channel.domain.StatVO;
import channel.persistence.ChannelDAOmybatis;
import common.controller.AbstractAction;

public class ChannelStatController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String email=req.getParameter("email");
		String pwd=req.getParameter("pwd");
		String type=req.getParameter("statType");
		String keyword=req.getParameter("statKeyword");
		String crtPageStr=req.getParameter("crtPage");	//현재 페이지
		int pageSize=10;		//한 페이지에 보여줄 게시글 수
		int pageCount=1;		//페이지 수
		int totalCount=0;		//총 게시글 수
		
		//유효성 체크
		if(email==null || pwd==null || email.trim().isEmpty() || pwd.trim().isEmpty()) {
			req.setAttribute("msg", "로그인해야 이용할 수 있습니다");
			req.setAttribute("loc", "index.do");
			this.setRedirect(false);
			this.setViewPage("message.jsp");
			System.out.println("!!--nullPointer @ChannelStatController.execute()--!!");
			return;
		}
		if(crtPageStr==null || crtPageStr.trim().isEmpty()) crtPageStr="1";
		
		//System.out.println(email+"/"+pwd+"/"+type+"/"+keyword);
		
		//총 게시글 수 추출
		ChannelDAOmybatis dao=new ChannelDAOmybatis();
		totalCount=dao.getTotalCount(email, type, keyword);
		
		//pagination
		pageCount=(totalCount-1)/pageSize+1;
		int crtPage=Integer.parseInt(crtPageStr.trim());
		if(crtPage>pageCount) crtPage=pageCount;
		if(crtPage<1) crtPage=1;
		
		//System.out.println(totalCount+"/"+pageCount+"/"+pageSize);
		
		//시작값, 끝값 연산
		int end=crtPage*pageSize;
		int start=end-(pageSize-1);
		
		List<StatVO> arr=dao.showUserStat(email, start, end, type, keyword);
		//List<StatVO> arr=dao.showUserStat(email);

		req.setAttribute("statArr", arr);
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("pageSize", pageSize);
		req.setAttribute("crtPage", crtPage);
		req.setAttribute("pageCount", pageCount);
		
		this.setViewPage("/channel/chStat.jsp");
		this.setRedirect(false);
	}

}
