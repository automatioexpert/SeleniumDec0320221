package SubPackage;

import SuperPackage.Car;

public class Audi extends Car{

	public static void main(String[] args) {

		Car c1 = new Car();
		System.out.println(c1.name);
//		System.out.println(c1.price);
//		System.out.println(c1.color);
//		System.out.println(c1.model);
		
		Audi a1 = new Audi();
		System.out.println(a1.name);
		System.out.println(a1.color);
		
	}

}
