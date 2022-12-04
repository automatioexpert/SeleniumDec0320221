package ExceptionHandling;

public class FinallyIntQues {

	public static int getMarks(String name) {

		System.out.println("getting marks for: " + name);
		int marks = 0;

		if (name.equals("Ram")) {

			try {
				marks = 90 / 2;
				System.exit(0);//shut down JVM
				return marks;
			} catch (ArithmeticException e) {
				System.out.println("AE is coming");
				return -2;
			}
			finally {
				System.out.println("st is failed....");
				return -3;
			}

		} else if (name.equals("Nikki")) {
			marks = 95;
		} else if (name.equals("Sri")) {
			marks = 85;
		} else {
			System.out.println("st not found....");
			return -1;
		}

		return marks;

	}

	public static void main(String[] args) {

		int m = getMarks("Ram");
		System.out.println(m);
	}

}
