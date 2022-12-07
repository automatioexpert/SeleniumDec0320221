package UI;

import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handlingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.naukri.com/");
		driver.findElementByXPath("/html[1]/body[1]/div[1]/div[2]/div[4]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]").click();
		//getWindowHandles will give the id of all the window in string fromat
		Set<String> IDs = driver.getWindowHandles();
		for(String id : IDs)
		{
			String TitleOfCurrentWindow = driver.switchTo().window(id).getTitle();
			System.out.println(TitleOfCurrentWindow);//the  title of 2nd window is changing again and again
			if(TitleOfCurrentWindow.equals("Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com"))
			{
				driver.close();
			}
			
		}
		
	}

}
