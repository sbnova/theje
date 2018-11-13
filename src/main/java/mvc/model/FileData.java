package mvc.model;

import org.springframework.web.multipart.MultipartFile;

public class FileData {
	String id, name,  sys1, sys2;
	

	public String getSys1() {
		return sys1;
	}

	public void setSys1(String sys1) {
		this.sys1 = sys1;
	}

	public String getSys2() {
		return sys2;
	}

	public void setSys2(String sys2) {
		this.sys2 = sys2;
	}

	MultipartFile up1, up2;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getUp1() {
		return up1;
	}

	public void setUp1(MultipartFile up1) {
		this.up1 = up1;
	}

	public MultipartFile getUp2() {
		return up2;
	}

	public void setUp2(MultipartFile up2) {
		this.up2 = up2;
	}
	
	public String getUp1Name() {
		return  up1.getOriginalFilename();
	}
	
	public String getUp2Name() {
		return  up2.getOriginalFilename();
	}
}
