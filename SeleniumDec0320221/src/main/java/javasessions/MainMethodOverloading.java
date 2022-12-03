package javasessions;

public class MainMethodOverloading {
	
	public void main() {
		System.out.println("main 1 method");
	}
	
	public void main(String a) {
		System.out.println("main 2 method "+ a);
	}
	
//JVM is calling main method with no values -- command line arguments
	public static void main(String []t) {
		
		System.out.println(t.length);
		System.out.println(t[0]);

		System.out.println("this is my java code");
		
		MainMethodOverloading obj = new MainMethodOverloading();
		obj.main("testing");
		
	}
	
	public void main(int a[]) {

		System.out.println("java code");
		
	}

}
