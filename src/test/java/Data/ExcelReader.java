package Data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    static FileInputStream fileInputStream = null;

    public FileInputStream getFileInputStream() {
        String filePath = "src\\test\\java\\data\\UserData.xlsx";
        File srcFile = new File(filePath);
        try {
            fileInputStream = new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            System.out.println("test data file not found check file path of test data" + e.getMessage());
        }
        return fileInputStream;
    }

    public Object[][] getExcelData() throws IOException {
        fileInputStream = getFileInputStream();

        XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workBook.getSheetAt(0);
        int totalNumberOfRows = (sheet.getLastRowNum() + 1);
        int totalNumberOfCols = 1;
        String[][] excelDataArray = new String[totalNumberOfRows][totalNumberOfCols];
        for (int i = 0; i < totalNumberOfRows; i++) {
            for (int j = 0; j < totalNumberOfCols; j++) {
                XSSFRow row = sheet.getRow(i);
                excelDataArray[i][j] = row.getCell(j).toString();
            }
        }
        workBook.close();
        return excelDataArray;
    }
}
