package com.assertions.example;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;
import org.json.JSONException;
import org.skyscreamer.jsonassert.*;

import com.student.base.TestBase;

public class JSONOutputAssertionExample extends TestBase {
	
	
	//JSON Assert is helpful when there is an error in the actual output
	@Test
	public void getStudents() throws IOException, JSONException {
		String expectedValue = new String(
				Files.readAllBytes(Paths.get(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
						+ File.separator + "resources" + File.separator + "ExpectedStudentJSON.txt")));
		
		String actualValue = given().when().get("/list").asString();
		
		//compare mode is the 3rd parameter of assertEqual here. If value is LENIENT order of output does not matter
		//but if the value is STRICT then the order of JSON output should match with expected
		JSONAssert.assertEquals(expectedValue, actualValue, JSONCompareMode.LENIENT);
	}
}
