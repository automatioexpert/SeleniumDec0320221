package javasessions;

public class Ecomm {

	// Method overloading:
	// when we have different methods:
	// 1. within the same class
	// 2. with the same name
	// 3. with different parameters
	// 4. with different sequence/order of parameters

	// Poly(Many)+Morphism(Forms) --> Compile time (Static)

	public int test() {// 0
		System.out.println("test method");
		return 10;
	}

	public String test(int i) {// 1
		System.out.println("test method " + i);
		return "IBM";
	}

	public void test(String i) {// 1
		System.out.println("test method " + i);
	}

	public void test(int i, int j) {// 2
		System.out.println("test method " + (i + j));
	}

	public void test(int j, double i) {// 2
		System.out.println("test method " + (i + j));
	}

	public void test(int i, String j) {// 2
		System.out.println("test method " + (i + j));
	}

	public void test(String i, int j) {// 2
		System.out.println("test method " + (i + j));
	}

	//
	public void login() {

	}

	public void login(String un, String pwd) {

	}

	public void login(String un, String pwd, String role) {

	}

	public void login(String un, String pwd, long ph) {

	}

	public void login(String sociaMediaAcc, int otp) {

	}

	// search:
	public void search() {

	}

	public void search(String productName) {

	}

	public void search(String productName, String color) {

	}

	public void search(String productName, String color, int price) {

	}

	// payment:
	public void doPayment(String upi) {

	}

	public void doPayment(String upi, int otp) {

	}

	public void doPayment(String cc, String pwd) {

	}

	public void doPayment(String paypal, String pwd, int otp) {

	}

	// uber: booking:
	public void booking() {

	}

	public void booking(String st, String end) {

	}

	public void booking(String st, String end, String carType) {

	}

	public void booking(String st, String end, String carType, int users) {

	}

	public static void main(String[] args) {

		Ecomm obj = new Ecomm();
		int n = obj.test();
		System.out.println(n);
		obj.test(100);
		
	}

}
