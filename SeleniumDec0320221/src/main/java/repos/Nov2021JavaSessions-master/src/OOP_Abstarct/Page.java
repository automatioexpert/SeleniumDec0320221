package OOP_Abstarct;

public abstract class Page extends WebPage implements W3C{	
	//0 to 100% abstraction
	//0% -> no abstract methods
	//100% --> only abstract methods
	//partial abstraction
	//can not create the Object of abstract class
	//but I can create the const.... of abstract class and 
	//it will be invoked when you create the object of child class	
	public Page() {
		System.out.println("Page -- default const....");
	}
	
	public Page(int i) {
		System.out.println("Page -- one param " + i);
	}
	
	public abstract void title();
	public abstract void url();

	public void doLogin(String un, String pwd) {
		System.out.println("Page -- login");
	}
	
	public static void logo() {
		System.out.println("page -- logo");
	}
	
	public final void calculatePrice() {
		System.out.println("page -- calculate price");
	}
	
	@Override
	public void loading() {
		System.out.println("page -- loading...");
	}
	
	@Override
	public final void javascriptLoading() {
		System.out.println("LP -- javascriptLoading");
	}
	

}
