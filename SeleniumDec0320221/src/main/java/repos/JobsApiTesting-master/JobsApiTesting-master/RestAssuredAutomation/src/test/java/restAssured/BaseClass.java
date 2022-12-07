package restAssured;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseClass {
	
	@BeforeClass
	public void setup() {
		
		RestAssured.baseURI = "https://jobs123.herokuapp.com/Jobs";
		final String Update_Excel = "./Data/UpdateExcel.xlsx";
		
	}

}
