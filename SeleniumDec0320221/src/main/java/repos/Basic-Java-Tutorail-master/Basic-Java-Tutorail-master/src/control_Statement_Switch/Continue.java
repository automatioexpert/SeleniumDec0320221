package control_Statement_Switch;

public class Continue {

	public static void main(String[] args) {
		for (int j = 0; j <= 6; j++) {
			if (j == 4) {
				continue;
			}
			System.out.print(j + " ");
		}
	}
}
