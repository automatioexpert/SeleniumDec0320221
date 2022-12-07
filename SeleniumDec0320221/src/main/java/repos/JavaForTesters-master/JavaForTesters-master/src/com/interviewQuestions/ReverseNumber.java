/**
 * 
 */
package com.interviewQuestions;

/**
 * Oct 31, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public final class ReverseNumber {

	/**
	 * @author Hassen
	 * Oct 31, 2022
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "test12pop90java978pyt";
		String[] parts = input.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
		StringBuilder sb = new StringBuilder();
		for (String part : parts) {
		    if (part.matches("\\d+")) {
		        StringBuilder num = new StringBuilder(part);
		        sb.append(num.reverse());
		    }
		    else {
		        sb.append(part);
		    }
		}

		System.out.println(sb.toString());

	}

}
