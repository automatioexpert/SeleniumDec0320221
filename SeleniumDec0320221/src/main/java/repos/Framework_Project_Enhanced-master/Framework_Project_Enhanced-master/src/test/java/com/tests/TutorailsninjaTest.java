package com.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.pages.LandingPage;

public final class TutorailsninjaTest extends BaseTest{

	private TutorailsninjaTest() {
		
	}
	
	@Test
	public void accountLoginTest() {    
		String title=new LandingPage().myAccountDropDown().loginOption()
				.getPageTitle();
		
    	Assertions.assertThat(title)
    	.isEqualTo("Account Login");
	}
	
	@Test
	public void invalidloginTest() {   
		new LandingPage().myAccountDropDown().loginOption()
		.enterEmailAddress("arun.selenium@gmail.com").enterPassword("123").clicklogin();
				
	}	
		
	@Test
	public void validloginTest() {    
		String title=new LandingPage().myAccountDropDown().loginOption()
				.enterEmailAddress("arun.selenium@gmail.com").enterPassword("Second@123").clicklogin()
				.getPageTitle();
		
    	Assertions.assertThat(title)
    	.isEqualTo("My Account");
	}	
		
	@Test
	public void editAccountLinkTest() {
		
		String editAccount=new LandingPage().myAccountDropDown().loginOption()
				.enterEmailAddress("arun.selenium@gmail.com").enterPassword("Second@123").clicklogin()
				.clickeditYourAccountInformation()
				.getPageTitle();
		
		Assertions.assertThat(editAccount)
		   .isEqualTo("My Account Information");
	}

}
