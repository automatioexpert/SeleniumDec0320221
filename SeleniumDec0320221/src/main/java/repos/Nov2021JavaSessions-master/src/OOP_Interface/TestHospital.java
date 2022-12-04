package OOP_Interface;

public class TestHospital {
	

	public static void main(String[] args) {
		
		
		final int i = 10;//constant variable
		System.out.println(i);
		
		final int days = 7;
		System.out.println(days * 100);
		

		FortisHospital fh = new FortisHospital();
		fh.cardioServices();
		fh.dentalServices();
		fh.emergencyServices();
		fh.oncologyServices();
		fh.medicalInsurance();
		fh.medicalTraining();
		fh.medicalFunds();
		fh.covidReport("OMicron");
		fh.medicalFunds(100);
		fh.optServices();
		
		System.out.println(USMedical.min_fee);
		USMedical.billing();
		System.out.println(FortisHospital.min_fee);

		// USMedical us = new USMedical();

		// top casting:
		// child class object can be referred by parent interface ref variable:
		USMedical us = new FortisHospital();
		us.physioServices();
		us.cardioServices();
		us.oncologyServices();
		us.emergencyServices();
		us.medicalFunds();

		// down casting:
		// FortisHospital f1 = new USMedical();

	}

}
