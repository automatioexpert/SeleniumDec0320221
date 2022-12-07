package MyWebDriverPrograms;

public abstract class AbstractionConcept {

	// All the three types of variables are used for Abstraction
	int amt = 100;
	final int rate = 20;
	static int LoanRate =10;
	static int PersonalLoanRate =50;

	//Partial Abstraction
	//Hiding the implementation Logic is called Abstraction
	//Abstract class can have both abstract methods and Non-abstract methods
	//Abstract class should have atleast one Abstract Method
	//Cannot instantiate or create the object of abstract classes
	//We achieve only Partial Abstraction with Abstract class

	public abstract void Loan(); // Abstract Method --> No Method Body
	public abstract void PersonalLoan(); // Abstract Method --> No Method Body

	//Non Abstract Methods
	public void credit() {
		System.out.println("Bank--Credit");
	}

	public void dedit() {
		System.out.println("Bank--dedit");
	}

	public static void HomeLoan() {
		System.out.println("Bank--HomeLoan");
	}


	public static void main(String[] args) {
		System.out.println("Enter into main method--BANK");
		System.out.println("Enter into main method--HDFC");
		System.out.println("Enter into main method--ICICI");
	}

}
