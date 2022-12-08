package projectImDB;

import org.openqa.selenium.By;

public class SeleniumPages {
public static By iterator1 = By.xpath(".//*[@id='main']/div/div[2]/table/tbody/tr[__placeholder]/td[2]/a");
public static By iterator2 = By.xpath("(//*[@class='subtext']//*[@class='itemprop'])[__placeholder]");
public static By searchField = By.xpath("//*[@id='navbar-query']");
public static By searchBtn = By.xpath("//*[@id='navbar-submit-button']");
public static By searchResult = By.xpath(".//*[@id='main']/div/div[2]/table/tbody/tr/td[@class='result_text']");

public static By title = By.xpath(".//*[@id='title-overview-widget']/div[2]/div[2]/div/div[2]/div[2]/h1");
public static By year = By.xpath(".//*[@id='titleYear']/a");
public static By time = By.xpath(".//*[@id='title-overview-widget']/div[2]/div[2]/div/div[2]/div[2]/div/time");
public static By genre = By.xpath("//*[@class='subtext']//*[@class='itemprop']");
public static By releaseDate = By.xpath("//*[@title='See more release dates']");
	

}
