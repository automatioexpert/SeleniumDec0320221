package array;

public class Array {

	public static void main(String[] args) {
		// Initialize array
		int arr1[] = new int[] { 1, 2, 3, 4, 5 };
		// Displaying elements of array arr1
		System.out.println("element of original array: ");
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		// Create another array arr2 with size of arr1
		int arr2[] = new int[arr1.length];
		// Copying all elements of one array into another
		for (int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		// Displaying elements of array arr2
		System.out.println("element of new array: ");
		for (int a : arr2) {
			System.out.println(a);
		}

	}

}
