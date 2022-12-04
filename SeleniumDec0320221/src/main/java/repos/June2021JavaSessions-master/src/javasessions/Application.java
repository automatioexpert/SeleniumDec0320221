package javasessions;

public class Application {

	// Method Overloading:
	// within the same class, when we have different methods with:
	// 1. the same name
	// 2. differnet parameters
	// 3. the sequnce of the params should be different

	// compile time Polymorphism
	// Poly+morphism ==> many forms

	// diff bw parameter and argument

	public void test() {// 0 param
		System.out.println("default function...");
	}

	public void test(int a) { // 1 param
		System.out.println("1 param function..." + a);

	}

	public void test(String a) { // 1 param

	}

	public void test(int a, int b) { // 2 params

	}

	public void test(int a, String b) { // 2 params

	}

	public void test(long a, String b) { // 2 params

	}

	public void test(byte a, String b) { // 2 params

	}

	public void test(String a, int b) { // 2 params

	}

	// Ecomm:
	public void login() {

	}

	public void login(String un, String pwd) {

	}

	public void login(String un, String pwd, String role) {

	}

	public void login(String un, String pwd, long ph) {

	}

	public void login(String un, String pwd, int otp) {

	}

	public void login(String emailId, int otp) {

	}

	// search:
	public void search() {

	}

	public void search(String name) {

	}

	public void search(String name, String color) {

	}

	public void search(String name, String color, int price) {

	}

	// payment:
	public void payment(String cc, String pwd) {

	}

	public void payment(String cc, String pwd, int otp) {

	}

	public int payment(String upi, long ph, int otp) {
		return 100;
	}

	public String payment(String debitCard) {
		return "payment is done";
	}

	// Uber: booking car
	// carType, from, to, code -- PO
	public void bookingCar() {

	}

	public void bookingCar(String carType) {

	}

	public void bookingCar(String carType, String from, String to) {

	}

	public void bookingCar(String carType, String from, String to, String code) {

	}

	// Automation FW:
	public void click() {

	}

	public void click(String locator) {

	}

	public void click(int x, int y) {

	}

	public void click(String locator, int x, int y) {

	}

	// wait:
	public void waitForElement(int timeOut) {

	}

	public void waitForElement(String locator, int timeOut) {

	}

	public void get(int a, byte b) {
		System.out.println("hii");
	}

	public void get(int a, long b) {
		System.out.println("hey");
	}

	public static void main(String[] args) {

		Application a = new Application();
		a.test();
		a.test(10);
		a.test(10, 20);// call by value

		a.bookingCar("sedan", "Point A", "Point B");
		
		a.get(10, 2000000000);

	}

}
