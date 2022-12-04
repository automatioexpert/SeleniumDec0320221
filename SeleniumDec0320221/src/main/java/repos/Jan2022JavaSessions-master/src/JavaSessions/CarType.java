package JavaSessions;

public class CarType {

	String name;
	int price;
	String color;
	static final int wheels = 4;

	public static void start() {
		System.out.println("car -- start");
	}

	public void stop() {
		System.out.println("car -- stop");
	}

	public static void main(String[] args) {

		CarType c1 = new CarType();
		c1.name = "Honda";
		c1.price = 10;
		c1.color = "white";
		// CarType.wheels = 5;
		c1.stop();
		
		//to call static methods:
		start();
		CarType.start();

		CarType c2 = new CarType();
		c2.name = "Audi";
		c2.price = 50;
		c2.color = "Red";

		CarType c3 = new CarType();
		c3.name = "BMW";
		c3.price = 60;
		c3.color = "Black";

		// 1. directly:
		System.out.println(wheels);
		// 2. class name:
		System.out.println(CarType.wheels);
		
		
		for(int i=1; i<=10; i++) {
			System.out.println(i);
				if(i==3) {
					System.out.println("I am a batman");
				}
		}
		
		
		
		
		

	}

}
