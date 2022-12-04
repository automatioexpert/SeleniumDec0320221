package JavaSessions;

import java.util.ArrayList;

public class Car {

	/**
	 * This method is used to book the car on the basis of given car type
	 * 
	 * @param car (String)
	 * @return this will return ArrayList<String>
	 */
	public ArrayList<String> booking(String car) {
		System.out.println("car type: " + car);
		ArrayList<String> carList = new ArrayList<String>();

		if (car.equals("sedan")) {
			carList.add("city");
			carList.add("civic");
			carList.add("Tata Indigo");
		} else if (car.equals("SUV")) {
			carList.add("Range Rover");
			carList.add("XUV700");
		} else if (car.equals("mini")) {
			carList.add("cooper");
			carList.add("swift");
		} else {
			System.out.println("car type is not available....");
		}

		return carList;
	}

	// method overloading: Poly+Morphism--> compile time (static)
	// With in the same class, when have:
	// 1. different methods with the same name
	// 2. differnt parameters
	// 3. diff sequence of the parameters
	public void test() {//0 param
		System.out.println("test method");
	}

	public void test(int a) {//1 param
		System.out.println("test method " + a);
	}
	
	public int test(int a, int b, int c) {//1 param
		System.out.println("test method " + a);
		return 10;
	}

	public void test(int a, int b) {//2 params
		System.out.println("test method " + a + b);
	}

	public void test(int a, String b) {
		System.out.println("test method " + a + b);
	}

	public void test(String a, int b) {
		System.out.println("test method " + a + b);
	}

	public static void main(String[] args) {
		Car c = new Car();
		ArrayList<String> sedanList = c.booking("sedan");
		System.out.println(sedanList);
		
		c.test();
		c.test(10);
	}

}
