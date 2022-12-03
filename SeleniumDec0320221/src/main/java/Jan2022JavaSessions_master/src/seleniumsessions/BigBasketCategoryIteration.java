package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BigBasketCategoryIteration {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");

		WebElement mainCat = driver.findElement(By.className("meganav-shop"));

		Actions act = new Actions(driver);
		act.moveToElement(mainCat).perform();
		Thread.sleep(3000);

		List<WebElement> level1list = driver.findElements(By.xpath("//ul[@id='navBarMegaNav']//a"));

		for (WebElement e1 : level1list) {

			act.moveToElement(e1).perform();
			System.out.println(e1.getText());

			List<WebElement> level2list = driver.findElements(By.xpath("(//ul[contains(@class,'nav-stacked')])[4]//a"));

			for (WebElement e2 : level2list) {

				act.moveToElement(e2).perform();
				System.out.println(e2.getText());

				List<WebElement> level3list = driver
						.findElements(By.xpath("(//div[@class='box']//ul[@class='list-unstyled'])[3]//a"));

				for (WebElement e3 : level3list) {

					act.moveToElement(e3).perform();
					System.out.println(e3.getText());

				}

			}

		}

	}

}
