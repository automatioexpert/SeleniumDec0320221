package SeleniumSessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	public WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> doGetElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}
	
	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public void vefiyElementPresent(By locator) {
		List<WebElement> emailList = doGetElements(locator);
		System.out.println(emailList.size());// 0
		try {
			if (emailList.size() == 0) {
				System.out.println("element not present");
				throw new Exception("ELEMENTNOTPRESENTEXCEPTION");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> getAttributeList(By locator, String attributeName) {
		List<WebElement> eleList = doGetElements(locator);
		List<String> attrList = new ArrayList<String>();

		for (WebElement e : eleList) {
			String attrVal = e.getAttribute(attributeName);
			attrList.add(attrVal);
		}
		return attrList;
	}

	public int getLinksCount(By locator) {
		return getLinksTextList(locator).size();
	}

	public List<String> getLinksTextList(By locator) {
		List<WebElement> list = doGetElements(locator);
		List<String> textList = new ArrayList<String>();

		for (WebElement e : list) {
			String text = e.getText();
			if (!text.isEmpty()) {
				textList.add(text);
			}
		}
		return textList;
	}

	public List<WebElement> getLinksList(By locator) {
		return doGetElements(locator).stream().filter(e -> !e.getText().isEmpty()).collect(Collectors.toList());
	}

	/************************
	 * Drop Down Utils**************************8 These utils are for Select based
	 * drop downs where html tag = select
	 */

	public void doSelectDropDownByIndex(By locator, int index) {
		Select sel = new Select(getElement(locator));
		sel.selectByIndex(index);
	}

	public void doSelectDropDownByVisibleText(By locator, String text) {
		Select sel = new Select(getElement(locator));
		sel.selectByVisibleText(text);
	}

	public void doSelectDropDownByValue(By locator, String value) {
		Select sel = new Select(getElement(locator));
		sel.selectByValue(value);
	}

	public List<String> doGetAllDropDownOptions(By locator) {
		List<String> optionsTextList = new ArrayList<String>();
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());

		for (WebElement e : optionsList) {
			String text = e.getText();
			optionsTextList.add(text);
		}
		return optionsTextList;
	}

	public void doSelectValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		for (WebElement e : optionsList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	/*
	 * without using Select class:
	 */
	public void selectDropDownValue(By locator, String value) {
		List<WebElement> optionsList = doGetElements(locator);
		for (WebElement e : optionsList) {
			if (e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}

	/**************************** Wait Utils ****************************/

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * Default Intervla/polling Time = 500 ms
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public WebElement doPresenceOfElementLocated(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	public WebElement doPresenceOfElementLocated(By locator, int timeout, int intervaltime) {
		WebDriverWait wait = new WebDriverWait(driver, timeout, intervaltime);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that an element, known to be present on the DOM
	 * of a page, is visible. Visibility means that the element is not only
	 * displayed but also has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public WebElement isElementVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}
	
	/**
	 * An expectation for checking that all elements present on the web page that 
	 * match the locator are visible. 
	 * Visibility means that the elements are not only displayed but 
	 * also have a height and width that is greater than 0.
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public List<WebElement> waitForElementsToBeVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public Boolean waitForElementsToBeInVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public void printAllElementsTextWithWait(By locator, int timeOut) {
		waitForElementsToBeVisible(locator, timeOut).stream().forEach(e -> System.out.println(e.getText()));
	}
	
	public List<String> getElementsTextListWithWait(By locator, int timeOut) {
		List<WebElement> elementsList = waitForElementsToBeVisible(locator, timeOut);
		List<String> elementsTextList = new ArrayList<String>();
		for(WebElement e : elementsList) {
			elementsTextList.add(e.getText().trim());
		}
		return elementsTextList;
	}
	
	/**
	 * An expectation for checking an element is visible and enabled such that you can click it.
	 * @param locator
	 * @param timeOut
	 */
	public void clickWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	public void clickElementWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(getElement(locator))).click();
	}
		

	private Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}

	public void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}

	public String alertGetText(int timeOut) {
		return waitForAlert(timeOut).getText();
	}

	public void alertSendKeys(int timeOut, String value) {
		waitForAlert(timeOut).sendKeys(value);
	}

	public void waitForFrameAndSwitch(String nameORID, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameORID));
	}

	public void waitForFrameAndSwitch(By frameLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	public void waitForFrameAndSwitch(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	public void waitForFrameAndSwitch(WebElement frameElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

	public boolean waitForUrlFraction(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlContains(urlFraction));
	}

	public boolean waitForUrlToBe(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlToBe(url));
	}
	
	public String waitForTitleIs(String expTitle, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if(wait.until(ExpectedConditions.titleIs(expTitle)))
			return driver.getTitle();
		return null;
	}
	
	public String waitForTitleContains(String titleFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if(wait.until(ExpectedConditions.titleContains(titleFraction)))
			return driver.getTitle();
		return null;
	}
	
	public WebElement waitForElementDemo(By locator, int timeOut, long pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.withTimeout(Duration.ofSeconds(timeOut))
				.withMessage(Error.TIME_OUT_WEB_ELEMENT_MSG)
					.pollingEvery(Duration.ofMillis(pollingTime))
						.ignoring(NoSuchElementException.class, 
									StaleElementReferenceException.class);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	public WebElement waitForElementWithFluentWait(By locator, int timeOut, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.withMessage(Error.TIME_OUT_WEB_ELEMENT_MSG)
				.pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchElementException.class, 
						StaleElementReferenceException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	
	public Alert waitForAlertWithFluentWait(int timeOut, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.withMessage(Error.TIME_OUT_ALERT_MSG)
				.pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoAlertPresentException.class);

		 return wait.until(ExpectedConditions.alertIsPresent());

	}
	
	
	public WebDriver waitForFrameWithFluentWait(String frameLocator, int timeOut, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.withMessage(Error.TIME_OUT_FRAME_ELEMENT_MSG)
				.pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchFrameException.class);

		 return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));

	}

}
