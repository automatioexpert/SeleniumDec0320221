package com.BasicSelinum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class https_certificates_handling {

	public static void main(String[] args) {

		FirefoxProfile fp = new FirefoxProfile();
		fp.setAcceptUntrustedCertificates(true);
		fp.setAssumeUntrustedCertificateIssuer(false);

		FirefoxOptions options = new FirefoxOptions().merge(DesiredCapabilities.firefox());
		options.setAcceptInsecureCerts(true);

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\HASSEN\\workspace\\BasicSelinum_Tutorail_Suite\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://expired.badssl.com/");

		ChromeOptions cap = new ChromeOptions().merge(DesiredCapabilities.chrome());
		cap.setAcceptInsecureCerts(true);

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HASSEN\\workspace\\BasicSelinum_Tutorail_Suite\\Drivers\\chromedriver.exe");
		WebDriver driver1 = new ChromeDriver(cap);
		driver1.get("https://expired.badssl.com/");

	}

}
