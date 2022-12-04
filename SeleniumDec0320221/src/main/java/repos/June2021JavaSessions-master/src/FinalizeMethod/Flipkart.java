package FinalizeMethod;

public class Flipkart{
	
	String name = "flipkart";
	
	@Override
	public void finalize() {
		System.out.println("this is flipkart finalize method....");
	}

}
