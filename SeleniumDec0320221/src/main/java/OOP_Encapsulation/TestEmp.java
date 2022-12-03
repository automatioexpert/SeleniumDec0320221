package OOP_Encapsulation;

public class TestEmp {

	public static void main(String[] args) {

		Employee e1 = new Employee();

		e1.setName("Tom");
		String n = e1.getName();
		System.out.println(n);

		e1.setAge(25);
		int age = e1.getAge();
		System.out.println(age);
		
		LoginPage lp = new LoginPage();
		lp.setUsername(null);
		System.out.println(lp.getUsername());

	}

}
