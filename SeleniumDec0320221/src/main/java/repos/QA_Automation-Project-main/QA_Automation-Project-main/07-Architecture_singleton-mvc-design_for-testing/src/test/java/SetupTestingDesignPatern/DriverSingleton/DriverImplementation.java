package SetupTestingDesignPatern.DriverSingleton;

import SetupTestingDesignPatern.SetUp.SetUpUtils;

public class DriverImplementation {
	public static DriverStrategyInterface chooseStrategy(String strategy) {
		
		switch(strategy) {
		case SetUpUtils.CHROME:
			return new Chrome();
			
		case SetUpUtils.FIREFOX:
			return new Firefox();
		
		default:
			return null;
		}
		
	}
}
