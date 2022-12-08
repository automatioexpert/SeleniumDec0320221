/**
 * 
 */
package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonutil.WaitUtil;

/**
 * @author rohitnegi
 *
 */
public class ManageCarousel {

	WebDriver driver;
		
		@FindBy(xpath="//*[@class='generaltable']//tbody/tr")
		List<WebElement> tot_Carousel_rows;
		
		@FindBy(xpath="//a/input[contains(@value,'Add Carousel')]")
		WebElement addCarouselLink;
		
		//first entry of edit button for a carousel
		@FindBy(xpath="//input[contains(@value,'Edit Carousel')]")
		WebElement generalEditBtnForACarousel;
		
		public ManageCarousel(WebDriver driver){
			this.driver = driver;
			//testBase = new TestBase();
			PageFactory.initElements(driver, this);
		}
		
		
		public int getAllCarousel() {
			
			return tot_Carousel_rows.size();
		}
		
		
		public int isCarouselRecordHasCorrespondingEditButton() {
			
			int isEditBtnExist=0;
			System.out.println("Verifying Edit button exist for each Carousel records");
			
			for(int i=1;i<=tot_Carousel_rows.size();i++) {
				
				if(driver.findElement(By.xpath("//*[@class='generaltable']//tbody/tr["+i+"]/td[2]/a/input[contains(@value,'Edit')]")).isDisplayed()) {
					
					isEditBtnExist++;
				}
				System.out.println("Edit button for Carousel: "+
						driver.findElement(By.xpath("//*[@class='generaltable']//tbody/tr["+i+"]/td[1]")).getText()
						+" exist.");
				
			}
			
			return isEditBtnExist;
		}
		
		
		public int isCarouselRecordHasCorrespondingDeleteButton() {
			
			int isDeleteBtnExist=0;
			System.out.println("Verifying Delete button exist for each Carousel records");
			
			for(int i=1;i<=tot_Carousel_rows.size();i++) {
				
				if(driver.findElement(By.xpath("//*[@class='generaltable']//tbody/tr["+i+"]/td[3]/a/input[contains(@value,'Delete')]")).isDisplayed()) {
					
					isDeleteBtnExist++;
				}
				System.out.println("Delete button for Carousel: "+
						driver.findElement(By.xpath("//*[@class='generaltable']//tbody/tr["+i+"]/td[1]")).getText()
						+" exist.");
				
			}
			
			return isDeleteBtnExist;
		}
		
		
		public boolean isAddCarouselLinkButtonExist() {
			
			return addCarouselLink.isEnabled();
		}
		
		
		public void clickOnaddCarouselLink() throws InterruptedException {
			
			addCarouselLink.click();
			WaitUtil.simpleWait(3);
		}
		
		public void clickOnFirstEditCarouselBtn() throws InterruptedException{
			
			generalEditBtnForACarousel.click();
			WaitUtil.simpleWait(5);
		}
}