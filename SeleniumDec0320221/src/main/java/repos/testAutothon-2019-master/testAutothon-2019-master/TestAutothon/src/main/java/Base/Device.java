package Base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public enum Device {
    MOBILESAFARI, MOBILECHROME, WEBCHROME, WEBFIREFOX, WEBSAFARI, REMOTECHROME, REMOTEFIREFOX;

    public WebDriver setDriver() throws MalformedURLException {
        switch (this) {
            case MOBILECHROME:
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", "chrome");
                capabilities.setCapability("deviceName", "device");
                capabilities.setCapability("platformName", "Android");
                //capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
                capabilities.setCapability("forceMjsonwp", true);
                capabilities.setCapability("noReset", true);
                capabilities.setCapability("automationName", "UiAutomator2");
                return new RemoteWebDriver(new URL(System.getProperty("appiumUrl", "http://127.0.0.1:4723/wd/hub")), capabilities);
            case MOBILESAFARI:
                DesiredCapabilities capabilities1 = new DesiredCapabilities();
                capabilities1.setCapability("browserName", "Safari");
                capabilities1.setCapability("deviceName", "iPhone Simulator");
                capabilities1.setCapability("platformName", "iOS");
                capabilities1.setCapability("bundleId", "com.apple.mobilesafari");
                capabilities1.setCapability("automationName", "XCUITest");
                capabilities1.setCapability("noReset", true);
                return new RemoteWebDriver(new URL(System.getProperty("appiumUrl", "http://127.0.0.1:4723/wd/hub")), capabilities1);
            case WEBCHROME:
                File chromeDriver = new File("./src/main/resources/drivers/chromedriver");
                System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-extensions");
                options.addArguments("disable-infobars");
                // options.addArguments("auth-server-whitelist=" +
                // StringUtils.join(whiteListUrls, "*,"));
                return new ChromeDriver(options);
            case WEBFIREFOX:
                File firefoxDriver = new File("./src/main/resources/drivers/geckodriver");
                System.setProperty("webdriver.gecko.driver", firefoxDriver.getAbsolutePath());
                FirefoxOptions options1 = new FirefoxOptions();
                return new FirefoxDriver(options1);
            case WEBSAFARI:
                File safariDriver = new File("/src/main/resources/drivers/chromedriver");
                System.setProperty("webdriver.safari.driver", safariDriver.getAbsolutePath());
                SafariOptions options2 = new SafariOptions();
                return new SafariDriver(options2);
            case REMOTECHROME:
                DesiredCapabilities capability = new DesiredCapabilities();
                ChromeOptions option = new ChromeOptions();
                option.addArguments("disable-extensions");
                option.addArguments("disable-infobars");
                option.addArguments("disable-notifications");
                option.addArguments("disable-web-security");
                option.addArguments("dns-prefetch-disable");
                option.addArguments("disable-browser-side-navigation");
                option.addArguments("disable-gpu");
                option.addArguments("always-authorize-plugins");
                option.addArguments("load-extension=src/main/resources/chrome_load_stopper");
                capability.setCapability(ChromeOptions.CAPABILITY, option);
                capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                return new RemoteWebDriver(new URL(System.getProperty("seleniumUrl", "http://127.0.0.1:4444/wd/hub")), capability);
            case REMOTEFIREFOX:
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, new FirefoxOptions());
                cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                return new RemoteWebDriver(new URL(System.getProperty("seleniumUrl", "http://127.0.0.1:4444/wd/hub")), cap);
            default:
                return null;
        }

    }

    public static Device fromString(String browserArg) {
        return Stream.of(Device.values()).filter(v -> v.name().replace("_", "").equalsIgnoreCase(browserArg)
                || v.name().replace("_", " ").equalsIgnoreCase(browserArg))
                .findFirst().orElseThrow(() -> new InvalidParameterException("\'" + browserArg + "\" Browser Type is not supported."));

    }
}
