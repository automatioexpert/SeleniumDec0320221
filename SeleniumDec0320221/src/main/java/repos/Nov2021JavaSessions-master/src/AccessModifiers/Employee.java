package AccessModifiers;

public class Employee {
	
	public String name;
	private int salary;
	String city;
	protected String dob;

	public static void main(String[] args) {

		int i = 10;//local var		
		
		Employee e = new Employee();
		e.name = "tom";
		e.salary = 10;
		e.city = "LA";
		e.dob = "12 jan";
		
		
	}

}
