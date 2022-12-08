package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FilesUtils {
	static ActionKeywords actionkeyword = new ActionKeywords();
	public static String filePath = System.getProperty("user.dir") + "\\Test_Data";
	public static String reportfilepath = ".//AutomationReport.xlsx";
	static int SuiteRowNum = 1;
	static int flagForSuiteRowNum = 0;
	static String sentMailTo="saurabh.mishra@worldfashionexchange.com";

	public static void storeVariables(String Filename) throws IOException {
		Properties p = new Properties();
		p.putAll(ActionKeywords.DocrefNum);
		p.setProperty("Unique", ActionKeywords.Unique);
		p.setProperty("LastSuiteRowNum", Integer.toString(FilesUtils.SuiteRowNum));
		FileOutputStream fos = new FileOutputStream(new File(".//RunTimeVariables//" + Filename + ".properties"));
		p.store(fos, null);
		fos.close();
	}

	public static void restoreVaribales(String Filename) throws IOException {
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(new File(".//RunTimeVariables//" + Filename + ".properties"));
		p.load(fis);
		Iterator<Object> keyitr = p.keySet().iterator();
		while (keyitr.hasNext()) {
			String key = (String) keyitr.next();
			ActionKeywords.DocrefNum.put(key, p.getProperty(key));
		}
		ActionKeywords.Unique = p.getProperty("Unique");
		FilesUtils.SuiteRowNum = Integer.parseInt(p.getProperty("LastSuiteRowNum"));
	}

	public static Properties getObjectRepository(String ObjectFile) throws IOException {
		Properties p = new Properties();
		// Read object repository file
		InputStream stream = new FileInputStream(new File(".\\LocatersObjects\\" + ObjectFile + ".properties"));
		// load all objects
		p.load(stream);
		return p;
	}

	public static void ReadExcel(String fileName, String sheetName, String XMLName, String ObjectFile)
			throws Exception {
		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook myWorkbook = WorkbookFactory.create(inputStream);
		Sheet mySheet = myWorkbook.getSheet(sheetName);
		int rowCount = mySheet.getLastRowNum() - mySheet.getFirstRowNum();
		for (int i = 1; i < rowCount + 1; i++) {
			Row row = mySheet.getRow(i);
			if (row.getCell(0).toString().length() == 0) {
				System.err.println("TestStep->" + row.getCell(0).toString() + " Is Empty");
			} else {
				actionkeyword.CheckNonMandatory(row.getCell(1).toString(), row.getCell(4).toString(),
						row.getCell(5).toString(), row.getCell(6).toString(), XMLName, sheetName,
						row.getCell(7).toString(), row.getCell(2).toString(), row.getCell(3).toString(),
						row.getCell(8).toString(), ObjectFile);
				// Print testCase detail on console
				System.out.println(row.getCell(0).toString() + "----" + row.getCell(1).toString() + "----"
						+ row.getCell(3).toString() + "----" + row.getCell(4).toString() + "----"
						+ row.getCell(5).toString());
			}
		}
	}

	static void ReadExcelSuite(String File, String SheetName) throws Exception {
		String errorMessage = "";
		Workbook wb = WorkbookFactory.create(new FileInputStream(new File(".//Test_Data//" + File)));
		Sheet sheet = wb.getSheet(SheetName);
		int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		FilesUtils.SetAutomationReport();
		for (int i = 1; i <= rowcount; i++) {
			int flag = 0;
			String ScreenshotPath = "";
			System.out.println("  Test Case   " + sheet.getRow(i).getCell(2).toString());
			FilesUtils.setCellData(sheet.getRow(i).getCell(1).toString().replace(".xlsx", ""), i + 3, 0);
			FilesUtils.setCellData(sheet.getRow(i).getCell(2).toString(), i + 3, 1);
			long start = System.currentTimeMillis();
			try {
				ReadExcel(sheet.getRow(i).getCell(1).toString(), sheet.getRow(i).getCell(2).toString(),
						sheet.getRow(i).getCell(3).toString(), sheet.getRow(i).getCell(4).toString());
				SuiteRowNum++;
			} catch (Exception e) {
				if (flagForSuiteRowNum == 0) {
					storeVariables("RuntimeVaribles");
					flagForSuiteRowNum = 1;
				}

				flag = 1;
				ScreenshotPath = System.getProperty("user.dir") + "\\testoutput\\" + "screenshot"
						+ (new Random().nextInt()) + ".png";
				ActionKeywords.takeSnapShot(ActionKeywords.driver, ScreenshotPath);
				errorMessage = e.getMessage();
				e.printStackTrace();
			}
			long end = System.currentTimeMillis();
			String TotalTime = Long.toString((end - start));
			FilesUtils.setCellData(TotalTime, i + 3, 2);
			if (flag == 1) {
				FilesUtils.hyperlinkScreenshot(ScreenshotPath, i + 3, 3);
				FilesUtils.setCellData(errorMessage, i + 3, 4);
				ActionKeywords.sendPDFReportByGMail("wfx.automationalert@gmail.com", "qrst@1234",
						sentMailTo, " Report OF Automation ", "");
				throw new Exception("  Test Case   " + sheet.getRow(i).getCell(2).toString() + "Falied");
			} else {
				FilesUtils.setCellData("Pass", i + 3, 3);
				FilesUtils.setCellData(ActionKeywords.DocrefNum.get(sheet.getRow(i).getCell(2).toString()), i + 3, 4);
			}

			System.out.println("************************ End of Test Case ***************************");
		}

		ActionKeywords.sendPDFReportByGMail("wfx.automationalert@gmail.com", "qrst@1234",
				sentMailTo, " Report OF Automation ", "");
	}

	static void ResumeReadExcelSuite(String File, String SheetName) throws Exception {

		restoreVaribales("RuntimeVaribles");
		String errorMessage = "";
		Workbook wb = WorkbookFactory.create(new FileInputStream(new File(".//Test_Data//" + File)));
		Sheet sheet = wb.getSheet(SheetName);
		int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		FilesUtils.SetAutomationReport();
		System.out.println("Login To Application");
		ReadExcel(sheet.getRow(1).getCell(1).toString(), sheet.getRow(1).getCell(2).toString(),
				sheet.getRow(1).getCell(3).toString(), sheet.getRow(1).getCell(4).toString());
		System.out.println("************************ Resuming Last Run Test Case ***************************");
		for (int i = SuiteRowNum; i <= rowcount; i++) {
			int flag = 0;
			String ScreenshotPath = "";
			System.out.println("  Test Case   " + sheet.getRow(i).getCell(2).toString());
			FilesUtils.setCellData(sheet.getRow(i).getCell(1).toString().replace(".xlsx", ""), i + 3, 0);
			FilesUtils.setCellData(sheet.getRow(i).getCell(2).toString(), i + 3, 1);
			long start = System.currentTimeMillis();
			try {
				ReadExcel(sheet.getRow(i).getCell(1).toString(), sheet.getRow(i).getCell(2).toString(),
						sheet.getRow(i).getCell(3).toString(), sheet.getRow(i).getCell(4).toString());
			} catch (Exception e) {
				if (flagForSuiteRowNum == 0) {
					storeVariables("RuntimeVaribles");
					flagForSuiteRowNum = 1;
				}

				flag = 1;
				ScreenshotPath = System.getProperty("user.dir") + "\\testoutput\\" + "screenshot"
						+ (new Random().nextInt()) + ".png";
				ActionKeywords.takeSnapShot(ActionKeywords.driver, ScreenshotPath);
				errorMessage = e.getMessage();
				e.printStackTrace();
			}

			long end = System.currentTimeMillis();
			String TotalTime = Long.toString((end - start));
			FilesUtils.setCellData(TotalTime, i + 3, 2);
			if (flag == 1) {
				FilesUtils.hyperlinkScreenshot(ScreenshotPath, i + 3, 3);
				FilesUtils.setCellData(errorMessage, i + 3, 4);
				ActionKeywords.sendPDFReportByGMail("wfx.automationalert@gmail.com", "qrst@1234",
						sentMailTo, " Report OF Automation ", "");
				throw new Exception("  Test Case   " + sheet.getRow(i).getCell(2).toString() + "Falied");
			} else {

				FilesUtils.setCellData("Pass", i + 3, 3);
				FilesUtils.setCellData(ActionKeywords.DocrefNum.get(sheet.getRow(i).getCell(2).toString()), i + 3, 4);
			}

			System.out.println("************************ End of Test Case ***************************");
		}

		ActionKeywords.sendPDFReportByGMail("wfx.automationalert@gmail.com", "qrst@1234",
				sentMailTo, " Report OF Automation ", "");
	}

	static String ReadConfigXML(String XMLName, String LocaterName, String testdata) throws SAXException, IOException {
		String testdatavalue = testdata;
		try {
			File inputFile = new File(".//Config_XML//" + XMLName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			// System.out.println(doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("ConfigElement");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String xmlLocatername = eElement.getAttribute("LocaterName");
					// String xmlLocaterType =
					// eElement.getAttribute("LocaterType");
					// String xmlLocaterValue =
					// eElement.getAttribute("LocaterValue");
					if
					// (xmlLocaterType.equalsIgnoreCase(LocaterType) &&
					// xmlLocaterValue.equals(LocaterValue))
					(xmlLocatername.equalsIgnoreCase(LocaterName)) {
						NodeList Testdata = eElement.getElementsByTagName("TestData");
						Element eSubElement = (Element) Testdata.item(0);
						testdatavalue = eSubElement.getTextContent();
						System.out.println(testdatavalue);
						break;
					}

				}

			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return testdatavalue;
	}

	public static void SetAutomationReport() throws Exception {
		try {
			Workbook wb = new XSSFWorkbook();
			Sheet sheet = wb.createSheet("AutomationReport");
			Row exeTime = sheet.createRow(0);
			exeTime.setHeight((short) 600);
			Row Browser = sheet.createRow(1);
			exeTime.setHeight((short) 600);
			Row URLRow = sheet.createRow(2);
			exeTime.setHeight((short) 600);
			Row HeaderRow = sheet.createRow(3);
			HeaderRow.setHeight((short) 600);

			DateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			String DateToStr = dateFormat.format(cal.getTime());

			CellStyle style = wb.createCellStyle();
			style.setBorderBottom(CellStyle.BORDER_THIN);
			style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			style.setBorderLeft(CellStyle.BORDER_THIN);
			style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
			style.setRightBorderColor(CellStyle.BORDER_THIN);
			style.setRightBorderColor(IndexedColors.BLACK.getIndex());
			style.setBorderBottom(CellStyle.BORDER_THIN);
			style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			Font font = wb.createFont();
			font.setFontName("Courier New");
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			style.setFont(font);

			Cell executionTime = exeTime.createCell(0);
			executionTime.setCellValue("Executed On ");
			executionTime.setCellStyle(style);

			Cell date = exeTime.createCell(1);
			date.setCellValue(DateToStr);
			// date.setCellStyle(style);

			Cell BrowserName = Browser.createCell(0);
			BrowserName.setCellValue("Browser Name");
			BrowserName.setCellStyle(style);

			Cell URL = URLRow.createCell(0);
			URL.setCellValue("URL ( Server Name ) ");
			URL.setCellStyle(style);

			Cell TestSuiteName = HeaderRow.createCell(0);
			TestSuiteName.setCellValue("Test Suite Name");
			TestSuiteName.setCellStyle(style);

			Cell TestCaseName = HeaderRow.createCell(1);
			TestCaseName.setCellValue("Test Case Name");
			TestCaseName.setCellStyle(style);

			Cell Time = HeaderRow.createCell(2);
			Time.setCellValue("Time (ms)");
			Time.setCellStyle(style);

			Cell Status = HeaderRow.createCell(3);
			Status.setCellValue("Status");
			Status.setCellStyle(style);

			Cell RefNo = HeaderRow.createCell(4);
			RefNo.setCellValue("Ref No.");
			RefNo.setCellStyle(style);

			FileOutputStream fileOut = new FileOutputStream(new File(reportfilepath));
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
			wb.close();
		} catch (Exception e) {
			throw (e);
		}
	}

	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {
		try {

			// Access the required test data sheet
			Workbook ExcelWBook = WorkbookFactory.create(new FileInputStream(new File(reportfilepath)));
			Sheet ExcelWSheet = ExcelWBook.getSheet("AutomationReport");
			Row row = ExcelWSheet.getRow(RowNum);
			if (row == null) {
				row = ExcelWSheet.createRow(RowNum);
			}

			Row HeaderRowURL = ExcelWSheet.getRow(2);
			Cell URLName = HeaderRowURL.getCell(1, Row.RETURN_BLANK_AS_NULL);
			if (URLName == null) {

				URLName = HeaderRowURL.createCell(1);

				URLName.setCellValue(ActionKeywords.URLname);
			} else {
				URLName.setCellValue(ActionKeywords.URLname);
			}

			Row HeaderRowBrowser = ExcelWSheet.getRow(1);
			Cell BrowserName = HeaderRowBrowser.getCell(1, Row.RETURN_BLANK_AS_NULL);
			if (BrowserName == null) {

				BrowserName = HeaderRowBrowser.createCell(1);

				BrowserName.setCellValue(ActionKeywords.BrowserName);
			} else {
				BrowserName.setCellValue(ActionKeywords.BrowserName);
			}

			Cell cell = row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			if (cell == null) {
				cell = row.createCell(ColNum);
				cell.setCellValue(Result);
			} else {
				cell.setCellValue(Result);
			}

			for (int columnIndex = 0; columnIndex < 5; columnIndex++) {
				ExcelWSheet.autoSizeColumn(columnIndex);
			}

			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(new File(reportfilepath));
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();

		} catch (Exception e) {
			throw (e);
		}
	}

	public static void hyperlinkScreenshot(String FileAddress, int RowNum, int ColNum)
			throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException {

		Workbook wb = WorkbookFactory.create(new FileInputStream(new File(reportfilepath)));
		Sheet sheet = wb.getSheet("AutomationReport");

		Row HeaderRowURL = sheet.getRow(2);
		Cell URLName = HeaderRowURL.getCell(1, Row.RETURN_BLANK_AS_NULL);
		if (URLName == null) {
			URLName = HeaderRowURL.createCell(1);
			URLName.setCellValue(ActionKeywords.URLname);
		} else {
			URLName.setCellValue(ActionKeywords.URLname);
		}

		Row HeaderRowBrowser = sheet.getRow(1);
		Cell BrowserName = HeaderRowBrowser.getCell(1, Row.RETURN_BLANK_AS_NULL);
		if (BrowserName == null) {

			BrowserName = HeaderRowBrowser.createCell(1);

			BrowserName.setCellValue(ActionKeywords.BrowserName);
		} else {
			BrowserName.setCellValue(ActionKeywords.BrowserName);
		}

		Row row = sheet.getRow(RowNum);
		if (row == null) {
			row = sheet.createRow(RowNum);
		}
		CreationHelper createHelper = wb.getCreationHelper();
		CellStyle hlink_style = wb.createCellStyle();
		Font hlink_font = wb.createFont();
		hlink_font.setUnderline(Font.U_SINGLE);
		hlink_font.setColor(IndexedColors.BLUE.getIndex());
		hlink_style.setFont(hlink_font);
		Hyperlink hp = createHelper.createHyperlink(Hyperlink.LINK_FILE);
		FileAddress = FileAddress.replace("\\", "/");
		hp.setAddress(FileAddress);
		Cell cell = row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
		if (cell == null) {
			cell = row.createCell(ColNum);
			cell.setHyperlink(hp);
			cell.setCellStyle(hlink_style);
			cell.setCellValue("Fail");
		} else {
			cell.setHyperlink(hp);
			cell.setCellStyle(hlink_style);
		}
		FileOutputStream fileOut = new FileOutputStream(new File(reportfilepath));
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}

}
