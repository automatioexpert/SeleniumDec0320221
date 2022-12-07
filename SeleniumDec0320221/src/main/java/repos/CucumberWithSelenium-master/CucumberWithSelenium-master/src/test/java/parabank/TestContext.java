package parabank;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import parabank.po.PO_Login;
import parabank.po.PO_TransferFunds;

public class TestContext {

	public WebDriver driver;
	public PO_Login oPO_Login;
	public PO_TransferFunds oPO_TransferFunds;
	public Scenario scn;
	public HashMap<String, String> hm = new HashMap<String,String>();
	
}
