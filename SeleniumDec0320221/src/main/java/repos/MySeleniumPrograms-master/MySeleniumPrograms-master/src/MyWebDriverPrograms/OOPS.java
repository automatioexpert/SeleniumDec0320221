package MyWebDriverPrograms;

public class OOPS extends AbstractionConcept implements InterfaceExample  {

	public static void main(String[] args) {
		// If a class implements any interface then it should define/override all the methods of interface.

		//Dynamic polymorphism OR Runtime Polymorphism
		// Child class object can be reffered by parent Interface Reference Variable 'a' from below
		InterfaceExample a = new OOPS();
		 a.dbconnection();
		 a.StudentDetails();
		 a.StudentResult();
		 a.testconnection();
		 System.out.println("College Name is:" +InterfaceExample.Collegename);
		 System.out.println("Subjects are:" +InterfaceExample.Subjects);

		 AbstractionConcept b = new OOPS();
		 b.PersonalLoan();
		 b.Loan();
		 b.dedit();
		 b.credit();
		 AbstractionConcept.HomeLoan();// Static always written as Classname.Methodname
		 System.out.println("Amount is :" +b.amt);
		 System.out.println("Rate is :" +b.rate);
		 System.out.println("LoanRate is :" +AbstractionConcept.LoanRate);
		 System.out.println("Personal Loan Rate is :" +AbstractionConcept.PersonalLoanRate);

	}

	@Override
	public void dbconnection() {
		System.out.println("Printing dbconnection");
	}


	@Override
	public void testconnection() {
	  System.out.println("The testconnection is Working");

	}

	@Override
	public void StudentDetails() {
		  System.out.println("Computer Dept. Student Detail Part");
		 }

	@Override
	public void StudentResult() {
		  System.out.println("Computer Dept. Student Result Part");
		 }

	@Override
	public void Loan() {
		System.out.println("Loan Method extended from the AbstractionConcept Class");
		//Static variable is always written as Classname.VariableName
		System.out.println("LoanRate is :" +AbstractionConcept.LoanRate);
	}

	@Override
	public void PersonalLoan() {
		System.out.println("PersonalLoan Method extended from the AbstractionConcept Class");
		//Static variable is always written as Classname.VariableName
		System.out.println("Personal Loan Rate is :" +AbstractionConcept.PersonalLoanRate);
	}
}
