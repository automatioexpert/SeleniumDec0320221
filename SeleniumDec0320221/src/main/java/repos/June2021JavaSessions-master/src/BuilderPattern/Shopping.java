package BuilderPattern;

public class Shopping {

	public static void main(String[] args) {

		EcommApp ecom = new EcommApp();
		
		//case1
		ecom.login("naveen123@gmail.com", "test12345")
				.search("tshirts", "black")
					.addToCart("tshirts")
						.doPayment("121212@hdfc", 1234, "test123")
							.getOrderInfo()
								.logout();
		
		//case2
		ecom.login("naveen@gmail.com", "test123")
				.getOrderInfo()
					.logout();
		
		
		//case3:
		ecom.login("naveen@gmail.com", "test123")
				.search("Macbook")
					.logout();
		
		//case4:
		ecom.login("naveen@gmail.com", "test123")
				.logout();
		
		//case5:
		ecom.logout();		
		
	}

}
