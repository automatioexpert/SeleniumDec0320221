package ExceptionHandling;

public class TryCatchBlock {

	String name;

	// compile time : Checked Exception
	// run time: UnChecked Exception

	public static void main(String[] args) {

		System.out.println("A");
		System.out.println("A");
		System.out.println("A");

		TryCatchBlock obj = new TryCatchBlock();
		obj = null;

		try {
			obj.name = "HArsh";
		} catch (NullPointerException e) {
			System.out.println("NPE is coming....");
			e.printStackTrace();
		}

		try {

			int i = 9 / 0;
			int k[] = new int[2];
			k[4] = 10;
			System.out.println("Hello");
			System.out.println("Hello");
			System.out.println("Hello");

		}
//		catch(Throwable e) {
//			System.out.println("some exception is coming..");
//			e.printStackTrace();
//		}
		catch (ArithmeticException e) {
			System.out.println("ARITHMETIC is coming....");
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("AIOB is coming....");
			e.printStackTrace();
		}
//		catch(NullPointerException e) {
//			System.out.println("NPE is coming....");
//			e.printStackTrace();
//		}

		System.out.println("Bye");
		System.out.println("Bye");
		System.out.println("Bye");
		System.out.println("Bye");
		System.out.println("Bye");

	}

}
