package SetupTestingDesignPatern.SetUp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {
	
//configuration browser
	@Value("${browser}")
	private String browser;
	
	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	
//configuration login	
	
	@Value("${usernameIsLogin}")
	private String usernameIsLogin;
	
	@Value("${usernameSuccess}")
	private String usernameSuccess;

	@Value("${password}")
	private String password;

	
	public String getUsernameIsLogin() {
		return usernameIsLogin;
	}

	public void setUsernameIsLogin(String usernameIsLogin) {
		this.usernameIsLogin = usernameIsLogin;
	}

	public String getUsernameSuccess() {
		return usernameSuccess;
	}

	public void setUsernameSuccess(String usernameSuccess) {
		this.usernameSuccess = usernameSuccess;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
//Configuration Upload
	
	@Value("${fileExcel}")
	private String fileExcel;
	
	public String getFileExcel() {
		return fileExcel;
	}

	public void setFileExcel(String fileExcel) {
		this.fileExcel = fileExcel;
	}
	
	@Value("${fileDoc}")
	private String fileDoc;
	
	public String getFileDoc() {
		return fileDoc;
	}

	public void setFileDoc(String fileDoc) {
		this.fileDoc = fileDoc;
	}

}
