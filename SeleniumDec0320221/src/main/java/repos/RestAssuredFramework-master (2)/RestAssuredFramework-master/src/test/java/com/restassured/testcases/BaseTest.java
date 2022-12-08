package com.restassured.testcases;

import static io.restassured.RestAssured.given;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.restassured.constants.Constants;
import com.restassured.reports.ExtentReport;
import com.restassured.reports.LogStatus;
import com.restassured.utils.TestUtils;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BaseTest {
	
	protected StringWriter writer;
	protected PrintStream captor;
	
	
	/*
	 * Initializing the extent report
	 * @author Amuthan Sakthivel
	 */
	@BeforeSuite
	public void setUpSuite() {
		ExtentReport.initialize();
		
	}

	/*
	 * Flusing the extent report
	 * Opening the extent report automatically after the test suite execution.
	 * @author Amuthan Sakthivel
	 */
	
	@AfterSuite
	public void afterSuite() throws IOException  {
		ExtentReport.report.flush();
		File htmlFile = new File(Constants.EXTENTREPORTPATH);
		Desktop.getDesktop().browse(htmlFile.toURI());

	}

	/*
	 * This method helps to write the request and reponse to the extent report
	 * @author Amuthan Sakthivel
	 */
	@BeforeMethod
	public void setUp() {
		
		writer = new StringWriter();
		captor = new PrintStream(new WriterOutputStream(writer), true);
	}

	
	
	/*
	 * This might not be applied/used in the project.
	 * Provided as an sample to handle OAUTH scenarios and to handle x-www-form-urlencoded content type.
	 * Perform OAuth only once before each suite
	 * @author : Amuthan Sakthivel
	 */
	protected void performOAuth() {

		Response response=given().header("Content-Type", "application/json").
				config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC)))
				.contentType("application/x-www-form-urlencoded; charset=UTF-8")
				.formParam("username", Constants.USERNAME)
				.formParam("grant_type",  Constants.GRANT_TYPE)
				.formParam("client_id", Constants.CLIENT_ID)
				.formParam("password",  Constants.PASSWORD)
				.formParam("client_secret", TestUtils.decode(Constants.CLIENT_SECRET))
				.post(Constants.BASEURL+Constants.AUTH_ENDPOINT);
		response.then().statusCode(200);

		System.out.println("OAUTH is success");
	}

	/*
	 * Format the api string and log in Extent Report
	 * @author : Amuthan Sakthivel
	 * @param  : apicontent
	 */
	protected void formatAPIAndLogInReport(String content) {

		String prettyPrint = content.replace("\n", "<br>");
		LogStatus.info("<pre>" + prettyPrint + "</pre>");

	}


	/*
	 * Read the json file and convert to String
	 * @author : Amuthan Sakthivel
	 * @param  : filepath
	 */
	public String generateStringFromResource(String path) throws IOException {
		String temp="";
		try {
			temp= new String(Files.readAllBytes(Paths.get(path)));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return temp;

	}
	
	public void writeRequestAndResponseInReport(String request,String response) {

		LogStatus.info("---- Request ---");
		formatAPIAndLogInReport(request);
		LogStatus.info("---- Response ---");
		formatAPIAndLogInReport(response);
	}
	
}
