import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class Main {


    public static void main(String[] args) {


        try {
            XSSFWorkbook workbook = ActionReader.readExcel();
            XSSFSheet sheet = workbook.getSheetAt(0);
            List<String> actions = ActionReader.getActionsFromExcel(sheet);//Create list with actions
            List<String> params = ActionReader.getParamsFromExcel(sheet);//Create list with parameters


            Step step = new Step();
            System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, 10);


            for (int i = 1; i < actions.size(); i++) {        //run scrypt
                step.runStep(actions.get(i), params.get(i), driver, wait);

            }
            driver.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
