package OOP_Abstract;

public abstract class Page {

	// abstract methods + non abstract methods
	// can not create the object of abstract class
	// but can create the const... of abstract class
	// and this const.. will be called when you create object of child class
	
	//can have  no abstract method -- 0% abstraction
	//can have only abstract methods -- 100% abstraction
	//abstract methods + non abstract methods -- partial abstraction

	public Page() {
		System.out.println("page const...");
	}

	public Page(int a) {
		System.out.println("page const..." + a);
	}

	public abstract void title();

	public abstract void url();

	public void timeOut() {
		System.out.println("page time out is 10 secs");
	}

	public final void logo() {
		System.out.println("page logo");
	}

}
