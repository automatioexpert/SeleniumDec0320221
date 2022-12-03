package SuperKeyword;

public class Car {

	int speed = 100;

	public Car() {
		System.out.println("car -- const...");
	}

	public Car(int a) {
		System.out.println("car -- const..." + a);
	}

	public void start() {
		System.out.println("car -- start");
	}
	
	public static void refuel() {
		System.out.println("car -- refuel");
	}

}
