/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonutil.WaitUtil;

/**
 * @author rohitnegi
 *
 */
public class Home {

	WebDriver driver;
		
		@FindBy(xpath="//*[contains(@class,'nav')]/li[1]/a")
		WebElement homelink;
		
		@FindBy(xpath="//*[@class='footer']/a")
		WebElement manageCarouselLink;
		
		@FindBy(xpath="//div[text()='Your carousel is empty']")
		WebElement emptyCarouselTxt;
		
		@FindBy(xpath="//*[@style='background-image: url(https://leotest.eukleialms.com/pluginfile.php/1/block_carousel/image_2_2/CAROUSEL_1920x1080_Step1.jpg)']")
		WebElement carousel_1;
		
		@FindBy(xpath="//*[@style='background-image: url(https://leotest.eukleialms.com/pluginfile.php/1/block_carousel/image_2_3/CAROUSEL_1920x1080_Step2_v1.jpg)']")
		WebElement carousel_2;
		
		@FindBy(xpath="//*[@style='background-image: url(https://leotest.eukleialms.com/pluginfile.php/1/block_carousel/image_2_4/CAROUSEL_1920x1080_Step3.2.jpg)']")
		WebElement carousel_3;
		
		@FindBy(xpath="//*[@style='background-image: url(https://leotest.eukleialms.com/pluginfile.php/1/block_carousel/image_2_5/CAROUSEL_1920x1080_Step4.2.jpg)']")
		WebElement carousel_4;
		
		@FindBy(xpath="//*[@style='background-image: url(https://leotest.eukleialms.com/pluginfile.php/1/block_carousel/image_2_6/CAROUSEL_1920x1080_Step5.jpg)']")
		WebElement carousel_5;
		
		
		
		public Home(WebDriver driver){
			this.driver = driver;
			//testBase = new TestBase();
			PageFactory.initElements(driver, this);
		}
		
		public String getHomeLinkText(){
			
			WaitUtil.waitForElementVisibility(driver, 10, homelink);
			return homelink.getText();
		}
		
		public int IsAllCarouselImagesExists(){
			
			int flag=0;
			WaitUtil.waitForElementVisibility(driver, 30, carousel_1);
			if(carousel_1.isDisplayed()){
				flag++;
			}
			WaitUtil.waitForElementVisibility(driver, 30, carousel_2);
			if(carousel_2.isDisplayed()){
				flag++;
			}
			WaitUtil.waitForElementVisibility(driver, 30, carousel_3);
			if(carousel_3.isDisplayed()){
				flag++;
			}
			WaitUtil.waitForElementVisibility(driver, 30, carousel_4);
			if(carousel_4.isDisplayed()){
				flag++;
			}
			WaitUtil.waitForElementVisibility(driver, 30, carousel_5);
			if(carousel_5.isDisplayed()){
				flag++;
			}
			
			return flag;
		}
		
		
		public void clickOnManageCarousel() throws InterruptedException {
			
			if(manageCarouselLink.isEnabled()){
				
				manageCarouselLink.click();
				WaitUtil.simpleWait(5);
				driver.get("https://leotest.eukleialms.com/blocks/carousel/");
				
			}
			else if(isCarouselEmpty() ){
				
				driver.navigate().to("https://leotest.eukleialms.com/blocks/carousel/");
				
			}
			else {
				
				System.out.println("No Carousel available in system as of now");
			}
			
		}
		
		public boolean isCarouselEmpty(){
			
			return emptyCarouselTxt.isDisplayed();
		}
}
