package mvc.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.model.ActorList;

@Controller
public class ActorController {
	
	@Autowired
	ActorList actorList;
	
	@ModelAttribute("actors")
	List<String> actors(
			@RequestParam(value="key", required=false, defaultValue="it")String key){
		return actorList.actors(key);
	}
	
	@RequestMapping("actor/detail")
	String detail(Model model) {
		
		model.addAttribute("dd", "detail");
		return "model/actor";
	}
	@RequestMapping("actor/list")
	String list(Model model) {
		
		model.addAttribute("dd", "list");
		return "model/actor";
	}
	@RequestMapping("actor/insert")
	String insert(Model model) {
		
		model.addAttribute("dd", "insert");
		return "model/actor";
	}
}
