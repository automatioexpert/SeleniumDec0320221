package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();
		Thread.sleep(2000);
		By choices = By.xpath("//span[@class='comboTreeItemTitle']");

		// tc_01: single selection:
		// selectChoice(choices, "choice 1");

		// tc_02: multi selection:
		// selectChoice(choices, "choice 1", "choice 2", "choice 6 2 2", "choice 7");

		// tc_03: all selection:
		//selectChoice(choices, "ALL");

	}

	public static void selectChoice(By locator, String... value) {
		List<WebElement> choiceList = driver.findElements(locator);

		if (!value[0].equalsIgnoreCase("all")) {
			for (WebElement e : choiceList) {
				String text = e.getText();

				for (int i = 0; i < value.length; i++) {
					if (text.equals(value[i])) {
						e.click();
						break;
					}
				}

			}
		} else {
			// all selection logic:
			try {
				for (WebElement e : choiceList) {
					e.click();
				}
			} catch (ElementNotInteractableException e) {
				System.out.println("all choices are over.....");
			}
		}
	}

}
