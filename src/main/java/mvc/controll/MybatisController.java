package mvc.controll;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.model.BoardDTO;
import mvc.model.ListDTO;
import mvc.model.PageStatus;
import mvc.service.BoardDAO;
import mvc.service.FileService;

@Controller
@RequestMapping("/mybatis/{service}")
public class MybatisController {
	
	@Autowired
	BoardDAO dao;
	
	@Autowired
	FileService fileService;
	
	//상태정보만 가질 클래스 --> dto로 알람을 가져오는것으로 전부 status 로 변경한다.
	PageStatus status = new PageStatus();
	@ModelAttribute
	public Object statusGo() {
		return status;
	}
	
	@ModelAttribute
	public void listGo(@PathVariable("service")String service, ListDTO dto) { //나가는게 없다
		if(service.equals("insertMultiReg")) {
			dao.insertList(dto);
		}
		
		if(service.equals("insertErrorReg")) {
			try {
				dao.insertError(dto);
				status.setMsg("입력되었습니다");
				status.setUrl("list");				
			}catch(Exception e) {
				e.printStackTrace();
				status.setMsg("입력이 취소되었습니다");
				status.setUrl("list");
				
			}
		}
	}
	
	@ModelAttribute("data") //data 속성 값 집어 불러 오는 것, 없을 시 데이터 값 가져올 수 없음
	public Object dataGo(@PathVariable("service")String service, 
			BoardDTO dto, //BoardDTO 추가 insert문 추가하기 위해
			HttpServletRequest request) {
															
		Object res =null;
		switch(service) {
			case "list":
				System.out.println(dto.getCntType());
				res = dao.list(dto);
				break;
				
			case "detail":
				dao.addCount(dto);//조회수
			case "modifyForm":
				res = dao.selectOne(dto);
				break;
				
			// insert 추가
			case "insertReg":
				System.out.println(dto);
				System.out.println(dto.getUpfileMM().isEmpty()); //파일업로드 비어있는지 확인 출력
				if(!dto.getUpfileMM().isEmpty()) //파일업로드에 비어있지않을시 작동
					dto.setUpfile(fileService.fileUpload(dto.getUpfileMM(), request));//file 업로드 resources->up 에 저장
				//System.out.println(dto);
				res = dao.insertOne(dto); //dto내용을 dao의 insertOne 메소드를 사용
				System.out.println(res + ":"+dto);
				
				status.setMsg("입력되었습니다");
				status.setUrl("detail?id="+dto.getId());
				
				res = dto;
				break;
				
			case "insertMultiReg":			
				status.setMsg("입력되었습니다");
				status.setUrl("list");
				
				res = dto;
				break;
			
			case "deleteReg":
				status.setMsg("id pw 불일치");
				status.setUrl("deleteForm");
				
				if((int)dao.deleteOne(dto) >= 1) {
					status.setMsg("삭제 성공");
					status.setUrl("list");
				}
				
				res = dto;
				//res = dao.deleteOne(dto); //dto내용을 dao의 deleteOne 메소드를 사용
				break;		
			
			case "modifyReg":
				status.setMsg("id pw 불일치");
				status.setUrl("modifyForm?id="+dto.getId());
				
				if((int)dao.modify(dto) >= 1) {
					status.setMsg("수정 성공");
					status.setUrl("detail?id="+dto.getId());
				}
				
				res = dto;
				break;		
		}
		return res;
	}
	
	@RequestMapping()
	public String view(@PathVariable("service")String service) {
		//view 페이지
		String res = "mybatis/"+service;
		
		String [] arr = {"deleteReg", "modifyReg", "insertReg", "insertMultiReg", "insertErrorReg"};
		
		if(Arrays.asList(arr).contains(service)){
			res = "mybatis/alert";
		}		
		/*if(service.equals("insertReg"))
			res = "redirect:list";*/  //아래로 통합 redirect 사용 안함
		/*if(service.equals("deleteReg") ||
				service.equals("modifyReg") ||
				service.equals("insertReg") ||
				service.equals("insertMultiReg") ||
				service.equals("insertErrorReg")
				)
			res = "mybatis/alert";	// redirect 할곳이 없다
			*/
		return res;
	}
}
