package ExceptionHandling;

public class ThrowKeyword {

	public static void main(String[] args) {
		
		String data = null;
		
		if(data==null) {
			try {
				throw new Exception("NODATAFOUNDEXCEPTION");
			}
			catch(Exception e) {
				System.out.println("data is null....");
				e.printStackTrace();
			}		}
		
		
		
	}

}
