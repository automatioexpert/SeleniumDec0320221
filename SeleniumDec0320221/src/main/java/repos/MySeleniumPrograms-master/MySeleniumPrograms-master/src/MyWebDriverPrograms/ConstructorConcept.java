package MyWebDriverPrograms;

//A Constructor is a block of code similar to method that is invoked or called when an instance of an object is created.
// A Constructor looks similar to a method but it is not a method
// A Constructor doesn't have a return type
// The name of the constructor must be same as the name of the class
// Similarly like Method overloading, Constructor can also be overloaded with different signatures or arguments
public class ConstructorConcept {

	String name;
	int Age;

	public ConstructorConcept() { // Following params in Constructor overloading
		System.out.println("Default Constructor");
	}

	public ConstructorConcept(int i) {
		System.out.println("Single param constructor");
		System.out.println("Value of i:" + i);
	}

	public ConstructorConcept(int i, int j) {
		System.out.println("Two params constructor");
		System.out.println("Value of i:" + i);
		System.out.println("Value of j:" + j);
	}

	public ConstructorConcept(String name, int Age) {

		// This Keyword:-
		//---------------
		// this.Class Variable = Local variable
	    // 'This' Keyword is used to access the current class constructor
	    // 'This' keyword can be used also in any non static method or block or in Constructor


		// this() Method:-
		//-----------------
		// "this() Method" - Must be Used only inside another constructor of same class
		// Call to this() method must be the first statement

		this.name = name;
		this.Age = Age;
		System.out.println("Name :" +name);
		System.out.println("Age :" +Age);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ConstructorConcept obj  = new ConstructorConcept();
		ConstructorConcept obj1 = new ConstructorConcept(10);
		ConstructorConcept obj2 = new ConstructorConcept(10, 20);
		ConstructorConcept obj3 = new ConstructorConcept("Jay", 32);
	}

}
