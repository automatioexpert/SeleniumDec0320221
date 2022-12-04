package OOP_Encapsulation;

public class LoginPageTest {

	public static void main(String[] args) {

		//user1: naveen
		LoginPage u1 = new LoginPage("naveenauto", "test123");
		System.out.println(u1.getUsername());
		System.out.println(u1.getPassword());
		
		//user2: Shabeer
		LoginPage u2 = new LoginPage("Shabeer", "Shabeer123");//POST
		System.out.println(u2.getUsername());//GET
		System.out.println(u2.getPassword());

		u2.setPassword("selenium123");//update//PUT
		
		System.out.println(u2.getUsername());
		System.out.println(u2.getPassword());
		
		u2.doLogin(u2.getUsername(), u2.getPassword());
		
		
		
		LoginPage u3 = new LoginPage("naveenauto", "test123");
		u3.doLogin();
		
		
		Browser br = new Browser();
		br.launchBrowser();

		
	}

}
