package javasessions;

public class MainMethodOverloading {

	public static void main(String a[]) {
		System.out.println("main method....");
		System.out.println(main(10));
		main(10,20);
	}
	
	public static int main(int a) {
		System.out.println("main method...."+a);
		main(20,30);
		return 100;
	}
	
	public static void main(int a, int b) {
		System.out.println("main method...."+(a+b));
	}

}
