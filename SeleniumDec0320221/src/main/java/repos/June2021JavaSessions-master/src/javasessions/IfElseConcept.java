package javasessions;

public class IfElseConcept {

	public static void main(String[] args) {

		int a = 10;
		int b = 20;

		System.out.println(a == b);

		if (a == b) {
			System.out.println("both are equal");
		} else {
			System.out.println("both are not equal");
		}

		if (true) {
			System.out.println("PASS");
		} else {// dead code
			System.out.println("FAIL");
		}

		boolean flag = false;
		if (flag) {
			System.out.println("hiii");
		} else {
			System.out.println("bye...");
		}

		String s = "selenium";

		if (s.equals("selenium")) {
			System.out.println("I learn selenium...");
		}
		if (s.equals("cypress")) {
			System.out.println("I learn cypress...");
		}

		String browser = "chrome";
//		
		if (browser.equals("chrome")) {
			System.out.println("launch chrome");
		}
		if (browser.equals("firefox")) {
			System.out.println("launch ff");
		}
		if (browser.equals("safari")) {
			System.out.println("launch safari");
		}
		if (browser.equals("edge")) {
			System.out.println("launch edge");
		} else {
			System.out.println("browser not found....");
		}

		// String browser = "chrome";
		if (browser.equals("chrome")) {
			System.out.println("launch chrome");
		} else if (browser.equals("firefox")) {
			System.out.println("launch ff");
		} else if (browser.equals("safari")) {
			System.out.println("launch safari");
		} else if (browser.equals("edge")) {
			System.out.println("launch edge");
		} else {
			System.out.println("browser not found....");
		}

		// switch-case:
		// String browser = "edge";
		switch (browser) {
		case "chrome":
			System.out.println("launch chrome");
			break;
		case "firefox":
			System.out.println("launch ff");
			break;
		case "safari":
			System.out.println("launch safari");
			break;
		case "edge":
			System.out.println("launch edge");
			break;

		default:
			System.out.println("please pass the correct browser.....");
			break;
		}

		int marks = 10;

		switch (marks) {
		case 1:
			System.out.println("case 1");
			break;
		case 10:
			System.out.println("case 10");
			break;
		case 100:
			System.out.println("case 100");
			break;

		default:
			break;
		}

		//>=90 -- Grade A, 
		//71 - 90 ---> grade B
		//50 to 70--> grade C
		//less 50 -- Fail
		int m = 70;
		if (m <= 100) {
			if (m >= 90) {
				System.out.println("Grade A");
			}
		}
		else {
			System.out.println("incorrect marks");
		}

		//WAP to find out the highest number out of three diff numbers:
		int x = 500;
		int y = 800;
		int z = 300;
		//&& -> short circuit operator
		if(x>y && x>z) {//false && true = false
			System.out.println("x is the highest");
		}
		else if(y>z) {//false
			System.out.println("y is the highest");
		}
		else {
			System.out.println("z is the highest");
		}
		
		//&& || 
		String s1 = "Linux";
		if(s1.equals("Win") && s1.equals("Mac") && s1.equals("Linux")) {
			System.out.println("OS is running....");
		}
		
		String user = "admin";
		if(!user.equals("admin")) {
			System.out.println("login with admin....");
		}
		else {
			System.out.println("login with normal user");
		}
		
		String text = "naveen";
		System.out.println(text.isEmpty());
		System.out.println(text.isBlank());
		
		if(!text.isBlank()) {
			System.out.println("text link is found....");
		}
		
		int i = 'a';//97
		char c = 'b';//98
		System.out.println(c);//b
		System.out.println(i+c);
		
		System.out.println('a'+'b');
		System.out.println('a'+""+'b');
		System.out.println(97+""+'b');

		System.out.println(c++);
		System.out.println(c);
		
		int v = 2;
		System.out.println(v++ + ++v);
		
	}

}
