package ConstructorConcept;

public class Employee {
	
	String name;
	int age;
	String empId;
	String dept;
	
	//const...
	//1. const... name will remain same as the class name
	//2. const... will not have any return trype/no void/no return keyword
	//3. const.. looks like a function but not a fnction
	//4. const.. overloading is possible
	//5. default const... depneds on use cases...N number of objetcs...
	
	//const vs func:
	//1. const... name will remain same...but function  name can be anything
	//2. const.. will never have any return but func may or may not return the value
	//3. const.. will be called when you create the Object but mthod will be called with object reference
	//4. const.. will help to create the Object of the class, we can restrict unnecessary object creation
	//5. func should have the buss logic, should define feature of the class. But const should not have any buss logic
	
	
	public Employee() {//0 param
		System.out.println("default const...");
	}
	
	public Employee(int i) {//1 param
		System.out.println("1 param const..." + i);
	}
	
	public Employee(int i, String p) {//2 params
		System.out.println("1 param const..." + i+p);
	}
	

	public static void main(String[] args) {

		//5. const.. will be called when you create the Object
		Employee e1 = new Employee(10,"test");
		Employee e2 = new Employee(10);
		Employee e3 = new Employee();

		
	}

}
