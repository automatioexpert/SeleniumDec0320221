/**
 * 
 */
package com.interviewQuestions;

/**
 * Oct 31, 2022
 * 
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public final class ReveresString {

	/**
	 * @author Hassen Oct 31, 2022
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "test12pop90"; // declaring variable

		// convert String to character array by using toCharArray
		char[] array = str.toCharArray();
		
		// iteration
		for (int i = array.length - 1; i >= 0; i--)
			System.out.print(array[i]); // print reversed String
	}
}
