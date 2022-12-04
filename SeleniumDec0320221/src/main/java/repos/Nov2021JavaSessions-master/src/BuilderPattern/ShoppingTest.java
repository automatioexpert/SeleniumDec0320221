package BuilderPattern;

public class ShoppingTest {

	public static void main(String[] args) {

		//user1:
		EcommApp e1 = new EcommApp();
		
		//uc1
		e1.login("naven@gmail.com", "test123")
			.search("iMac")
			.addToCart("iMac")
			.doPayment("123 122 222 222", 212)
			.generateOrder()
			.sendOrderViaEmail()
			.logout();
		
		//uc2:
		e1.login()
		.search("nike shoes")
		.logout();
		
		//uc3;
		e1.login("admin", "admin123")
		.logout();
		
		//uc4:
		int id = e1.login("tom@gmail.com", "tom123")
				.search("macbook pro")
					.addToCart("macbook pro")
						.search("ipad")
							.addToCart("ipad")
								.search("apple pencil")
									.doPayment("naveen@hdfc")
											.generateOrder()
													.sendOrderViaEmail()
															.logout()
																.getOrderId();
		System.out.println(id);
		
		
		//uc5:
		e1.login().logout();
		
		//
		e1.logout();
		
		
		EcommApp e2 = new EcommApp();
		
		
		
	}

}
