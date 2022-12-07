/**
 * 
 */
package com.interviewQuestions;

import java.util.Scanner;

/**
 * Oct 26, 2022
 * 
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public final class CompareTwoStrings {

	/**
	 * @author Hassen Oct 26, 2022
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first string");
		String first = sc.next();
		System.out.println("Enter second string");
		String second = sc.next();
		compare(first, second);
	}
	
	/**
	 * 
	 * @author Hassen
	 * Oct 26, 2022
	 * @param s1
	 * @param s2
	 */

	public static void compare(String s1, String s2) {
		if (s1.compareTo(s2) == 0) {
			System.out.println("Strings are equal");
		} else {
			System.out.println("Strings are not equal");
		}
	}

}
