package MyWebDriverPrograms;

import java.util.Scanner;

public class ReverseAInteger {
	public static void main(String args[]) {
			long original;
			long reverse = 0 ;
			@SuppressWarnings("resource")
			Scanner inputvalue = new Scanner(System.in);
			System.out.println("Enter a number :");
			original = inputvalue.nextLong();
			System.out.println("Original value is:" + original);
			while(original!= 0) {
			reverse = reverse * 10 + original % 10; // % is modulus - Remainder
			original = original / 10;
			}
			System.out.println("Reverse Number is :" +reverse);
	}
}
