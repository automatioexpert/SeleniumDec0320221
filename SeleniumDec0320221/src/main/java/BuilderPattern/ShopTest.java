package BuilderPattern;

public class ShopTest {

	public static void main(String[] args) {

		AmazonShop app = new AmazonShop();

		app.login("naveen@gmail.com", "naveen123").
		search("macbook pro", "white")
					.addToCart("macbook pro")
						.doPayment("naveen@hdfc")
							.generateOrderId()
								.logout();
		
				
		
		//
		app.login("admin@gmail.com", "admin123")
				.search("nike tshirt", "black", 1000)
					.addToCart("nike tshirt")
							.logout();
		
		//
		app.login("naveen@gmail.com", "naveen123")
				.search()
						.logout();
		//
		app.login("naveen@gmail.com", "naveen123")
				.doPayment("121212121", 121)
					.generateOrderId()
							.logout();
		
		//
		app.login("naveen@gmail.com", "naveen123")
				.logout();
		
		//
		app.login("naveen@gmail.com", "naveen123");
		
		//
		app.login()
				.search("iPh12", "white")
						.addToCart("iPh12")
							.doPayment("naveen@hdfc")
									.generateOrderId()
											.logout();		
		
	}

}
