package stepDefinations;

import io.cucumber.java.After;
import resources.Base;

public class Hooks extends Base{
	
	@After()
	public void AfterEveryScenarion() {
		driver.close();
	}

}
