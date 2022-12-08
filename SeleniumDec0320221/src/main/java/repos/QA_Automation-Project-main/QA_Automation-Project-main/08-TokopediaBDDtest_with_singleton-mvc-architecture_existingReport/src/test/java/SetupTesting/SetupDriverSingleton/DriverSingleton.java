package SetupTesting.SetupDriverSingleton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;


public class DriverSingleton {
	private static DriverSingleton instance = null;
	private static WebDriver driver;
	
	public DriverSingleton(String driver) {
		instantiate(driver);
	}
	
	public WebDriver instantiate(String strategy) {
		DriverStrategyInterface driverStrategy = DriverImplementation.chooseStrategy(strategy);
		driver = driverStrategy.setStrategy();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public static DriverSingleton getInstance(String driver) {
		if(instance == null) {
			instance = new DriverSingleton(driver);
		}
		
		return instance;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}


}
