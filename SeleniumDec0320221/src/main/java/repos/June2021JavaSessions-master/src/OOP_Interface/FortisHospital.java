package OOP_Interface;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FortisHospital extends HospitalMgmt implements USMedical, UKMedical, IndianMedical {

	private String name;
	private String city;
	
	// USMedical
	@Override
	public void physioServices() {
		System.out.println("FH -- physioServices");
	}

	@Override
	public void cardioServices() {
		System.out.println("FH -- cardioServices");

	}

	@Override
	public void gynecServices() {
		System.out.println("FH -- gynecServices");

	}

	// common method
	@Override
	public void emergencyServices() {
		System.out.println("FH -- emergencyServices");

	}

	// UK
	@Override
	public void ENTServices() {
		System.out.println("FH -- ENTServices");
	}

	@Override
	public void oncologyServices() {
		System.out.println("FH -- oncologyServices");
	}

	// India
	@Override
	public void radiologyServices() {
		System.out.println("FH -- radiologyServices");

	}

	@Override
	public void neuroServices() {
		System.out.println("FH -- neuroServices");

	}

	// fortis hospital:
	public void medicalInsurance() {
		System.out.println("FH -- medicalInsurance");
	}

	public void medicalTraining() {
		System.out.println("FH -- medicalTraining");
	}

	// method hiding
	public static void billing() {
		System.out.println("FH - billing");
	}

	@Override
	public void getVaccine() {
		System.out.println("FH -- vaccination");
	}

	// who
	@Override
	public void covidTest() {
		System.out.println("FH -- Covid Test");
	}

	@Override
	public int test(int a) {
		return 100;
	}

}
