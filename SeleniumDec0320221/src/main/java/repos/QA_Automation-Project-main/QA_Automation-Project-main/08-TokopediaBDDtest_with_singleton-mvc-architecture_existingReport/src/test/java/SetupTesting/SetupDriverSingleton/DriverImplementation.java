package SetupTesting.SetupDriverSingleton;

import SetupTesting.SetupUtilsAndProperties.SetupUrlDriverUtils;

public class DriverImplementation {
	public static DriverStrategyInterface chooseStrategy(String strategy) {
		
		switch(strategy) {
		case SetupUrlDriverUtils.CHROME:
			return new Chrome();
			
		case SetupUrlDriverUtils.FIREFOX:
			return new Firefox();

		case SetupUrlDriverUtils.CHROMEEXISTINGBROWSER:
			return new ChromeExistingBrowser();

		default:
			return null;
		}
		
	}
}
