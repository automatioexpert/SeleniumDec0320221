package UI;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMTestcase {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElementById("txtUsername").sendKeys("Admin");
		driver.findElementById("txtPassword").sendKeys("admin123");
		driver.findElementByName("Submit").click();
		driver.findElementByXPath("//*[@id=\"menu_admin_viewAdminModule\"]/b").click();
		driver.findElementByXPath("//*[@id=\"menu_admin_UserManagement\"]").click();
		driver.findElementByXPath("//*[@id=\"menu_admin_viewSystemUsers\"]").click();
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
//firoz bhai testing branch


