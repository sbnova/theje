package mvc.model;

public class Product {
	String id, name;
	//Integer는 null을 알고 있다.
	Integer cnt;
	
	Integer price;
	
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
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
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	

	public Integer getTotal() {
		
		return price * cnt;
	}
}
