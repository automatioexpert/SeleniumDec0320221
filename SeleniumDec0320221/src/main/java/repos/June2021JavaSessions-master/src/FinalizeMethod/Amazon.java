package FinalizeMethod;

public class Amazon {
	
	//final: keyword
	//1. costant values
	//2. to prevent the inheritance
	//3. to preven method overriding
	
	//2. finally: block
	
	//3. finalize(): method (overriden from Object class)
	
	
	String name;

	public static void main(String[] args) {

//		Amazon a = new Amazon();
//		a = null;
		
		Flipkart f = new Flipkart(); 
		f = null;
		
		//requesting JVM to call GC:
		System.gc();
		System.out.println("Bye....");
		
	}
	
	@Override
	public void finalize() {
		System.out.println("this is Amazon finalize method....");
	}

}
