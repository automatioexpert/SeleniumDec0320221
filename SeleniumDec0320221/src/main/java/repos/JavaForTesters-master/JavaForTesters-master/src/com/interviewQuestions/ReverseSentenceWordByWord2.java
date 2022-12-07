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
public final class ReverseSentenceWordByWord2 {

	/**
	 * @author Hassen Oct 31, 2022
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "test12pop90java989pyt", 
		nstr = "";
		char ch;

		System.out.print("Original word: ");
		System.out.println(str); // Example word

		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i); // extracts each character
			nstr = ch + nstr; // adds each character in front of the existing string
		}
		System.out.println("Reversed word: " + nstr);
	}

}
