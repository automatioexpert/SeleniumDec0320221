package OOP_Interface;

public class TestHospital {

	public static void main(String[] args) {

		FortisHospital fh = new FortisHospital("Fortis", "NY");
		System.out.println(fh.getName() + " " + fh.getCity());
		fh.setCity("LA");
		System.out.println(fh.getName() + " " + fh.getCity());
		
		fh.cardioServices();
		fh.physioServices();
		fh.oncologyServices();
		fh.emergencyServices();
		fh.medicalInsurance();
		fh.medicalTraining();
		USMedical.billing();
		FortisHospital.billing();
		fh.getVaccine();
		System.out.println(USMedical.min_fee);
		fh.medicalRD();
		fh.medicalPatientData();
		fh.covidFunds();
		
		
		//top casting: child class object can be referred by parent interface ref variable
		USMedical us = new FortisHospital();
		
		us.cardioServices();
		us.emergencyServices();
		us.gynecServices();
		us.physioServices();
		
		//down casting: not allowed
		
		UKMedical uk = new FortisHospital();
		uk.emergencyServices();
		
		

		
		
	}

}
