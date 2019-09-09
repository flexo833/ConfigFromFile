import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckIsVisible extends Assert {
    @Before
        public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\test\\chromedriver.exe");


    }
    @After
    public void TearDown(){

    }


    @Test
    public void CheckIsElementVisible(){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            XSSFWorkbook workbook = ActionReader.readExcel();
            XSSFSheet sheet = workbook.getSheetAt(0);
            List<String> actions = ActionReader.getActionsFromExcel(sheet);//Create list with actions
            List<String> params = ActionReader.getParamsFromExcel(sheet);//Create list with parameters


            Step step = new Step();
            for (int i = 1; i < actions.size(); i++) {        //run scrypt
                step.runStep(actions.get(i), params.get(i), driver, wait);

            }
            Assert.assertTrue(driver.findElement(By.xpath("//a[@class='navbar-brand ']")).isDisplayed());
            driver.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
