package com.selenium.testing;

import org.junit.Test;
import org.openqa.selenium.edge.EdgeDriver;

public class Netflix {
	
	@Test
	public void loginPage() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Raj Kawale\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://WWW.Netflix.com");
	}
}