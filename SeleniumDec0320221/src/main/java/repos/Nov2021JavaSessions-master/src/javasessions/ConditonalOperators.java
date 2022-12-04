package javasessions;

public class ConditonalOperators {

	public static void main(String[] args) {

//		byte b = 065;
//		System.out.println(b);
		// 065 --> 5x8^0
		// 065 = (0 × 8²) + (6 × 8¹) + (5 × 8⁰) = 53

		int a = 10;
		int b = 20;

		System.out.println(a == b);

		if (a == b) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

		if (true) {
			System.out.println("Hi");
		} else {
			System.out.println("Bye");
		}

		boolean flag = true;
		if (flag) {
			System.out.println("Selenium");
		} else {
			System.out.println("UFT");
		}

		double d1 = 12.33;
		double d2 = 12.34;
		if (d1 == d2) {
			System.out.println("both are eq");
		} else {
			System.out.println("both r not eq");
		}

		String s1 = "Hello";
		String s2 = "Hello";
		if (s1.equals(s2)) {
			System.out.println("eq");
		} else {
			System.out.println("not eq");
		}

		if (s1.equalsIgnoreCase(s2)) {
			System.out.println("eqq");
		}

		if (s1 == s2) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

		//
		int total = 85;
		if (total <= 100) {
			if (total >= 95) {
				System.out.println("A++");
			} else {
				System.out.println("GRADE A");
			}
		}
		
		//
		String browser = "chrome";
		if(browser.equals("chrome")) {
			System.out.println("launch chrome");
		}
		
		if(browser.equals("ff")) {
			System.out.println("launch ff");
		}
		
		if(browser.equals("safari")) {
			System.out.println("launch safari");
		}
		
		if(browser.equals("ie")) {
			System.out.println("launch ie");
		}

		else {
			System.out.println("please pass the right browser");
		}
		
		
	}

}
