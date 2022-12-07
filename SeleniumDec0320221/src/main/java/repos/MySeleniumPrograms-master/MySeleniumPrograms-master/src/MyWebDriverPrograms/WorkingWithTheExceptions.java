package MyWebDriverPrograms;

public class WorkingWithTheExceptions {
	
public static void main(String[] args) {

	
	  try {
		  int a =100;
		  int b=0;
		  @SuppressWarnings("unused")
		float c=a/b;
    	  }catch (Exception e)
	        {
    		  String Msg = e.getMessage();
    		  System.out.println("Exception for Airthmetic" +Msg); 
	        }finally
	        { 
	        	System.out.println("The statements are executed finally");
	        }
	      
	
	
	
	
	
	
	
	
 }
	
}
