package anhtester.com.helpers;

import java.awt.Color;
import java.io.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelpers {

    private static FileInputStream fis;
    private static FileOutputStream fileOut;
    private static Workbook wb;
    private static Sheet sh;
    private static Cell cell;
    private static Row row;
    private static CellStyle cellstyle;
    private static Color mycolor;
    private static String excelFilePath;
    private static Map<String, Integer> columns = new HashMap<>();

    public static int rowNumber; //Row Number
    public static int columnNumber; //Column Number

    //    Set Excel file
    public static void setExcelFile(String ExcelPath, String SheetName) {
        try {
            File f = new File(ExcelPath);

            if (!f.exists()) {
                f.createNewFile();
                System.out.println("File doesn't exist, so created!");
            }

            fis = new FileInputStream(ExcelPath);
            wb = WorkbookFactory.create(fis);
            sh = wb.getSheet(SheetName);
            //sh = wb.getSheetAt(0); //0 - index of 1st sheet
            if (sh == null) {
                sh = wb.createSheet(SheetName);
            }

            excelFilePath = ExcelPath;

            //adding all the column header names to the map 'columns'
            sh.getRow(0).forEach(cell -> {
                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
            });

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    //Phương thức này nhận số hàng làm tham số và trả về dữ liệu của hàng đó.
    public static Row getRowData(int RowNum) {
        row = sh.getRow(RowNum);
        return row;
    }

    public static String[][] getDataArray(String ExcelPath, String sheetName, int startCol, int totalCols) {

        String[][] data = null;
        try {

            File f = new File(ExcelPath);

            if (!f.exists()) {
                f.createNewFile();
                System.out.println("File doesn't exist, so created!");
            }

            fis = new FileInputStream(ExcelPath);
            wb = new XSSFWorkbook(fis);
            sh = wb.getSheet(sheetName);

            int noOfRows = sh.getPhysicalNumberOfRows();
            //int noOfCols = row.getLastCellNum();
            int noOfCols = totalCols + 1;

            System.out.println("Số Dòng: " + (noOfRows - 1));
            System.out.println("Số Cột: " + (noOfCols - startCol));

            data = new String[noOfRows - 1][noOfCols - startCol];
            for (int i = 1; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols - startCol; j++) {
                    data[i - 1][j] = getCellData(i, j + startCol);
                    System.out.println(data[i - 1][j]);
                }
            }
        } catch (Exception e) {
            System.out.println("The exception is: " + e.getMessage());
        }
        return data;
    }

    public static Object[][] getTableArray(String FilePath, String SheetName, int iTestCaseRow) throws Exception {

        String[][] tabArray = null;

        try {
            FileInputStream ExcelFile = new FileInputStream(FilePath);

            // Access the required test data sheet
            wb = new XSSFWorkbook(ExcelFile);
            sh = wb.getSheet(SheetName);

            int startCol = 1;
            int ci = 0, cj = 0;

            int totalRows = 1;
            int totalCols = 2;

            tabArray = new String[totalRows][totalCols];

            for (int j = startCol; j <= totalCols; j++, cj++) {
                tabArray[ci][cj] = getCellData(iTestCaseRow, j);
                System.out.println(tabArray[ci][cj]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return (tabArray);
    }

    public static Object[][] getDataHashTable(String ExcelPath, String SheetName, int startRow, int endRow) {

        Object[][] data = null;
        try {

            File f = new File(ExcelPath);

            if (!f.exists()) {
                f.createNewFile();
                System.out.println("File doesn't exist, so created!");
            }

            fis = new FileInputStream(ExcelPath);
            wb = new XSSFWorkbook(fis);
            sh = wb.getSheet(SheetName);

            int rows = getRowCount();
            int columns = getColumnCount();
            System.out.println("Row: " + rows + " - Column: " + columns);
            data = new Object[endRow - startRow][1];
            Hashtable<String, String> table = null;
            for (int rowNums = startRow; rowNums < endRow; rowNums++) {
                table = new Hashtable<String, String>();
                for (int colNum = 0; colNum < columns; colNum++) {
                    // data[rowNums-2][colNum] = excel.getCellData(sheetName, colNum, rowNums);
                    table.put(getCellData(0, colNum), getCellData(rowNums, colNum));
                    data[rowNums - startRow][0] = table;
                }
            }

            System.out.println(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String getTestCaseName(String sTestCase) throws Exception {
        String value = sTestCase;
        try {
            int posi = value.indexOf("@");
            value = value.substring(0, posi);
            posi = value.lastIndexOf(".");

            value = value.substring(posi + 1);
            return value;

        } catch (Exception e) {
            throw (e);
        }
    }

    public static int getRowContains(String sTestCaseName, int colNum) throws Exception {
        int i;
        try {
            int rowCount = getRowUsed();
            for (i = 0; i < rowCount; i++) {
                if (getCellData(i, colNum).equalsIgnoreCase(sTestCaseName)) {
                    break;
                }
            }
            return i;

        } catch (Exception e) {
            throw (e);
        }

    }

    public static int getRowUsed() throws Exception {
        try {
            int RowCount = sh.getLastRowNum();
            return RowCount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw (e);
        }
    }

    // Get cell data
    public static String getCellData(int rownum, int colnum) {
        try {
            cell = sh.getRow(rownum).getCell(colnum);
            String CellData = null;
            switch (cell.getCellType()) {
                case STRING:
                    CellData = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        CellData = String.valueOf(cell.getDateCellValue());
                    } else {
                        CellData = String.valueOf((long) cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    CellData = Boolean.toString(cell.getBooleanCellValue());
                    break;
                case BLANK:
                    CellData = "";
                    break;
            }
            return CellData;
        } catch (Exception e) {
            return "";
        }
    }

    public static String getCellData(int rowNum, String columnName) {
        return getCellData(rowNum, columns.get(columnName));
    }

    public static int getRows() {
        return sh.getPhysicalNumberOfRows();
    }

    public static int getRowCount() {
        int rowCount = sh.getLastRowNum() + 1;
        return rowCount;
    }

    public static int getColumnCount() {
        row = sh.getRow(0);
        int colCount = row.getLastCellNum();
        return colCount;
    }

    // Write data to excel sheet
    public static void setCellData(String text, int rowNum, int colnum) {
        try {
            row = sh.getRow(rowNum);
            if (row == null) {
                row = sh.createRow(rowNum);
            }
            cell = row.getCell(colnum);

            if (cell == null) {
                cell = row.createCell(colnum);
            }
            cell.setCellValue(text);

            XSSFCellStyle style = (XSSFCellStyle) wb.createCellStyle();
            if (text == "pass" || text == "passed" || text == "Pass" || text == "Passed") {
                style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
            } else {
                style.setFillForegroundColor(IndexedColors.RED.getIndex());
            }
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            style.setAlignment(HorizontalAlignment.CENTER);
            style.setVerticalAlignment(VerticalAlignment.CENTER);

            cell.setCellStyle(style);

            fileOut = new FileOutputStream(excelFilePath);
            wb.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
