package UI;
import java.security.PublicKey;
import java.sql.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class javaScriptUtil {


	public static void flash(WebElement element , WebDriver driver) {
	     //    TODO Auto-generated method 		
	   WebDriverManager.chromedriver().setup();
	   JavascriptExecutor js = ((JavascriptExecutor) driver);
	   String color1 = element.getCssValue("backgroundColor");
	   for(int i=0;i<500;i++)
	   {
		   js.executeScript("arguments[0].style.backgroundColor ='red'", element);
		   js.executeScript("arguments[0].style.backgroundColor = '" + color1 + "'" , element);
	   }
	}
	
	public static void border(WebElement element , WebDriver driver) {
	     //    TODO Auto-generated method 		
	   WebDriverManager.chromedriver().setup();
	   JavascriptExecutor js = ((JavascriptExecutor) driver);
	   js.executeScript("arguments[0].style.border ='3px solid red'", element);
	}
	
	public static String returnTitle(ChromeDriver driver) {
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String string=js.executeScript("return document.title").toString();
		return string;		
	}
    public static void clickByJs(WebElement e , WebDriver driver) {
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();",e);
	}
    public static void generateAlert(String message , WebDriver driver) {
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");
	}
   public static void refreshBrowserJS(WebDriver driver) {
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
   }
   public static void scrollTillTheElement(WebElement ele, WebDriver driver)
   {
	   JavascriptExecutor js = ((JavascriptExecutor) driver);
	   js.executeScript("arguments[0].scrollIntoView(true);",ele);
   }
   public static void scrollTillEnd(WebDriver driver)
   {
	   JavascriptExecutor js = ((JavascriptExecutor) driver);
	   js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
   }
   
}