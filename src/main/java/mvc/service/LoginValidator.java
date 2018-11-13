package mvc.service;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import mvc.model.Stud;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Stud.class.isAssignableFrom(clazz); //나갈때의 형변환(stud 클래스)
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		System.out.println("validate() 진입");
		
		Stud st = (Stud)target;
		
		if(st.getId() == null || st.getId().trim().equals("")) {
			errors.rejectValue("id", "invalid.id", "id 에러"); // 이게 없으면 -> 에러가없어도 값이 출력된다
		}else if(st.getPw() == null || st.getPw().trim().equals("")) {
			errors.rejectValue("pw", "invalid.pw", "pw 에러");
		}
		// password 입력되어 있고 id가 입력 안 되 있을시 id는 에러출력 메시지  password는 입력값이 사라지지 않게 할것				
	}

}
