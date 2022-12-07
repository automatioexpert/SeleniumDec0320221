package UI;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElementByXPath("//input[@id='travel_date']").click();
		
		for(int i=9;i>=1;i++) // 2june 2022
		{
			driver.findElementByXPath("//body[1]/div[6]/div[1]/table[1]/thead[1]/tr[1]/th[3]").click();
			String date = driver.findElementByXPath("/html[1]/body[1]/div[6]/div[1]/table[1]/thead[1]/tr[1]/th[2]").getText();
		  //  System.out.print(date);
			if(date.equals("June 2022"))
			{
			    
				driver.findElementByXPath("//tbody/tr[1]/td[5]").click();
				break;
			}
		}
		
		
	//	driver.close();
		//driver.quit();

	}

}
