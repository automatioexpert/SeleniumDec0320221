package constructorconcept;

public class Employee {
	//class vars
	String name;
	int age;
	double salary;
	boolean isPerm;
	
	//constructor of the class
	//const... name will be same as the class name
	//const... looks like a function but not a function
	//const... can not return any value, there is no return type
	//const... will be called when you create the object of the class
	//const... can be overloaded
	//const... is used to initialize the class vars
	//const.. is used to create the object on the basis of given parameters
	//const... is helping to prevent of creating unnecessary object
	
	
//	public Employee() {//0 param - default const...
//		System.out.println("default const....");
//	}
//	
//	public Employee(int i) {//1 param
//		System.out.println("1 param const...." + i);
//	}
//	
//	public Employee(int i, String p) {//2 params
//		System.out.println("2 params const...." + i + p);
//	}
	
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public static void main(String[] args) {

		Employee e1 = new Employee("Neel", 25);
		System.out.println(e1.name + " " + e1.age + " " + e1.salary + " " + e1.isPerm);

		
		
	}

}
