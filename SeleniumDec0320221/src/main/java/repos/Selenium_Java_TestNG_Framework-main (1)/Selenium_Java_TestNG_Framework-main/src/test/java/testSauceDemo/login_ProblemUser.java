package testSauceDemo;

import org.testng.annotations.Test;

import pagefiles_SauceDemo.LoginPage;
import testBase.testBase;
import utililty.ReadProperties;
import utililty.TakeSnap;

public class login_ProblemUser extends testBase
{
    @Test(priority = 1)
    public void login_Problem_User() throws Exception
    { 
        
      
        LoginPage loginpage = new LoginPage();
        test.get().info("Navigated to Url");
        Thread.sleep(2000);
        
        loginpage.sendUsername(ReadProperties.getData("problemuser"));
        test.get().info("Problem User Username Entered");
        Thread.sleep(2000);
       
        loginpage.sendPassword(ReadProperties.getData("Password"));
        test.get().info("Password Entered");
        Thread.sleep(2000);
        
        loginpage.Login();
        test.get().info("Clicked on Login");
        test.get().addScreenCaptureFromPath(TakeSnap.capturescreen("Login-Problem-User_"+timeStamp+".png"));
    }
}


