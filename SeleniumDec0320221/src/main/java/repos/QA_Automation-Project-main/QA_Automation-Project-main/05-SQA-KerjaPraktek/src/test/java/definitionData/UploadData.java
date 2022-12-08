package definitionData;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UploadData {
	WebDriver driver;
	static String fileExcel;
	static XSSFRow row;
	String baseURL = "https://sqa.peluangkerjaku.com/tele/";

	@Given("UserSpv on the login page")
	public void UserSpv_on_the_login_page() {
		String path = System.getenv("WEBDRIVER");
		System.setProperty("webdriver.chrome.driver", path);
		this.driver = new ChromeDriver();
		driver.get(baseURL);
	}

	@When("UserSpv login with valid UserSpvname {string} and password {string}")
	public void UserSpv_login_with_valid_UserSpvname_and_password(String string, String string2) {
		try {
			Thread.sleep(1000);
			driver.findElement(By.id("tl_login-1-51550_text")).sendKeys(string);
			Thread.sleep(1000);
			driver.findElement(By.id("tl_login-1-51551_text")).sendKeys(string2);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='Sign In']")).click();
		} catch (Exception e) {
		}
	}

	@When("UserSpv get login validate {string}")
	public void UserSpv_get_login_validate(String string) {
		try {
			Thread.sleep(1000);
			WebElement welcomeText = driver.findElement(By.xpath("//*[@id=\"nikita-form-dialog\"]/p"));
			System.out.println("Welcome validation => " + welcomeText.getText());
			Assert.assertEquals(welcomeText.getText(), string);
		} catch (Exception e) {
		}

	}

	@When("UserSpv click ok to the validate message")
	public void UserSpv_click_ok_to_the_validate_message() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='OK']")).click();
		} catch (Exception e) {

		}
	}

	@When("UserSpv move to table Data")
	public void UserSpv_move_to_table_Data() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//h3[@id='ui-id-11']")).click();
		} catch (Exception e) {

		}
	}

	@When("UserSpv move to table Upload Data")
	public void UserSpv_move_to_table_upload() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='Upload Data']")).click();
		} catch (Exception e) {

		}
	}

	@When("UserSpv import excel file from directory {string}")
	public void UserSpv_import_excel_file_from_directory(String string) {
		this.fileExcel = string;
		try {
			Thread.sleep(1000);
			WebElement chooseFile = driver.findElement(By.xpath("//input[@id='tl_upload_new--52043_text']"));
			chooseFile.sendKeys(string);
		} catch (Exception e) {

		}
	}

	@When("UserSpv click Upload file")
	public void UserSpv_click_file() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='Upload']")).click();
		} catch (Exception e) {

		}

	}

	@Then("UserSpv get new data import on the page or website")
	public void UserSpv_get_new_data_import_on_the_page() {
		int dataTabel = 0;
		int dataExcel = 0;
		
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				// *[@id="tl_upload_new--52045_table"]/tbody/tr
				List<WebElement> jml = driver
						.findElements(By.xpath("//*[@id=\"tl_upload_new--52045_table\"]/tbody/tr"));
				System.out.println( "jumlah table " + jml.size());
				dataTabel=jml.size();
				state = false;
			} catch (Exception e) {
			}
		}
		
		
		state = true;
		while (state) {
			// Excel data
			try {
				FileInputStream file = new FileInputStream(new File(fileExcel));
				XSSFWorkbook workbook = new XSSFWorkbook(file);

				XSSFSheet sheet = workbook.getSheetAt(0);

				Iterator<Row> iterator = sheet.iterator();
				int counter = -1;

				while (iterator.hasNext()) {
					counter += 1;
					row = (XSSFRow) iterator.next();
					Iterator<Cell> cellIterator = row.cellIterator();

					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
					}
				}

				System.out.println("data excel ada= " + counter);
				dataExcel = counter;
				file.close();
				state = false;
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println(dataTabel + " jumlah data table");
			System.out.println(dataExcel + " jumlah data excel");
			 Assert.assertEquals(dataExcel, dataTabel);
			//div[@id='tl_upload_new--52045']//div[8]
		}
	}

	@When("UserSpv save the new file")
	public void UserSpv_save_the_new_file() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@id='52055_query']")).click();
		} catch (Exception e) {

		}

	}

	@When("UserSpv get measurement statement Yakin Menimpan ?")
	public void UserSpv_get_measurement_statement() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@id='formtl_upload_newdialog-123']"));
		} catch (Exception e) {

		}
	}

	@When("UserSpv click SIMPAN button")
	public void UserSpv_click_button() {
		try {
			Thread.sleep(1000);
			WebElement simpan = driver.findElement(By.xpath("//span[normalize-space()='SIMPAN']"));
			simpan.click();
		} catch (Exception e) {

		}
	}

	@Then("UserSpv get validation message {string}")
	public void UserSpv_get_validation_message(String string) {
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				//p[normalize-space()='Data Berhasil Simpan']
				WebDriverWait wait = new WebDriverWait(driver, 50);
				WebElement validation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='nikita-form-dialog']/p")));
				Assert.assertEquals(validation.getText(), string);
				driver.close();
				state = false;
			} catch (Exception e) {

			}
		}
	}

	@Then("UserSpv get message {string}")
	public void UserSpv_get_message(String string) {
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				WebElement validation = driver.findElement(By.xpath("//*[@id='nikita-form-dialog']/p"));
				Assert.assertEquals(validation.getText(), string);
				state = false;
			} catch (Exception e) {

			}
		}
	}

	@When("UserSpv close the validation message")
	public void UserSpv_close_the_validation_message() {
		try {
			Thread.sleep(1000);
			WebElement close = driver.findElement(By.xpath("//button[@title='Close']"));
			close.click();
		} catch (Exception e) {

		}
	}

}
