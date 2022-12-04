package seleniumsessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}

	public void printElementsText(By locator) {
		getElementsTextList(locator).stream().forEach(e -> System.out.println(e));
	}

	public void getAttributeList(By locator, String attr) {
		List<WebElement> attrList = getElements(locator);
		for (int i = 0; i < attrList.size(); i++) {
			String srcVal = attrList.get(i).getAttribute(attr);
			System.out.println(srcVal);
		}
	}

	/**************************
	 * Select based Drop Downs *************************
	 * 
	 */

	public void doSelectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectDropDownByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	public void doSelectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public void printDropDownOptions(By locator) {
		getDropDownOptions(locator).stream().forEach(e -> System.out.println(e));
	}

	public List<String> getDropDownOptions(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();

		for (WebElement e : optionsList) {
			optionsTextList.add(e.getText());
		}
		return optionsTextList;
	}

	public void doSelectValueFromDropDown(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		for (WebElement e : optionsList) {
			if (e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}

	public void doSelectValues(By locator, String value) {
		List<WebElement> optionsList = getElements(locator);
		for (WebElement e : optionsList) {
			if (e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}

	/*****************************
	 * Actions Utils *********************
	 * 
	 * 
	 */
	public void handleTwoLevelMenu(By parentLocator, By childLocator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentLocator)).perform();
		doClick(childLocator);
	}

	public void handleThreeLevelMenu(By parentLocator1, By parentLocator2, By childLocator)
			throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentLocator1)).perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(parentLocator2)).perform();
		Thread.sleep(2000);
		doClick(childLocator);
	}

	public void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}

	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}

	/******************************
	 * Wait Utils
	 * 
	 * @return
	 ******************************/

	public List<WebElement> waitForVisibilityOfElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public void printElementsText(By locator, int timeOut) {
		waitForVisibilityOfElements(locator, timeOut).stream().forEach(e -> System.out.println(e.getText()));
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param timeOut(secs)
	 * @return
	 */
	public WebElement doPresenceOfElementLocated(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * 
	 * @param locator
	 * @param timeOut(secs)
	 * @param intervalTime  (milli secs)
	 * @return
	 */
	public WebElement doPresenceOfElementLocated(By locator, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut, intervalTime);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that an element, known to be present on the DOM
	 * of a page, is visible on the page also. Visibility means that the element is
	 * not only displayed but also has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement doVisibilityOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}

	public Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}

	public void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}

	public String getAlertText(int timeOut) {
		return waitForAlert(timeOut).getText();
	}

	public boolean waitForURL(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlContains(urlFraction));
	}

	public boolean waitForURLToBe(String urlValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlToBe(urlValue));
	}

	public String getPageTitle(String titleFraction, int timeOut) {
		waitForTitle(titleFraction, timeOut);
		return driver.getTitle();
	}

	public boolean waitForTitle(String titleFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.titleContains(titleFraction));
	}

	public boolean waitForTitleIs(String titleVal, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.titleIs(titleVal));
	}

	public void waitForFrameElement(String IDORNAME, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IDORNAME));
	}

	public void waitForFrameElement(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	/**
	 * An expectation for checking an element is visible and enabled such that you
	 * can click it.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementToBeClickable(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void clickWhenReady(By locator, int timeOut) {
		waitForElementToBeClickable(locator, timeOut).click();
	}
	
	public WebElement waitForPresenceOfElementWithFluentWait(By locator, int timeOut, int intervalTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(intervalTime))
				.ignoring(StaleElementReferenceException.class,
						NoSuchElementException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void waitForFrameWithFluentWait(By locator, int timeOut, int intervalTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(intervalTime))
				.ignoring(NoSuchFrameException.class);

		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	public Alert waitForAlertWithFluentWait(By locator, int timeOut, int intervalTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(intervalTime))
				.ignoring(NoAlertPresentException.class);

		 return wait.until(ExpectedConditions.alertIsPresent());
	}

}
