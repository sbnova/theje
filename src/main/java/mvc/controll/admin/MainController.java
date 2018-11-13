package mvc.controll.admin;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("admin/main")
	String main(HttpSession session, HttpServletResponse response) { //도메인을 바꾸는작업이므로 response가 필요
		return "admin/main";
	}
}
