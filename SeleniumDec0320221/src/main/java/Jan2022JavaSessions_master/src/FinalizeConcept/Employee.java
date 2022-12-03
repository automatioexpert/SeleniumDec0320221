package FinalizeConcept;

public class Employee {
	
	String id;
	
	@Override
	public void finalize() {
		System.out.println("emp -- finalize method....");
	}

}
