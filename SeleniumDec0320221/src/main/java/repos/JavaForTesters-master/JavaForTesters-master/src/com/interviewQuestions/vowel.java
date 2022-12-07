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
public final class vowel {

	/**
	 * @author Hassen Oct 31, 2022
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "GeeksForGeeks";
		str = str.toLowerCase();
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			// check if char[i] is vowel
			if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
					|| str.charAt(i) == 'u') {
				// count increments if there is vowel in
				// char[i]
				count++;
			}
		}
		// display total count of vowels in string
		System.out.println("Total no of vowels in string are: " + count);
	}
}
