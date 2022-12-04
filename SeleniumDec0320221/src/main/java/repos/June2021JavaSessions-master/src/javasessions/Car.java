package javasessions;

public class Car {

	String name;
	int price;
	String model;
	static int wheels = 4;

	public static void main(String[] args) {

		Car c1 = new Car();
		c1.name = "Audi";
		c1.price = 70;
		c1.model = "A6";

		Car c2 = new Car();
		c2.name = "BMW";
		c2.price = 75;
		c2.model = "520d";

		Car c3 = new Car();
		c3.name = "Honda";
		c3.price = 20;
		c3.model = "Civic";

		System.out.println(c1.name + " " + c1.price + " " + c1.model + " " + Car.wheels);
		System.out.println(c1.name + " " + c1.price + " " + c1.model + " " + wheels);
		System.out.println(c1.name + " " + c1.price + " " + c1.model + " " + c1.wheels);

		//how to call static var with static way:
		//1. call by class name
		//2. call directly
		//3. call by object ref name: a warning will be given
		
	}

}
