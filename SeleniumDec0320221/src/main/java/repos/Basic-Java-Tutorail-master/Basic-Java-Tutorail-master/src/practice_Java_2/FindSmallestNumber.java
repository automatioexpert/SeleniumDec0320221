package practice_Java_2;

import java.util.Scanner;

public class FindSmallestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numbers[] = new int[] { 33, 53, 73, 94, 22, 45, 23, 87, 13, 63 };
		int smallest = numbers[0];
		int biggest = numbers[0];

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > biggest) {
				biggest = numbers[i];
			} else if (numbers[i] < smallest) {
				smallest = numbers[i];
			}
		}
		System.out.println("Largest Number is:" + biggest);
		System.out.println("Smallest Number is:" + smallest);
		
		input();
	}
	
	public static void input() {
		System.out.println("Welcome to Java Program to find "
		        + "largest and smallest number without using array");
		    
		    System.out.println("Please enter value of N: ");

		    Scanner sc = new Scanner(System.in);
		    int n = sc.nextInt();
		    int largest = Integer.MIN_VALUE;
		    int smallest = Integer.MAX_VALUE;

		    System.out.printf("Please enter %d numbers %n", n);
		    for (int i = 0; i < n; i++) {

		      int current = sc.nextInt();
		      if (current > largest) {
		        largest = current;
		      } 
		      if (current < smallest) {
		        smallest = current;

		      }
		    }

		    System.out.println("largest of N number is : " + largest);
		    System.out.println("smallest of N number is : " + smallest);
		  }

}
