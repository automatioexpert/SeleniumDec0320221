package control_Statement_Do_While;

public class Do_While_Loop_Array {

	public static void main(String[] args) {
		int arr[] = { 2, 11, 45, 9 };
		// i starts with 0 as array index starts with 0
		int i = 0;
		do {
			System.out.println(arr[i]);
			i++;
		} while (i < 4);
	}

}
