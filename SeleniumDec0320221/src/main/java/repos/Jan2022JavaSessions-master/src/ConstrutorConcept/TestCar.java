package ConstrutorConcept;

public class TestCar {

	public static void main(String[] args) {
		
		final int i = 10;//local
		
		final int days = 7;
		//days = 10;
		System.out.println(days * 100);

		Car c = new Car("BMW", "Red");
		System.out.println(c.name + " " + c.color + " " + c.price + " " + c.model);
		
		Car c1 = new Car("Honda", 15, "White");
		
		//Car c3 = new Car();
		
//		Car c3 = new Car(5);
//		
		System.out.println(Car.wheels);
		
	}

}
