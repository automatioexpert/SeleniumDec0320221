package UI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class verifyDropDownSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
	//	WebElement element = driver.findElementByXPath("//select[@id='oldSelectMenu']");
	//	driver.get("https://demoqa.com/select-menu");
		WebElement element = driver.findElementByXPath("//tbody/tr[11]/td[2]/select[1]");
		Select sel = new Select(element);
		List originalList = new ArrayList();
		List templist = new ArrayList();
		List <WebElement> options= sel.getOptions();
		for(WebElement option : options)
		{
		    originalList.add(option.getText());
		    templist.add(option.getText());
		}
		Collections.sort(templist);
		System.out.println(originalList);
		System.out.println(templist);	
		
		if(originalList.equals(templist))
			System.out.println("List is sorted ");
		else
			System.out.println("list is not sorted ");
		
	}
}
