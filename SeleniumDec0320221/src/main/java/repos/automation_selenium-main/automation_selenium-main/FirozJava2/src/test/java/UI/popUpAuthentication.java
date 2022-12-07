package UI;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class popUpAuthentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		String s = driver.findElementByCssSelector("p").getText();
		if(s.equals("Congratulations! You must have the proper credentials."))
			System.out.print("test cases passed ");
	}

}
