package BuilderPattern;


public class EcommApp {

	public EcommApp login(String un, String pwd) {
		System.out.println("login with : " + un + " & " + pwd);
		return this;
	}

	public EcommApp search() {
		System.out.println("search the product");
		return this;
	}

	public EcommApp search(String productName) {
		System.out.println("search the product " + productName);
		return this;
	}

	public EcommApp search(String productName, String color) {
		System.out.println("search the product " + productName + " color : " + color);
		return this;
	}

	public EcommApp addToCart(String productName) {
		System.out.println("adding the product to cart : " + productName);
		return this;
	}

	public EcommApp doPayment(String cc, int otp) {
		System.out.println("payment with : " + cc + " " + otp);
		return this;
	}

	public EcommApp doPayment(long phone, int otp) {
		System.out.println("payment with : " + phone + " " + otp);
		return this;
	}

	public EcommApp doPayment(String upi, int otp, String password) {
		System.out.println("payment with : " + upi + " " + otp + " " + password);
		return this;
	}

	public EcommApp getOrderInfo() {
		System.out.println("display the order details....");
		return this;
	}

	public EcommApp logout() {
		System.out.println("logout from the application");
		return this;
	}

}
