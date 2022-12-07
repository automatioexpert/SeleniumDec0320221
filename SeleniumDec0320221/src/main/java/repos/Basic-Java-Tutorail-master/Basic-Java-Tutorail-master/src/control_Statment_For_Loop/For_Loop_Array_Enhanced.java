package control_Statment_For_Loop;

public class For_Loop_Array_Enhanced {

	public static void main(String[] args) {
		int arr[] = { 2, 11, 45, 9 };
		for (int num : arr) {
			System.out.println(num);
		}
		
		//enhanced for loop for string type
		String arr2[] = { "Hi", "Hello", "Bye" };
		for (String str : arr2) {
			System.out.println(str);
		}
	}
}
