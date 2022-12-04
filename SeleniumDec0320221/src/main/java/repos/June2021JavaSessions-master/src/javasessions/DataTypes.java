package javasessions;

public class DataTypes {

	public static void main(String[] args) {

		//data types: 
		//strict type: 
		
		//1. primitive data types: (we dont need any Object)
				//a. Boolean: boolean - true/false
				//b. Numeric:
						//b.1: Character: char
						//b.2: Integral: 		
								//i). Integer: byte, short, int, long
								//ii). FloatingPoint: float, double		
		
		//2. non primitive data  types: String, Class, Interface, Arrays
		//(we need object to use non prim types)
		
		//Java -- is not 100% object oriented 
		
		//1. byte:
		//range: -128 to 127
		//size: 1 byte = 8 bits
		byte b = 10;//1 byte
		b = 30;
		byte b1 = 20;
		byte b2 = 0;
		byte b3 = -90;
		
		System.out.println(b1+b3);
		System.out.println(b);
		System.out.println(b1);
		
		//2. short:
		//range: -32768 to 32767
		//size: 2 bytes = 16 bits
		short s = 120;
		short s1 = 1000;
		short s2 = 10; //2 bytes
		
		//3. int:
		//range: -2147483648 to 2147483647
		//size: 4 bytes = 32 bits
		int number = 10000;
		
		//long: 
		//range:
		//size: 8 bytes = 64 bits
		long l = 10200;
		long distance = 100000;
		//PNR, Amount, CC, population
		//SSN -- 12122321, 3443-4343-3434--4343
		
		//float:
		//range: can take upto 7 digits after .
		//size: 4 byts = 32 bits
		float f = (float)12.33;
		float f1 = 12.43f;
		System.out.println(f);
		System.out.println(f1);
		
		//double: 
		//size: 8 bytes
		//range: can take upto 16 digits after .
		double d = 12.3333d;
		System.out.println(d);
		double dd = 100;
		System.out.println(dd);
		
		//char:
		//size: 2 bytes = 16 bits
		char c = 'a';
		char c5 = 'b';
		char bt = '1';
		char ct = '$';
		//a-z --> 97 to 122
		//A-Z --> 65 to 90
		//0-9 --> 48 to 57
		System.out.println(c);
		System.out.println(10+20);
		System.out.println(c+c5);//97+98 = 195
		
		//boolean: true or false
		//size: ~1 bit
		boolean flag = true;
		boolean f11 = false;
		
		byte nn = 065;//octal number
		System.out.println(nn);//53
		//065 = (0 × 8²) + (6 × 8¹) + (5 × 8⁰) = 53
		
		byte mm = 010;//octal number
		System.out.println(mm);
		
		int bb = (byte) 200;
		System.out.println(bb);
		
		
		
	}

}
