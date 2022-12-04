package ConstrutorConcept;

public class Car {

	String name;
	int price;
	String color;
	String model;
	static final int wheels = 4;
	
//	public Car() {
//		
//	}

//	public Car(int wheels) {
//		Car.wheels = wheels;
//	}
	
	public Car(String name, int price, String color, String model) {
		this.name = name;
		this.price = price;
		this.color = color;
		this.model = model;
	}

	public Car(String name, int price, String color) {
		this.name = name;
		this.price = price;
		this.color = color;
	}

	public Car(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public Car(String name, String color) {
		this.name = name;
		this.color = color;
	}

	public Car(String name, String model, int price) {
		this.name = name;
		this.model = model;
		this.price = price;
	}

}
