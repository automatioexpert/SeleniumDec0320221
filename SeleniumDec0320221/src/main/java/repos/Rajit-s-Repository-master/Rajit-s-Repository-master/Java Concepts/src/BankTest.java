
public class BankTest {

	public static void main(String[] args) {
		
		//Static polymorphism since  child class object ref is created and methods of both child and parent class are seen.
		// Overridden methods are not shown here.
		
		RetailBank RB = new RetailBank();
		
		RB.RetailBankingguide();
		RB.lending();
		
		//Dynamic polymorphism since only parent methods and overridden methods are shown. Methods in child class are not displayed.
		
		CentralBankGuidance pobj = new CentralBankGuidance();
		
		pobj.lending();
		

	}

}
