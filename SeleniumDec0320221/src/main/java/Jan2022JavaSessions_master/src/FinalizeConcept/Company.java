package FinalizeConcept;

public class Company {

	String name;

	public static void main(String[] args) {

		Company c = new Company();
		c = null;
		//c.name = "IBM";
		Employee e = new Employee();
		e = null;
		System.gc();
	}
	
	@Override
	public void finalize() {
		System.out.println("comp -- finalize method....");
	}

}
