package mvc.controll;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController { // 로그인기능? id/pw 받아서 정상이다 -> Cookie make처럼 되야한다. (보안상의 문제로 사용하지 않는다)
	@RequestMapping("cookie/make")
	public String make(Model model, HttpServletResponse response) {
		
		response.addCookie(new Cookie("pid", "aaa")); //쿠키 생성
		
		model.addAttribute("title","쿠키생성");
		return "cookie/view";
	}
	
	@RequestMapping("cookie/view")
	public String View(Model model, @CookieValue(value="pid", defaultValue="ccc")String pid) { //삭제후 parameter 값이없어서 에러가 난다
		
		
		model.addAttribute("title","쿠키보기");
		model.addAttribute("pid",pid);
		return "cookie/view";
	}
	
	@RequestMapping("cookie/modify")
	public String Modify(Model model, HttpServletResponse response) {
		
		response.addCookie(new Cookie("pid","bbb"));
		model.addAttribute("title","쿠키수정");
		return "cookie/view";
	}
	
	@RequestMapping("cookie/delete")
	public String delete(Model model, HttpServletResponse response) {
		
		Cookie coo = new Cookie("pid","");
		coo.setMaxAge(0);
		response.addCookie(coo);
		model.addAttribute("title","쿠키삭제");
		return "cookie/view";
	}
	
	
}
