package javasessions;


/*
 * @author naveen
 * this class is about data  types in java
 */
public class DataType {

	public static void main(String[] args) {

	//this is my java code
	
	//primititve data types: (No need of any Object)
	//Boolean: boolean (true/false)
	//Numeric: 
		//1. Character : char
		//2. Integral : 
			//a. Integer: byte, short, int, long
			//b. Floating-point: float, double
		
	//non primititve: String, Class, Interfaces, Arrays, Obejects
	
	//1. byte:
	//size: 1 byte = 8 bits
	//range: -128 to 127
	byte b = 10;
	 b = 20;
	 b = 30;
	byte b1 = -20; 
	//byte b2 = 130;
	byte b4 = 0;
	
	System.out.println(b);
	System.out.println(b+b1);	
	
	//2. short:
	//size: 2 bytes: 16 bits
	//range: -32768 to 32767
	short s1 = 1234;
	short s2 = 1;
	
	//3. int:
	//size: 4 bytes: 32 bits
	//range: -2147483648 to 2147483647
	int i = 10000;
	int j = 1;
	
	//4. long:
	//size: 8 bytes : 64 bits
	//range: 
	long distance = 12121212121L;
	System.out.println(distance);
	
	//5. float:
	//size: 4 bytes = 32 bits
	//range: after . it can take upto 7 digits
	float f1 = 12.33f;
	System.out.println(f1);
	float f2 = 100;
	System.out.println(f2);
	
	//6. double:
	//size: 8 bytes = 64 bits
	//range: after . it can take upto 15 digits
	double d1 = 12.333399999;
	
	//7. char: sing digit value
	//size: 2 bytes = 16 bits
	char c = 'a';
	char h = 'b';
	char c1 = '1';
	char c2 = '$';
	
	//a-z: 97 to 122
	//A-Z: 65 to 90
	//0-9: 48 to 57
	
	System.out.println(c);//a
	System.out.println(c+h);//97+98 = 195
	System.out.println((byte)c);
	
	
	//8. boolean:
	//size: ~1 bit
	boolean flag = true;
	boolean h11 = false;
	
	
		
	}

}
