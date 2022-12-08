package Poly_Inheritance;

public class Cars_test {

	public static void main(String[] args) {
		// This is called static/ compile time polymorphism where the compiler gets to know which class to call
		BMW bm = new BMW();
		bm.antitheft();
		bm.start();   //Here the start method of the BMW class would be taken. This is called METHOD OVERRIDING where there are multiple 
						// multiple functions with same name and same number of arguments. and the method from the child class is taken.
		
		
		bm.vehicleengine();
		
		

		
		System.out.println("**********************************************");
		
		Car c = new Car();
		
		c.start();
		c.stop();
		c.carfeature();
		
		c.vehicleengine();
		
		
		
		System.out.println("************************************************");
		
		//TopCasting
		Car c1 = new BMW(); //Child class object can be referred by parent class reference variable. This is called runtime/dynamic polymorphism.
		
		c1.start();
		c1.carfeature();
		
		
		
		System.out.println("*************************************************");
		
		//Bottom Casting
		
		BMW b1 = (BMW) new Car(); //Class Cast Exception
		
		
		
		
		
		
		
		
		
	}

}
