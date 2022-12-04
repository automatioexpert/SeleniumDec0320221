package ExceptionHandling;

public class ThrowKeyword {

	public static void getInfo() {
		
		String data = null;
		
		try {
			if(data == null) {
				throw new Exception("DATANOTFOUNDEXCEPTION");
			}
			else {
				System.out.println(data);
			}
		} catch (Exception e) {
			System.out.println("data not found for this user.....");
			e.printStackTrace();
		}

		System.out.println("bye");
	}

	public static void main(String[] args) {

		getInfo();

	}

}
