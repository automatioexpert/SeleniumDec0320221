package OOP_Abstract;

public class LoginPage extends Page{

	@Override
	public void title() {
		System.out.println("Lp -- title");
	}

	@Override
	public void url() {
		System.out.println("Lp -- url");
	}
	
	@Override
	public void timeOut() {
		System.out.println("page time out is 5 secs");
	}
	
	public void doLogin() {
		System.out.println("app login");
	}
	
	

}
