package practice_Java_2;

import java.util.Scanner;

public class Homework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in= new Scanner(System.in);
		
		System.out.print("Enter a number for Linux class:");
		int gradLinux = in.nextInt();		
		
		System.out.print("Enter a number for System class:");
		int gradSystem= in.nextInt();		
		
		System.out.print("Enter a number for Computer class:");		
		int gradComputer= in.nextInt();		
		
		int avg= (gradLinux+gradSystem+gradComputer) * 100 /300;
		System.out.println("Linux grade is: " +gradLinux);
		System.out.println("System grade is: " +gradSystem);
		System.out.println("System grade is: " +gradComputer);
		System.out.println("The average of the grade is: " +avg);
		
	     if (avg>=90 && avg<100){
	    	 System.out.println("Grade of the student is: 'A' (PASS).");
	     }else if(avg>=80 && avg<89){
	    	 System.out.println("Grade of the student is: 'B' (PASS)");
	     }else if(avg>=70 && avg<79){
	    	 System.out.println("Grade of the student is: 'C' (PASS)");
		 }else if(avg>=60 && avg<69){
	    	 System.out.println("Grade of the student is: 'D' (FAIL)");
		 }else if(avg>=50 && avg<59){
	    	 System.out.println("Grade of the student is: 'E' (FAIL)");
		 }else{
			 System.out.println("Grade of the student is: 'F' (FAIL)");
		 }
	}
}
