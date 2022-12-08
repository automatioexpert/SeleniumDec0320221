package OOPs_Concepts;

public class CentralBankGuidance {
	
	public void lending() {
		
		String Lendingamountdetails = "Banks should lend upto 10% of their Cash Reserve Ratio" ;
		
		String Lendingforms = "An applicant should show their income, expenditure and reason for lending";
		
		String Lendingcriteria = "An applicants CIBIL score should be checked before lending";
		Lendingcriteria = "CIBIL score should be more than 600 or the lender should provide any colateral security";
		
		System.out.println("Plending>>>>>>>" +Lendingamountdetails );
		System.out.println("Plending>>>>>>>" + Lendingforms);
		System.out.println("Plending>>>>>>>" +Lendingcriteria);
		
	}
	
	
	public void RetailBankingguide() {
		
		String custdoc = "Each customer should have checkbook , passbook and debit card";
		
		String minbal = "Each customer should have a minimum balance of 100 in their account";
		
		System.out.println(custdoc);
		System.out.println(minbal);
	}
	
	public void InvestmentBanking() {
		
		String IPO = "ForIPO generation each bank should have a detailed analysed report of the business";
		IPO = "Banks should find share buyers and should fix the price";
		System.out.println(IPO);
		
		String LoanSynd = "For loan sysndication banks should find other appropiate bank for loan process";
		LoanSynd = "Banks should charge fixed amount of commission for this process";
		
	}

}
