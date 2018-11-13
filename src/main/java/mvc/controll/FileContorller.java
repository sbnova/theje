package mvc.controll;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import mvc.model.FileData;
import mvc.service.FileService;

@Controller
public class FileContorller {
	
	@Autowired
	FileService fileService;
	
	@RequestMapping(value="mvc/fileUpload", method=RequestMethod.GET)
	String get() {
		
		return "file/get";
	}
	@RequestMapping(value="mvc/fileUpload", method=RequestMethod.POST)
	String post(@RequestParam("id")String id, 
			@ModelAttribute("name")String name
			,MultipartFile up1
			,Model model
			) {
		
		System.out.println("id : "+id);
		System.out.println("name : "+name);
		//System.out.println("up1 : "+up1);
		System.out.println("up1.name : "+up1.getName());
		System.out.println("up1.type : "+up1.getContentType());
		System.out.println("up1.Ori : "+up1.getOriginalFilename());
		System.out.println("up1.isEmpty : "+up1.isEmpty());
		
		model.addAttribute("up1", up1.getOriginalFilename());
		return "file/post";
	}
	
	@RequestMapping(value="mvc/post2", method=RequestMethod.POST)
	ModelAndView post2(MultipartHttpServletRequest mm) {
		
		ModelAndView res = new ModelAndView("file/post");
		
		System.out.println("id : "+mm.getParameter("id"));
		System.out.println("name : "+mm.getParameter("name"));
		MultipartFile up1 = mm.getFile("up1");
		System.out.println("up1.name : "+up1.getName());
		System.out.println("up1.type : "+up1.getContentType());
		System.out.println("up1.Ori : "+up1.getOriginalFilename());
		System.out.println("up1.isEmpty : "+up1.isEmpty());
		
		res.addObject("id",mm.getParameter("id"));
		res.addObject("name",mm.getParameter("name"));
		res.addObject("up1",up1.getOriginalFilename());
		
		return res;
	}
	
	@RequestMapping(value="mvc/post3", method=RequestMethod.POST)
	String post3(FileData data, HttpServletRequest request, Model model) {
		
		//이미지 파일에 맞는 확장자만 체크, 여기 체크를 안돌아가면 error로 돌아간다
		if(fileService.isImgChk(data.getUp2())) {
			data.setSys1(fileService.fileUpload(data.getUp1(), request));
			data.setSys2(fileService.fileUpload(data.getUp2(), request));
			
			model.addAttribute("id", data.getId());
			model.addAttribute("name", data.getName());			
			model.addAttribute("sys1", data.getSys1());			
			model.addAttribute("sys2", data.getSys2());			
			model.addAttribute("age", 29);				
			return "redirect:fileView"; //file/post3 -> redirct로 변환 /404출력 -> 밑에 fileView로 재정의
		}
			
		return "file/error";
	}

	@RequestMapping(value="mvc/fileView")
	String fileView(FileData data, @RequestParam(value="age")int age,
			@RequestParam(value="grade", required=false, defaultValue="5")
	Integer grade) {	
		//FileData로는 못간다, post3에 Model 추가-> RequestParam추가 
		//RequestParam으로 grad 추가 Integer grade => 없는 값이므로 출력X -> required=false 추가 ->값 없는 상태로 출력
		//defalutValue="5" 값이없다면 defalut로 초기화
		
		System.out.println("grade:"+grade);
		return "file/post3";
	}
	
	/*void fileUpload(MultipartFile mf, HttpServletRequest request) { //내장객체라 request로 당겨올수 있다.
		
	
		
//		System.out.println(request.getRealPath("/resources/up")); //eclipes는 가상서버에 집어넣기 때문에 나오는 주소가 가상서버주소가 나온다
				
		String filename = mf.getOriginalFilename();
		String fname = filename.substring(0, filename.lastIndexOf("."));
		String ext = filename.substring(filename.lastIndexOf(".")+1).toLowerCase(); // 확장자 뽑아내고 -> 소문자로 변환
		System.out.println(filename);
		System.out.println(fname +"."+ ext);
		
		
		try {
			String path = request.getRealPath("/resources/up");           		//배포할때 사용 안쓰는거 주석
			path = "D:\\workspace\\mvcProj\\src\\main\\webapp\\resources\\up";  //작업할때 사용
			//서버에 절대 경로를 가져오는건 쉬운건 아니다(내부 파일 계속 수정해야 함)
			FileOutputStream fos = new FileOutputStream(path +"/"+ mf.getOriginalFilename());
			fos.write(mf.getBytes()); //Byte 배열을 받을 수 있다
		
			fos.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		if(!isImage(ext)) {
			
			System.out.println("이미지 파일을 올리세요");
		}else {		
			try {
					String path = request.getRealPath("/resources/up");           		//배포할때 사용 안쓰는거 주석
					path = "D:\\workspace\\mvcProj\\src\\main\\webapp\\resources\\up";  //작업할때 사용
					//서버에 절대 경로를 가져오는건 쉬운건 아니다(내부 파일 계속 수정해야 함)
					FileOutputStream fos = new FileOutputStream(path +"/"+ filename);
					fos.write(mf.getBytes()); //Byte 배열을 받을 수 있다
				
					fos.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	//확장자 처리
	private boolean isImage(String ext){
		
		List<String> allowExt = Arrays.asList("jpg","jpeg","gif","bmp","png");
		
		return allowExt.contains(ext); // true
		
	}*/
}
