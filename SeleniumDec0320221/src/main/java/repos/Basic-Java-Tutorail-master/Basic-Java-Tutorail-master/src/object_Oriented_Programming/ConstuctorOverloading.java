package object_Oriented_Programming;

public class ConstuctorOverloading {
	int id;
	String name;
	int age;

	// creating two arg constructor
	ConstuctorOverloading(int i, String n) {
		id = i;
		name = n;
	}

	// creating three arg constructor
	ConstuctorOverloading(int i, String n, int a) {
		id = i;
		name = n;
		age = a;
	}

	void display() {
		System.out.println(id + " " + name + " " + age);
	}

	public static void main(String args[]) {
		ConstuctorOverloading s1 = new ConstuctorOverloading(111, "Karan");
		ConstuctorOverloading s2 = new ConstuctorOverloading(222, "Aryan", 25);
		s1.display();
		s2.display();
	}
}
