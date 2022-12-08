package Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class Validation {
	public void opration(WebDriver driver, WebElement element, String opration, String expected, String testdata) 
			throws InterruptedException {
		switch (opration.toUpperCase()) {
		case "MAXLENGTH":
			System.err.println("Test for MaxLength is started");
			element.click();
			String actualdata = element.getAttribute("value");
			String maxlength = element.getAttribute("maxlength");
			int actualLength = actualdata.length();
			int maxlen = Integer.parseInt(maxlength);
			float exp = Float.parseFloat(expected);
			if (actualLength <= maxlen && exp == maxlen) {
				System.out.println("Maxlength is  within  " + maxlength);
			} else {
				System.err.println("Maxlength is Fail  ");
			}
			System.out.println("Length of I/p is " + actualLength);
			break;
		case "DDLMATCH":
			System.err.println("Test for DDL Match is started");
			String[] array = expected.split(",");
			Select select = new Select(element);
			List < WebElement > options = select.getOptions();
			for (WebElement e: options) {
				for (int i = 0; i < array.length; i++) {
					if (e.getText().equals(array[i])) {
						System.out.println(array[i] + " Matched.");
					}
				}
			}
			break;
		case "DATATYPE":
			System.err.println("Test for Special Charecter/Numeric/alphanumeric  is started");
			String value = element.getAttribute("value");
			System.out.println("my input for Field is " + value);
			if (expected.equals(value)) {
				System.out.println("System is Automatically  Deleting STest for Special Charecter/Numeric/alphanumeric  is started,article code is - " + value);
			} else {
				System.err.println("System is not Deleting Special Charecter/Numeric/alphanumeric, Now article code is  " + value);
			}
			break;
		case "MANDATORY":
			System.err.println("Test for MANDATORY Check " + expected + " is started");
			driver.findElement(By.linkText("Confirm")).click();
			Thread.sleep(5000);
			WebElement alert = driver.findElement(By.className("dialogContentright"));
			String alertText = alert.getText();
			if (driver.getPageSource().contains("Mandatory Field") && alertText.contains(expected)) {
				System.out.println("MANDATORY Check Pass");
				driver.findElement(By.id("dialogMessageClose")).click();
			} else {
				System.out.println("MANDATORY Check Fail");
				driver.findElement(By.id("dialogMessageClose")).click();
			}
			break;
		default:
			break;
		}
	}
}