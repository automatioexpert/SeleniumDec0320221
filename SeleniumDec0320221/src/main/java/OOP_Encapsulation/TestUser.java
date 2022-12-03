package OOP_Encapsulation;

public class TestUser {

	public static void main(String[] args) {

		//Create: POST
		User u1 = new User("Nikita", 25, true);
		
		//Retrieve: GET
		System.out.println(u1.getName());
		System.out.println(u1.getAge());
		System.out.println(u1.isActive());
		
		System.out.println("-------");
		//update: PUT/PATCH
		u1.setActive(false);
		System.out.println(u1.getName());
		System.out.println(u1.getAge());
		System.out.println(u1.isActive());
		
		u1.setName("Nikita Kapoor");
		u1.setActive(true);
		System.out.println("-------");

		System.out.println(u1.getName());
		System.out.println(u1.getAge());
		System.out.println(u1.isActive());
		
		///////
		Login l1 = new Login("naveen", "naveen123");
		System.out.println(l1.getUsername() +" :" + l1.getPassword());
		
		Login l2 = new Login("nikita", "nikita123");
		l2.setPassword("nikita4567");
		
		System.out.println(l1.getUsername() +" :" + l1.getPassword());
		System.out.println(l2.getUsername() +" :" + l2.getPassword());

		

		
		
	}

}
