package MyWebDriverPrograms;

import java.util.Scanner;

public class ReverseAString {

	public static void main(String args[]) {
		// 1. WAY
		String original, reverse = ""; // Objects of String class
		@SuppressWarnings("resource")
		Scanner inputvalue = new Scanner(System.in);
		System.out.println("Enter a string/number :");
		original = inputvalue.nextLine();
		System.out.println("Original value is:" + original);
		int length = original.length();
		System.out.println("Length is :" + length);
		for (int i = length - 1; i >= 0; i--) {
			reverse = reverse + original.charAt(i);
		}
		System.out.println("Reverse value is:" + reverse);

		// 2 Way:
		StringBuffer sf = new StringBuffer(original);
		System.out.println("Reverse value for given StringBuffer is : " + sf.reverse());

	}

}