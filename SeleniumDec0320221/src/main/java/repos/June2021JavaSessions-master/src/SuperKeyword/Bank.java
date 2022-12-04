package SuperKeyword;

public class Bank {
	
	public Bank() {
		System.out.println("bank const...");
	}
	
	public Bank(int a) {
		System.out.println("bank const..." + a);
	}
	
	public Bank(String name, String branchName) {
		System.out.println("bank const..." + name + " " + branchName);
	}
	
	
	int min_bal = 100;
	static int min_age = 15;
	
	public void balanceDisplay() {
		System.out.println("Bank -- balance display");
	}
	
	public static void account() {
		System.out.println("Bank -- acount");
	}

}
