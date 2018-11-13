package mvc.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class EventExpireChk extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//return super.preHandle(request, response, handler);
		
		//request로 들어올것
		String url = request.getContextPath()+"/interceptor/event"; //프로젝트 경로
		
		HttpSession session = request.getSession(); //세션불러오기
		System.out.println("세션불러오기");
		System.out.println(url);
		System.out.println(request.getRequestURI());
		/*if(request.getRequestURI().equals(url)) {//if문 돌릴것
			response.sendRedirect("https://cafe.naver.com/jx007s");
			//이 프로젝트로 들어오는건 전부 sendRedirect로 이동된다
			return false;
		}*/
		if(request.getRequestURI().equals(url) && session.getAttribute("pid")==null) {//if문 돌릴것
			response.sendRedirect("expire");
			//이 프로젝트로 들어오는건 전부 sendRedirect로 이동된다
			return false;
		}
		return true;
	}
}
