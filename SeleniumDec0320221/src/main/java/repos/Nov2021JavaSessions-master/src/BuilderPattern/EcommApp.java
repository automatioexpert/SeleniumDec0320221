package BuilderPattern;

public class EcommApp {
	
	private int orderId;

	public EcommApp login() {
		System.out.println("login to app");
		return this;//current class Object--> new EcommApp();
	}

	public EcommApp login(String un, String pwd) {
		System.out.println("login to app: " + un + ":" + pwd);
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

	public EcommApp clickOnProduct(String productName) {
		System.out.println("click on the product: " + productName);
		return this;

	}

	public EcommApp addToCart(String productName) {
		System.out.println("add to cart:--> product: " + productName);
		return this;

	}

	public EcommApp doPayment(String cc, int cvv) {
		System.out.println("do payment: " + cc + ":" + cvv);
		return this;

	}

	public EcommApp doPayment(String cc, int cvv, int otp) {
		System.out.println("do payment: " + cc + ":" + cvv + ":" + otp);
		return this;

	}

	public EcommApp doPayment(String upi) {
		System.out.println("do payment: " + upi);
		return this;
	}

	public EcommApp generateOrder() {
		System.out.println("order id is: " + 12345);
		this.orderId = 12345;
		return this;
	}
	
	public int getOrderId() {
		return this.orderId;
	}

	public EcommApp sendOrderViaEmail() {
		System.out.println("send Order Via Email and order id " + 12345);
		return this;
	}
	
	public EcommApp logout() {
		System.out.println("logout app");
		return this;
	}

}
