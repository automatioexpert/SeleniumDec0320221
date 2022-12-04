package OOP_Inheritance;

public class Car extends Vehicle {
	
	int price = 100;
	
	//final: to prevent method overriding
	//to prevent inheritance
	
	private void fuel() {
		System.out.println("Car -- fuel");
	}

	public static void testing() {
		System.out.println("car -- testing");
	}

	public void start() {
		System.out.println("Car -- start");
	}

	public void stop() {
		System.out.println("Car -- stop");
	}

	public void refuel() {
		System.out.println("Car -- refuel");
	}

	@Override
	public void airBags() {
		System.out.println("car -- airBags");

	}

}
