package DataUtility;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtilities {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelUtilities(String excelPath, String sheetName) {

        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet=workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getCelldata(int rowNum, int colNum){
        DataFormatter formatter = new DataFormatter();
        Object valueofCell = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));


        return valueofCell;
    }
}
