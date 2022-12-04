package javasessions;

public class Employee {

	// class vars: global vars
	//data member of the class
	String name; //null
	int age; //0
	String dob; //null
	char gender; // 
	double salary; //0.0
	

	public static void main(String[] args) {

		// String name; //local var
		
		Employee e1 = new Employee();
		
		e1.name = "Tom";
		e1.age = 25;
		e1.dob = "01-01-1990";
		e1.gender = 'm';
		e1.salary = 12.33;
		
		System.out.println(e1.name + " " + e1.age) ;
		
		Employee e2 = new Employee();
		System.out.println(e2.name);
		System.out.println(e2.age);
		
		Employee e3 = new Employee();
		e3.name = "Nancy";
		e3.age = 40;
		
		System.out.println(e3.name + " " + e3.age + " " + e3.dob + " " + e3.gender + " " + e3.salary);

		new Employee().name = "Dev";
		new Employee().age = 25;
		new Employee().dob = "01-01-1990";


		
		System.gc();
		
		
		
		
	}

}
