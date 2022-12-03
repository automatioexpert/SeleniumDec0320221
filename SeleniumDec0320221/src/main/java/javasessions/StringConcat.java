package javasessions;

public class StringConcat {

	public static void main(String[] args) {
		
		
		String s = "Hello World";
		System.out.println(s);
		
		System.out.println(10);
		System.out.println("hello selenium");
		
		int a = 100;
		int b = 200;
		
		String x = "Hello";
		String y = "Selenium";
		
		System.out.println(a+b);
		System.out.println(x+y);
		System.out.println(a+x);
		System.out.println(a+b+x+y);
		System.out.println(x+y+a+b);
		System.out.println(x+y+(a+b));

		System.out.println("the value of a : " + a);
		System.out.println("the value of b : " + b);
		System.out.println("the sum is : " + (a+b));

		char c1 = 'a';//97
		char c2 = 'b';//98
		char c3 = '9';//57
		System.out.println(c1);
		System.out.println(c1+c2);///97+98 = 195
		
		//a-z : 97 to 122
		//A-Z : 65 to 90
		//0-9: 48 to 57
		
		System.out.println((int)c3);
		System.out.println(c3-c2);
		
		System.out.println(c1+""+c2);
		System.out.println(c1+"");
		
		System.out.println(x+c1+c2);
		System.out.println(c1+c2+x+y);
		
		System.out.println((int)c1 + (int)c2 + "");

	}

}
