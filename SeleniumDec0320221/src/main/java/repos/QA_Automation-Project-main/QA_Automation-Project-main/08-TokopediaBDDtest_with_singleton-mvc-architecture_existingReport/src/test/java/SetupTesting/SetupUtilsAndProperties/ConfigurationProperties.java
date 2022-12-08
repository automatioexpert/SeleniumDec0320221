package SetupTesting.SetupUtilsAndProperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {
	
	// configuration browser
	@Value("${browser}")
	private String browser;

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	// configuration login
	@Value("${invalidPhone}")
	private String invalidPhone;
	
	public String getinvalidPhone() {
		return invalidPhone;
	}

	public void setinvalidPhone(String invalidPhone) {
		this.invalidPhone = invalidPhone;
	}


}
