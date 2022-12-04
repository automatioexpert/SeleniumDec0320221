package OOP_Abstarct;

public class LoginPage extends Page{
	
	public LoginPage() {
		System.out.println("LP -- defalt const....");
	}
	
	public LoginPage(int i) {
		System.out.println("LP -- one param const...."+i);
	}

	@Override
	public void title() {
		System.out.println("LP -- title");
	}

	@Override
	public void url() {
		System.out.println("LP -- url");
	}
	
	@Override
	public void doLogin(String un, String pwd) {
		System.out.println("Page -- login "+ un + ":"+ pwd);
	}
	
	public void forgotPwd() {
		System.out.println("LP -- forgot pwd");
	}
	
	@Override
	public void loading() {
		System.out.println("Login page -- loading...in 10 secs");
	}

	
	

}
