package crm.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseclass {
	
	public static WebDriver driver;
	
	public static Properties prop = new Properties();
	
	public baseclass() throws IOException {
		
		InputStream ip = null;
		
	//	FileInputStream ip = new FileInputStream("D:\\Eclipse Projects\\CRM\\src\\main\\java\\crm\\config\\config.properties");
		if(System.getenv().containsKey("CRM_conf_Path")){
			
			ip = new FileInputStream(System.getenv("CRM_conf_Path"));
			
			
			System.out.println("from if");
		}
		
		else {
			
			ip = new FileInputStream("D:\\Eclipse Projects\\CRM\\src\\main\\java\\crm\\config\\config.properties");
			
			
			System.out.println("from else");
		}
		
		prop.load(ip);
		
		
	}
		
		public static void initialization() {
			
			String browsername = prop.getProperty("Browser");
			String url = prop.getProperty("URL");
			
			System.out.println("Initi print >>>>>>>>" +browsername);
			
			System.out.println("Initi print >>>>>>>>" +url);
			
		
		if(browsername.equals("chrome"))
			
		{
			System.setProperty("webdriver.chrome.driver","D:\\Workspace\\eclipse\\chromedriver.exe");
			driver = new ChromeDriver();
			
			
		}
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		System.out.println("After if>>>> " + url);
		
		
		
		
		System.out.println("Rajit>>>>>" + url);
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		
		
			
			
	}

}
