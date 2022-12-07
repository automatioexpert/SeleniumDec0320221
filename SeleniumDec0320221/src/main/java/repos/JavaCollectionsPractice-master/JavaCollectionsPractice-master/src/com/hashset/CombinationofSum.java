package com.hashset;

import java.util.HashSet;
import java.util.Set;

public class CombinationofSum {

	/**
	 * This is program to find pair of integers from given array whose sum is given
	 * number
	 * 
	 * @author krishna
	 * 
	 * @param int[]
	 *            integerArray
	 * @param int
	 *            sum
	 * 
	 * @return String output of pairs
	 */
	public void getPair(int[] array, int sum) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i : array) {
			set.add(i);
			if (set.contains(sum - i)) {
				System.out.println("Pair having sum " + sum + " is " + i + " " + (sum - i));
			}
		}

	}

	public static void main(String[] args) {
		int[] arr = { 10, 0, 9, 1, 2, 7, 5, 3, 2, 7 };
		new CombinationofSum().getPair(arr, 10);
	}
}
