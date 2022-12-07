package MyWebDriverPrograms;

public class ArrayReturningValue {

    int z;

	public int solution(int A[]) {

		for (int i = 0; i < A.length; i++) {
			System.out.print("A[i] is :" + A[i] + "\n");
			if (A[i] == A[8]) {
				z = A[i] + A[3];
				break;
			}
		}
		return z;
	}

	public static void main(String[] args) {
		ArrayReturningValue process = new ArrayReturningValue();
		int A[] = { 6, -91, 1011, -100, 84, -22, 0, 1, 473 };
		process.solution(A);
		System.out.println("Return Value of Z is :" + " " + process.z);
	}
}
