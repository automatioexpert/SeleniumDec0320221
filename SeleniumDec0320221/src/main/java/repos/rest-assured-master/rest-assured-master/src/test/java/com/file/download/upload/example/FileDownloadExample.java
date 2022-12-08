package com.file.download.upload.example;

import java.io.File;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class FileDownloadExample {

	@Test
	public void verifyDownloadedFile() {
		File expectedFile = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
				+ File.separator + "resources" + File.separator + "5MB.zip");
		int expectedFileSize = (int) expectedFile.length();
		byte[] actualFileSize = given().when().get("http://ipv4.download.thinkbroadband.com/5MB.zip").then().extract()
				.asByteArray();
		assertThat(actualFileSize.length).isEqualTo(expectedFileSize);
	}
}
