package OOP_Abstract;

public class PageTest {

	public static void main(String[] args) {

		LoginPage lp = new LoginPage();//child class object
		lp.title();
		lp.url();
		lp.header();
		lp.loadingPage();
		lp.logo();
		Page.footer();
		LoginPage.footer();
		lp.doLogin("admin", "admin");
		lp.loadApp();
		System.out.println(Page.price);
		System.out.println(LoginPage.price);
		
		lp.name = "IBM";
		lp.timeOut = 15;
		System.out.println(lp.name + " : " + lp.timeOut);

		
		
		//top casting: child class object can be referred by parent abstract class ref variable
		Page p = new LoginPage();
		p.title();
		p.url();
		p.header();
		p.loadingPage();
		
		//can I create the object page abst.... class?
		//Page p1 = new Page();
		//down casting: NA
		
		
		
		///
		//Employee e = new Employee();
		
	}

}
