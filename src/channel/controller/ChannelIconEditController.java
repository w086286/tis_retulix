package channel.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import common.controller.AbstractAction;

public class ChannelIconEditController extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//디렉토리 생성
		ServletContext app=req.getServletContext();
		String upDir=app.getRealPath("images/userIcon");
		File dir=new File(upDir);
		if(!dir.exists()) dir.mkdir();
		
		//파일 업로드
		MultipartRequest mreq=new MultipartRequest(req, upDir, 6*1024*1024, "UTF-8");
		String email=mreq.getParameter("email");
		File upload=mreq.getFile("btUpUserIcon");
		
		String fileName=upDir+"/"+(upload.getName());	//원본 파일명
		String reName=upDir+"/"+email;					//바꿀 파일명
		
		int lio=(upload.getName()).lastIndexOf(".");
		String format=(upload.getName()).substring(lio+1).toLowerCase();//확장자만 추출

		long fileSize=upload.length();

		//유효성 체크
		if(!format.equals("png") && !format.equals("jpg") && !format.equals("jpeg") && !format.equals("gif")) {
			req.setAttribute("msg", "JPG, GIF 또는 PNG파일을 업로드하고 있는지 확인한 다음 다시 시도하세요");
			req.setAttribute("loc", "javascript:history.back()");
			this.setViewPage("message.jsp");
			this.setRedirect(false);
			return;
		}
		if(fileSize>((long)6*1024*1024)) {
			req.setAttribute("msg", "파일 용량이 너무 큽니다. 파일의 크기가 6MB 이하인지 확인한 다음 다시 시도하세요");
			req.setAttribute("loc", "javascript:history.back()");
			this.setViewPage("message.jsp");
			this.setRedirect(false);
			return;
		}
		
		//if(new File(fileName).exists()) new File(fileName).delete();	//회원이 업로드한 이름의 파일이 이전에 있으면 지워 --> 같은이름(1) 이런식으로 저장 안되게
		//new File(reName).exists()
		//새로 설정한 이름이 이전에 존재하면
		//업로드 날짜랑 대조해서 오늘 날짜보다 작으면 지워
		/*
		if(new File(reName).exists()) {
			String files[]=dir.list();
			for(String f: files) {
				int index=(f.lastIndexOf("."));
				String fName=f.substring(0, index);
				if(email.equals(fName)) {
					System.out.println(fName);
				}
			}			
		}
		*/
		
		//업로드 파일명 변경
		//if(new File(reName).exists()) new File(fileName).delete();
		/*
		 * ★★★★★★★★★★여기 덮어쓰기 로직 짜다가 말았음★★★★★★★★
		 * */
		if(new File(fileName).exists()) new File(fileName).renameTo(new File(reName+"."+format));
		

		boolean fileExist=new File(reName).exists();
		String msg=(!fileExist)? "아이콘이 성공적으로 변경되었습니다":"아이콘 변경이 실패했습니다";
		String loc=(!fileExist)? "chInfo.do":"javascript:history.back()";
		req.setAttribute("msg", msg);
		req.setAttribute("loc", loc);
		
		this.setViewPage("message.jsp");
		this.setRedirect(false);
	}

}
