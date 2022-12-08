package NewPrac;

public class CallbyValueandRef {
	
	int i;
	int j;

	public static void main(String[] args) {
		
		
		
		CallbyValueandRef obj = new CallbyValueandRef();
		
		int p = 19;
		int q = 1;
		int sumationresult = obj.testsum(p, q);
		System.out.println(sumationresult);
		
		
		obj.i = 40;
		obj.j = 33;
		
		obj.swap(obj);             ///Here the function is called and obj is passed as it is another reference to the class.
		
		System.out.println(obj.i);
		System.out.println(obj.j);
		
		
	
	}
	
	
	public int testsum(int x, int y) {
		
		int c = x+y;
		
		return c;
		
	}
	
	//Call By reference
	public void swap(CallbyValueandRef t) {    /// here t is the reference variable of the class since i want to call by reference
		
		int temp;
		temp = i;
		i= j;
	    j=temp;
		
		
		
	}

}
