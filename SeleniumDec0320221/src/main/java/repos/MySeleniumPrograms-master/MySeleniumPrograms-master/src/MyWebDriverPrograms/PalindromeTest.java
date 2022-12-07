/* Palindrome number algorithm
 * ----------------------------
 * Get the number to check for palindrome
 * Hold the number in temporary variable
 * Reverse the number
 * Compare the temporary number with reversed number/String
 * If both numbers are same, print "Palindrome number/String"
 * Else print "Not Palindrome number/String"
 */
package MyWebDriverPrograms;

import java.util.Scanner;

public class PalindromeTest {

	public static void main(String args[]) {
		String original, reverse = ""; // Objects of String class
		@SuppressWarnings("resource")
		Scanner inputvalue = new Scanner(System.in);
		System.out.println("Enter a string/number to check if it is a palindrome:");
		original = inputvalue.nextLine();
		System.out.println("Original value is:" + original);
		int length = original.length();
		System.out.println("Length is :" + length);
		for (int i = length - 1; i >= 0; i--)
			reverse = reverse + original.charAt(i);
		System.out.println("Reverse value is:" + reverse);
		if (original.equals(reverse)) {
			System.out.println("Entered string/number is a palindrome.");
		} else {
			System.out.println("Entered string/number isn't a palindrome.");
		}

	}
}