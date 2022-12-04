package OOP_Abstarct;

public class LoginPageTest {
	
	public static void main(String a[]) {
		
		LoginPage lp = new LoginPage(10);
		lp.title();
		lp.url();
		lp.doLogin("admin", "admin");
		lp.forgotPwd();
		lp.calculatePrice();
		lp.loading();
		lp.javascriptLoading();
		Page.logo();
		
		//top casting:
		Page p = new LoginPage();
		p.url();
		p.title();
		p.calculatePrice();
		p.doLogin("admin", "test123");
		
		//down casting:NA
		
	}
	
	

}
