package BuilderPattern;

public class EcommApp {

	public EcommApp login() {
		System.out.println("login to app....");
		return this;
	}

	public EcommApp login(String un, String pwd) {
		System.out.println("login with : " + un + ":" + pwd);
		return this;

	}

	public EcommApp search(String productName) {
		System.out.println("searching the product: " + productName);
		return this;

	}

	public EcommApp search(String productName, int price) {
		System.out.println("searching the product: " + productName + ":" + price);
		return this;

	}

	public EcommApp addToCart(String productName) {
		System.out.println("adding to the cart: " + productName);
		return this;

	}

	public EcommApp doPayment(String CC, int otp) {
		System.out.println("make payment using: " + CC + ":" + otp);
		return this;

	}

	public EcommApp doPayment(String upi) {
		System.out.println("make payment using: " + upi);
		return this;

	}

	public EcommApp generateOrderId() {
		System.out.println("your order id is: " + 12345);
		return this;

	}

	public EcommApp logout() {
		System.out.println("logout from app....");
		return this;

	}

}
