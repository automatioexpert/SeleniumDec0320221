package pageobject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class product {

	public WebDriver driver;
	
	
	By chooseProduct = By.className("m-productCard__desc");
	By addbasket = By.xpath("//button[@id='addBasket']");
	By productdetail = By.className("o-productDetail__description");
	By productprice = By.className("m-price__new");
	By productsize = By.className("-criticalStock");
	By gobasket = By.xpath("(//*[@class='o-header__userInfo--text'])[3]");
	By basketPrice = By.className("m-productPrice__salePrice");
	
	
	public product(WebDriver driver) {
		
		
		this.driver=driver;
		
	}
	
	
	public void ProductFind() {
		
		driver.findElements(chooseProduct).get(2).click();
		Assert.assertTrue(driver.findElement(addbasket).isDisplayed());
	}
	
	public void CreateTxtFile() throws InterruptedException {
		
		String productInfo= driver.findElement(productdetail).getText();
		String productPrice =  driver.findElement(productprice).getText();
		
		try {
		      FileWriter myWriter = new FileWriter("variables.txt");
		      myWriter.write(productInfo);
		      myWriter.write(" ");
		      myWriter.write(productPrice);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		Thread.sleep(2000);
	}
	
	
	public void AddBasket () throws InterruptedException, IOException {
		
		driver.findElement(productsize).click();
		Thread.sleep(2000);
		driver.findElement(addbasket).click();
		Thread.sleep(2000);
		driver.findElement(gobasket).click();
		
		//Read txt file 
		FileReader fr = new FileReader("variables.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        line = br.readLine();
        String[] arrayLine=line.split("\\s+");
       String   price1 = arrayLine[5] + " " + arrayLine[6];
       System.out.println(price1);
		Assert.assertEquals(price1, driver.findElement(basketPrice).getText());
	}
	
	
	public void AddSecondProduct() throws InterruptedException {
		
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(productsize).click();
		Thread.sleep(2000);
		driver.findElement(addbasket).click();
		driver.findElement(gobasket).click();
	}
}
