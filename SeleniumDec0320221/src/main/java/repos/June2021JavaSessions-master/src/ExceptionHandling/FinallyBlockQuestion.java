package ExceptionHandling;

public class FinallyBlockQuestion {

	public static int getMarks(String name) {

		if (name.equals("Dev")) {
			try {
				int cal = 10 / 2;
				return 100;
			} catch (ArithmeticException e) {
				System.out.println("some exception is coming....");
				return -2;
			}
			finally {
				System.out.println("hi im in finally block");
				return -3;
			}
			
		} else if (name.equals("sonia")) {
			return 90;
		}

		return -1;

	}

	public static void main(String[] args) {

		int m1 = getMarks("sonia");
		System.out.println(m1);
	}

}
