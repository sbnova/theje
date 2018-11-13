package mvc.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.model.Stud;

@Controller
@RequestMapping("ppp/{userId}/aaa/{no}")
public class PathController {
	
	@ModelAttribute("st") //이렇게 집어넣을수 있다
	Stud stud(@PathVariable String userId,
			@PathVariable int no) { //PathVariable 이 없으면 값이 없는 상태로 들어간다
		Stud st = new Stud();
		st.setId(userId);
		st.setNo(no);
		return st;
	}
	
	@RequestMapping
	String view(@PathVariable String userId,
			@PathVariable int no) {
		System.out.println("view : "+userId+","+no);
		
		return "path/view";
	}
	
	/*@RequestMapping
	String view2(@PathVariable String userId,
			@PathVariable String no) {
		System.out.println("view : "+userId+","+no);
		
		return "path/view";
	}*/ //못한다
}
