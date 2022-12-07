package object_Oriented_Programming;

public class ConstructorParameterized {
	int id;
	String name;

	// creating a parameterized constructor
	ConstructorParameterized(int i, String n) {
		id = i;
		name = n;
	}

	// method to display the values
	void display() {
		System.out.println(id + " " + name);
	}

	public static void main(String args[]) {
		// creating objects and passing values
		ConstructorParameterized s1 = new ConstructorParameterized(111, "Karan");
		ConstructorParameterized s2 = new ConstructorParameterized(222, "Aryan");
		// calling method to display the values of object
		s1.display();
		s2.display();
	}
}
