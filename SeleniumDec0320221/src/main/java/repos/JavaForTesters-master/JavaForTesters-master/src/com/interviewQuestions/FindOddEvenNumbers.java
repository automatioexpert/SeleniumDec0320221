/**
 * 
 */
package com.interviewQuestions;

import java.util.Scanner;

/**
 * Oct 26, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public class FindOddEvenNumbers {

	/**
	 * @author Hassen
	 * Oct 26, 2022
	 * @param args
	 */
	public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a number: ");
        int inputNumber = sc.nextInt();
        findNumber(inputNumber);
	}
	
	/**
	 * 
	 * @author Hassen
	 * Oct 26, 2022
	 * @param number
	 */
    public static void findNumber(int number){
        if(number%2!=0){
            System.out.println("Number is odd");
        }
        else {
            System.out.println("Number is even");
        }
    }

}
