package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {
	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		Thread.sleep(2000);

		driver.findElement(By.id("justAnInputBox")).click();
		Thread.sleep(2000);

		By choices = By.cssSelector(".comboTreeItemTitle");

		// UC1 : Single Selection:
		 //selectChoice(choices, "choice 7");

		// UC2 : Multiple Selection:
		// selectChoice(choices, "choice 7", "choice 1", "choice 2");

		// UC3: All Selection:
		selectChoice(choices, "select_all");

	}

	/*
	 * This method is used tp select the values from the drop down:
	 * it covers three use cases:
	 * 1. Single
	 * 2. Multiple
	 * 3. All : Please pass "select_all"
	 */
	public static void selectChoice(By locator, String... value) {
		List<WebElement> choiceList = driver.findElements(locator);
		if (!value[0].equalsIgnoreCase("select_all")) {
			for (int i = 0; i < choiceList.size(); i++) {
				String text = choiceList.get(i).getText();
				System.out.println(text);
				for (int j = 0; j < value.length; j++) {
					if (text.equals(value[j])) {
						choiceList.get(i).click();
						break;
					}
				}

			}
		}
		// select all the values:
		else {
			try {
				for (WebElement e : choiceList) {
					e.click();
				}
			} catch (Exception e) {

			}
		}

	}

}
