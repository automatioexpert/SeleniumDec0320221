package OOP_Abstract;

public class HomePage extends Page {

	//default const...
	public HomePage() {
		System.out.println("Hp -- const...");
	}
	public HomePage(int a) {
		System.out.println("Hp -- const..."+a);
	}
	
	@Override
	public void title() {
		System.out.println("HP -- home page title");
	}

	@Override
	public void url() {
		System.out.println("HP -- home page url");
	}

}
