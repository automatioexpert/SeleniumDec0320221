package ConstrutorConcept;

public class Emp {
	String name;
	int age;
	String city;
	double sal;
	boolean isPerm;
	
	public void getSalary(String empName) {
		//buss logic
	}

	// const.. will help us to design the object
	public Emp(String name, int age) {
		System.out.println("emp const...");
		this.name = name;
		this.age = age;
	}

	public Emp(String name, int age, String city) {
		System.out.println("emp const...");
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public Emp(String name, int age, String city, double sal, boolean isPerm) {
		this.name = name;
		this.age = age;
		this.city = city;
		this.sal = sal;
		this.isPerm = isPerm;
	}

	public Emp(String name) {
		this.name = name;
	}

	public static void main(String[] args) {

		Emp e1 = new Emp("Tom", 25);
		System.out.println(e1.name);
		System.out.println(e1.age);

		Emp e2 = new Emp("Peter", 30, "LA");
		System.out.println(e2.name + " " + e2.age + " " + e2.city);

		Emp e3 = new Emp("Lisa", 24, "Pune", 12.33, true);

		Emp e4 = new Emp("Ravi");

	}

}
