package UI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class actionMouseOver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElementById("txtUsername").sendKeys("Admin");
		driver.findElementById("txtPassword").sendKeys("admin123");
		driver.findElementByName("Submit").click();
	    Actions act = new Actions(driver);
	    WebElement admin = driver.findElementByXPath("//*[@id=\"menu_admin_viewAdminModule\"]/b");
	    WebElement UM = driver.findElementByXPath("//*[@id=\"menu_admin_UserManagement\"]");
		WebElement users = driver.findElementByXPath("//*[@id=\"menu_admin_viewSystemUsers\"]");
		
		act.moveToElement(admin).build().perform();
		act.moveToElement(UM).build().perform();
		act.moveToElement(users).click().perform();
		
		//driver.findElementByXPath("//*[@id=\"menu_admin_viewAdminModule\"]/b").click();
		//driver.findElementByXPath("//*[@id=\"menu_admin_UserManagement\"]").click();
		//driver.findElementByXPath("//*[@id=\"menu_admin_viewSystemUsers\"]").click();
		int row = driver.findElementsByXPath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr").size();
		int col = driver.findElementsByXPath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr[1]/td").size();
		System.out.println(row);
		System.out.print(col);		
		int count=0;
		for(int i = 1 ;i<=row;i++)
		{
			for(int j=2 ; j <= col ; j ++){
				String name = driver.findElementByXPath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr["+i+"]/td["+j+"]").getText();
			    String status1=driver.findElementByXPath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr["+i+"]/td[5]").getText();
               if(status1.equals("Enabled"))
				{
					count++;
				}
					
				System.out.print(name + "    ");
			}
			System.out.println();
		}
		System.out.println("enabled count  = " + count);

	}

}


