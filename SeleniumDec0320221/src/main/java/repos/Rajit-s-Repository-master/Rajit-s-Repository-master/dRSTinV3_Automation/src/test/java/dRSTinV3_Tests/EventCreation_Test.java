package dRSTinV3_Tests;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dRSTinV3_Pages.dRSTinV3_AdvanceQueryPage;
import dRSTinV3_Pages.dRSTinV3_DBEventCreation;
import dRSTinV3_Pages.dRSTinV3_Homepage;
import dRSTinV3_Pages.dRSTinV3_loginpage;
import dRSTinV3_baseclass.baseclass;
import dRSTinV3_util.reader;

public class EventCreation_Test extends baseclass{
	
	dRSTinV3_loginpage loginpage;
	dRSTinV3_Homepage  homepage;
	dRSTinV3_DBEventCreation eventcreationpage;
	
	public EventCreation_Test() throws Exception {
		
		super();
		
	}
	
	@BeforeMethod
	public void Setup() throws Exception {
		
		initialization();
		
		loginpage = new dRSTinV3_loginpage();
		homepage = new dRSTinV3_Homepage();
		
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		eventcreationpage = homepage.NavigatetoManageDatasetPage();
		
	}
	
	@DataProvider()
	public Iterator<Object[]> getDBdetails(){
		
		ArrayList<Object[]> dbdetails = reader.getDBDetails();
		
		return dbdetails.iterator();
	}
	
	@Test(description = "Verify that the user is able to navigate to the Event creation page successfully")
	public void eventcreatrionpagenavigation() throws Exception {
		
		eventcreationpage.NavigatetoEventCreationPage();
		
	}
	
	@Test(dataProvider = "getDBdetails" , description = "Verify that the useris able to create a new DB event")
	public void DBEventCreation(String DatasetName,String HostName,String DriverName,String DBName,String Username
			,String Password) throws Exception {
		
		
		eventcreationpage.DBsuccessfulEventCreation(DatasetName,HostName , DriverName,DBName,Username,Password);
		
	}
	
	
	
	@AfterMethod
	public void teardown() throws Exception {
		
		Thread.sleep(4000);
		driver.quit();
	}

}
