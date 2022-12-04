package OOP_Abstract;

public class LoginPage extends Page {

	// default const...hidden const...JVM will create this at run time

	public LoginPage() {
		System.out.println("LP -- default const....");
	}

	public LoginPage(int timeOut) {
		super(40);
		System.out.println("LP -- with timeout...." + timeOut);
	}

	@Override
	public void header() {
		System.out.println("LP -- header");
	}

	@Override
	public void title() {
		System.out.println("LP -- title");
	}

	public void forogotPwd() {
		System.out.println("LP -- forgot pwd ");
	}

	public void doLogin(String username, String password) {
		System.out.println("login with: " + username + ":" + password);
	}

	//method hiding
	public static void bussiness() {
		System.out.println("Login Page business");
	}

}
