package Test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import com.thoughtworks.selenium.webdriven.JavascriptLibrary;

/**
 * 
 * @author saurabh.misra
 *
 */
public class ActionKeywords {
	public static WebDriver driver = ActionKeywords.getDriver("Chrome");
	Validation d = new Validation();
	String windowHandle;
	static String Unique = String.valueOf(System.currentTimeMillis());
	static List<String> Data = new ArrayList<String>();
	static List<String> dt = new ArrayList<String>();
	public static Map<String, String> DocrefNum = new HashMap<String, String>();
	static String URLname = "";
	static String BrowserName = "Chrome";
	static HashMap<String, Boolean> dependence = new HashMap<>();
	SoftAssert s_assert = new SoftAssert();

	void SetDocRefNum(String Key, String Value) {
		DocrefNum.put(Key, Value);
	}

	String GetDocRefNum(String Key) {
		String DocNum = DocrefNum.get(Key);
		return DocNum;
	}

	public static WebDriver getDriver(String Testdata) {
		if (driver == null) {
			switch (Testdata.toLowerCase()) {
			case "chrome":
				String chromedrvPath = System.getProperty("user.dir") + "\\Jarlibs\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", chromedrvPath);
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			}

			// driver=new FirefoxDriver();
		}
		return driver;
	}

	public static void sendPDFReportByGMail(String from, String pass, String to, String subject, String body) {
		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);
		try {
			// Set from address
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// Set subject
			message.setSubject(subject);
			message.setText(body);
			BodyPart objMessageBodyPart = new MimeBodyPart();
			objMessageBodyPart.setText("Please Find The Attached Report File!<br>Regards,<br>Saurabh Mishra");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(objMessageBodyPart);
			objMessageBodyPart = new MimeBodyPart();
			// Set path to the pdf report file
			String filename = System.getProperty("user.dir") + ".//AutomationReport.xlsx";
			// Create data source to attach the file in mail
			DataSource source = new FileDataSource(filename);
			objMessageBodyPart.setDataHandler(new DataHandler(source));
			objMessageBodyPart.setFileName(filename);
			multipart.addBodyPart(objMessageBodyPart);
			message.setContent(multipart);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		}
	}

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}

	public void CheckNonMandatory(String Keyword, String testdata, String unique, String Configurable, String xmlname,
			String Sheetname, String conditional, String dependedon, String LocaterName, String Mandatory,
			String ObjectFile) throws Exception

	{

		if (Mandatory.toUpperCase().equals("TRUE")) {
			try {
				CheckDependency(Keyword, testdata, unique, Configurable, xmlname, Sheetname, conditional, dependedon,
						LocaterName, ObjectFile);
			} catch (Exception e) {
				System.out.println("Element is not visible " + LocaterName);
			}
		} else {

			CheckDependency(Keyword, testdata, unique, Configurable, xmlname, Sheetname, conditional, dependedon,
					LocaterName, ObjectFile);

		}
	}

	public void CheckDependency(String Keyword, String testdata, String unique, String Configurable, String xmlname,
			String Sheetname, String conditional, String dependedon, String LocaterName, String ObjectFile)
			throws Exception {

		if (conditional.toUpperCase().equals("TRUE")) {

			String[] dependedonarr = dependedon.split(",");
			if (dependedonarr.length == 2) {
				if (dependence.get(dependedonarr[0])) {
					if (dependence.get(dependedonarr[1])) {
						perform(Keyword, testdata, unique, Configurable, xmlname, Sheetname, conditional, LocaterName,
								ObjectFile);
					}
				}
			} else {
				if (dependence.get(dependedon)) {
					perform(Keyword, testdata, unique, Configurable, xmlname, Sheetname, conditional, LocaterName,
							ObjectFile);
				}
			}
		} else {
			perform(Keyword, testdata, unique, Configurable, xmlname, Sheetname, conditional, LocaterName, ObjectFile);
		}
	}

	public static By locatorValue(String ObjectFile, String locatorName) throws IOException {
		By by;
		String LocType = FilesUtils.getObjectRepository(ObjectFile).getProperty(locatorName).split(":")[0];
		// System.out.println("LocType is "+LocType);
		String Locvalue = FilesUtils.getObjectRepository(ObjectFile).getProperty(locatorName).split(":")[1];
		// System.out.println("Locvalue is "+Locvalue);
		switch (LocType.toLowerCase()) {
		case "id":
			by = By.id(Locvalue);
			break;
		case "name":
			by = By.name(Locvalue);
			break;
		case "xpath":
			by = By.xpath(Locvalue);
			break;
		case "css":
			by = By.cssSelector(Locvalue);
			break;
		case "class":
			by = By.className(Locvalue);
			break;
		case "linktext":
			by = By.linkText(Locvalue);
			break;
		case "partiallinktext":
			by = By.partialLinkText(Locvalue);
			break;
		case "tagname":
			by = By.tagName(Locvalue);
			break;
		default:
			by = null;
			break;
		}
		return by;
	}

	public void perform(String Keyword, String testdata, String unique, String Configurable, String xmlname,
			String Sheetname, String conditional, String locatorName, String ObjectFile)
			throws UnhandledAlertException, Exception {

		switch (Keyword.toUpperCase()) {
		case "CLICK":
			// Perform click
			By locator;
			locator = locatorValue(ObjectFile, locatorName);
			WebElement element = driver.findElement(locator);
			// if (!mandatory.equals("null")) {
			// // element.clear();
			// driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
			// d.opration(driver, element, "MANDATORY", mandatory, testdata);
			// } // checking for Mandatory method.
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(3000);
			element.click(); // Code that is sometimes throwing the exception.
			Thread.sleep(2000);
			// if (!maxlength.equals("null")) {
			// d.opration(driver, element, "maxlength", maxlength, testdata);
			// }
			// // Thread.sleep(2000);
			// if (!datatype.equals("null")) {
			// d.opration(driver, element, "DATATYPE", datatype, testdata);
			// }
			break;
		case "CCLICK": // special case for multiple unique in middle only.
			String data1 = "";
			String Loctype1 = FilesUtils.getObjectRepository(ObjectFile).getProperty(locatorName).split(":")[0];
			String[] arr = FilesUtils.getObjectRepository(ObjectFile).getProperty(locatorName).split(":")[1].split(",");
			for (int i = 0; i < arr.length - 1; i++) {
				arr[i] = arr[i] + Unique;
				data1 = data1 + arr[i];
			}
			data1 = data1 + arr[arr.length - 1];
			System.out.println("new data is " + data1);
			locatorName = Loctype1 + ":" + data1;
			By locator6;
			locator6 = locatorValue(ObjectFile, locatorName);
			WebElement element15 = driver.findElement(locator6);
			element15.click();
			break;

		case "SETTEXT":
			// Set text on control
			if (unique.toUpperCase().equals("TRUE")) {
				// checking for uniqueness
				testdata = testdata + "" + Unique;
			}
			if (Configurable.toUpperCase().equals("TRUE")) {
				// checking for Configurable
				testdata = FilesUtils.ReadConfigXML(xmlname, locatorName, testdata);
			}
			By locator1;
			System.out.println(ObjectFile + "   " + locatorName);
			locator1 = locatorValue(ObjectFile, locatorName);

			WebElement element1 = driver.findElement(locator1);
			// if (!mandatory.equals("null")) {
			// element1.clear(); // checking for Mandatory method.
			// Thread.sleep(2000);
			// d.opration(driver, element1, "MANDATORY", mandatory, testdata);
			// }
			element1.click();
			element1.clear();
			element1.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
			element1.sendKeys(testdata);
			System.out.println("Typing " + testdata);
			// Thread.sleep(2000);
			// if (!maxlength.equals("null")) // checking for Maxlength method.
			// {
			// d.opration(driver, element1, "maxlength", maxlength, testdata);
			// }
			// Thread.sleep(2000);
			// if (!datatype.equals("null")) // checking for DataType method.
			// {
			// d.opration(driver, element1, "DATATYPE", datatype, testdata);
			// }
			// Thread.sleep(3000);

			break;

		case "GOTOURL":
			// Get url of application
			if (Configurable.toUpperCase().equals("TRUE")) { // checking for
				// Configurable
				testdata = FilesUtils.ReadConfigXML(xmlname, locatorName, testdata);
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(testdata);
			driver.navigate().refresh();
			URLname = driver.getCurrentUrl();
			System.out.println("current URL IS " + URLname);
			driver.manage().window().maximize();
			System.out.println("Opening URL " + testdata);
			break;
		case "GETTEXT":
			// Get text of an element
			By locator2;
			locator2 = locatorValue(ObjectFile, locatorName);
			WebElement element2 = driver.findElement(locator2);
			element2.getText();
			Thread.sleep(3000);
			break;
		case "GOTOMENU":
			// Go to menu from span of an element
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.switchTo().defaultContent();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			System.out.println("Going to default frame");
			By locator3;
			locator3 = locatorValue(ObjectFile, locatorName);
			WebElement span = driver.findElement(locator3).findElement(By.tagName("a"));
			JavascriptLibrary jsLib = new JavascriptLibrary();
			jsLib.callEmbeddedSelenium(driver, "triggerMouseEventAt", span, "click", "0,0");
			System.out.println("Selecting Menu ");
			driver.switchTo().frame("body");
			break;
		case "SELECT":
			// select option to an Dropdown
			if (unique.toUpperCase().equals("TRUE")) {
				testdata = testdata + "" + Unique;
			}
			if (Configurable.toUpperCase().equals("TRUE")) { // checking for
				// Configurable
				testdata = FilesUtils.ReadConfigXML(xmlname, locatorName, testdata);
			}
			By locator4;
			locator4 = locatorValue(ObjectFile, locatorName);
			WebElement dropdown = driver.findElement(locator4);
			Select s = new Select(dropdown);
			// if (!mandatory.equals("null")) {
			// dropdown.click();
			// d.opration(driver, dropdown, "MANDATORY", mandatory, testdata);
			// }
			if (testdata.contains(",")) {
				// Perform click
				String data = "";
				String[] array = testdata.split(",");

				for (int i = 0; i < array.length; i++) {
					array[i] = array[i] + Unique;
					data = data + array[i];
				}
				dropdown.click();
				s.selectByVisibleText(data);
			} else {
				dropdown.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				s.selectByVisibleText(testdata);
				System.out.println("Selecting option " + testdata + " From DropDown");
			}

			// if (!ddlmatch.equals("null")) // checking for DDlMAtch method.se
			// {
			// d.opration(driver, dropdown, "DDLMATCH", ddlmatch, testdata);
			// }
			break;

		case "SSELECT": // special case for multiple unique id (in both end)
			String data = "";
			String[] array = testdata.split(",");
			By locator5;
			for (int i = 0; i < array.length; i++) {
				array[i] = array[i] + Unique;
				data = data + array[i];
			}
			locator5 = locatorValue(ObjectFile, locatorName);
			WebElement dropdown1 = driver.findElement(locator5);
			Select s1 = new Select(dropdown1);
			dropdown1.click();
			s1.selectByVisibleText(data);
			break;
		case "WINDOW":
			// Switching B/w Window.
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			Thread.sleep(3000);
			Set<String> win = driver.getWindowHandles();

			Iterator<String> tr = win.iterator();

			while (tr.hasNext()) {
				driver.switchTo().window(tr.next());
			}

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			System.out.println("Switching Window ");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		case "GETWINDOW":
			// get the present SwWindow.
			windowHandle = driver.getWindowHandle();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		case "PARRENTTWINDOW":
			// get the present SwWindow.
			driver.switchTo().window(windowHandle);
			System.out.println("Switching to parrent Window");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		case "ACCEPTALERT":
			// Accept Alert.
			try {
				String alert1 = driver.switchTo().alert().getText();
				driver.switchTo().alert().accept();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				System.err.println(alert1 + " is Accepted ");
			} catch (Exception e1) {
				System.err.println("Alert is not present !! ");
				e1.printStackTrace();
			}
			break;
		case "DISSMISSALERT":
			// Dismiss Alert.
			try {
				String alert2 = driver.switchTo().alert().getText();
				driver.switchTo().alert().dismiss();
				System.err.println(alert2 + " is Dissmissed ");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			} catch (Exception e1) {
				System.err.println("Alert is not present !! ");
				e1.printStackTrace();
			}
			break;
		case "GETALERT":
			// Print alert Alert.
			try {
				String alert = driver.switchTo().alert().getText();
				System.out.println(alert);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			} catch (Exception e1) {
				System.err.println("Alert is not present !! ");
				e1.printStackTrace();
			}
			break;
		case "SWITCHFRAME":
			// Switch to frame.
			driver.switchTo().frame(testdata);
			System.out.println("Switched to Frame " + testdata);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		case "SWITCHTOFRAMEELE":
			// Switch to frame.
			By locator29;
			locator29 = locatorValue(ObjectFile, locatorName);
			WebElement element29 = driver.findElement(locator29);
			driver.switchTo().frame(element29);
			System.out.println("Switched to Frame ");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		case "FRAME":
			// Switching B/w frames.
			driver.switchTo().defaultContent();
			driver.switchTo().frame("body");
			driver.switchTo().frame(testdata);
			System.out.println("Switching to Frame " + testdata);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		case "WAIT":
			// waiting .
			float wat = Float.parseFloat(testdata);
			int wait = (int) wat;
			Thread.sleep(wait);
			System.out.println("waiting");
			break;
		case "DATE":
			// Type present date in textbox
			DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
			Date date = new Date();
			String date1 = dateFormat.format(date);
			System.out.println(dateFormat.format(date));
			By locator7;
			locator7 = locatorValue(ObjectFile, locatorName);
			WebElement element16 = driver.findElement(locator7);
			element16.click();
			element16.clear();
			element16.sendKeys(date1);
			element16.sendKeys(Keys.ENTER);
			break;
		case "DATE2":
			// Select present date in Calender
			DateFormat dateFor = new SimpleDateFormat("d");
			Calendar cal = Calendar.getInstance();
			String day = dateFor.format(cal.getTime());
			String datexpath = "//*[text()='" + day + "']";
			driver.findElement(By.xpath(datexpath)).click();
			break;
		case "TABKEY":
			// waiting .
			By locator8;
			locator8 = locatorValue(ObjectFile, locatorName);
			WebElement element19 = driver.findElement(locator8);
			element19.sendKeys(Keys.TAB);
			break;
		case "LINK":
			// waiting .
			Thread.sleep(3000);
			if (Configurable.toUpperCase().equals("TRUE")) { // checking for
				// Configurable
				testdata = FilesUtils.ReadConfigXML(xmlname, locatorName, testdata);
			}
			driver.findElement(By.linkText(testdata)).click();
			break;
		case "ID":
			// waiting .
			if (Configurable.toUpperCase().equals("TRUE")) {
				// checking for Configurable
				testdata = FilesUtils.ReadConfigXML(xmlname, locatorName, testdata);
			}
			Thread.sleep(3000);
			driver.findElement(By.id(testdata)).click();
			break;
		case "DDL":
			// waiting .
			if (Configurable.toUpperCase().equals("TRUE")) { // checking for
				// Configurable
				testdata = FilesUtils.ReadConfigXML(xmlname, locatorName, testdata);
			}
			By locator10;
			locator10 = locatorValue(ObjectFile, locatorName);
			WebElement dropdown2 = driver.findElement(locator10);
			dropdown2.click();
			Select s2 = new Select(dropdown2);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			s2.selectByVisibleText(testdata);
			break;
		case "XPATH":
			if (Configurable.toUpperCase().equals("TRUE")) { // checking for
				// Configurable
				testdata = FilesUtils.ReadConfigXML(xmlname, locatorName, testdata);
			}
			// waiting .
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(3000);
			driver.findElement(By.xpath(testdata)).click();
			break;
		case "SCROLL":
			// Scrolling down .
			By locator11;
			if (unique.toUpperCase().equals("TRUE")) {
				// testdata=testdata+""+Unique;
				String data2 = "";
				String Loctype = FilesUtils.getObjectRepository(ObjectFile).getProperty(locatorName).split(":")[0];
				String[] arr2 = FilesUtils.getObjectRepository(ObjectFile).getProperty(locatorName).split(":")[1]
						.split(",");
				for (int i = 0; i < arr2.length - 1; i++) {
					arr2[i] = arr2[i] + Unique;
					data2 = data2 + arr2[i];
				}
				data2 = data2 + arr2[arr2.length - 1];// (extra field is in
														// middile) .
				System.out.println("new data is " + data2);
				locatorName = Loctype + ":" + data2;
				// FilesUtils.getObjectRepository(ObjectFile).setProperty(locatorName,
				// Loctype+":"+data2);
				locator11 = locatorValue(ObjectFile, locatorName);
			} else {
				locator11 = locatorValue(ObjectFile, locatorName);
			}

			WebElement drop = driver.findElement(locator11);
			// JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("javascript:window.scrollBy(250,350)");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", drop);
			System.out.println("scrolling to element");
			break;
		case "SELECT1":
			// select special dropdown(extra field is in middile) .
			if (Configurable.toUpperCase().equals("TRUE")) { // checking for
				// Configurable
				testdata = FilesUtils.ReadConfigXML(xmlname, locatorName, testdata);
			}
			String data3 = "";
			String[] arr3 = testdata.split(",");
			for (int i = 0; i < arr3.length - 1; i++) {
				arr3[i] = arr3[i] + Unique;
				data3 = data3 + arr3[i];
			}
			data3 = data3 + arr3[arr3.length - 1];
			System.out.println("new data is " + data3);
			By locator12;
			locator12 = locatorValue(ObjectFile, locatorName);
			WebElement element22 = driver.findElement(locator12);
			Select s3 = new Select(element22);
			element22.click();
			s3.selectByVisibleText(data3);
			break;
		case "CLOSE":
			// close the current Window .
			Thread.sleep(5000);
			driver.close();
			break;
		case "READDATA":
			// Reading Data & printing it in PDF report .
			By locator16;
			locator16 = locatorValue(ObjectFile, locatorName);
			WebElement element20 = driver.findElement(locator16);
			SetDocRefNum(Sheetname, element20.getText());
			Data.add(element20.getText());
			Reporter.log(testdata + " " + Data);
			break;
		case "SELECTBYINDEX":
			// Select option from DDl by index.
			By locator13;
			float ind = Float.parseFloat(testdata);
			int index = (int) ind;
			locator13 = locatorValue(ObjectFile, locatorName);
			WebElement dropdown3 = driver.findElement(locator13);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			dropdown3.click();
			new Select(dropdown3).selectByIndex(index);
			break;

		case "SELECTBYVALUE":
			// Select option from DDl by index.
			By locator22;
			locator22 = locatorValue(ObjectFile, locatorName);
			WebElement dropdown5 = driver.findElement(locator22);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			dropdown5.click();
			new Select(dropdown5).selectByValue(testdata);
			break;

		case "MOVE&CLICK":
			// first move to element & click on it.
			By locator17;
			locator17 = locatorValue(ObjectFile, locatorName);
			WebElement element21 = driver.findElement(locator17);
			Actions action = new Actions(driver);
			action.moveToElement(element21).click().perform();
			break;
		case "CAPTURE":
			// Reading Data & printing it in PDF report .
			By locator18;
			locator18 = locatorValue(ObjectFile, locatorName);
			WebElement element23 = driver.findElement(locator18);
			SetDocRefNum(testdata, element23.getText());
			dt.add(element23.getText());
			SetDocRefNum(Sheetname, element23.getText() + " , ");
			System.out.println(dt);
			break;
		case "USECAPTURE":
			// get Captured Data & USing it in transactions .
			By locator19;
			// float in = Float.parseFloat(testdata);
			// int indx = (int) in;
			locator19 = locatorValue(ObjectFile, locatorName);
			WebElement element24 = driver.findElement(locator19);
			element24.clear();
			// System.out.println(dt.get(indx));
			// element24.sendKeys(dt.get(indx));
			element24.sendKeys(GetDocRefNum(testdata));
			break;
		case "SETVALUE":
			// get Captured Data & USing it in transactions .
			By locator20;
			float Val = Float.parseFloat(testdata);
			int Value = (int) Val;
			locator20 = locatorValue(ObjectFile, locatorName);
			WebElement element25 = driver.findElement(locator20);
			element25.click();
			element25.clear();
			element25.sendKeys("" + Value);
			break;
		case "SETBROWSER":
			// get Captured Data & USing it in transactions .
			driver = ActionKeywords.getDriver(testdata);
			BrowserName = testdata;
			break;

		case "RIGHTCLICK":
			// Right click on webelement .
			// By locator21;
			// locator21 = locatorValue(locatorTpye, locatorvalue);
			// WebElement element26 = driver.findElement(locator21);
			Actions action1 = new Actions(driver);
			Action rgtclk = action1.contextClick().build();
			rgtclk.perform();
			break;
		case "SETDEP":
			// Set Dep for webelement .
			By locator21;
			locator21 = locatorValue(ObjectFile, locatorName);
			List<WebElement> element26 = driver.findElements(locator21);
			System.out.println(element26.size());
			if (element26.size() == 0) {
				dependence.put(testdata, false);
				System.err.println("Dep. is set to False");
			} else {
				dependence.put(testdata, true);
				System.out.println("Dep. is set to True");
			}
			break;
		case "UPLOAD":
			// Set Dep for webelement .
			By locator25;
			locator25 = locatorValue(ObjectFile, locatorName);
			WebElement ele = driver.findElement(locator25);
			ele.sendKeys(testdata);
			break;

		case "SETTEXTEDITOR":
			// Switch to Iframe
			By locator27;
			locator27 = locatorValue(ObjectFile, locatorName);
			WebElement iframe = driver.findElement(locator27);
			driver.switchTo().frame(iframe);
			// switch to the active element, which gives "body" tag
			// and click it.
			WebElement we = driver.switchTo().activeElement();
			we.click();
			we.sendKeys(testdata);
			break;
		case "VALIDATE":
			// Set Dep for testdata witch the webelement .

			By locator26;
			locator26 = locatorValue(ObjectFile, locatorName);
			WebElement ele1 = driver.findElement(locator26);
			if (!testdata.equals(ele1.getText())) {
				throw new Exception("Validation Failed!! Expeted " + testdata + " but found " + ele1.getText());
			} else {
				System.out.println("Validation Passed!! Expeted " + testdata + " but found " + ele1.getText());
			}
			break;
		case "VALIDATEJSALERT":
			Alert alert3;
			try {
				alert3 = driver.switchTo().alert();
			} catch (Exception e) {

				throw new Exception(" Alert is not present");
			}
			String alerttext = alert3.getText();
			if (alerttext.contains(testdata)) {
				System.out.println("Validation Passed ");
			} else {
				throw new Exception("Validation is failed Expeted alert is " + testdata + " But found " + alerttext);
			}

			break;

		case "VALIDATEVALUE":
			String[] keyset = testdata.split(",");
			int length = keyset.length;
			if (length == 2) {
				if (Float.parseFloat(GetDocRefNum(keyset[0])) == Float.parseFloat(GetDocRefNum(keyset[1]))) {
					System.out.println("values are same");
				} else {
					throw new Exception("Validation is failed values  " + GetDocRefNum(keyset[0]) + " and "
							+ GetDocRefNum(keyset[1]) + " not matching. ");
				}
			}
			break;
		case "VALIDATEBOOTSTRAPALERT":
			// String pagetext = driver.getPageSource();
			By locator28;
			locator28 = locatorValue(ObjectFile, locatorName);
			WebElement alertele = driver.findElement(locator28);
			String BSalertText = alertele.getText();
			System.out.println(BSalertText);
			Assert.assertTrue("Alert Validation Failed", BSalertText.contains(testdata));
			break;
		case "VALIDATEPAYMENT":
			String[] keyset1 = testdata.split(",");
			int length1 = keyset1.length;
			if (length1 == 3) {
				// @param1 is RMPO Amount @param2 is APR Amount @param3 is
				// Supplier Invoice Amount
				float doc1 = Float.parseFloat(GetDocRefNum(keyset1[0]).replace(",", ""));
				float doc2 = Float.parseFloat(GetDocRefNum(keyset1[1]).replace(",", ""));
				float doc3 = Float.parseFloat(GetDocRefNum(keyset1[2]).replace(",", ""));
				if (doc1 >= doc2 + doc3) {
					System.out.println("Paymant are matching ");
				} else {
					throw new Exception("Validation is failed values Original Doc  Amount " + GetDocRefNum(keyset1[0])
							+ " and payment Doc amount"
							+ (GetDocRefNum(keyset1[1]) + Float.parseFloat(GetDocRefNum(keyset1[2])))
							+ " not matching. ");
				}
			}
			break;
		case "CHECKVISIBILITY":
			// String pagetext = driver.getPageSource();
			By locator30;
			locator30 = locatorValue(ObjectFile, locatorName);
			List<WebElement> element30 = driver.findElements(locator30);
			System.out.println(element30.size());
			if (element30.size() == 0) {
				dependence.put(testdata, false);
				System.out.println("Dep. is set to False");
			} else {
				WebElement alertele1 = driver.findElement(locator30);
				boolean displayed = alertele1.isDisplayed();
				dependence.put(testdata, displayed);
				System.out.println("Dep. is set to " + displayed);
			}
			break;
		case "CHECKFORSETTING":
			// String pagetext = driver.getPageSource();
			By locator31;
			locator31 = locatorValue(ObjectFile, locatorName);
			WebElement element31 = driver.findElement(locator31);
			dependence.put(testdata, element31.isSelected());
			System.out.println("Dep. is set to " + element31.isSelected());

			break;
		default:
			break;
		}

	}

}