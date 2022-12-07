package Files.TestNG;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithFacebook {
	String url="https://www.facebook.com/";
	WebDriver driver;
	
  @BeforeTest
  public void OpenApplication() {
	  System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
      driver = new ChromeDriver();
	  driver.get(url);
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	  
	  
  }
  
  @Test(dataProvider="Excel")
  public void dataProviderUsage(String user, String password, String LoginStatus) throws Exception {
	  
	  System.out.println(user + password +LoginStatus);
	  driver.findElement(By.xpath("//input[@id='email']")).clear();
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys(user);
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@value='Log In']")).click();
	  WebElement username=driver.findElement(By.xpath("//input[@id='email']"));
	  if(username.isDisplayed()) {
		  System.out.println("Unable To Login");
	  }
	  driver.navigate().back();
	  Thread.sleep(1000);  	  
  }
  
  @AfterTest
  public void closeConnection() {
	  driver.close();
  }
  
  @DataProvider
  public Object[][] Excel() throws IOException {
	  String filepath="E:\\Test_Data_Facebook.xlsx";
	  FileInputStream fi=new FileInputStream(filepath);
	  XSSFWorkbook wb=new XSSFWorkbook(fi);
	  XSSFSheet ws=wb.getSheetAt(0);
	  //row count
	  int rc=ws.getLastRowNum()+1;
	//  System.out.println("Row Count is:" +rc); 
	  // column count
	  int cc=ws.getRow(0).getLastCellNum();
	  String[][] data=new String[rc-1][cc];
	  
	  for(int i=1;i<rc;i++) {
		  XSSFRow row=ws.getRow(i);
		//  System.out.println("row number is " + row);
		  for(int j=0;j<cc;j++) {
			 // System.out.println("Cell Count is:" +cc);
			  XSSFCell cell=row.getCell(j);
			  String val=cell.getStringCellValue();
			  data[i-1][j]=val;
		  }
	  }
	  wb.close();
	  fi.close();
	  return data;
  }
}

