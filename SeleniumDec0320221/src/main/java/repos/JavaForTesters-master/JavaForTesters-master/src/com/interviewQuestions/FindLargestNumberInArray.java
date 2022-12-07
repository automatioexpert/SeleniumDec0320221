/**
 * 
 */
package com.interviewQuestions;

/**
 * Oct 24, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public class FindLargestNumberInArray {

	static int [] array= {21,98,13,9,34};
	
	public static void main(String[] args) {
		int maxNumber=findLargestNumber();
		System.out.println(""+maxNumber);
	}
	
	/**
	 * 
	 * @author Hassen
	 * Oct 24, 2022
	 * @return integer max
	 */
	public static int findLargestNumber() {
		int max=array[0];
		for(int i=0; i<array.length; i++) {
			if (array[i]>max){
				max=array[i];
			}
		}
		return max;		
	}
}
