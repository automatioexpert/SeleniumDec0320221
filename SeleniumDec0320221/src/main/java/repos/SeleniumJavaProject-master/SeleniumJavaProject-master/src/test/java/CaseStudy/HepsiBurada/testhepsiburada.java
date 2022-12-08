package CaseStudy.HepsiBurada;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.homepage;
import pageobject.productDetailpage;
import resources.base;

public class testhepsiburada extends base{
	
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException {
		
		driver =initializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test (priority=1)
	public void validateHomepage() {
		
		homepage h= new homepage(driver);
		
		//premium yazısını kontrolu ve yazdırılması
		Assert.assertTrue(h.getpreminum().isDisplayed());
		System.out.println(h.getpreminum().getText());
		
		//urun ara
		h.getsearchbar().sendKeys("laptop");
		
		//search butonuna tıkla
		h.getfindproduct().click();
		
		
		//ilk laptop a tıkla
		h.getchooseproduct().click();
		
	}
	
	@Test (priority=2)
	public void validateProductpage() {
		
		productDetailpage p = new productDetailpage(driver);
		
		Set<String> windows = driver.getWindowHandles();

		java.util.Iterator<String> it=windows.iterator();

		String parentId = it.next();

		String childId = it.next();
		driver.switchTo().window(childId);
		
		
		
		
		//Secilen urun adını yaz
		System.out.println(p.getproductname().getText());
		
		//Satıcıyı yaz
		if(p.getsellerpanel().isDisplayed()) {
			
			System.out.println(p.getsellerword().getText() + " " + p.getspecialsellername().getText()); 
		}
		
		//yorum bolumune tıkla
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scroll(0,2500)");
		p.getcommenttab().click();
		
		
		//yorumlardaki degerlendir butonu kontrolu
		Assert.assertTrue(p.getcommentbutton().isDisplayed());
		
	}
	
	

}
