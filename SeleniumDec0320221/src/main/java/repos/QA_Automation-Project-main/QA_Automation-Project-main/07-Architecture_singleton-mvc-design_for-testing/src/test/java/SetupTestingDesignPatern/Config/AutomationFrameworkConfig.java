package SetupTestingDesignPatern.Config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan("SetupTestingDesignPatern")
public class AutomationFrameworkConfig {

	public AutomationFrameworkConfig() {
		
	}
	
}
