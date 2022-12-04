package mytests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

	@Test(priority = 1)
	public void titleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google11");
	}

	@Test(priority = 2, enabled = false)
	public void searchFieldTest() {
		Assert.assertTrue(driver.findElement(By.name("q")).isDisplayed());
	}
	
	
	//CRUD
	//create a user  -- @test1 (Riya) - X // disabled //parallel - th1
	
	//update a user --> @test2 (update Riya ph) - skipped //only test execution // th2
	
	
	//create a user:
	//@test 
		//1. create a user (riya)
	
	
	//update a user ---> 
	//@test 
	//1. create a user (riya)
	//2. update the same user(riya ph)
	
	//delete a user ---> 
		//@test 
		//1. create a user (riya)
		//2. delete the same user(riya)
	
	
	//get a user ---> 
			//@test 
			//1. create a user (tom)
			//2. delete the same user(tom)
	
	

}
