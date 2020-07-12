import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestExcelInput {
    public static void main(String[] args) {
        try (InputStream inp = new FileInputStream("E:\\workspace\\web-jwglxt\\src\\main\\java\\成绩单.xls")) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();
            for (int j = 3; j <= rowNum; j++) {
                Row row = sheet.getRow(j);
                for (int i = row.getFirstCellNum(); i <= 3; i++) {
                    Cell cell = row.getCell(i);
                    if (cell.getCellType() == CellType.NUMERIC) {
                        System.out.print(cell.getNumericCellValue() + " ");
                    } else {
                        System.out.print(cell.getStringCellValue() + " ");
                    }
                    if (i == 3) System.out.println(" ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
