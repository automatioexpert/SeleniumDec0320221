package CDPTests;

import java.util.HashMap;
import java.util.Map;

import org.naveenautomatiolabs.CDP.NAL_CDP.NALChromeDevTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CDPTest {
	
	public void test1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		NALChromeDevTools nc = new NALChromeDevTools(driver, "chrome");
		//nc.getNetworkHTTPRequest();
		Map deviceMetrics = new HashMap()
        {{
            put("width", 600);
            put("height", 1000);
            put("mobile", true);
            put("deviceScaleFactor", 50);
        }};
		//nc.simulateDeviceMode(deviceMetrics);
		
		nc.setGeoLocation(35.8235, -78.8256, 100);		
		//driver.get("http://www.amazon.in");
        driver.get("https://oldnavy.gap.com/stores");
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("naveen automation labs");
//		driver.findElement(By.id("twotabsearchtextbox")).submit();
		nc.getConsoleLogs();
		
		//driver.quit();
	}
	
	
	
	

}
