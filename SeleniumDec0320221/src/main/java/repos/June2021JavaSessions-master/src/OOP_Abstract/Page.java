package OOP_Abstract;

public abstract class Page {
	
	//can have abstract methods and non abstract methods
	//abst.. class object can not be created
	//abst.. class constructor can be created
	//it will be called when you create the object of child class
	
	public Page() {
		System.out.println("Page default const....launch app page");
	}
	
	public Page(int timeOut) {
		System.out.println("launch app within: " + timeOut);
	}
	
	//abst methods - 2
	//non abstract -- 3
	public abstract void header();
	public abstract void title();
	
	public void pageUrl() {
		System.out.println("http://www.xyz.com");
	}
	
	public final void logo() {
		System.out.println("app logo");
	}

	public static void bussiness() {
		System.out.println("Page business");
	}
	

}
