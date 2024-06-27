package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    @DataProvider(name = "excelData_Brand")
    public Object[][] readExcel() throws IOException {
        return readExcel("src/test/resources/Data Set/Data test for API .xlsx", "Brand Management"); // Đọc từ sheet có tên "Sheet1"
    }

    public Object[][] readExcel(String filePath, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            workbook.close();
            file.close();
            throw new IllegalArgumentException("Sheet " + sheetName + " does not exist");
        }

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                if (row.getCell(j) != null) {
                    data[i - 1][j] = row.getCell(j).toString();
                } else {
                    data[i - 1][j] = "";
                }
            }
        }

        workbook.close();
        file.close();

        return data;
    }
}
