package OOP_Abstract;

public class TestPage {

	public static void main(String[] args) {

		LoginPage lp = new LoginPage(10);
		lp.logo();
		lp.pageUrl();
		lp.header();
		lp.title();
		lp.forogotPwd();
		lp.doLogin("admin", "admin");
		Page.bussiness();
		LoginPage.bussiness();
		
		//top casting: child class object can be 
		//referred by abstract parent class ref variable
		Page p = new LoginPage();
		p.title();
		p.header();
		p.logo();
		p.pageUrl();
		
		//down casting: NA
		
		
	}

}
