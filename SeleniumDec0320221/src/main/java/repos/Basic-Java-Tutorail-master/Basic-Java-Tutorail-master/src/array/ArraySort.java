package array;

import java.util.Arrays;

public class ArraySort {

	public static void main(String[] args) {
		// defining an array of integer type
		int[] numbers = new int[] { 90, 23, 5, 109, 12, 22, 67, 34 };

		// invoking sort() method of the Arrays class
		Arrays.sort(numbers);
		System.out.println("Array elements in Ascending order: " +Arrays.toString(numbers));
		
		// prints array using the for loop
		System.out.println("Elements of array sorted in Ascending order: ");
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		
		String [] strarray = {"Mango", "Apple", "Grapes", "Papaya", "Pineapple", "Banana", "Orange"};   
		// sorts array[] in ascending order   
		Arrays.sort(strarray);   
		System.out.println("Array elements in ascending order: " +Arrays.toString(strarray)); 
	}
}
