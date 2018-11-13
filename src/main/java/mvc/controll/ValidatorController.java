package mvc.controll;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mvc.model.Stud;
import mvc.service.LoginValidator;

@Controller
@RequestMapping("validate")
public class ValidatorController {

	@RequestMapping(method=RequestMethod.GET)
	String form() {
		return "validate/form";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	String submit(Stud st, BindingResult res) { //BindingResult-> error문구 생기면 작동
		
		new LoginValidator().validate(st, res); // validate(Object target, Errors errors)
		
		if(res.hasErrors()) { //에러 발생시
			System.out.println("유효성 검사 에러 발생");
			return "validate/form";
		}
		return "validate/submit";
	}
}

