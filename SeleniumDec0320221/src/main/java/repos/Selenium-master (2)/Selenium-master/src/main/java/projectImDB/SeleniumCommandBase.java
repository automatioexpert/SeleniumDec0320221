package projectImDB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumCommandBase extends SeleniumDriverInstance {
	
	private int timeOut ;
	
	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

	public SeleniumCommandBase(String browserName){
		super(browserName);
		init();
	}
	
	public void init(){
		setTimeOut(20);
	}
	
	
	/**
	 * @param byLocator
	 * @return
	 */
	private WebElement findElement(By byLocator){
		WebElement element =  (new WebDriverWait(getDriver(), getTimeOut())).until(ExpectedConditions.presenceOfElementLocated(byLocator));
		return element;
	}

	
	/**
	 * @param byLocator
	 * Verifies the element present
	 * @return
	 */
	public boolean CheckElementPresent(By byLocator){
		try {
			findElement(byLocator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	/**
	 * @param WebPage
	 */
	public void openWebPage(String WebPage){
		try {
			getDriver().get(WebPage);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * @param timeOut in seconds to wait implicitly
	 */
	public void wait(int timeOut){
		try {
			driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * @param text to send
	 * @param byLocator the element 
	 */
	public void sendKeys(String text , By byLocator){
		try {
			WebElement element = findElement(byLocator);
			element.sendKeys(text);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	

	public void clearTextField(By byLocator){
		try {
			WebElement element = findElement(byLocator);
			element.clear();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
   public void click(By bylocator){
   	try {
		WebElement element = findElement(bylocator);
		element.click();
	} catch (Exception e) {
		System.out.println(e);
	}
	}
	
	/**
	 * @param byLocator
	 * @return the count of elements available
	 */
	public int getCount(By byLocator){
	
	int count = 0;
	try {
	count = driver.findElements(byLocator).size();
	} catch (Exception e) {
	System.out.println(e);
	}
	return count;
	}
	
	 /**
    * @param i
    * @param byLocator
    */
   public void iteratorClick(int temp, By byLocator){
		
		try {
		    String xpath = byLocator.toString();
		    String var = ""+temp+"";
		    xpath =  xpath.replaceAll("__placeholder", var);
		    String[] test = xpath.split(": ");
		    xpath = test[1];
		    getDriver().findElement(By.xpath(xpath)).click();
		    } catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * @param property
	 * @param bylocator
	 * @return
	 */
	public String retrieveText(String property, By bylocator){
	WebElement element =null;
    String temp = null;
	try {
	 element = getDriver().findElement(bylocator);
	 temp = element.getText();		
		
	} catch (Exception e) {
		System.out.println(e);
	}
	return temp;
	}
	
	
	/**
	 * Navigates back
	 */
	public void navigateBack(){
	try {
		getDriver().navigate().back();
	} catch (Exception e) {
		System.out.println(e);
	}
  }
	
	
	/**
	 * @return
	 */
	public String getPageSource(){
	String temp = null;
	try {
		temp = driver.getPageSource();
	} catch (Exception e) {
		System.out.println(e);
	}
	return temp;
	}
	
	
	 /**
     * @param i
     * @param byLocator
     * @returns the By locator
     */
   public String iterativeXpathtoStringGenerator(int temp, By byLocator){
  	 
  	 WebElement element =null;
  	 String drug = null;
		try {
			
			String xpath = byLocator.toString();
			String var = ""+temp+"";
		    xpath = xpath.replaceAll("__placeholder", var);
		    String[] test = xpath.split(": ");
		    xpath = test[1];
		    element = getDriver().findElement(By.xpath(xpath));
		    drug = element.getText();
		} catch (Exception e) {
			System.out.println(e);
		}
		return drug;
	}
	
	
	/**
	 * @param File_Name
	 */
	public ArrayList<String> readTextData(String File_Name){
		ArrayList<String> textvalues = new ArrayList<String>();
		try {
			File file = new File(File_Name);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				textvalues.add(line);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return textvalues;
	}

	/**
	 * Quits the running driver
	 */
	public void quitDriver(){
		try {
		driver.quit();	
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
}
