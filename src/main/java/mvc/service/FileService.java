package mvc.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	
	String path;
	
	public String fileUpload(MultipartFile mf, HttpServletRequest request) { //내장객체라 request로 당겨올수 있다.
		//파일을 새로 갱신해줘야함
		path = request.getRealPath("/resources/up")+"/";           		//배포할때 사용 안쓰는거 주석
		path = "D:\\workspace\\mvcProj\\src\\main\\webapp\\resources\\up/";  //작업할때 사용
		//서버에 절대 경로를 가져오는건 쉬운건 아니다(내부 파일 계속 수정해야 함)
		
		//중복되지 않는 파일명 만드는것
		String res = fileNamePolicy(mf); //새로운 파일명이 나왔을시
		
		try {
			
			FileOutputStream fos = new FileOutputStream(path+res);
			fos.write(mf.getBytes()); //Byte 배열을 받을 수 있다
		
			fos.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		
		return res;
	}
	
	String fileNamePolicy(MultipartFile mf) {// request가 필요없으므로 request 삭제
		
		
		//파일 확장자랑 파일 이름을 끊어 주어야 한다
		int pos = mf.getOriginalFilename().lastIndexOf(".");
		
		String ext = mf.getOriginalFilename().substring(pos); //.포함 뒤로 
		String fileName = mf.getOriginalFilename().substring(0, pos); //0~.전까지
		
		
		String res = mf.getOriginalFilename(); //파일명이된다
		String filePath = path+ res; //up폴더 경로 -> path
		
		//파일로 등록
		File file = new File(filePath);
		int no = 0;
		while(file.exists()) { //새로운 파일명이 나올때까지
			//존재하는지 체크
			res = fileName+"_"+no+ext; //파일이름에서
			filePath = path + res; //경로 만들기
			
			file = new File(filePath);
			no++;
		}
		
		return res;
	}
	
	
	public boolean isImgChk(MultipartFile mf) {
		String ext = mf.getOriginalFilename().toLowerCase().substring(
				mf.getOriginalFilename().lastIndexOf(".")+1);
		
		System.out.println(ext);
		
		/*ArrayList<String>extList  = new ArrayList<>();
		
		for (String string : "jpg,jpeg,bmg,gif,png".split(",")) {
			extList.add(string);
		}*/
		//List<String>extList = Arrays.asList("jpg,jpeg,bmg,gif,png".split(","));
		
		return Arrays.asList("jpg,jpeg,bmg,gif,png".split(",")).contains(ext); //확장자명에 대한 스플릿 리턴
		
//		return false;
	}
	
}
