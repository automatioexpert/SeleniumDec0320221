package javasessions;

public class StringConcatenation {

	public static void main(String[] args) {

		int a = 100;
		int b = 200;
		
		String x = "Hello";
		String y = "World";
		
		System.out.println(a+b);
		System.out.println(x+y);
		
		System.out.println("HelloWorld");
		System.out.println(100);
		System.out.println(a);
		
		System.out.println(a+x);
		System.out.println(a+b+x+y);
		System.out.println(x+y+a+b);
		System.out.println(x+y+(a+b));
		
		System.out.println("the value of a : " + a);
		System.out.println("the value of b : " + b);
		System.out.println("the sum is: " + (a+b));
		
		double d1 = 12.33;
		double d2 = 23.44;
		System.out.println(a+b+d1);
		System.out.println(d1+d2+x+y);
		System.out.println(x+y+a+b+d1+d2);
		
		// I Love "Java" and Python
		System.out.println("I Love \"Java\" and Python");
		//welcome "naveen"
		
		

	}

}
