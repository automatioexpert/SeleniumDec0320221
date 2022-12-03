package constructorconcept;

import java.util.ArrayList;

public class TestComp {

	public static void main(String[] args) {

		Company c1 = new Company("IBM", "NY");
		System.out.println(c1.name + " " + c1.ceo + " " + c1.empCount + " " + c1.sharePrice + " " + c1.hq);
		
		Company c2 = new Company("Infosys", 10000, 500.44);
		System.out.println(c2.name + " " + c2.ceo + " " + c2.empCount + " " + c2.sharePrice + " " + c2.hq);
		
		c2.hq = "Bangalore";
		

		System.out.println(c2.name + " " + c2.ceo + " " + c2.empCount + " " + c2.sharePrice + " " + c2.hq);

		
		Company c3 = new Company("ABC ltd");
		System.out.println(c3.name + " " + c3.ceo + " " + c3.empCount + " " + c3.sharePrice + " " + c3.hq);

		
		Customer cu1 = new Customer("Naveen", "999999", "naveen@gmail.com");
		System.out.println(cu1.ordersList);
		
		ArrayList<String> tomOrderList = new ArrayList<String>();
		tomOrderList.add("MacbookPro");
		tomOrderList.add("iph12");
		tomOrderList.add("nike shoes");

		Customer cu2 = new Customer("Tom", "Peter", tomOrderList);
		
		System.out.println(cu2.fistname + " " + cu2.lastname);
		System.out.println(cu2.ordersList);
		
		LoginPage l = new LoginPage();
		l.driver = "firefox";
		l.testing(l);
		System.out.println(l.driver);
		
		
	}

}
