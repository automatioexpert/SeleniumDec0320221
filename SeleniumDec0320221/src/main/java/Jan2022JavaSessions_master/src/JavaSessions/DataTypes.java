package JavaSessions;

/*
 * @author Naveen
 */
public class DataTypes {

	//this is my first java code
	public static void main(String[] args) {
		
		//data types:
		//strict type:
		//1. primitive data types: no need of Object
			//boolean type: boolean : true/false
			//Numeric type:
				//a. Character type: char
				//b. Intergral Value:
					//b.1: Integer: byte, short, int, long
					//b.2: Floating-point: float, double
				
		//2. non primitive data types: String, Arrays, Class, Interface
		//Objects will come into the picture
		
		//1. byte:
		//range: -128 to 127
		//size: 1 byte = 8 bits
		byte b = 10;
		b = 30;
		b = 40;
		byte b1 = 20;
		byte b2 = 0;
		byte b3 = -90;
		byte b4 = 1;
		System.out.println(b);
		System.out.println(b+b1);
		byte seats = 4;
		
		//2. short:
		//range: -32768 to 32767
		//size: 2 bytes = 16 bits
		short s = 1000;
		short s1 = 1;
		
		//3. int:
		//range: -2147483648 to 2147483647
		//size: 4 bytes = 32 bits
		int i = 1;
		int totalBill = 12222222;
		
		//4. long:
		//range: 
		//size: 8 bytes = 64 bits
		long l = 2222222222222l;
		System.out.println(l);
		
		long pop = 121212121212121l;
		long cc = 121223232323233l;
		long ssn = 89898989898l;
		
		//4. float: 
		//size: 4 bytes = 32 bits
		//range: after point, it can take upto 7 digits
		float f = 12.33f;
		System.out.println(f);
		
		float f1 = (float)34.44;
		System.out.println(f1);
		
		//5. double:
		//size: 8 bytes = 64 bits
		//range: after point, it can take upto 15 digits
		double d = 12.3333;
		
		double d1 = 100;
		System.out.println(d1);
		
		//6. char: single digit value
		//size: 2 bytes = 16 bits
		char c = 'a';
		char c1 = '1';
		char c2 = '$';
		char c3 = 'h';
		char gender = 'f';
		char flag = 'Y';
		
		//7. boolean:
		//size: ~1 bit
		boolean fl = true;
		boolean flg = false;
		
		System.out.println(10 % 2);
		System.out.println(10 % 3);
		System.out.println(5 % 2);
		
		byte t = 065;
		System.out.println(t);
		//065 = (0 × 8²) + (6 × 8¹) + (5 × 8⁰) = 53
		
		byte t1 = 077;
		System.out.println(t1);

	}

}


