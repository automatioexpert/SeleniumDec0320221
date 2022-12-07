package stepdefs;

import org.apache.commons.lang.StringUtils;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import listeners.ExtentReportListener;

public class BaseClassSteps extends ExtentReportListener{
	public static String featureName;
	
	  @Before
		public void before(Scenario scenario) throws Exception {
		  String featureName= getFeatureFileNameFromScenarioId(scenario);
			setUp();  
			setUpDriver();
		}
	    
	     private String getFeatureFileNameFromScenarioId(Scenario scenario) {
		    featureName = "Feature ";
		    String rawFeatureName = scenario.getId().split(";")[0].replace("-"," ");
		    featureName = StringUtils.substringAfterLast(rawFeatureName, "/").split(".feature")[0];
		    return featureName;
		}
	  
	    @After
	    public void after(Scenario scenario){
	    	closeDriver(scenario);
	    	extent.flush();
	    }
}
