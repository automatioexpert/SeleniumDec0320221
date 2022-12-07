package org.wego.dataprovider;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExcelHelper {


    public static String[][] getDataFromExcel(String path, String sheetName, String testCase) {
        String[][] data;

        try {
            Workbook workbook = WorkbookFactory.create(Files.newInputStream(Paths.get(path)));
            Sheet sheet = workbook.getSheet(sheetName);
            System.out.println("Workbook Sheet: " + sheetName);
            int startRow, startCol, endRow, endCol;
            Cell firstCell = getCellByValue(sheet, 0, 0, testCase);
            startRow = firstCell.getRowIndex();
            startCol = firstCell.getColumnIndex();
            Cell lastCell = getCellByValue(sheet, startRow, startCol + 1, testCase);
            endRow = lastCell.getRowIndex();
            endCol = lastCell.getColumnIndex();
            System.out.println("startRow - " + startRow);
            System.out.println("startCol - " + startCol);
            System.out.println("endRow - " + endRow);
            System.out.println("endCol - " + endCol);
            data = getTable(sheet, startRow, endRow, startCol, endCol);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return data;
    }

    public static String[][] getTable(Sheet sheet, int startRow, int endRow, int startCol, int endCol) {
        String[][] table = new String[endRow - startRow + 1][endCol - startCol - 1];
        int cj, ci;
        ci = 0;
        for (int i = startRow; i < endRow + 1; i++, ci++) {
            cj = 0;
            for (int j = startCol + 1; j < endCol; j++, cj++) {
                Cell cell = sheet.getRow(i).getCell(j);
                String tempData = null;
                if (cell != null && cell.getCellType() == CellType.STRING) {
                    tempData = cell.getStringCellValue();
                } else if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    tempData = NumberToTextConverter.toText(cell.getNumericCellValue());
                }
                table[ci][cj] = tempData;
            }
        }
        return table;
    }

    public static Cell getCellByValue(Sheet sheet, int startRow, int startCol, String value) {
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        Cell res = null;
        for (int i = startRow; i <= rowCount; i++) {
            //get cell count in a row
            int cellCount = sheet.getRow(i).getLastCellNum();
            //iterate over each cell compare the Value
            for (int j = startCol; j < cellCount; j++) {
                Cell cell = sheet.getRow(i).getCell(j);
                if (cell != null && cell.getCellType() == CellType.STRING) {
                    if (cell.getStringCellValue().equals(value)) {
                        return cell;
                    }
                }
            }
        }

        System.out.println("Test Case name not found in sheet:" + value);
        return res;
    }

}
