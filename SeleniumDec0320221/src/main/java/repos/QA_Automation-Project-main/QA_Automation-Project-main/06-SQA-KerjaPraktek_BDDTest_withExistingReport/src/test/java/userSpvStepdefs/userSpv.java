package userSpvStepdefs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class userSpv {
	static WebDriver driver;
	static String fileExcel;
	static XSSFRow row;

	String actual;
	String direktoriFile = System.getProperty("user.dir") + "\\test-output\\myfileNeg";

	public static ExtentTest extentTest ;
	public static ExtentReports reports = new ExtentReports("ReportTest.html");;
	static int counter = 0;
	static int fileCounter = 0;
	static String[] testName = {
			"Test Scenario Login Valid",
			"Test Scenario Login dengan pasword kosong",
			"Test Scenario Login dengan kombinasi Capitalcase",
			"Test Scenario Login dengan username dan password kosong",
			"Test Scenario Upload data excel",
			"Test Scenario Upload data non excel",
			"Test Scenario Distribute Valid",
			"Test Scenario Distribute tidak mengisi agent",
			"Test Scenario Distribute tidak mengisi jumlah data",
			"Test Scenario Distribute tidak mengsi agent dan jumlah data",
			"Test Scenario Edit Data User awal",
			"Test Scenario Edit Data User akhir",
			"Test Scenario Edit Data User awal negatif",
			"Test Scenario Edit Data User akhir negatif",
	};
	String baseURL = "https://sqa.peluangkerjaku.com/tele/";
	
	@Before
	public void setUp() {
		extentTest = reports.startTest(testName[counter++]);
	}

	@AfterStep
	public void getResultScreenshot(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			fileCounter++;
			extentTest.log(LogStatus.FAIL, screenShot());
		} 
	}

	@After
	public void endTestStep() {
		reports.endTest(extentTest);
		reports.flush();
		driver.quit();
	}


	@Given("User on the login page")
	public void user_on_the_login_page() {
		String path = System.getenv("WEBDRIVER");
		System.setProperty("webdriver.chrome.driver", path);
		this.driver = new ChromeDriver();
		driver.get(baseURL);
		extentTest.log(LogStatus.PASS, "User on the login page");
	}

	@When("User fill the username {string}")
	public void user_fill_the_username(String string) {
		try {
			Thread.sleep(1000);
			driver.findElement(By.id("tl_login-1-51550_text")).sendKeys(string);
			extentTest.log(LogStatus.PASS, "User fill the username " + string);
		} catch (Exception e) {
		}
	}

	@When("User fill the password {string}")
	public void user_fill_the_password(String string) {
		try {
			Thread.sleep(1000);
			driver.findElement(By.id("tl_login-1-51551_text")).sendKeys(string);
			extentTest.log(LogStatus.PASS, "User fill the password " + string);
		} catch (Exception e) {
		}
	}

	@When("User click the login button")
	public void user_click_the_login_button() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='Sign In']")).click();
			extentTest.log(LogStatus.PASS, "User click the login button");
		} catch (Exception e) {
		}
	}

	@Then("User get login validate {string}")
	public void user_get_login_validate(String string) {
		try {
			Thread.sleep(1000);
			WebElement welcomeText = driver.findElement(By.xpath("//*[@id=\"nikita-form-dialog\"]/p"));
			System.out.println("Welcome validation => " + welcomeText.getText());
			Assert.assertEquals(welcomeText.getText(), string);
			extentTest.log(LogStatus.PASS, "User get login validate "+string);
		} catch (Exception e) {

		}
	}

	@Then("User get alert or notification {string}")
	public void user_get_alert_notification(String string) {
		try {
			Thread.sleep(1000);
			WebElement invalidText = driver.findElement(By.xpath("//*[@id=\"nikita-form-dialog\"]/p"));
			System.out.println("Invalid validation => " + invalidText.getText());
			Assert.assertEquals(invalidText.getText(), string);
			extentTest.log(LogStatus.PASS, "User get alert "+string);
		} catch (Exception e) {

		}
	}

	@Given("UserSpv on the login page")
	public void UserSpv_on_the_login_page() {
		String path = System.getenv("WEBDRIVER");
		System.setProperty("webdriver.chrome.driver", path);
		this.driver = new ChromeDriver();
		driver.get(baseURL);
		extentTest.log(LogStatus.PASS, "User on the login page");
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
			extentTest.log(LogStatus.PASS, "User login with valid userSpv ");
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
			extentTest.log(LogStatus.PASS, "User get alert "+string);
		} catch (Exception e) {
		}

	}

	@When("UserSpv click ok to the validate message")
	public void UserSpv_click_ok_to_the_validate_message() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='OK']")).click();
			extentTest.log(LogStatus.PASS, "User click the msg");
		} catch (Exception e) {

		}
	}

	@When("UserSpv move to table Data")
	public void UserSpv_move_to_table_Data() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//h3[@id='ui-id-11']")).click();
			extentTest.log(LogStatus.PASS, "User move to table Data");
		} catch (Exception e) {

		}
	}

	@When("UserSpv move to table Upload Data")
	public void UserSpv_move_to_table_upload() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='Upload Data']")).click();
			extentTest.log(LogStatus.PASS, "User move to upload Data");
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
			extentTest.log(LogStatus.PASS, "User import file "+string);
		} catch (Exception e) {

		}
	}

	@When("UserSpv click Upload file")
	public void UserSpv_click_file() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='Upload']")).click();
			extentTest.log(LogStatus.PASS, "User click upload btn");
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
		extentTest.log(LogStatus.PASS, "User get new data");
	}

	@When("UserSpv save the new file")
	public void UserSpv_save_the_new_file() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@id='52055_query']")).click();
			extentTest.log(LogStatus.PASS, "User click save btn");
		} catch (Exception e) {

		}

	}

	@When("UserSpv get measurement statement Yakin Menimpan ?")
	public void UserSpv_get_measurement_statement() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@id='formtl_upload_newdialog-123']"));
			extentTest.log(LogStatus.PASS, "User get measurement statement");
		} catch (Exception e) {

		}
	}

	@When("UserSpv click SIMPAN button")
	public void UserSpv_click_button() {
		try {
			Thread.sleep(1000);
			WebElement simpan = driver.findElement(By.xpath("//span[normalize-space()='SIMPAN']"));
			simpan.click();
			extentTest.log(LogStatus.PASS, "User click simpan btn");
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
				extentTest.log(LogStatus.PASS, "User get msg "+string);
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
				extentTest.log(LogStatus.PASS, "User get msg "+string);
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
			extentTest.log(LogStatus.PASS, "User not update the data");
		} catch (Exception e) {

		}
	}

	

	@Given("User on the login")
	public void user_on_the_login_page1() {
		String path = System.getenv("WEBDRIVER");
		System.setProperty("webdriver.chrome.driver", path);
		this.driver = new ChromeDriver();
		driver.get("https://sqa.peluangkerjaku.com/tele/");
		extentTest.log(LogStatus.PASS, "User on the login page");
	}

	@When("User login with valid username {string} and password {string}")
	public void user_login_with_valid_username_and_password(String string, String string2) {
		driver.findElement(By.id("tl_login-1-51550_text")).sendKeys(string);
		driver.findElement(By.id("tl_login-1-51551_text")).sendKeys(string2);
		driver.findElement(By.xpath("//span[normalize-space()='Sign In']")).click();
		extentTest.log(LogStatus.PASS, "User get login with valid user");
	}

	@When("User get login validation {string}")
	public void user_get_login_validate1(String string) {
		try {
			Thread.sleep(1000);
			WebElement welcomeText = driver.findElement(By.xpath("//*[@id=\"nikita-form-dialog\"]/p"));
			System.out.println("Welcome validation => " + welcomeText.getText());
			Assert.assertEquals(welcomeText.getText(), string);
			extentTest.log(LogStatus.PASS, "User get alert "+string);
		} catch (Exception e) {

		}
	}

	@When("User click ok to the validate message")
	public void user_click_ok_to_the_validate_message() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='OK']")).click();
			extentTest.log(LogStatus.PASS, "User click on validation msg");

		} catch (Exception e) {
			System.out.println("1" + e);
		}

	}

	@When("User move to table Data")
	public void user_move_to_table_Data1() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//h3[@id='ui-id-11']")).click();
			extentTest.log(LogStatus.PASS, "User move to the table");
		} catch (Exception e) {
			System.out.println("2" + e);
		}
	}

	@When("User move to table Distribute Data")
	public void user_move_to_table_Distribute_Data() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='Distribute Data']")).click();
			extentTest.log(LogStatus.PASS, "User move to distribute data");
		} catch (Exception e) {
			System.out.println("3" + e);
		}
	}

	@When("User select the agent {string}")
	public void user_select_the_agent(String string) {
		Boolean state = Boolean.parseBoolean(string);
		while (state) {
			try {
				Thread.sleep(1000);
				WebElement select = driver.findElement(By.xpath("//*[@id=\"ddcl-tl_distribute--52066_select\"]/span"));
				Thread.sleep(1000);
				select.click();
				extentTest.log(LogStatus.PASS, "User select the agent "+string);
			} catch (Exception e) {
				System.out.println("5" + e);
			}

			// select agent

			try {
				Thread.sleep(1000);
				WebElement agent = driver.findElement(By.xpath("//input[@id='ddcl-tl_distribute--52066_select-i6']"));
				Thread.sleep(1000);
				agent.click();
				Thread.sleep(1000);
				agent.sendKeys(Keys.ENTER);

				state = false;
			} catch (Exception e) {
				System.out.println("6" + e);
			}
		}
		state = true;

	}

	@When("User fill the quantity {string}")
	public void user_fill_the_quantity(String string) {
		try {
			Thread.sleep(1000);
			WebElement jml = driver.findElement(By.xpath("//input[@id='tl_distribute--52070_text']"));
			jml.click();
			jml.sendKeys(string);
			extentTest.log(LogStatus.PASS, "User fill the quantity " + string);
		} catch (Exception e) {
			System.out.println("7" + e);
		}
	}

	@When("User select the New status")
	public void user_select_the_New_status() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//select[@id='tl_distribute--52079_text']")).click();
		} catch (Exception e) {
			System.out.println("8" + e);
		}
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//option[@value='NEW']")).click();
		} catch (Exception e) {
			System.out.println("9" + e);
		}
		extentTest.log(LogStatus.PASS, "User select new status");
	}

	@When("User push the distribute button")
	public void user_push_the_distribute_button() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='Distribusi']")).click();
			extentTest.log(LogStatus.PASS, "User click distribute btn");
		} catch (Exception e) {
			System.out.println("10" + e);
		}
	}

	@Then("User get validation message {string}")
	public void user_get_validation_message(String string) {
		try {
			Thread.sleep(1000);
			String msg = driver.findElement(By.xpath("//*[@id=\"nikita-form-dialog\"]/p")).getText();
			Assert.assertEquals(msg, string);
			extentTest.log(LogStatus.PASS, "User get alert "+string);
		} catch (Exception e) {
			System.out.println("11" + e);
		}
	}

	String agent;
	String status;

	@Given("User login with username {string} and password {string}")
	public void user_login_with_username_and_password(String string, String string2) {
		String path = System.getenv("WEBDRIVER");
		System.setProperty("webdriver.chrome.driver", path);
		this.driver = new ChromeDriver();
		driver.get("https://sqa.peluangkerjaku.com/tele/");
		driver.findElement(By.id("tl_login-1-51550_text")).sendKeys(string);
		driver.findElement(By.id("tl_login-1-51551_text")).sendKeys(string2);
		driver.findElement(By.xpath("//span[normalize-space()='Sign In']")).click();
		extentTest.log(LogStatus.PASS, "User login with valid user "+string);
	}

	@When("User get login msg {string}")
	public void user_get_login_msg(String string) {
		try {
			Thread.sleep(1000);
			WebElement welcomeText = driver.findElement(By.xpath("//*[@id=\"nikita-form-dialog\"]/p"));
			System.out.println("Welcome validation => " + welcomeText.getText());
			Assert.assertEquals(welcomeText.getText(), string);
			extentTest.log(LogStatus.PASS, "User get alert "+string);
		} catch (Exception e) {

		}

	}

	@When("User click ok to the validate msg")
	public void user_click_ok_to_the_validate_msg() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='OK']")).click();
			extentTest.log(LogStatus.PASS, "User get alert ");

		} catch (Exception e) {
			System.out.println("1" + e);
		}

	}

	@When("User move to table_Data")
	public void user_move_to_table_Data() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//h3[@id='ui-id-11']")).click();
			extentTest.log(LogStatus.PASS, "User move to table");
		} catch (Exception e) {
			System.out.println("2" + e);
		}
	}

	@When("User move to table Edit Data")
	public void user_move_to_table_Edit_Data() {
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[normalize-space()='Edit Data']")).click();
				extentTest.log(LogStatus.PASS, "User move to edit data");
				state = false;
			} catch (Exception e) {
				System.out.println("3" + e);
			}
		}
	}

	@When("User select the {string}")
	public void user_select_the_data(String string) {

		switch (string) {
		case "earliest data":
			Boolean state = true;
			while (state) {
				try {
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id=\"tl_edit_data--52536_table\"]/tbody/tr[1]")).click();
					extentTest.log(LogStatus.PASS, "User select  "+string);
					state = false;
				} catch (Exception e) {
					System.out.println("5" + e);
				}
			}
			break;
		case "data from the latest table":
			state = true;
			while (state) {
				try {
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id=\"tl_edit_data--52536\"]/div[9]/ul/li[8]/a")).click();
					extentTest.log(LogStatus.PASS, "User select  "+string);
					state = false;
				} catch (Exception e) {
					System.out.println("5" + e);
				}
			}

			state = true;
			while (state) {
				try {
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id=\"tl_edit_data--52536_table\"]/tbody/tr[1]")).click();
					state = false;
				} catch (Exception e) {
					System.out.println("5" + e);
				}
			}
			break;

		}

	}


	@When("User update or edit the data")
	public void user_update_or_edit_the_data() {
		// mengubah nama agent
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				// *[@id="tl_edit_user_activity-12-52807_text"]/option[5]
				WebElement agent = driver
						.findElement(By.xpath("//*[@id=\"tl_edit_user_activity-12-52807_text\"]/option[5]"));
				agent.click();
				System.out.println("agent dalam kotak yang dipilih " + agent.getText());
				this.agent = agent.getText();
				extentTest.log(LogStatus.PASS, "User update data");
				state = false;
			} catch (Exception e) {
				System.out.println("6" + e);
			}
		}

		// mengubah status activity
		state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//select[@id='tl_edit_user_activity-12-52786_text']")).click();
				// *[@id="tl_edit_user_activity-12-52786_text"]/option[2]
				WebElement status = driver
						.findElement(By.xpath("//*[@id=\"tl_edit_user_activity-12-52786_text\"]/option[2]"));
				status.click();
				System.out.println("status dalam kotak yang dipilih " + status.getText());
				this.status = status.getText();
				state = false;
			} catch (Exception e) {
				System.out.println("6" + e);
			}
		}
	}

	@When("User confirm or click update button")
	public void user_confirm_or_click_update_button() {
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[normalize-space()='UPDATE']")).click();
				state = false;
				extentTest.log(LogStatus.PASS, "User click update btn");
			} catch (Exception e) {
				System.out.println("8" + e);
			}
		}
		state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				WebElement updtMsg = driver.findElement(By.xpath("//*[@id=\"nikita-form-dialog\"]/p"));
				System.out.println(updtMsg.getText());
				driver.findElement(By.xpath("//span[normalize-space()='OK']")).click();
				state = false;
			} catch (Exception e) {
				System.out.println("7" + e);
			}
		}
	}

	@Then("User see data changed successfully")
	public void user_see_data_changed_successfully() {
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				WebElement agentAct = driver.findElement(By.xpath("//td[@id='tl_edit_data--52536-cell-0-10']"));
				System.out.println("agent yang dilihat setelah di update " + agentAct.getText());
				WebElement statusAct = driver.findElement(By.xpath("//*[@id=\"tl_edit_data--52536-cell-0-9\"]"));
				System.out.println("status acivity yang dilihat setelah di update " + statusAct.getText());
				Assert.assertEquals(agent, agentAct.getText());
				Assert.assertEquals(status, statusAct.getText());
				extentTest.log(LogStatus.PASS, "User see data changed successfully");
				state = false;
			} catch (Exception e) {
				System.out.println("9" + e);
			}
		}
	}


	@When("User not confirm or click close button")
	public void user_not_confirm_or_click_close_button() {
		// agent
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				WebElement agent = driver
						.findElement(By.xpath("//*[@id=\"tl_edit_user_activity-12-52807_text\"]/option[4]"));
				System.out.println("agent dalam kotak yang tidak jadi dipilih " + agent.getText());
				this.agent = agent.getText();
				state = false;
			} catch (Exception e) {
				System.out.println("6" + e);
			}
		}
		// status
		state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//select[@id='tl_edit_user_activity-12-52786_text']")).click();
				// *[@id="tl_edit_user_activity-12-52786_text"]/option[2]
				// *[@id="tl_edit_user_activity-12-52786_text"]/option[12]
				WebElement status = driver
						.findElement(By.xpath("//*[@id=\"tl_edit_user_activity-12-52786_text\"]/option[12]"));
				status.click();
				System.out.println("status dalam kotak yang tidak dipilih " + status.getText());
				this.status = status.getText();
				state = false;
			} catch (Exception e) {
				System.out.println("6" + e);
			}
		}

		// close button
		state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-close']")).click();
				extentTest.log(LogStatus.PASS, "User not confirm to change the data");
				state = false;
			} catch (Exception e) {
				System.out.println("8" + e);
			}
		}
	}

	@Then("User see data not changed")
	public void user_see_data_not_changed() {
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				WebElement agentAct = driver.findElement(By.xpath("//td[@id='tl_edit_data--52536-cell-0-10']"));
				System.out.println("agent yang dilihat pada tabel " + agentAct.getText());
				WebElement statusAct = driver.findElement(By.xpath("//*[@id=\"tl_edit_data--52536-cell-0-9\"]"));
				System.out.println("status acivity yang dilihat setelah di update " + statusAct.getText());
				Assert.assertNotEquals(agent, agentAct.getText());
				Assert.assertNotEquals(status, statusAct.getText());
				extentTest.log(LogStatus.PASS, "User see data not change");
				state = false;
			} catch (Exception e) {
				System.out.println("9" + e);
			}
		}
	}

	
	
	
	
	
	
	//method screenshot
	public String screenShot() {
		String hasil = null;
		try {
			File destFile = userSpv.ambilGambar(driver, direktoriFile + fileCounter + ".png");
			hasil = "<a target='_blank' href='" + destFile.getAbsolutePath() + "'>" + "<img src='"
					+ destFile.getAbsolutePath() + "'width = 100 height = 100 /></a>";
		} catch (IOException e) {
			System.out.println("error");
		}

		return hasil;

	}

	public static File ambilGambar(WebDriver webdriver, String filepath) throws IOException {
		TakesScreenshot ss = ((TakesScreenshot) webdriver);
		File srcFile = ss.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filepath);
		FileUtils.copyFile(srcFile, destFile);

		return destFile;
	}


}
