package javasessions;

public class StringConcatenation {

	public static void main(String[] args) {

		String x = "Hello";
		String y = "World";

		int a = 100;
		int b = 200;
		double d1 = 12.33;
		double d2 = 23.44;

		System.out.println(a + b);
		System.out.println(x + y);
		System.out.println(a + b + x + y);
		System.out.println(x+y+a+b);//HelloWorld100200
		System.out.println(x+y+(a+b));
		System.out.println(d1+d2);
		System.out.println(b-a);
		System.out.println(b/a);
		System.out.println(a * b);
		System.out.println(x+y+d1+d2+a+b);
		System.out.println(x+y+(d1-d2+a+b));
		
		
		int h = 10;
		int p = 2;
		System.out.println(h/p);
		System.out.println(9/3);
		System.out.println(9.0/3);
		System.out.println(9.0/3.0);
		System.out.println(9/3.0);
		//System.out.println(9/0); //ArithmeticException
		System.out.println(9.0/0);//Infinity
		System.out.println(8.33/0);//Infinity
		System.out.println(9/0.0);//Infinity
		System.out.println(9.0/0.0);//Infinity
		//System.out.println(0/0);//ArithmeticException
		System.out.println(0.0/0.0);//NaN
		System.out.println(0/9);
		System.out.println(0/12.33);
		System.out.println(0.0/9);
		
		System.out.println(8 % 2);
		System.out.println(901 % 2);
		
		System.out.println(9.2 % 2);
		
		System.out.println(0.1+0.3);
		System.out.println(0.2+0.3);
		System.out.println(0.1+0.4);
		System.out.println(0.1+0.2);


	}

}
