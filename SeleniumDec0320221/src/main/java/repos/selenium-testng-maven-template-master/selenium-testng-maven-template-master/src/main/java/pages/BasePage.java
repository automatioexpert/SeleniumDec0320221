package pages;

import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.support.ui.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import tools.Config;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BasePage {

  protected WebDriver driver;
  JavascriptExecutor js = (JavascriptExecutor) driver;
  private Logger logger = Logger.getLogger(String.valueOf(BasePage.class));

  public BasePage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement find(By locator) {
    logger.info(String.format("Locating element '%s'", locator.toString()));

    return new WebDriverWait(driver, Config.POLLING_PERIOD)
        .until(ExpectedConditions.presenceOfElementLocated(locator));
  }

  public List<WebElement> findList(By locator) {
    logger.info(String.format("Locating element '%s'", locator.toString()));

    return driver.findElements(locator);
  }

  public WebElement findIn(WebElement element,
      By locator) {
    logger.info(String
        .format("Locating element '%s' in element %s", locator.toString(), element.toString()));

    return new WebDriverWait(driver, Config.POLLING_PERIOD)
        .withTimeout(Config.LOCATION_TIMEOUT, TimeUnit.MILLISECONDS)
        .pollingEvery(Config.POLLING_PERIOD, TimeUnit.MILLISECONDS)
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.presenceOfElementLocated(locator));
  }

  public void click(By locator) {
    logger.info(String.format("Clicking element '%s'", locator.toString()));
    find(locator).click();
  }

  public void type(String text,
      By locator) {
    type(text, true, locator);
  }

  public void type(String text,
      boolean append,
      By locator) {
    WebElement element = find(locator);
    if (append) {
      element.clear();
    }

    logger.info(String.format("Typing '%s' in element '%s'", text, locator.toString()));
    element.sendKeys(text);
  }

  public void selectByText(String text,
      By locator) {
    logger.info(
        String.format("Selecting '%s' option in dropdown element '%s'", text, locator.toString()));

    getSelect(locator).selectByVisibleText(text);

  }

  public void selectByIndex(int index,
      By locator) {
    getSelect(locator).selectByIndex(index);
  }

  @Attachment(type = "image/png")
  public static byte[] saveFullPageScreenshot(WebDriver webDriver) {
    Screenshot fpScreenshot = new AShot()
        .shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(2f), 1000))
        .takeScreenshot(webDriver);

    BufferedImage originalImage = fpScreenshot.getImage();

    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
      ImageIO.write(originalImage, "png", baos);
      baos.flush();
      return baos.toByteArray();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "Unable to Get Screenshot.".getBytes();
  }

  protected WebElement waitForElementToBeVisible(final By locator) {
    Wait<WebDriver> wait = new FluentWait<>(driver)
        .withTimeout(10, TimeUnit.SECONDS)
        .pollingEvery(200, TimeUnit.MILLISECONDS);

    return wait.until(ExpectedConditions.visibilityOf(find(locator)));
  }

  protected Select getSelect(By locator) {
    return new Select(find(locator));
  }

  private WebDriver getDriver(WebElement element) {
    return ((WrapsDriver) element).getWrappedDriver();
  }

  public boolean waitForJStoLoad() {
    WebDriverWait wait = new WebDriverWait(driver, 30);

    // wait for jQuery to load
    ExpectedCondition<Boolean> jQueryLoad = driver -> {
      try {
        return ((Long)js.executeScript("return jQuery.active") == 0);
      }
      catch (Exception e) {
        return true;
      }
    };

    // wait for Javascript to load
    ExpectedCondition<Boolean> jsLoad = driver -> js.executeScript("return document.readyState")
        .toString().equals("complete");

    return wait.until(jQueryLoad) && wait.until(jsLoad);
  }
}
