import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class Main {
    public enum Action {
        openUrl("openUrl"),
        click("Click"),
        setValue("setValue"),
        screenshot("Screenshot");


        private String action;

        Action(String action) {
            this.action = action;
        }

        public String getAction() {
            return action;
        }
    }


    public static void main(String[] args) throws IOException {


        System.setProperty("webdriver.chrome.driver", "C:\\test\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        FileInputStream file = new FileInputStream(new File("C:\\test\\file.xlsx"));

        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);


        XSSFRow row1 = sheet.getRow(1);
        XSSFRow row2 = sheet.getRow(2);
        XSSFRow row3 = sheet.getRow(3);
        XSSFRow row4 = sheet.getRow(4);
        XSSFRow row5 = sheet.getRow(5);
        XSSFRow row6 = sheet.getRow(6);


        String action1 = row1.getCell(0).getStringCellValue();
        String param1 = row1.getCell(1).getStringCellValue();

        String action2 = row2.getCell(0).getStringCellValue();
        String param2 = row2.getCell(1).getStringCellValue();

        String action3 = row3.getCell(0).getStringCellValue();
        String param3 = row3.getCell(1).getStringCellValue();

        String action4 = row4.getCell(0).getStringCellValue();
        String param4 = row4.getCell(1).getStringCellValue();

        String action5 = row5.getCell(0).getStringCellValue();
        String param5 = row5.getCell(1).getStringCellValue();

        String action6 = row6.getCell(0).getStringCellValue();
        String param6 = row6.getCell(1).getStringCellValue();

//Step 1
        if (action1.equals(Action.openUrl.getAction())) {
            driver.get(param1);
            driver.manage().window().maximize();

        }


//Step 2
        if (action2.equals(Action.click.getAction())) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(param2)));
            driver.findElement(By.xpath(param2)).click();
        }

//Step 3


        if (action3.equals(Action.setValue.getAction())) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(param3)));
            driver.findElement(By.xpath(param3)).sendKeys(param3);
        } else {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(param3)));
            driver.findElement(By.xpath(param3)).click();
        }


        //Step 4
        if (action4.equals(Action.setValue.getAction())) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(param3)));
            driver.findElement(By.xpath(param4)).sendKeys(param4);
        }
        if (action4.equals(Action.screenshot.getAction())) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        } else {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(param4)));
            driver.findElement(By.xpath(param4)).click();
        }

        //Step 5

        if (action4.equals(Action.setValue.getAction())) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(param5)));
            driver.findElement(By.xpath(param5)).sendKeys(param5);
        }
        if (action4.equals(Action.screenshot.getAction())) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        } else {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(param5)));
            boolean isDisplay = driver.findElement(By.xpath(param5)).isDisplayed();
            driver.findElement(By.xpath(param5)).click();
        }
        //Step 6

        if (action4.equals(Action.setValue.getAction())) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(param6)));
            driver.findElement(By.xpath(param6)).sendKeys(param6);
        }
        if (action4.equals(Action.screenshot.getAction())) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        } else {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(param6)));
            driver.findElement(By.xpath(param6)).click();

        }


    }
}
