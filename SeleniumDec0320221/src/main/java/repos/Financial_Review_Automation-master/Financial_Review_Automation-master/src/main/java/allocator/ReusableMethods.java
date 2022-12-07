package allocator;
import static allocator.WebConnector.driver;
import static allocator.WebConnector.prop;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.core.api.Scenario;

public class ReusableMethods {
	public String RunTimeValue;

	public void saveScreenshotsForScenario(final Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");
	}

	public void waitForPageLoad(int timeout){
		ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";");
	}

	public void compareAndreport(String actual, String Expected, String ReportMessage, ExtentTest logInfo, String imagePath) throws IOException
	{
		try {
			if(actual.contains(Expected)){
				logInfo.pass(ReportMessage +" is working as expected");
				System.out.println(ReportMessage +" is matching");
				logInfo.addScreenCaptureFromPath(imagePath);  
			}
			else{
				logInfo.fail(ReportMessage +" is not as expected");
				logInfo.addScreenCaptureFromPath(imagePath);  
			}
		}
		catch(Exception e) {
			logInfo.fail(ReportMessage +" is not as expected");
			logInfo.addScreenCaptureFromPath(imagePath);  
		}
	}

	public By getElementWithLocator(String AppElement) throws Exception {
		String locatorTypeAndValue = prop.getProperty(AppElement);
		String[] locatorTypeAndValueArray = locatorTypeAndValue.split(",",2);
		String locatorType = locatorTypeAndValueArray[0].trim();
		String locatorValue = locatorTypeAndValueArray[1].trim();
		if(locatorValue.contains("ObjectToken")){
			locatorValue = locatorValue.replaceAll("ObjectToken", RunTimeValue);
		}
		switch (locatorType.toUpperCase()) {
		case "ID":
			return By.id(locatorValue);
		case "NAME":
			return By.name(locatorValue);
		case "XPATH":
			return By.xpath(locatorValue);
		case "CLASS":
			return By.className(locatorValue);
		default:
			return null;
		}
	}

	public WebElement FindAnElement(String AppElement) throws Exception{
		return (WebElement) driver.findElement(getElementWithLocator(AppElement));
	}

	public void PerformActionOnElement(String AppElement, String Action, String Text) throws Exception {
		try {
			RunTimeValue=Text;
			switch (Action.toLowerCase()) {
			case "click":
				FindAnElement(AppElement).click();
				break;
			case "clickwithactionclass":
				Actions actions = new Actions(driver);
				WebElement mainMenu = FindAnElement(AppElement);
				actions.moveToElement(mainMenu).click().build().perform();
				break;
			case "clickondropdownwithmouseover":
				Actions action = new Actions(driver);
				WebElement menu = FindAnElement(AppElement);
				Thread.sleep(2000);
				action.moveToElement(menu).moveToElement(FindAnElement(AppElement)).click().build().perform();
				break;
			case "sendkeys":
				FindAnElement(AppElement).sendKeys(Text);
				Thread.sleep(5000);
				break;
			case "enterkeys":
				FindAnElement(AppElement).sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				break;
			case "clear":
				FindAnElement(AppElement).clear();
				break;
			case "gettext":
				FindAnElement(AppElement).getText();
				break;
			case "select":
				Select dropdown = new Select(FindAnElement(AppElement));
				dropdown.selectByValue(Text);
			case "selectbyindex":
				Select selectbyindexDropDown = new Select(FindAnElement(AppElement));
				selectbyindexDropDown.selectByIndex(Integer.parseInt(Text));
				break;
			case "waitforelementdisplay":
				waitForCondition("Presence",AppElement,60);
				break;
			case "waitforelementclickable":
				waitForCondition("Clickable",AppElement,60);
				break;
			case "elementnotdisplayed":
				waitForCondition("NotPresent",AppElement,60);
				break;
			default:
				throw new IllegalArgumentException("Action \"" + Action + "\" isn't supported.");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public boolean waitForCondition(String TypeOfWait, String AppElement, int Time){
		boolean conditionMeet = false;
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Time, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(Exception.class);
			switch (TypeOfWait)
			{
			case "Clickable":
				wait.until(ExpectedConditions.elementToBeClickable(FindAnElement(AppElement)));
				conditionMeet=true;
				break;
			case "Presence":
				wait.until(ExpectedConditions.presenceOfElementLocated(getElementWithLocator(AppElement)));
				conditionMeet=true;
				break;
			case "Visibility":
				wait.until(ExpectedConditions.visibilityOfElementLocated(getElementWithLocator(AppElement)));
				conditionMeet=true;
				break;
			case "NotPresent":
				wait.until(ExpectedConditions.invisibilityOfElementLocated(getElementWithLocator(AppElement)));
				conditionMeet=true;
				break;
			}
		}
		catch(Exception e)
		{
			throw new IllegalArgumentException("wait For Condition \"" + TypeOfWait + "\" isn't supported.");
			//System.out.println(AppElement+" Element is not displayed");
		}
		return conditionMeet;
	}

	public void scrollToView(String AppElement) throws Exception
	{
		WebElement element = FindAnElement(AppElement);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public String getUrl()
	{
		String url = driver.getCurrentUrl();
		return url;
	}

	public void closebrowser() {
		try
		{
			driver.close();
		}
		catch(Exception e)
		{
			System.out.println("Window doesn't exist");
		}
	}
}



















