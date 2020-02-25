package channel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.domain.MemberVO;
import channel.persistence.ChannelDAOmybatis;
import common.controller.AbstractAction;

/** 개인정보 수정 클릭시 처리 */
public class ChannelInfoEditController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		/**회원 정보 수정*/
		String email=req.getParameter("email");
		String pwd=req.getParameter("pwd");
		String age=req.getParameter("age");
		String editPwd=req.getParameter("editPwd");
		String editPwdCheck=req.getParameter("editPwdCheck");
		//System.out.println(email+"/"+pwd+"/"+age+"/"+editPwd+"/"+editPwdCheck);
		
		//id, pwd null check
		if(email==null || pwd==null || email.trim().isEmpty() || pwd.trim().isEmpty()) {
			req.setAttribute("msg", "로그인해야 이용할 수 있습니다");
			req.setAttribute("loc", "javascript:history.back()");
			this.setViewPage("message.jsp");
			this.setRedirect(false);
			return;
		}
		//변경 비밀번호 일치 여부
		if(!editPwd.equals(editPwdCheck)) {
			req.setAttribute("msg", "변경할 비밀번호가 일치하지 않습니다");
			req.setAttribute("loc", "javascript:history.back()");
			this.setViewPage("message.jsp");
			this.setRedirect(false);
			return;
		}
		//비밀번호 변경 안할 경우
		if(editPwd==null || editPwd.trim().isEmpty()) {
			editPwd=pwd;
		}
		
		ChannelDAOmybatis dao=new ChannelDAOmybatis();
		MemberVO vo=new MemberVO(email, editPwd, null, age, 0, 0, null, null, 0);
		int n=dao.updateUserInfo(vo);
		String msg=(n>0)? "정보 수정 성공":"정보 수정 실패";
		String loc=(n>0)? "chInfo.do":"javascript:history.back()";
		
		req.setAttribute("msg", msg);
		req.setAttribute("loc", loc);
		
		this.setViewPage("message.jsp");
		this.setRedirect(false);
	}

}
