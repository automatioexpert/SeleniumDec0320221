package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDown {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		driver.findElement(By.id("justAnInputBox")).click();
		By choices = By.cssSelector("span.comboTreeItemTitle");

		// TC01: Single Selection:
		// selectChoice(choices, "choice 1");

		// TC02: Multiple Selection:
		// selectChoice(choices, "choice 2", "choice 2 1", "choice 6 2 3");

		// TC03: All selection
		selectChoice(choices, "automation_all");

	}

	/**
	 * TC01: Single Selection: TC02: Multiple Selection: TC03: All selection: Please
	 * pass - > automation_all
	 * 
	 * @param locator
	 * @param value
	 */
	public static void selectChoice(By locator, String... value) {
		List<WebElement> choiceList = driver.findElements(locator);

		if (!value[0].equalsIgnoreCase("automation_all")) {

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
		} else {
			// select all the choices:
			try {
				for (WebElement e : choiceList) {
					e.click();
				}
			} catch (Exception e) {
				System.out.println("all choices are over.....");
			}
		}
	}

}
