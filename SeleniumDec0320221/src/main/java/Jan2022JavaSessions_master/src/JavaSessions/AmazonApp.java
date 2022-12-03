package JavaSessions;

public class AmazonApp {

	public boolean login() {
		System.out.println("login is done");
		return true;
	}

	public void login(String un, String pwd) {

	}

	public void login(String un, String pwd, String role) {

	}

	public void login(String un, String pwd, int otp) {

	}

	public void login(String un, String pwd, long ph, int otp) {

	}

	public void search() {

	}

	public void search(String name) {

	}

	public void search(String name, int price) {

	}

	public void doPayment(String CC, int otp) {

	}

	public void doPayment(String CC, int cvv, String expDate, int otp) {

	}

	public void doPayment(String upi, long ph, int otp) {

	}

	public void doPayment(String paypalId) {

	}

	//
	public void booking(String car, String from, String to) {

	}

	public void booking(String from, String to) {

	}

	public int add(int a, int b) {
		System.out.println("hi");
		return a+b;
	}
	
//	public void add(short a, int b) {
//		System.out.println("bye");
//	}

//	public void add(int a, long b) {
//		System.out.println("hello");
//	}
	
	public double add(int a, double b) {
		System.out.println("hello");
		return a-b;
	}
	
	

	public static void main(String[] args) {

		AmazonApp ap = new AmazonApp();
		ap.add(10, 20);
		
		int a = 10;
		int b = 20;
		System.out.println(a+b);
		
		String s = "Hello";
		System.out.println(s+(a+b));
		
	}

}
