package javasessions;

public class Car {

	String name;
	int price;
	String color;
	static int wheels = 4;

	public static void main(String[] args) {

		Car c1 = new Car();
		c1.name = "BMW";
		c1.price = 30;
		c1.color = "Red";

		Car c2 = new Car();
		c2.name = "Audi";
		c2.price = 40;
		c2.color = "White";

		Car c3 = new Car();
		c3.name = "Honda";
		c3.price = 20;
		c3.color = "Black";

		System.out.println(c1.name+ " " + c1.price + " " + c1.color + " " + Car.wheels);
		
		//how to access static vars:
		//1. by using class name
		System.out.println(Car.wheels);
		
		//2. use it directly
		System.out.println(wheels);
		
		//3. can we access static var using object ref variable?
		System.out.println(c1.wheels);
		
		
		
	}

}
