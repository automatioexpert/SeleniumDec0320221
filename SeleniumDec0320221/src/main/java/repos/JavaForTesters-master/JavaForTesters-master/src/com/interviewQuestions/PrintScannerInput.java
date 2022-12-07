/**
 * 
 */
package com.interviewQuestions;

import java.util.Scanner;

/**
 * Oct 14, 2022
 * 
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public final class PrintScannerInput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("Name: " + name);
	}
}
