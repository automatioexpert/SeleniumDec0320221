package com.kugeci;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.kugeci.Setup;
import com.kugeci.PageFactory.HomePage;
import com.kugeci.PageFactory.SearchResultPage;

public class TestSearchWithPageFactory extends Setup {

    @BeforeClass
    public void beforeTest() {
		driver.get("https://www.kugeci.com/");		
		// maximizing the window
		driver.manage().window().maximize();
    }
	
	HomePage objHomePage; 
	SearchResultPage objSearchResultPage;
	@Test
    public void test_Search_Result_Page_Appear_Correct(){
        //Create Home Page object
    	objHomePage = new HomePage(driver);
	
	    //do a search at home page	
    	objHomePage.SearchAtHomePage("disco");
	
	    // go the Search Result Page page	
	    objSearchResultPage = new SearchResultPage(driver);
	
	    //Verify if search_result is returned	
	    Assert.assertTrue(objSearchResultPage.searchResultReturned());
    }
}
