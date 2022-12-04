package OOP_Inheritance;

public class BMW extends Car {

	int speed = 200;
	
	public BMW() {
		super();
		System.out.println("testing");
	}
	
	
	
	// Method Overriding: poly + morphism : RunTime(Dynamic)
	// when you have a method in the parent class and the same method in the child
	// class with:
	// 1. method name should be same
	// 2. same number of parameters
	// 3. same types of parameters
	// 4. same sequence of parameters
	// 5. same return type

	@Override
	public void start() {
		System.out.println("BMW -- start");
	}
	
	@Override
	public void engine() {
		System.out.println("BMW -- engine");
	}

	public void autoParking() {
		System.out.println("BMW -- auto parking");
	}
	
	public void autoStart() {
		System.out.println("BMW -- auto start");
	}
	
	//method hiding
	public static void run() {
		System.out.println("BMW -- run");
	}
	
	
	private void billing() {
		System.out.println("car - billing");
	}
	
	@Override
	public void aeroDynamic() {
		System.out.println("BMW -- aeroDynamic");
	}
	

}
