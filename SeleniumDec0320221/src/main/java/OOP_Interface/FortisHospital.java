package OOP_Interface;

public class FortisHospital extends Medical implements USMedical, UKMedical, IndianMedical {

	static int min_fee = 20;
	
	
	// US
	@Override
	public void cardioServices() {
		System.out.println("FH -- cardioServices");
	}
	
	@Override
	public void cardioServices(int a) {
		System.out.println("FH -- cardioServices");
	}

	@Override
	public void neuroServices() {
		System.out.println("FH -- neuroServices");
	}

	@Override
	public void physioServices() {
		System.out.println("FH -- physioServices");
	}

	// UK
	@Override
	public void dentalServices() {
		System.out.println("FH -- dentalServices");

	}

	@Override
	public void entServices() {
		System.out.println("FH -- entServices");

	}

	// India
	@Override
	public void pediaServices() {
		System.out.println("FH -- pediaServices");

	}

	@Override
	public void onclogyServices() {
		System.out.println("FH -- onclogyServices");

	}

	// common
	@Override
	public void emergencyServices() {
		System.out.println("FH -- emergencyServices");
	}

	// individual
	public void medicalTraining() {
		System.out.println("FH -- medicalTraining");
	}

	public void medicalInsurance() {
		System.out.println("FH -- medicalInsurance");
	}

	// static
	public static void billing() {
		System.out.println("FH -- billing");
	}

	@Override
	public void medicalDevelopment() {
		UKMedical.super.medicalDevelopment();
		USMedical.super.medicalDevelopment();
	}

	@Override
	public void covid19Vaccination() {
		System.out.println("FH -- covid19Vaccination");
	}

	@Override
	public void medicalNews() {
		
	}

//	@Override
//	public void medicalDevelopment() {
//		System.out.println("FH -- medicalDevelopment");
//	}

}
