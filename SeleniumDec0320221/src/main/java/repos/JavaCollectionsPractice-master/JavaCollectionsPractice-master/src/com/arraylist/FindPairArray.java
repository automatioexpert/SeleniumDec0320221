package com.arraylist;

import java.util.ArrayList;

public class FindPairArray {
	
	/**
	 * This programs find out all possible combinations from given array where sum 
	 * is given number. Combinations can be of different length
	 * 
	 * For given scenario, expected combinations are:
	 * 
	 * 
	 * @return
	 * [1, 2, 4]
	 * [2, 5]
	 * [5, 2]
	 * [4, 3]
	 * [3, 2, 2]
	 * [2, 2, 3]
	 * [3, 4]
	 * [6, 1]

	 * @param args
	 */

	public static void main(String args[]) {

		int[] ar = { 1, 2, 5, 4, 8, 3, 9, 13, 2, 2, 3, 4, 6, 1, 7 };
		int sum = 7;

		for (int i = 0; i < ar.length; i++) {
			int value = 0;
			boolean flag = false;
			ArrayList<Integer> ar1 = new ArrayList<Integer>();
			value = ar[i];
			ar1.add(ar[i]);
			if (value == sum && value <= sum) {
				flag = true;
				continue;
			} else {
				for (int j = i + 1; j < ar.length; j++) {
					value += ar[j];
					if (value == sum) {
						ar1.add(ar[j]);
						flag = true;
						break;
					} else if (value > sum) {
						value -= ar[j];
					} else
						ar1.add(ar[j]);
				}
			}
			if (flag) {
				System.out.println(ar1.toString());
			}
		}
	}
}
