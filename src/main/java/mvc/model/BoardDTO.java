package mvc.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("boardDTO") //클래스명 변환 -> Alias 걸로 부르겠다
public class BoardDTO { //DB로 들어갈것
	Integer id, cnt;
	Date reg_date;
	String pname, pw, title, content, upfile, sch;
	MultipartFile upfileMM; //이것이 있어야 파일을 받을수 있다
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (E) HH:mm:ss"); // 날짜 형식 변경
	
	
	String cntType;
	
	
	public String getCntType() {
		return cntType;
	}
	public void setCntType(String cntType) {
		this.cntType = cntType;
	}
	public String getSch() {
		return sch;
	}
	public void setSch(String sch) {
		this.sch = sch;
	}
	
	
	public MultipartFile getUpfileMM() {
		return upfileMM;
	}
	public void setUpfileMM(MultipartFile upfileMM) {
		this.upfileMM = upfileMM;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public String getReg_dateStr() {
		return sdf.format(reg_date);
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public String getContentBr() { //Content 강제로 문단 나누기
		return content.replaceAll("\n", "<br>");
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUpfile() {
		return upfile;
	}
	public void setUpfile(String upfile) {
		this.upfile = upfile;
	}
	@Override
	public String toString() {
		return "BoardDTO [id=" + id + ", cnt=" + cnt + ", reg_date=" + reg_date + ", pname=" + pname + ", pw=" + pw
				+ ", title=" + title + ", content=" + content + ", upfile=" + upfile + ", upfileMM=" + upfileMM + "]";
	}
	
	
}
