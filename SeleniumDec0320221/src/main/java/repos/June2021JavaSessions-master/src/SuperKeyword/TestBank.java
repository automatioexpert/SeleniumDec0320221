package SuperKeyword;

public class TestBank {

	public static void main(String[] args) {

		HDFCBank hb = new HDFCBank("Naveen", "Pune");
		
		System.out.println(hb.min_bal);
		
		hb.balanceDisplay();

		Bank b = new Bank("ICICI", "Delhi");
		
		HSBCBank hs = new HSBCBank();
		hs.display();
		
	}

}
