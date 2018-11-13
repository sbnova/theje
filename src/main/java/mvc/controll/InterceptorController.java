package mvc.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorController {

	@RequestMapping("interceptor/event")
	String event() {
		return "interceptor/event";
	}
	
	@RequestMapping("interceptor/expire")
	String expire() {
		return "interceptor/expire";
	}
}

