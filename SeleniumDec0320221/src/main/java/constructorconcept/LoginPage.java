package constructorconcept;

public class LoginPage {

	public String driver;

	public void testing(LoginPage lp1) {

		System.out.println(lp1.driver);
		lp1.driver = "chrome";
		System.out.println(lp1.driver);

	}

	public void click() {
		System.out.println(driver.length());
		getEmps("naveen", "Ravi");
	}
	
	public void getEmps(String...a) {
		System.out.println(a.length);
	}

}
