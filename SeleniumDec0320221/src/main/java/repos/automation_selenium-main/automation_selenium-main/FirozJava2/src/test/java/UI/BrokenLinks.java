package UI;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.hc.core5.http.HttpConnection;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	driver.get("http://www.zlti.com");
		driver.get("https://a1t1qa01.securonix.net/Snypr/");
		driver.findElementByXPath("//*[@id=\"loginForm\"]/div[1]/input").sendKeys("admin");
		driver.findElementByXPath("//*[@id=\"loginForm\"]/div[2]/input").sendKeys("yCQyJIxGHK2opl60");
		driver.findElementByXPath("/html/body/div[2]/div[2]/div/div/div[1]/div/input[1]").click();
		driver.findElementByXPath("//*[@id=\"navbar\"]/ul[1]/li[1]/div/a").click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElementByXPath("//*[@id=\"mCSB_1_container\"]/div/table/tbody/tr/td[4]/div/ul[3]/li[2]/a").click();
		Thread.sleep(6000);
		List <WebElement> links = (List<WebElement>) driver.findElementsByTagName("a");
		System.out.println(links.size());
		int validURL = 0;
		int brokenURL =0;
		for(int i=0;i<links.size();i++)
		{
			WebElement ele = links.get(i);
			String url = ele.getAttribute("href");
			URL link = new URL(url);
			HttpURLConnection httpconnect =  (HttpURLConnection) link.openConnection();
			httpconnect.connect();
			int response = httpconnect.getResponseCode();
			if(response>=400)
			{
				System.out.println(url + "-" + " Is broken " );
				brokenURL++;
			}
			else
			{
				System.out.println(url + "-" + " Is valid " );
				validURL++;
			}
		}
	}

}
