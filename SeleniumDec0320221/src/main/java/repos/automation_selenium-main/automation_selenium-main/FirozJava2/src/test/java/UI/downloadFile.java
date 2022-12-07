package UI;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class downloadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		driver.findElementByXPath("//*[@id=\"textbox\"]").sendKeys("automation");
		driver.findElementByXPath("//*[@id=\"createTxt\"]").click();
		driver.findElementById("link-to-download").click();
	}

}
