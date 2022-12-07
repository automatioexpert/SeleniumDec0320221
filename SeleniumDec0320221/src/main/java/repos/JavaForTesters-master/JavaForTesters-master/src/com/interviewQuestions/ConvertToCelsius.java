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
public class ConvertToCelsius {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input temperature in Fahrenheit: ");
		double fahrenheit = sc.nextDouble();
		double celsius = ((5 * (fahrenheit - 32.0)) / 9.0);
		System.out.println(fahrenheit + " degree fahrenheit is equal to " + celsius + "in celsius");
	}
}
