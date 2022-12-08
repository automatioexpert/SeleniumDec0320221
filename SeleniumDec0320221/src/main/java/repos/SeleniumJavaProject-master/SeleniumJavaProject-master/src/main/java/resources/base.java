package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class base {
	
	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
	
	ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--ignore-certifcate-errors");   // ssl sertifika hatası yok sayma
    chromeOptions.addArguments("--disable-popup-blocking");  //pop-up bloklaması
    chromeOptions.addArguments("--disable-gpu");  //
    chromeOptions.addArguments("--start-maximized"); // full screen browser
    chromeOptions.addArguments("--disable-plugins"); //chrome pluginler , driver bazlı pluginler durdurulur
    chromeOptions.addArguments("--disable-plugins-discovery");   //flash dahil tüm pluginler durdurulur
    chromeOptions.addArguments("--disable-preconnect");   //google ın dns çözümlemesi nedeniyle oluşabilecek performans düşüklüğünü engeller
    chromeOptions.addArguments("--disable-notifications");   // bildirimleri engeller
    chromeOptions.addArguments("'--dns-prefetch-disable'");   //search bara girilen anahtar kelimenin doğuracağı sonuçları chromeun arka planda yüklemesini engellemek için
    chromeOptions.setAcceptInsecureCerts(true);
    chromeOptions.addArguments("test-type");
	
	
	
	
	WebDriverManager.chromedriver().setup();
    driver= new ChromeDriver(chromeOptions);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	
	//Global değişkenler tanımladık, data.properties ile
	prop = new Properties();
	FileInputStream fis = new FileInputStream("C:\\Users\\cihan\\SeleniumTekrar\\HepsiBurada\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	
	String browserName = prop.getProperty("url");
	System.out.println(prop.getProperty("browser"));
	System.out.println(prop.getProperty("url"));

	
	if(browserName.equals("chrome")) {
		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\cihan\\chromedriver.exe");
		
		driver= new ChromeDriver();
	}
	else if (browserName.equals("firefox"))
	{
		 driver= new FirefoxDriver();
		//firefox code
	}
	else if (browserName.equals("IE"))
	{
//		IE code
	}
	
	return driver;
}
}
