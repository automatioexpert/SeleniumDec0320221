package javasessions;


public class MathematicalOperations {

	public static void main(String[] args) {

		
		System.out.println(9/3);
		System.out.println(9/2);//4
		System.out.println(9.0/2);//4.5
		System.out.println(9/2.0);
		System.out.println(9.0/2.0);
		
		System.out.println(0/100);
		//System.out.println(9/0);//AE
		System.out.println(9.0/0);//Infinity
		System.out.println(9/0.0);//Infinity
		//System.out.println(0/0);//AE
		System.out.println(0.0/0.0);//NaN
		System.out.println(0.0/0);//NaN
		System.out.println(0/0.0);//NaN
		
		System.out.println(9 % 2);
		System.out.println(10 % 2);
		System.out.println(100 % 3);
		
		System.out.println('a'/97);
		System.out.println('b' - 'a');
		System.out.println('b' / 'a');
		System.out.println('b' * 'a');
		
		System.out.println("hello" + "testing");
		
		System.out.println("hello" + 12.33 + 30 + 12.33 + 'a' + 'b'+ 100);
		System.out.println(12.33 + 30 + 12.33 + 'a' + 'b'+ 100);

	}

}
