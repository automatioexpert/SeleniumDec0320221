package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectUtils {

    private final File filePath;
    protected final WebDriver driver;
    private static Logger log = Logger.getLogger(ObjectUtils.class.getName());
    private final static String OBJECT_REPO_FOLDER = "ObjectRepo";

    public ObjectUtils(WebDriver driver, String pageName) {
        this.driver = driver;
        filePath = Paths.get(OBJECT_REPO_FOLDER, pageName +".properties").toFile();
    }

    private Properties getObjectRepository() {
        Properties p = new Properties();
        InputStream stream = null;
        try {
            // Read object repository file
            stream = new FileInputStream(filePath);
            // load all objects
            p.load(stream);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return p;
    }

    public By getLocator(String locatorName) {
        By by = null;
        try {
            String locType = getObjectRepository().getProperty(locatorName).split(":")[0];
            String locvalue = getObjectRepository().getProperty(locatorName).split(":")[1];
            by = getByFromParams(locType, locvalue);
        } catch (NullPointerException e) {
            log.error(e.getMessage(), e);
        }
        return by;

    }

    public WebElement getElement(String lacatorName) {
        return driver.findElement(getLocator(lacatorName));
    }

    public List<WebElement> getListOfEelments(String lacatorName) {
        return driver.findElements(getLocator(lacatorName));
    }

    private By getByFromParams(String byName, String byValue) {
        switch (byName.toLowerCase()) {
            case "id":
                return By.id(byValue);
            case "name":
                return By.name(byValue);
            case "tagname":
            case "tag name":
            case "htmltag":
                return By.tagName(byValue);
            case "class":
            case "class name":
                return By.className(byValue);
            case "text":
            case "linktext":
            case "link text":
                return By.linkText(byValue);
            case "partial link text":
            case "partiallinktext":
                return By.partialLinkText(byValue);
            case "xpath":
                return By.xpath(byValue);
            case "css":
            case "css selector":
                return By.cssSelector(byValue);
            default:
                throw new IllegalArgumentException("Invalid Property Name: " + byName);
        }
    }

}
