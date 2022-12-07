/**
 * 
 */
package com.interviewQuestions;

import java.util.Scanner;

/**
 * Oct 25, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public class FindNumberIsPrime {

	/**
	 * @author Hassen
	 * Oct 25, 2022
	 * @param args
	 */
	public static void main(String[] args) {
        boolean flag = false;
        System.out.println("Enter input number");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i=2;i<=num/2;i++){
            if(num%i==0){
                flag = true;
                break;
            }
        }
        if(!flag){
                System.out.println(num + " is a prime number");
            } else{
                System.out.println(num + " is not a prime number");
            }
    }
}
