package javasessions;

public class Employee {

	String name;
	int age;
	double salary;

	public static void main(String[] args) {

		Employee e1 = new Employee();
		e1.name = "Shikha";
		e1.age = 25;
		e1.salary = 30.44;

		Employee e2 = new Employee();
		e2.name = "Ram";
		e2.age = 28;
		e2.salary = 23.44;

		Employee e3 = new Employee();
		e3.name = "Kate";
		e3.age = 29;
		e3.salary = 43.44;

		System.out.println(e1.name + " " + e1.age + " " + e1.salary);
		System.out.println(e2.name + " " + e2.age + " " + e2.salary);
		System.out.println(e3.name + " " + e3.age + " " + e3.salary);
		
		e1 = e2;
		
		System.out.println(e1.name + " " + e1.age + " " + e1.salary);
		System.out.println(e2.name + " " + e2.age + " " + e2.salary);
		System.out.println(e3.name + " " + e3.age + " " + e3.salary);
		
		e2 = e3;
		
		System.out.println(e1.name + " " + e1.age + " " + e1.salary);
		System.out.println(e2.name + " " + e2.age + " " + e2.salary);
		System.out.println(e3.name + " " + e3.age + " " + e3.salary);
		
		e3 = e1;
		System.out.println(e1.name + " " + e1.age + " " + e1.salary);
		System.out.println(e2.name + " " + e2.age + " " + e2.salary);
		System.out.println(e3.name + " " + e3.age + " " + e3.salary);

//		new Employee().name = "Naveen";
//		new Employee().salary = 12.33;
//
//		new Employee();
		
		Employee e4 = new Employee();
		e4 = null;
		System.out.println(e4.name);//NPE
		
		System.gc();//will call GC


	}

}
