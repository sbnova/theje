package mvc.model;

import java.util.ArrayList;

import org.apache.ibatis.type.Alias;

@Alias("listDTO")
public class ListDTO {
	ArrayList<BoardDTO>mem; //mem을 받아오기 위한 리스트
	
	
	public ArrayList<BoardDTO> getMem() {
		return mem;
	}
	public void setMem(ArrayList<BoardDTO> mem) {
		this.mem = mem;
	}
	
	
	@Override
	public String toString() {
		return "ListDTO [mem=" + mem + "]";
	}
	
	
}
