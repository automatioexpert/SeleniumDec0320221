package MyWebDriverPrograms;

public interface InterfaceExample {
	/*
	 * Only static and final Variables are used here, If you dont give the variable as
	 * static and final, By default variables will be static and final like below
	 */
	int Subjects = 5;
	String Collegename = "St.Joseph College";

	// Always define only abstract methods
	// No Method body for Interface
	// Only and only Method Declaration
	// No static method in Interface
	// No Main Method in Interface
	// We achieve 100% Abstraction with Interface
	// Cannot instantiate or create the object of Interface
	// Interface is Abstract in Nature

	public void dbconnection();

	public void testconnection();

	// Created non static methods without body.
	public void StudentDetails();

	public void StudentResult();
	
}
// This Class 'InterFace' is implemented in the class 'OOPS.java' with the
// keyword 'implements'
