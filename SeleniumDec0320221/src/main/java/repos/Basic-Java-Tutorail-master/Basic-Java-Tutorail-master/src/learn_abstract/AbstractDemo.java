package learn_abstract;

public class AbstractDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Salary s = new Salary("James Lenon","Ambehta, UP", 3, 3600.00);
		Employee e = new Salary("John Adams","Boston, MA", 2,2400.00);
		System.out.println();
		s.mailCheck();
		System.out.println();
		e.mailCheck();
	}

}
