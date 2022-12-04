package OOP_Interface;

public interface USMedical extends Medical{
	
	 int min_fee = 10;
	//static and final

	// No Method Body//only method declaration
	// Only Method Prototype
	// only abstract method: no body
	// can not create the Object of Interface
	// can not have static abstract non static method
	// 100% abstraction
	 
	public void physioServices();

	public void cardioServices();

	public void oncologyServices();
	
	public void emergencyServices();
	
	@Override
	public void vaccination();
	
	//after jdk 1.8:
	//1. can have static method with method body:
	public static void billing() {
		System.out.println("USMedical -- billing");
	}
	
	//2. can have non static default method:
	default void optServices() {
		System.out.println("US Medical -- opt");
	}

}
