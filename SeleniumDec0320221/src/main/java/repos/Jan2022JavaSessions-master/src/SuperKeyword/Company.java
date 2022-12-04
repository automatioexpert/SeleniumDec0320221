package SuperKeyword;

public class Company implements Fund{
	
	int salary = 100;
	
	public Company() {
		System.out.println("comp -- const...");
	}
	
	public Company(int a) {
		super();
		System.out.println("comp -- const..." + a);
	}
	
	public void cafe() {
		System.out.println("Comp -- cafe");
		System.out.println(salary);
	}
	
	public final static void logo() {
		System.out.println("comp -- logo");
	}
	

}
