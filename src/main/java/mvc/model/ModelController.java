package mvc.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelController {
	
	@ModelAttribute("fruit")	
	List<String> fruit(){
		return Arrays.asList("사과,바나나,딸기,포도".split(","));
	}
	//언제든지 출력되는 데이터
	
	@RequestMapping("model/detail")
	String detail(Model model) {
		
		model.addAttribute("dd", "detail");
		return "model/view";
	}
	@RequestMapping("model/list")
	String list(Model model) {
		
		model.addAttribute("dd", "list");
		return "model/view";
	}
	@RequestMapping("model/insert")
	String insert(Model model) {
		
		model.addAttribute("dd", "insert");
		return "model/view";
	}
}
