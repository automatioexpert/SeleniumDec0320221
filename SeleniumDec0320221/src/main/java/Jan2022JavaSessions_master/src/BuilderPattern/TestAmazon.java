package BuilderPattern;

public class TestAmazon {

	public static void main(String[] args) {

		EcommApp obj = new EcommApp();
		obj.login("naveen@gmail.com", "naveen@123")
			.search("iMac")
				.addToCart("iMac")
					.doPayment("1212 2222 3333 4444", 1234)
						.generateOrderId()
							.logout();
		
		//
		obj.login("naveen@gmail.com", "naveen@123")
			.search("iphone 13")
				.logout();
		
		//
		obj.login("naveen@gmail.com", "naveen@123")
			.logout();
		
		//
		obj.login("naveen@gmail.com", "naveen@123")
			.addToCart("macbook");
		
		//
		obj.login()
			.generateOrderId()
				.search("iph12", 10000)
					.addToCart("iph12")
						.logout();
	}

}
