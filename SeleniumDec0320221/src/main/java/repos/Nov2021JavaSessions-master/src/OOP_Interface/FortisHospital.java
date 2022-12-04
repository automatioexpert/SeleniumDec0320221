package OOP_Interface;

public class FortisHospital extends UNHG implements USMedical, UKMedical, IndianMedical {

	// US
	@Override
	public void physioServices() {
		System.out.println("FH -- physioServices");
	}

	@Override
	public void cardioServices() {
		System.out.println("FH -- cardioServices");

	}

	@Override
	public void oncologyServices() {
		System.out.println("FH -- oncologyServices");

	}

	// UK
	@Override
	public void radiologoyServices() {
		System.out.println("FH -- radiologoyServices");

	}

	@Override
	public void entServices() {
		System.out.println("FH -- entServices");

	}

	// India
	@Override
	public void dentalServices() {
		System.out.println("FH -- dentalServices");

	}

	@Override
	public void pediaServices() {
		System.out.println("FH -- pediaServices");

	}

	// common
	@Override
	public void emergencyServices() {
		System.out.println("FH -- emergencyServices");
	}

	// Individual methods:
	public void medicalTraining() {
		System.out.println("FH -- medical training");
	}

	public void medicalInsurance() {
		System.out.println("FH -- medical Insurance");
	}

	// Medical
	@Override
	public void medicalFunds() {
		System.out.println("FH  -- medical funds");
	}
	
	@Override
	public void medicalFunds(int fee) {
		System.out.println("FH  -- medical funds" + fee);
	}

	// WHO
	@Override
	public void covidTest() {
		System.out.println("FH  -- covid test");

	}

	@Override
	public void vaccination() {
		System.out.println("FH  -- vaccination");
	}

	@Override
	public void covidReport(String version) {
		System.out.println("covid report: " + version);
	}
	

	public static void billing() {
		System.out.println("FH -- billing");
	}
	
//	@Override
//	public void optServices() {
//		System.out.println("FH -- opt");
//	}

}
