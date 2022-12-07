package practice_Java_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Numbers {

	public static void main(String[] args) {
		printNumber();
	}
	public static void printNumber() {
		Scanner input= new Scanner(System.in);
		try {
			System.out.print("Please enter the first number:");
			double firstnumber = input.nextDouble();		
			
			System.out.print("Please enter the second number:");
			double secondnumber= input.nextDouble();	
			
			double result= firstnumber+secondnumber;
			System.out.println("the First number is: " +firstnumber);
			System.out.println("the Second number is: " +secondnumber);
			System.out.println("The average of the grade is: " +result);
			
		     if (firstnumber>secondnumber){
		    	 System.out.println("First number is greater then second number.");
		     }else if(firstnumber<secondnumber){
		    	 System.out.println("First number is less then second number.");
		     }else{
				 System.out.println("First number is equal to the second number.");
			 }
			
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("Error! "  + e);
			
		}
	}	
}
