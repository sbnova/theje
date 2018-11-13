package mvc.controll;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mvc.model.Exam;

@Controller
public class ExamController {
	
	@RequestMapping("mvc/first")
	public String first(Model model) {
		
		System.out.println("mvc/first 왓나?");
		model.addAttribute("st", new Exam("원빈", 88, 87, 86));
		return "mvc/first";
	}
	
	@RequestMapping("mvc/sec")
	public ModelAndView sec() {
		
		ModelAndView res = new ModelAndView("mvc/sec");
		//model.addAttribute("st", new Exam("투빈", 88, 87, 86));
		
		res.addObject("st", new Exam("투빈", 98, 77, 56));
		return res;
	}
	
	@RequestMapping("mvc/thr")
	public String thr(@ModelAttribute("st") Exam st) { //bean 이름은 멤버변수이다-> ModelAttribute사용하여 이름을 바꿔서 
		
		st.setName("박보검");
		st.setJum(new int [] {88, 49, 50});
		//System.out.println(exam.getName());
		return "mvc/thr";
	}
	
	@RequestMapping("mvc/four")
	public String four(@ModelAttribute("st") Exam st) { 
		
		return "mvc/four";
	}
	
	@RequestMapping(value="mvc/five", method=RequestMethod.GET)
	public String five() { 
		
		
		return "mvc/five";
	}
	
	/*@RequestMapping("mvc/fiveReg")
	public String fiveReg(Exam exam) { 
		
		
		return "mvc/fiveReg";
	}*/
	@RequestMapping(value="mvc/five", method=RequestMethod.POST)
	public String fiveReg(Exam exam) { 
		
		
		return "mvc/fiveReg";
	}
	
}
