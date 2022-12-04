package OOP_Inheritance;

public class Car extends Vehicle{
	
	//final:
	//used to provide constant variables(local vars)
	//used to prevent method overridding
	//used to prevent inheritance	
	
	String name;
	static int wheels = 4;
	
	public static void price() {
		System.out.println("car -- price");
	}

	public void start() {
		System.out.println("car -- start");
	}

	public void stop() {
		
		System.out.println("car -- stop");
	}

	public void refuel() {
		System.out.println("car -- refuel");
	}

}
