package javasessions;

public class MainMethodOverloading {


	public static void main(int b) {
		System.out.println("value of b" + b);
	}
	
	public static void main(int b, int c) {
		System.out.println("values:  " + b + " " + c);
	}
	
	public static void main(String a[]) {
		System.out.println("Start the program");
		
		MainMethodOverloading.main(10);
		
	}

}
