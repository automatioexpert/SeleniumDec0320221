package OOP_Interface;

public interface USMedical extends WHO{
	
	int min_fee = 10;
	//vars are static and final by default
	
	// no method body
	// abstract method: has no mehtod body
	// method prototype : only method declaration
	//can not create the object of interface

	public void physioServices();

	public void cardioServices();

	public void emergencyServices();
	
	public void gynecServices();
	
	public int test(int a);
	
	@Override
	public void covidTest();

	
	//after jdk 1.8:
	//1. can have method body with static method
	public static void billing() {
		System.out.println("US - billing");
	}
	
	//2. default method:with method body
	default void getVaccine() {
		System.out.println("US -- vaccination");
	}
	
	

}
