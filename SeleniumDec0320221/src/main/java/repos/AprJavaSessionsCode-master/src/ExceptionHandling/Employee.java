package ExceptionHandling;

public class Employee {
	
	String name = "Naveen";

	public static void main(String[] args) {

		System.out.println("A");
		System.out.println("A");
		System.out.println("A");

		try {
			Employee e = new Employee();
			e = null;
			System.out.println(e.name);//NPE
			int i = 9/0;//AE
			System.out.println("hello");
			System.out.println("hello");
			System.out.println("hello");
		}
		catch(NullPointerException e) {
			System.out.println("NPE is coming....");
			e.printStackTrace();
		}
		catch(ArithmeticException e) {
			System.out.println("AE is coming....");
			e.printStackTrace();
		}
		
		System.out.println("bye");
		
		
	}

}
