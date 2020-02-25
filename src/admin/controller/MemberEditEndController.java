package admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.persistence.MemberDAO;
import common.controller.AbstractAction;
import common.domain.MemberVO;

public class MemberEditEndController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("[MemberEditEndController] ## FROM.. memberEdit.do");
		
		String email= req.getParameter("email");
		//유효성
		if(email==null || email.trim().isEmpty()) {
			String msg="잘못된 경로입니다";
			String loc="index.do";
			req.setAttribute("msg", msg);
			req.setAttribute("loc", loc);
			this.setViewPage("/message.jsp");
			return;
		}
		MemberDAO dao= new MemberDAO();
		
		//해당 멤버vo 불러오고
		MemberVO member= dao.listOneMember(email);
		//기존정보 따로 저장하고
		MemberVO oldMember= dao.listOneMember(email);
		
		member.setName(req.getParameter("name"));
		member.setPoint(Integer.parseInt(req.getParameter("point")));
		member.setState(Integer.parseInt(req.getParameter("state")));
		
		int n= dao.updateMember(member);
		//바뀐멤버vo 다시가져와
		MemberVO newMember= dao.listOneMember(email);
		
		req.setAttribute("newMember", newMember);
		req.setAttribute("oldMember", oldMember);
		
		this.setViewPage("/admin/memberInfo.jsp");
		this.setRedirect(false);

	}

}
