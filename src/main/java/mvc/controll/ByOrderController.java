package mvc.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mvc.model.ByOrder;
import mvc.model.Product;

@Controller
@RequestMapping("mvc/byOrder")
public class ByOrderController {
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		
		return "mvc/byOrderForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(ByOrder bo) { // 나갈시는 ByOrder로 나간다

		bo.execute(); //execute 사용
		return "mvc/byOrderPost";
	}
	
}