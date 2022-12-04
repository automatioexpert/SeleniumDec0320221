package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {
	/*
	 * get the total of page links
	 * get the text of each link but exclude the blank text
	 * print it
	 */

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in");
		
		//FE -- WE
		//FEs -- L<WE>
		
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		
		System.out.println("total links: " +  linksList.size());
		
		//1. index based loop
//		for(int i=0; i<linksList.size(); i++) {
//			String text = linksList.get(i).getText();
//			
//			if(!text.isEmpty()) {
//				System.out.println(text);
//			}
//			
//		}
		
		//2. for each:
//		for(WebElement e : linksList) {
//			if(!e.getText().isEmpty()) {
//				System.out.println(e.getText());
//			}
//		}
		
		//3. streams: sequential
		long stTime = System.currentTimeMillis();
		linksList
			.stream()
				.filter(e -> !e.getText().isEmpty())
					.forEach(e -> System.out.println(e.getText()));
		long endTime = System.currentTimeMillis();

		System.out.println("time taken by seq Stream: " +(endTime-stTime));
		//time taken by seq Stream: 8288ms = 8.2 secs

		System.out.println("--------------");
		//4. streams: parallel
		
		long stPTime = System.currentTimeMillis();
		linksList
			.parallelStream()
				.filter(e -> !e.getText().isEmpty())
					.forEach(e -> System.out.println(e.getText()));
		long endPTime = System.currentTimeMillis();

		System.out.println("time taken by parallel Stream: " +(endPTime-stPTime));
		//time taken by parallel Stream: 7698ms = 7.6 secs

	}

}
