package SuperKeyword;

public class HDFCBank extends Bank {
	
	int min_bal = 200;
	
	public HDFCBank(int a) {
		super(20);
		System.out.println("this hdfc const...." + a);
	}
	
	public HDFCBank(String name, String branchName) {
		super(name, branchName);
	}
	
	

	public void balanceDisplay() {
		System.out.println("HDFCBank -- balance display");
		System.out.println(min_bal);
		System.out.println(super.min_bal);
		super.balanceDisplay();
		super.account();
		System.out.println(super.min_age);
		System.out.println(Bank.min_age);
	}

}
