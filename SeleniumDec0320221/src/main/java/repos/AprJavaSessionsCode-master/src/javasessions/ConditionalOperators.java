package javasessions;

public class ConditionalOperators {

	public static void main(String[] args) {

		int i = 10;
		int j = 20;

		System.out.println(i == j);

		if (i == j) {
			System.out.println("both are eql");
		} else {
			System.out.println("both are not eql");
		}

		if (j >= i) {
			System.out.println("hi");
		}

		if (i <= j) {
			System.out.println("hello");
		}

		if (true) {
			System.out.println("Hello Naveen");
		} else {// dead code
			System.out.println("Bye");
		}

		boolean flag = true;
		if (flag) {
			System.out.println("hi");
		} else {
			System.out.println("bye");
		}

		// nested if
		int marks = 80;
		if (marks <= 100) {
			if (marks >= 90) {
				System.out.println("A Grade");
			}
			if (marks <= 80) {
				System.out.println("B Grade");
				if (marks <= 50) {
					System.out.println("C Grade");
				} else {
					System.out.println("Good Bye");
				}
			} else {
				System.out.println("Good Bye");
			}
		} else {
			System.out.println("wrong marks");
		}

		//
//		String browser = "chrome";
//		if(browser.equals("chrome")) {
//			System.out.println("launch chrome");
//		}
//		if(browser.equals("firefox")) {
//			System.out.println("launch firefox");
//		}
//		if(browser.equals("safari")) {
//			System.out.println("launch safari");
//		}
//		else {
//			System.out.println("please pass the right browser");
//		}

		//
		String browser = "chrome";
		if (browser.equals("chrome")) {
			System.out.println("launch chrome");
		} else if (browser.equals("firefox")) {
			System.out.println("launch firefox");
		} else if (browser.equals("safari")) {
			System.out.println("launch safari");
		} else {
			System.out.println("please pass the right browser");
		}

		// given three different numbers are there
		// 100, 200, 300 --> 300

		int x = 700;
		int y = 600;
		int z = 800;
		if (x > y && x > z) {//true && false = false
			System.out.println("x is the greatest");
		}
		else if (y > z) {//false
			System.out.println("y is the greatest");
		}
		else {
			System.out.println("z is the greatest");
		}

	}

}
