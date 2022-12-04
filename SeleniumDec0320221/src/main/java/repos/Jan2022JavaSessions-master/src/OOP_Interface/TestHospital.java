package OOP_Interface;

public class TestHospital {

	public static void main(String[] args) {

		FortisHospital fh = new FortisHospital();
		fh.entServices();
		fh.cardioServices();
		fh.neuroServices();
		fh.emergencyServices();
		fh.medicalInsurance();
		fh.optServices();
		System.out.println(USMedical.min_fee);
		
		FortisHospital.billing();
		USMedical.billing();
		
		fh.medicalTraining();
		fh.medicalEquipment();
		fh.medicalStudy();
		
		fh.covid19Vaccination();
		
		int num = fh.getPatientNumber("Naveen");
		System.out.println(num);
		
		//top casting:
		//child class object can be referred by parent interface ref variable
		USMedical us = new FortisHospital();
		
		us.physioServices();
		us.cardioServices();
		us.entServices();
		us.emergencyServices();
		
		//down casting:NA
		//FortisHospital fh1 = new USMedical();
		
		
		
		
		
		
	}

}
