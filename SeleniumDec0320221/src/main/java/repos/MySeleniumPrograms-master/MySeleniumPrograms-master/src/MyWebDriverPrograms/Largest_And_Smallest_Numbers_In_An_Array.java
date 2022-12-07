package MyWebDriverPrograms;

import java.util.Arrays;

public class Largest_And_Smallest_Numbers_In_An_Array {

	public static void main(String args[]) {

		int Numbers[] = { -10, 24, -50, -88, 987656, 987657, 0, 100, 10000000, -89, -90, 999999999 };

		int Largest = Numbers[0];
		int Smallest = Numbers[0];

		for (int i = 0; i < Numbers.length; i++) {

			if (Numbers[i] > Largest) {
				Largest = Numbers[i];
			} else if (Numbers[i] < Smallest) {
				Smallest = Numbers[i];
			}
		}

		System.out.println("Given Array is :" + Arrays.toString(Numbers));
		System.out.println("Largest Number is : " + Largest);
		System.out.println("Smallest Number is : " + Smallest);
	}

}
