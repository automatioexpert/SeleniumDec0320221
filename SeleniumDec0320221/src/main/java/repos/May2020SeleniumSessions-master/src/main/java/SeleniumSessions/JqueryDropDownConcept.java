package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		Thread.sleep(3000);

		driver.findElement(By.id("justAnInputBox")).click();
		By allChoices = By.cssSelector("span.comboTreeItemTitle");

		//selectChoiceValues(allChoices, "choice 2 2");
		selectChoiceValues(allChoices, "choice 2 2", "choice 6", "choice 6 2 3");
		//selectChoiceValues(allChoices, "all");

		// 1. single value
		// 2. multiple value
		// 3. All values

		Thread.sleep(4000);
		driver.quit();

	}

	public static void selectChoiceValues(By locator, String... value) {

		List<WebElement> choiceList = driver.findElements(locator);

		if (!value[0].equalsIgnoreCase("ALL")) {
			for (int i = 0; i < choiceList.size(); i++) {
				String text = choiceList.get(i).getText();
				System.out.println(text);

				for (int k = 0; k < value.length; k++) {
					if (text.equals(value[k])) {
						choiceList.get(i).click();
						break;
					}
				}
			}
		}
		// select all the values:
		else {
			try {
				for (int all = 0; all < choiceList.size(); all++) {
					choiceList.get(all).click();
				}
			} catch (Exception e) {

			}
		}

	}

}
