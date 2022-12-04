package OOP_Inheritance;

public class BMW extends Car {

	// method overriding: poly+morphism -- dynamic (run time)
	// when you have a method in parent class as well as in child class
	// with the same name
	// and same number of parameters
	// and same return type

	@Override
	public void start() {
		System.out.println("BMW -- start");
	}
	

	public void autoParking() {
		System.out.println("BMW -- auto parking");
	}

	private void price() {
		System.out.println("BMW price");
	}
	
	//method hiding
	public static void speed() {
		System.out.println("BMW -- speed");
	}
	
	@Override
	public void engine() {
		System.out.println("BMW -- engine");
	}

}
