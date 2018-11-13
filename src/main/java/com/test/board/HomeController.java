package com.test.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) // url은 "/"기준으로 잡는다
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate ); 
		model.addAttribute("nick", "�嵿��" ); 
		
		//6~12 : 오전, 12~6(18) : 오후 , (18)6~24 : 오후, 24~6:새벽		
		//getHour() : 문자열의 시간을 뽑는 함수
		
		int hours = date.getHours();
		
		if(hours <= 6) {
			model.addAttribute("hours","아침이다");
		}else if(hours <= 12) {
			model.addAttribute("hours","오전이다");
		}else if(hours <= 18) {
			model.addAttribute("hours","오후다");
		}else {
			model.addAttribute("hours","새벽이다");
		}
		
		model.addAttribute("time","새벽,아침,오전,오후".split(",")[date.getHours()/6]);
		
		return "home"; //veiw page를 home으로 돌린다.
	}
	
}
