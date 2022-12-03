package OOP_Interface;

public interface USMedical extends WHO {

	int min_fee = 10;
	// static and final var by default

	// no method body
	// only method decalaration/method prototype
	// abstract methods
	// can not create the Object of Interface

	public void physioServices();

	public void cardioServices();

	public void entServices();

	public void emergencyServices();

	public int getPatientNumber(String name);

	@Override
	public void covid19Research();
	
	private void testing() {
		System.out.println("US -- testing");
	}

	// after jdk 1.8:

	// 1. you can have static method with method body:
	public static void billing() {
		System.out.println("US -- billing");
	}

	// 2. default method with method body:
	default void medicalTraining() {
		System.out.println("US -- medical training");
		testing();
	}

}
