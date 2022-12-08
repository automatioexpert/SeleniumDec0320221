package NewPrac;

// Non static Method Calling. Compulsory to create object for that as all the methods are inside an object

public class OOPS_1 {

	public static void main(String[] args) {
		OOPS_1 obj = new OOPS_1();
		
		int sumresult = obj.sumation(25, 45);
		System.out.println(sumresult);
		
		int divisionresult = obj.division();
		System.out.println(divisionresult);
		
		
		

	}
	
	//input parameter/argument
	public int sumation(int x, int y) {
		
		int S = x+y;
		return S;
	}
	
	public int division() {
		
		int d;
		int x = 10;
		int y = 5;
		
		d= x/y;
		return d;
		
	}

}
