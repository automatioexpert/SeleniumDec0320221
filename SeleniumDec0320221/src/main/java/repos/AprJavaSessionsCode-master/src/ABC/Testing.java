package ABC;

public class Testing {
	
	static Testing t;

	public static void m1() {
		System.out.println("m1");
		t.m3();
	}

	public static void m2() {
		System.out.println("m2");
		//this.m3();
		t = new Testing();
		
	}

	public void m3() {
		System.out.println("m3");
//		this.m1();
//		this.m3();
	}

	public static void main(String[] args) {
//		Testing ob = new Testing();
//		ob.m3();
		//Customer c = new Customer();
		Customer.APP_AMAZON_TIME_OUT = 30;
		
	}

}
