package testingStuffBecause;

public class Equipment {
	private String name;
	private String desc;
	private int price;
	
	Equipment(String name, String desc, int price) {
		this.name = name;
		this.desc = desc;
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public String getDesc() {
		return this.desc;
	}
}
