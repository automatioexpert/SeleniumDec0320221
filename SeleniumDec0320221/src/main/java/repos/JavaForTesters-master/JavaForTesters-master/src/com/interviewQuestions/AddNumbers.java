/**
 * 
 */
package com.interviewQuestions;

import java.util.Scanner;

/**
 * Oct 24, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public final class AddNumbers {

	/**
	 * @author Hassen
	 * Oct 24, 2022
	 * @param args
	 */
	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
		  int a = sc.nextInt(); int b = sc.nextInt();
		  int sum = a + b;
		  System.out.println("Sum of two numbers is: " + sum);
	}
}
