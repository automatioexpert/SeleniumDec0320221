package javasessions;

public class Ecomm {

	// Method Overloading: Poly(many)+Morphism(forms) --> CompileTime (static)
	// Within the same class, we have number of methods:
	// 1. with the same name
	// 2. different number of parameters
	// 3. different types of paramaters
	// 4. differnet sequence of the parameters
	// --return type doesnt matter

	public void test() {// 0 param
		System.out.println("test method");
	}

//	public int test(int a) {//1 param
//		System.out.println("test method:"+a);
//		return a+10;
//	}

	public double test(int a) {// 1 param
		System.out.println("test method:" + a);
		return a + 12.33;
	}

	public double test(double a) {// 1 param
		System.out.println("test method:" + a);
		return a + 20.11;
	}

	public void test(int a, int b) {// 2 param
		System.out.println("test method:" + (a + b));
	}

	public void test(String a, int b) {// 2 param
		System.out.println("test method:" + (a + b));
	}

	public void test(int a, String b) {// 2 param
		System.out.println("test method:" + (a + b));
	}

	// login:
	public void login() {

	}

	public void login(String un, String pwd) {

	}

	public void login(String un, String pwd, int otp) {

	}

	public void login(String un, String pwd, String role) {

	}

	// search:
	public void search() {
		// 1000
	}

	public void search(String productName) {
		// 100
	}

	public void search(String productName, int price) {
		// 50
	}

	public void search(String productName, int price, String color) {
		// 10
	}

	public void search(String productName, int price, String color, String sellerName) {
		// 10
	}

	// payment:
	public void doPayment(String cc, int cvv) {

	}

	public void doPayment(String cc, int cvv, int otp) {

	}

	public void doPayment(String upi) {

	}

	// uber app:
	public void booking(String stPoint, String endPoint) {

	}

	public void booking(String stPoint, String endPoint, String carType) {

	}

	public void booking(String stPoint, String endPoint, String carType, int persons) {

	}

	public static void main(String a[]) {
//		System.out.println(a.length);//0
//		System.out.println(a[0]);//AIOB
		
		Ecomm obj = new Ecomm();
		obj.test();
		double d = obj.test(10);
		System.out.println(d);
		obj.test(100, "testing");
		obj.booking("koramangla", "Whitefield");
	}
	
	

}
