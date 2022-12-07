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
public final class SwapNumbers {

	/**
	 * @author Hassen
	 * Oct 24, 2022
	 * @param args
	 */
	public static void main(String[] args) {
		  int x, y, z; 
		  Scanner sc = new Scanner(System.in);
		  x = sc.nextInt(); y = sc.nextInt(); 
		  System.out.println("Before swapping\n x = " + x + "\n y = " + y);
		  z = x; x = y; y = z; 
		  System.out.println("After swapping\n x = " + x + "\n y = " + y); 
	}
}
