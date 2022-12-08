package testSauceDemo;

import org.testng.annotations.Test;

import pagefiles_SauceDemo.LoginPage;
import testBase.testBase;
import utililty.ReadProperties;
import utililty.TakeSnap;

public class performance_glitch_user extends testBase {
    
    
    @Test(priority = 1)
    public void login_glitch_User() throws Exception
    { 
        
       
        LoginPage loginpage = new LoginPage();
        test.get().info("Navigated to Url");
        Thread.sleep(2000);
       
        loginpage.sendUsername(ReadProperties.getData("glitchuser"));
        Thread.sleep(2000);
        test.get().info("Glitch User Username Entered");
        loginpage.sendPassword(ReadProperties.getData("Password"));
        
        Thread.sleep(2000);
        test.get().info("Password Entered");
        loginpage.Login();
        test.get().info("Clicked on Login");
        test.get().addScreenCaptureFromPath(TakeSnap.capturescreen("Login-performance_glitch-User_"+timeStamp+".png"));
        
    }

}
