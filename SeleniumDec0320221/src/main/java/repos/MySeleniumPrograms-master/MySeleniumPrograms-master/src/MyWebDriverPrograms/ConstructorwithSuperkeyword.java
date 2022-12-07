package MyWebDriverPrograms;

public class ConstructorwithSuperkeyword extends ConstructorConcept {

	public ConstructorwithSuperkeyword() {
	// Constructor with Super keyword, Super Keyword is used to call/access parent class constructor from child class
	// Must use super keyword only inside child class constructor
	// Call to Super() method must be the first statement

		super("Jay", 40);
		System.out.println("Child class Constructor 'ConstructorwithSuperkeyword' ");
		System.out.println("Name :" +name);
		System.out.println("Age :" +Age);
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ConstructorwithSuperkeyword value = new ConstructorwithSuperkeyword();
		System.out.println("Name and Age values are correct !!!");
	}

}
