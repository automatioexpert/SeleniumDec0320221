package array;

public class MultiArray {

	public static void main(String[] args) {
		
		int arr[][] = new int[][] { {1,2,3},{2,4,5 },{7,4,5} };

		System.out.println("element of array: ");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.println(arr[i][j] +"");
			}
		}
	}
}
