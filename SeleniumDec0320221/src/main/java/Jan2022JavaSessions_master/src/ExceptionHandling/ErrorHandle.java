package ExceptionHandling;

public class ErrorHandle {

	public static void main(String[] args) {

		System.out.println("Hi");
		try {
			int i = 9 / 0;//AE
		} catch (Error e) {
			e.printStackTrace();
		}
		
		System.out.println("Bye");

	}

}
