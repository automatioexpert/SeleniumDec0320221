package Maps;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HahsMapUseInSelenium {

	//UserType and their AccessPermissions
	
	public static HashMap<String,String> UserDetails() {
		
	
		HashMap<String , String> userdata = new HashMap<String , String>();
		userdata.put("Customer", "rajit.sensharma@gmail.com:Test@123");
		userdata.put("Seller", "rajit.sensharma@gmail.com:Test@123");
		userdata.put("Admin", "rajit.sensharma@gmail.com:Test@123");
		System.out.println(userdata);
		return  userdata;
		
	}
	
public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver() ;
		System.setProperty("webdriver.chrome.driver","D:\\Workspace\\eclipse\\chromedriver.exe");
		driver.get("https://www.freecrm.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	 System.out.println(UserDetails());
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//span[@class='icon icon-xs mdi-chart-bar']")).click();
	 driver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys(Password("Customer"));
	 driver.findElement(By.xpath("//input[@placeholder='E-mail address']")).sendKeys(Username("Customer"));
	 
		
	}

public static String Username(String Usertype) {
	
	String sl = UserDetails().get(Usertype);
	
	
	return sl.split(":")[0];
	
}

public static String Password(String Ptype) {
	
	String pw = UserDetails().get(Ptype).split(":")[1];
	return pw;

	
	
}


}
