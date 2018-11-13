package mvc.model;

import java.util.Arrays;

public class Exam {
	String name;
	int [] jum;
	
	String [] index = {"국어", "영어", "수학"};
	
	
	public String title(int i) {
//		return index[i];
		return index[i] + ":" + jum[i];
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getJum() {
		return jum;
	}
	public void setJum(int[] jum) {
		this.jum = jum;
	}
	public Exam() {
		
	}
	
	public Exam(String name, int ... jum) { //int ... 은  멤버변수를 모를때 사용하며 함수내의 설정에서 맨마지막에 넣어줘야 한다.
		super();
		this.name = name;
		this.jum = jum;
	}
	
}
