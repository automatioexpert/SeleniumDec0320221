package org.qa.sharif.commonutils;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import java.io.File;

public class ExcelHelper {


    public static String[][] getTableArray(String filePath, String sheetName, String tableName) {

        String[][] tabArray = null;
        try {
            System.out.println("file path - " + filePath);
            System.out.println("Sheet_name - " + sheetName);
            Workbook workbook = Workbook.getWorkbook(new File(filePath));
            Sheet sheet = workbook.getSheet(sheetName);
            int startRow, startCol, endRow, endCol, ci, cj;
            Cell tableStart = sheet.findCell(tableName);
            startRow = tableStart.getRow();
            startCol = tableStart.getColumn();
            System.out.println("startRow - " + startRow);
            System.out.println("startCol - " + startCol);
            Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow, 100, 64000, false);
            endRow = tableEnd.getRow();
            endCol = tableEnd.getColumn();
            tabArray = new String[endRow - startRow + 1][endCol - startCol - 1];
            ci = 0;

            for (int i = startRow; i < endRow + 1; i++, ci++) {
                cj = 0;
                for (int j = startCol + 1; j < endCol; j++, cj++) {
                    tabArray[ci][cj] = sheet.getCell(j, i).getContents();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in getTableArray()" + e.getMessage());
        }

        return (tabArray);
    }


}
