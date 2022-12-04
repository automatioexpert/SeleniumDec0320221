package javasessions;

public class Users {
	
	String name;
	int age;
	boolean isActive;
	
	

	public static void main(String[] args) {

		Users u1 = new Users();
		u1.name = "Shalini";
		u1.age = 30;
		u1.isActive = true;
		
		Users u2 = new Users();
		u2.name = "Mani";
		u2.age = 32;
		u2.isActive = false;
		
		Users u3 = new Users();
		u3.name = "Sayali";
		u3.age = 33;
		u3.isActive = true;
		
		System.out.println(u1.name +  " " + u1.age + " " + u1.isActive);
		System.out.println(u2.name +  " " + u2.age + " " + u2.isActive);
		System.out.println(u3.name +  " " + u3.age + " " + u3.isActive);

		u1 = u2;
		
		System.out.println(u1.name +  " " + u1.age + " " + u1.isActive);
		System.out.println(u2.name +  " " + u2.age + " " + u2.isActive);
		System.out.println(u3.name +  " " + u3.age + " " + u3.isActive);
		
		u2 = u3;
		
		System.out.println(u1.name +  " " + u1.age + " " + u1.isActive);
		System.out.println(u2.name +  " " + u2.age + " " + u2.isActive);
		System.out.println(u3.name +  " " + u3.age + " " + u3.isActive);
		
		u3 = u1;
		
		System.out.println(u1.name +  " " + u1.age + " " + u1.isActive);
		System.out.println(u2.name +  " " + u2.age + " " + u2.isActive);
		System.out.println(u3.name +  " " + u3.age + " " + u3.isActive);
		
	}

}
