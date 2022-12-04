package OOP_Inheritance;

public class BMW extends Car{
	
	
	int price = 500;
	
	//Method Overriding: when we have method in parent class as well as in child class
	//with the same name 
	//and same number of parameters
	//and same return type
	//Run Time/Dynamic Polymorphism
	
	//staic method can not be overriden
	
	@Override
	public void start() {
		System.out.println("BMW -- start");
	}
	
	public void autoParking() {
		System.out.println("BMW -- autoparking");
	}
	
	//Method Hiding
	public static void testing() {
		System.out.println("BMW -- testing");
	}
	
	@Override
	public void airBags() {
		System.out.println("BMW -- airBags");
	}
	
	private void fuel() {
		System.out.println("Car -- fuel");
	}
	

}
