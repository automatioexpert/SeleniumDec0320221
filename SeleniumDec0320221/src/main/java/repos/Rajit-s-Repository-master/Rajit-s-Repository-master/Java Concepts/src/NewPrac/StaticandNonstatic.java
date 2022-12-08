package NewPrac;

public class StaticandNonstatic {
	
	String name = "POLL";
	static int age = 24;

	public static void main(String[] args) {
		
		StaticandNonstatic obj = new StaticandNonstatic();
		sum();
		
		obj.names();
		System.out.println(obj.name);

	}
	
	public void names() {
		
		System.out.println(age);
	}
	
	public static void sum() {
		
		StaticandNonstatic obj1 = new StaticandNonstatic();
		System.out.println(obj1.name);
	}

}
