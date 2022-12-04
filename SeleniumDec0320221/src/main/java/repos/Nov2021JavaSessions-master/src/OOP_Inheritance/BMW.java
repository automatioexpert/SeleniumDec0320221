package OOP_Inheritance;

public class BMW extends Car{
	
	//Method Overrding: poly+morphism -> dynamic (RunTime)
	//when you have the same method in parent class and in child class
	//with:
	//1. the same name
	//2. same number of parameters
	//3. same type of parameters
	//4. same return type
	
	@Override
	public void start() {
		System.out.println("BMW -- start");
	}
	
	public void autoParking() {
		System.out.println("BMW -- auto parking");
	}
	
	//method hiding
	public static void price() {
		System.out.println("BMW -- price");
	}
	
	
	
}
