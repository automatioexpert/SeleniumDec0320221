package OOP_Inheritance;

public class Car extends Vehicle{
	
	public static void speed() {
		System.out.println("Car -- speed");
	}
	
	private void price() {
		System.out.println("car price");
	}

	public void start() {
		System.out.println("Car -- start");
		price();
	}

	public void stop() {
		System.out.println("Car -- stop");
	}

	public void refuel() {
		System.out.println("Car -- refuel");
	}
	
	@Override
	public void engine() {
		System.out.println("car -- engine");
	}

}
