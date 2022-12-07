package misc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs {

	WebDriver driver;
	

	@Given("I Open {string} Browser")
	public void i_Open_Chrome_Browser(String string) {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Given("I navigate to URL as {string}")
	public void i_navigate_to_URL_as(String string) {
		driver.get(string);
	}

	@Given("I Click on {string} Link")
	public void i_Click_on_Link(String string) {
		driver.findElement(By.linkText(string)).click();
	}

	@When("I drag Source Section and drop it on Target Section")
	public void i_drag_Source_Section_and_drop_it_on_Target_Section() {
		//Read about Builder Pattern
		//Read about method Chaining
		
		//Switch to Frame
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		
		Actions action = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		action.dragAndDrop(source, target).build().perform();
			
	}

	@When("I Slide slider from point {int} to point {int}")
	public void i_Slide_slider_from_point_to_point(Integer int1, Integer int2) {
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		
		WebElement element_slider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		Actions action = new Actions(driver);
		action.clickAndHold(element_slider).moveByOffset(int2, 0).build().perform();
	}



	
}
