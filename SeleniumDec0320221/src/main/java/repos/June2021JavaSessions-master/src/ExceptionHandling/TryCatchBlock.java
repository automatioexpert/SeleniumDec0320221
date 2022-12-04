package ExceptionHandling;

public class TryCatchBlock {
	String name = "naveen";

	public static void main(String[] args) {

		int a = 10;
		int b = 2;
		
		//System.out.println(a/b);//Arithmetic Exception --> runtime -- unchecked exception 
		
		//Thread.sleep(3000); --> compile time -- checked exception
		
		try {
			TryCatchBlock obj = new TryCatchBlock();
			obj = null;
			System.out.println(obj.name);//NPE
			System.out.println("hiii");
			System.out.println(a/b);
			System.out.println("hello");
			System.out.println("hello");
			System.out.println("hello");
		}
		catch(ArithmeticException e) {
			System.out.println("AE exception is coming....");
			e.printStackTrace();
		}
		catch(NullPointerException e) {
			System.out.println("NPE exception is coming....");
			e.printStackTrace();
		}
		
		
		
		System.out.println("Bye");
		System.out.println("Bye");
		System.out.println("Bye");
		System.out.println("Bye");

		
	}

}
