package mvc.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//aspect를 사용하기 위한 aop class 설정

@Service
@Aspect
public class AdminAspect2 {
	
	@Pointcut("execution(* mvc.controll.admin..*(..))")
	void admin() {	}
	
	
	HttpSession session; //session을 받아오려면 이렇게 설정
	HttpServletResponse response; // response를 받아오기 위해 설정

	@Around("admin()")
	Object loginArround(ProceedingJoinPoint joinPoint) throws Throwable {
		Object res = null;
		
		System.out.println("loginArround() 실행");
		
		for(Object obj : joinPoint.getArgs()) {
			if(obj instanceof HttpSession) {
				session = (HttpSession)obj;
			}
			if(obj instanceof HttpServletResponse) {
				response = (HttpServletResponse)obj;
			}
		}
		//세션 획득 완료후
		
		if(session.getAttribute("pid") == null) {
			//ex) 로그인 안했을시 예제
			response.sendRedirect("/board/");
			// board로 되돌아 온다.
			return res;
		}
		
		res = joinPoint.proceed();
		
		return res;
	}
}
