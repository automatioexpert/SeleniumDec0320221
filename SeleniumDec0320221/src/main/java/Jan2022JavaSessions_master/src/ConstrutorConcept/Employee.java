package ConstrutorConcept;

public class Employee {

	String name;
	int age;
	String city;
	double sal;
	boolean isPerm;

	// constructor of the class
	// name will be same as the class name
	// const..is not a function
	// const... can not return anything...no retrun type
	// const.. overloading is possible
	// const.. will be called when you create the object of the class
	// but function will be called when you create the object of the class and use
	// obj ref varibale

	public Employee() {// 0 param
		System.out.println("default const...");
	}

	public Employee(int a) {// 1 param
		System.out.println("1 param const..." + a);
	}

	public Employee(int a, int b) {// 2 params
		System.out.println("2 params const..." + (a + b));
	}

	public static void main(String[] args) {

		Employee obj = new Employee(10,20);

	}

}
