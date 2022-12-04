package javasessions;

public class Persons {

	String name;//class 
	int age;
	String city;

	public Persons(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Persons(String name, String city) {
		this.name = name;
		this.city = city;
	}

	public Persons(String name, int age, String city) {
		this.name = name;
		this.age = age;
		this.city = city;
	}

	// constructor:
	// name should be as same as the class name:
	// its not a functions but it looks like a function
	// const.. can not return any value, it can not any void also
	// const... overloading can be done
	// const.. will be called when you create the object of the same class

//	public Persons() { //0 param
//		System.out.println("default const...");
//	}
//	
//	public Persons(int i) {//1 params
//		System.out.println("1 param: " + i);
//	}
//	
//	public Persons(int i, String a) {//2 params
//		System.out.println("2 params: " + i + a);
//	}

	public void getInfo() {
		System.out.println("get info");
	}

}
