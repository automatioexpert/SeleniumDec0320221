package ExceptionHandling;

public class FinallyBlock {
	String name = "SQL Server";

	public static void main(String[] args) {

		int a = 10;
		int b = 0;

		try {
			int z = a / b;
		} 
		catch (ArithmeticException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("I am in finally block");
		}
		
		//1. Database connection:
		try {
			System.out.println("DB connection is stablished");
			FinallyBlock obj = new FinallyBlock();
			//obj = null;
			System.out.println(obj.name);
		}
		catch(NullPointerException e ) {
			System.out.println("SQL query is not correct");
			e.printStackTrace();
		}
		finally {
			System.out.println("disconnect the DB");
		}
		
		//2. File Handling:
		//a. create the connection with excel sheet:
		//b. try to get the data
		//c. data is not found/null
		//d. some exception is coming
		//3. finnaly-> close the connection with excel (close/flush the connection)

	}

}
