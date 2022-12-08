package CaseStudy;

import static org.junit.Assert.assertArrayEquals;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.basket;
import pageobject.home;
import pageobject.product;
import resources.base;

public class Web_Test extends base{

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException   {
		
		driver =initializeDriver();
		log.info("Driver baslatılır..");
		}
	
	@Test (priority=1)
	public void Homepage() throws InterruptedException {
		
		home h = new home(driver);
		h.mainpageControl();
		log.info("Ana sayfanın başlatıldığı kontrol edilir.");
		h.getSearchbox();
		
	}
	
	@Test (priority=2)
	public void ProductPage() throws InterruptedException, IOException {
		
		product pr = new product(driver);
		pr.ProductFind();
		log.info("Ürün detay sayfasıa gidildiği kontrol edilir.");
		pr.CreateTxtFile();
		pr.AddBasket();
		log.info("Fiyatlar karşılaştırılır.");
		pr.AddSecondProduct();
	
	}
	
	@Test (priority=3)
	public void basketPage() throws InterruptedException {
		
		basket bs = new basket(driver);
		bs.ValidateBasket();
		log.info("Sepet sayfasına gidildiği doğrulanır.");
		log.info("Ürün adet sayısı kontrol edilir.");
		bs.DeleteItems();
		log.info("Ürünlerin silindiği kontrol edilir.");
		
		
	}
	
	@AfterTest
	public void closeDriver() throws IOException {
		
		teardown();
	
	}
}
