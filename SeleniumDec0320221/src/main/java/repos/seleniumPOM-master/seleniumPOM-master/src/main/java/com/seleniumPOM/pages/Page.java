package com.seleniumPOM.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.TestException;

public abstract class Page {
	
	WebDriver driver;
	WebDriverWait wait;
	private static int timeout = 10;
    public Actions actions;
    public Select select;
	
	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 15);
	}
	
	public abstract void waitForElemnet(By locator);
	
	public <NextPage extends BasePage> NextPage getInstance(Class<NextPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
    public void navigateToURL(String URL) {
        try {
            driver.navigate().to(URL);
        } catch (Exception e) {
            System.out.println("FAILURE: URL did not load: " + URL);
            throw new TestException("URL did not load");
        }
    }

    public void navigateBack() {
        try {
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("FAILURE: Could not navigate back to previous page.");
            throw new TestException("Could not navigate back to previous page.");
        }
    }

    public String getPageTitle() {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            throw new TestException(String.format("Current page title is: %s", driver.getTitle()));
        }
    }

    public String getCurrentURL() {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
            throw new TestException(String.format("Current URL is: %s", driver.getCurrentUrl()));
        }
    }

    public WebElement getElement(By selector) {
        try {
            return driver.findElement(selector);
        } catch (Exception e) {
            System.out.println(String.format("Element %s does not exist - proceeding", selector));
        }
        return null;
    }

    public String getElementText(By selector) {
        waitUntilElementIsDisplayedOnScreen(selector);
        try {
            return StringUtils.trim(driver.findElement(selector).getText());
        } catch (Exception e) {
            System.out.println(String.format("Element %s does not exist - proceeding", selector));
        }
        return null;
    }

    public List<WebElement> getElements(By Selector) {
        waitForElementToBeVisible(Selector);
        try {
            return driver.findElements(Selector);
        } catch (Exception e) {
            throw new NoSuchElementException(String.format("The following element did not display: [%s] ", Selector.toString()));
        }
    }

    public List<String> getListOfElementTexts(By selector) {
        List<String> elementList = new ArrayList<String>();
        List<WebElement> elements = getElements(selector);

        for (WebElement element : elements) {
            if (element == null) {
                throw new TestException("Some elements in the list do not exist");
            }
            if (element.isDisplayed()) {
                elementList.add(element.getText().trim());
            }
        }
        return elementList;
    }

    public void click(By selector) {
        WebElement element = getElement(selector);
        waitForElementToBeClickable(selector);
        try {
            element.click();
        } catch (Exception e) {
            throw new TestException(String.format("The following element is not clickable: [%s]", selector));
        }
    }

    public void scrollToThenClick(By selector) {
        WebElement element = driver.findElement(selector);
        actions = new Actions(driver);
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            actions.moveToElement(element).perform();
            actions.click(element).perform();
        } catch (Exception e) {
            throw new TestException(String.format("The following element is not clickable: [%s]", element.toString()));
        }
    }

    public void sendKeys(By selector, String value) {
        WebElement element = getElement(selector);
        clearField(element);
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            throw new TestException(String.format("Error in sending [%s] to the following element: [%s]", value, selector.toString()));
        }
    }

    public void clearField(WebElement element) {
        try {
            element.clear();
            waitForElementTextToBeEmpty(element);
        } catch (Exception e) {
            System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));
        }
    }

    public void waitForElementToDisplay(By Selector) {
        WebElement element = getElement(Selector);
        while (!element.isDisplayed()) {
            System.out.println("Waiting for element to display: " + Selector);
            sleep(200);
        }
    }

    public void waitForElementTextToBeEmpty(WebElement element) {
        String text;
        try {
            text = element.getText();
            int maxRetries = 10;
            int retry = 0;
            while ((text.length() >= 1) || (retry < maxRetries)) {
                retry++;
                text = element.getText();
            }
        } catch (Exception e) {
            System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));
        }

    }

    public void waitForElementToBeVisible(By selector) {
        try {
            wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        } catch (Exception e) {
            throw new NoSuchElementException(String.format("The following element was not visible: %s", selector));
        }
    }

    public void waitUntilElementIsDisplayedOnScreen(By selector) {
        try {
            wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        } catch (Exception e) {
            throw new NoSuchElementException(String.format("The following element was not visible: %s ", selector));
        }
    }

    public void waitForElementToBeClickable(By selector) {
        try {
            wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(selector));
        } catch (Exception e) {
            throw new TestException("The following element is not clickable: " + selector);
        }
    }

    public void sleep(final long millis) {
        System.out.println((String.format("sleeping %d ms", millis)));
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void selectIfOptionTextContains(By selector, String searchCriteria) {

        waitForElementToBeClickable(selector);
        Select dropdown = new Select(getElement(selector));

        List<WebElement> options = dropdown.getOptions();

        String optionText = "";

        if (options == null) {
            throw new TestException("Options for the dropdown list cannot be found.");
        }

        for (WebElement option : options) {

            optionText = option.getText().trim();
            boolean isOptionDisplayed = option.isDisplayed();

            if (optionText.contains(searchCriteria) && isOptionDisplayed) {
                try {
                    dropdown.selectByVisibleText(optionText);
                    break;
                } catch (Exception e) {
                    throw new NoSuchElementException(String.format("The following element did not display: [%s] ", selector.toString()));
                }
            }
        }
    }

    public void selectIfOptionTextEquals(By selector, String searchCriteria) {

        waitForElementToBeClickable(selector);
        Select dropdown = new Select(getElement(selector));

        List<WebElement> options = dropdown.getOptions();

        String optionText = "";

        if (options == null) {
            throw new TestException("Options for the dropdown list cannot be found.");
        }

        for (WebElement option : options) {

            optionText = option.getText().trim();
            boolean isOptionDisplayed = option.isDisplayed();

            if (optionText.equals(searchCriteria) && isOptionDisplayed) {
                try {
                    dropdown.selectByVisibleText(optionText);
                    break;
                } catch (Exception e) {
                    throw new NoSuchElementException(String.format("The following element did not display: [%s] ", selector.toString()));
                }
            }
        }
    }

    public List<String> getDropdownValues(By selector) {

        waitForElementToDisplay(selector);
        Select dropdown = new Select(getElement(selector));
        List<String> elementList = new ArrayList<String>();

        List<WebElement> allValues = dropdown.getOptions();

        if (allValues == null) {
            throw new TestException("Some elements in the list do not exist");
        }

        for (WebElement value : allValues) {
            if (value.isDisplayed()) {
                elementList.add(value.getText().trim());
            }
        }
        return elementList;
    
}
	
}
