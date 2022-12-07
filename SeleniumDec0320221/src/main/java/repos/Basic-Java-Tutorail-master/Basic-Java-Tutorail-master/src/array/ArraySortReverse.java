package array;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ArraySortReverse {
	public static void main(String[] args) {
		
		// defining an array of integer type
		int[] numbers = { 90, 23, 5, 109, 12, 22, 67, 34 };

		// Sort the array in reverse order
		Arrays.sort(numbers, Collections.reverseOrder());

		// Print array to confirm
		System.out.println("Array elements in descending order: " +Arrays.toString(numbers));

		// prints array using the for loop
		System.out.println("Elements of array sorted in revers order: ");
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
}
