package common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.domain.MemberVO;


@WebFilter(urlPatterns = {"/member/*","/admin/*"} )
public class LoginCheckFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("LoginCheckFilter started...");
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession();
		MemberVO user=(MemberVO)session.getAttribute("loginUser");
		if(user==null) {
			String msg="로그인 후 이용할 수 있습니다";
			String loc=req.getContextPath()+"/index.do";
			req.setAttribute("msg", msg);
			req.setAttribute("loc", loc);
			RequestDispatcher disp=req.getRequestDispatcher("/message.jsp");
			disp.forward(req, response);
			return;
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
