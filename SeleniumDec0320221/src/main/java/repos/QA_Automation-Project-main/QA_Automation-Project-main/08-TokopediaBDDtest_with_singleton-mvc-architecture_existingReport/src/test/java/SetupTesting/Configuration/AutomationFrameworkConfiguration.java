package SetupTesting.Configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan("SetupTesting")
public class AutomationFrameworkConfiguration {

	public AutomationFrameworkConfiguration() {
		
	}
	
}
