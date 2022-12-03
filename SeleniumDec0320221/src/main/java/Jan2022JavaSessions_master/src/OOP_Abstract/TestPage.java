package OOP_Abstract;

public class TestPage {

	public static void main(String[] args) {

		HomePage hp = new HomePage(10);
		hp.title();
		hp.url();
		hp.timeOut();
		hp.logo();

		LoginPage lp = new LoginPage();
		lp.timeOut();
		lp.title();
		lp.url();
		lp.doLogin();
		
		//top casting:
		Page p = new LoginPage();
		p.title();
		p.url();
		p.timeOut();
		p.logo();
		

	}

}
