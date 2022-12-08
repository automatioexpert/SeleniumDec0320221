package com.file.download.upload.example;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

public class FileUploadExample {
	final static String APIKEY = "734d05bac52c3137aff168687549b06a2d18872d";
	final static String ENDPOINT = "https://sandbox.zamzar.com/v1/jobs";

	@Test
	public void uploadFileExample() {

		File inputFile = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
				+ File.separator + "resources" + File.separator + "sample-graphic.gif");

		given().auth().basic(APIKEY, "")
		.multiPart("source_file", inputFile) // key "source_file" is as per defn in zamzar.com
		.multiPart("target_format", "png") // key "target_format" is as per defn in zamzar.com
		.when().post(ENDPOINT).then().log().all();
	}
}
