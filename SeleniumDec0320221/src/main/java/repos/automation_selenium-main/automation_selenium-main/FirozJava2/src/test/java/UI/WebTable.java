package UI;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		int rows = driver.findElements(By.xpath("/html/body/div[7]/div[1]/div[1]/div[3]/div/table/tbody/tr")).size();
		int cols = driver.findElements(By.xpath("/html/body/div[7]/div[1]/div[1]/div[3]/div/table/tbody/tr/th")).size();
		System.out.print(rows);
		System.out.print(cols);
		for(int i=2;i<=rows;i++)
	    {
	    	for(int j=1;j<=cols;j++)
	    	{
               String element = driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[1]/div[3]/div/table/tbody/tr["+i+"]/td["+j+"]")).getText();
               System.out.print(element + "  ");
	    	}
	    	 System.out.println();
	    }
	}
}