package Base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.stream.Stream;

public enum Device {

    CHROME, FIREFOX, REMOTECHROME, MOBILECHROME, REMOTEFIREFOX;

    public RemoteWebDriver setDriver() throws MalformedURLException {
        switch (this) {
            case CHROME:
                File chromeDriver = new File("./src/main/resources/drivers/chromedriver");
                System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
                ChromeOptions option = new ChromeOptions();
                option.addArguments("disable-extensions");
                option.addArguments("disable-infobars");
                option.addArguments("disable-notifications");
                option.addArguments("disable-web-security");
                option.addArguments("dns-prefetch-disable");
                option.addArguments("disable-browser-side-navigation");
                option.addArguments("disable-gpu");
                option.addArguments("always-authorize-plugins");
                return new ChromeDriver(option);
            case FIREFOX:
                File firefoxDriver = new File("./src/main/resources/drivers/geckodriver");
                System.setProperty("webdriver.gecko.driver", firefoxDriver.getAbsolutePath());
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                return new FirefoxDriver(firefoxOptions);
            case REMOTECHROME:
                DesiredCapabilities capabilities = new DesiredCapabilities();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("disable-extensions");
                chromeOptions.addArguments("disable-infobars");
                chromeOptions.addArguments("disable-notifications");
                chromeOptions.addArguments("disable-web-security");
                chromeOptions.addArguments("dns-prefetch-disable");
                chromeOptions.addArguments("disable-browser-side-navigation");
                chromeOptions.addArguments("disable-gpu");
                chromeOptions.addArguments("always-authorize-plugins");
                chromeOptions.addArguments("load-extension=src/main/resources/chrome_load_stopper");
                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                return new RemoteWebDriver(new URL(System.getProperty("seleniumGridUrl", "http://localhost:4444/wd/hub")), capabilities);
            case REMOTEFIREFOX:
                FirefoxOptions firefoxOptions1 = new FirefoxOptions();
                return new RemoteWebDriver(new URL(System.getProperty("seleniumUrl", "http://localhost:4444/wd/hub")), firefoxOptions1);
            case MOBILECHROME:
                DesiredCapabilities capability = new DesiredCapabilities();
                capability.setCapability("browserName", "chrome");
                capability.setCapability("deviceName", "device");
                capability.setCapability("platformName", "Android");
                capability.setCapability("automationName", "uiautomator2");
                capability.setCapability("appActivity", "com.google.android.apps.chrome.Main");
                capability.setCapability("noReset", true);
                return new RemoteWebDriver(new URL(System.getProperty("appiumUrl", "http://localhost:4444/wd/hub")), capability);
            default:
                return null;
        }

    }

    public static Device fromString(String browserArg) {
        return Stream.of(Device.values()).filter(v -> v.name().replace("_", "").equalsIgnoreCase(browserArg)
                || v.name().replace("_", " ").equalsIgnoreCase(browserArg))
                .findFirst().orElseThrow(() -> new InvalidParameterException(browserArg + "\" Browser Type is not supported."));

    }

}
