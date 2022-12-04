package BuilderPattern;

public class AmazonShop {

	public AmazonShop login() {
		System.out.println("login to app");
		return this;
	}

	public AmazonShop login(String un, String pwd) {
		System.out.println("login with: " + un + " " + pwd);
		return this;
	}

	public AmazonShop search() {
		System.out.println("display all the products");
		return this;
	}

	public AmazonShop search(String productName, String color) {
		System.out.println("display all the products with : " + productName + " " + color);
		return this;
	}

	public AmazonShop search(String productName, String color, int price) {
		System.out.println("display all the products with : " + productName + " " + color + " " + price);
		return this;
	}

	public AmazonShop addToCart(String productName) {
		System.out.println("add to cart: " + productName);
		return this;
	}

	public AmazonShop doPayment(String cc, int cvv) {
		System.out.println("make payment with : " + cc + " " + cvv);
		return this;
	}

	public AmazonShop doPayment(String upiNumber) {
		System.out.println("make payment with : " + upiNumber);
		return this;
	}

	public AmazonShop generateOrderId() {
		System.out.println("your order id is : " + 12345);
		return this;
	}

	public AmazonShop logout() {
		System.out.println("logout....");
		return this;
	}

}
