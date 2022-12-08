package OOPs_Concepts;

public class Bank_Test extends RetailBank implements PolicyCalculator{
	
	// This Class is extends RetailBank class which means it inherits the property of parent class
	
	
	public static void main(String[] args) {
		
		RetailBank rb = new RetailBank();
		
		//Inheriting from super parent class
		
		rb.InvestmentBanking();
		rb.RetailBankingguide();
		
		// Inheriting from parent class
		rb.OurRule();
		rb.lending();
		
	}
	
	//On implementing the interface all its methods are overridden
	
	

	@Override
	public void InsuranceCalculator() {
		
		
	}

	@Override
	public void FixedDepositReturnCalucator() {
		
		
	}

	@Override
	public void SIPCalculator() {
		
		
	}

}
