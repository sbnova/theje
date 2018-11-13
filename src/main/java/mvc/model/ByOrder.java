package mvc.model;

import java.util.List;

public class ByOrder {
	List<Product> proList;
	
	Address addr;
	
	//Product에서 cnt와 price 값을 가져와서 계산 
	
	int sum;

	public List<Product> getProList() {
		return proList;
	}

	public void setProList(List<Product> proList) {
		this.proList = proList;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
	public void execute() {
		sum = 0;
		/*for(Product pro : proList) { //순서가 엉킬수 잇다.
			if(pro.id.equals("") || pro.id.equals("null") || pro.id==null) {
				proList.remove(pro);
			}
				
			System.out.println(pro);
		}*/
		for(int i = proList.size()-1; i>=0; i--) { //직접찍기
			Product pro = proList.get(i); // 순서에 관련한 리스트 받기
			if(pro.id.equals("") || pro.id.equals("null") || pro.id==null) { //id가 비어있거나 null 값이라면
				proList.remove(pro); //리스트에서  pro를 지워라
			}else {//id가 있다면 합계를 도출해라
				
				sum += pro.getTotal(); // 전체 합계 구하기
			}
				
			System.out.println(pro);
		}
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
}
