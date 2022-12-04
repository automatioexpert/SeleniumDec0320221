package SuperKeyword;

public class HSBCBank {

	String name;
	String city;

	public HSBCBank() {
		this("hsbc insurance", "pune");
		System.out.println("default hsbc....");
	}

	public HSBCBank(String name, String city) {
		//this();
		this.name = name;
		this.city = city;
	}
	
	public void display() {
//		this.name = "HSBC";
//		this.city = "Pune";
		System.out.println(name + city);
	}

}
