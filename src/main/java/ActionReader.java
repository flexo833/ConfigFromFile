import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

class ActionReader {


    static XSSFWorkbook readExcel() {
        XSSFWorkbook workbook = null;
        try {
            FileInputStream file = new FileInputStream(new File("src/resources/file.xlsx"));
            workbook = new XSSFWorkbook(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workbook;
    }

    static List<String> getActionsFromExcel(final Sheet sheet) {
        List<String> action = new ArrayList<String>();

        for (Row r : sheet) {
            Cell c = r.getCell(0);
            if (c != null) {
                if (c.getCellType() == Cell.CELL_TYPE_STRING) {
                    action.add(c.getStringCellValue());
                } else
                    System.out.println("false");
            }
        }
        return action;
    }

    static List<String> getParamsFromExcel(final Sheet sheet) {
        List<String> params = new ArrayList<String>();

        for (Row r : sheet) {
            Cell c = r.getCell(1);
            if (c != null) {
                if (c.getCellType() == Cell.CELL_TYPE_STRING) {
                    params.add(c.getStringCellValue());
                } else
                    System.out.println("false");
            }
        }
        return params;
    }


}
