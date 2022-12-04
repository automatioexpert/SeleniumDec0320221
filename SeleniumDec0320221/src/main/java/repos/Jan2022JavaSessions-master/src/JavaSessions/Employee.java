package JavaSessions;

public class Employee {

	// class vars:
	String name;
	int age;
	String city;
	double salary;
	char gender;
	boolean isActive;

	public static void main(String[] args) {

		// class - blueprint/template/category
		// Object - a physical entity

		Employee e1 = new Employee();
		e1.name = "Tom";
		e1.age = 20;
		e1.city = "Bangalore";
		e1.salary = 12.33;
		e1.gender = 'm';
		e1.isActive = true;
		System.out.println(e1.name + " " + e1.age + " " + e1.isActive);

		Employee e2 = new Employee();
		System.out.println(e2.name + " " + e2.age + " " + e2.salary + e2.gender + e2.isActive);

		new Employee().name = "Naveen";
		// no reference Object
		new Employee().isActive = true;

		System.gc();

		Employee e3 = new Employee();
		e3.name = "Peter";
		e3.age = 40;
		System.out.println(e3.name);

		e3 = null;
		System.out.println(e3.name);// NullPointerException - NPE

	}

}
