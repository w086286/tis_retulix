package common.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns= {"*.do"},
		initParams= {
				@WebInitParam(name="config", value="C:\\Users\\2class-004\\git\\tis_retulix\\WebContent\\WEB-INF\\command.properties")
		})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> cmdMap= new HashMap<>();
       
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		String props= config.getInitParameter("config");
		
		Properties pr= new Properties();
		try {
			FileInputStream fis= new FileInputStream(props);
			pr.load(fis);
			
			fis.close();
			
			Enumeration<Object> en= pr.keys();
			while(en.hasMoreElements()) {
				Object key= en.nextElement();
				String cmd= key.toString();				//index.do가 들어옴
				String className=pr.getProperty(cmd);	//xxxIndexAction
				
				if(className != null) {
					className=className.trim();
				}
				
				Class cls= Class.forName(className);
				Object cmdObj= cls.newInstance();		//객체를 메모리에 올려줌
				
				cmdMap.put(cmd,  cmdObj);			//만들어둔 맵에 저장
			}//--while
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);				//브라우저에 예외 출력해주기
		}
	}

	/* get이나 post나 관계없이 process라는 메소드로 전송해줄거임 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		String path= req.getServletPath();
		
		Object obj=cmdMap.get(path);
		
		if(obj==null) {
			return;
		}
		
		AbstractAction action= (AbstractAction)obj;
		//obj는 path의 value값. 형변환 해줘야됨
		//AbstractAction에는 viewPage와 isRedirect가 들어있고 Command를 상속받고있다
		
		try {
			action.execute(req, res);			//서브컨트롤러의 일을 수행한다
			
			//이동할 뷰페이지 지정
			String viewPage= action.getViewPage();
			if(viewPage==null) {
				viewPage="index.jsp";
			}
			
			//이동방식에 따라 해당 뷰페이지로 이동
			if(action.isRedirect()) {
				res.sendRedirect(viewPage);
			}
			else {
				//isRedirect가 false일 경우 경로지정
				RequestDispatcher disp= req.getRequestDispatcher(viewPage);
				disp.forward(req, res);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);			//에러를 화면에 띄워주세요
		}
	}
	

}
