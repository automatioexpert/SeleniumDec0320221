package ExceptionHandling;

public class FinallyBlock {

	public static int getMarks(String stName) {

		System.out.println("student name is : " + stName);

		if (stName.equals("Vijay")) {
			try {
				int i = 9 / 3;
				System.exit(1);//shut down the JVM
				return 90;
			} catch (ArithmeticException e) {
				System.out.println("AE is coming...");
				return 20;
			} finally {
				System.out.println("inside finally block....");
				return 10;
			}

		} else if (stName.equals("Aman")) {
			return 95;
		} else if (stName.equals("Priyanka")) {
			return 100;
		} else {
			System.out.println("student is not found..." + stName);
			return -1;
		}

	}

	public static void main(String[] args) {

		System.out.println(getMarks("Vijay"));

//		System.out.println("A");
//		System.out.println("A");
//		System.out.println("A");
//
//		try {
//			int i = 9 / 3;
//		} 
//		
//		finally {
//			System.out.println("inside the finally block");
//		}
//
//		System.out.println("bye");

	}

}
