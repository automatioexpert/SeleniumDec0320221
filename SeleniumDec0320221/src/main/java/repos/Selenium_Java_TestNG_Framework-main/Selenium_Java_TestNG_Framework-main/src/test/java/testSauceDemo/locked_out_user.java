package testSauceDemo;

import pagefiles_SauceDemo.LoginPage;
import testBase.testBase;
import utililty.ReadProperties;
import utililty.TakeSnap;

import org.testng.annotations.Test;
public class locked_out_user extends testBase {

    
    @Test(priority = 1)
    public void login_locked_User() throws Exception
    { 
        
        LoginPage loginpage = new LoginPage();
        test.get().info("Navigated to Url");
        Thread.sleep(2000);
        loginpage.sendUsername(ReadProperties.getData("lockeduser"));
        test.get().info("Locked Out Username Entered");
        Thread.sleep(2000);
        loginpage.sendPassword(ReadProperties.getData("Password"));
        test.get().info("Password Entered");
        Thread.sleep(2000);
        loginpage.Login();
        test.get().info("Clicked on Login");
        test.get().addScreenCaptureFromPath(TakeSnap.capturescreen("Login-Locked-User_"+timeStamp+".png"));
        
        
      
    }
}
