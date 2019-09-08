import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static repackage.Repackage.copyFile;


public class Step {


    public Step() {

    }

    public void runStep(String action, String param, WebDriver driver, WebDriverWait wait) throws Exception {
        boolean verify = verifyActionIsValid(action);
        if (verify) {


            if (action.equals(Actions.Action.openUrl.getAction())) {
                driver.get(param);
            }

            if (action.equals(Actions.Action.Click.getAction())) {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(param)));
                verifyElementIsVisible(driver, param);
                driver.findElement(By.xpath(param)).click();

            }
            if (action.equals(Actions.Action.SetValue.getAction())) {
                String[] parts = param.split("%");
                String part1 = parts[0]; // Xpath
                String part2 = parts[1]; // Text Value
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(part1)));
                driver.findElement(By.xpath(part1)).sendKeys(part2);

            }
            if (action.equals((Actions.Action.ClickEnter).getAction())) {
                driver.findElement(By.xpath(param)).sendKeys(Keys.ENTER);
            }
            if (action.equals(Actions.Action.Screenshot)) {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(scrFile, new File("c:\\test\\screenshot.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } else throw new Exception("Action is not valid");

    }


    public static void verifyElementIsVisible(WebDriver driver, String param) {

        boolean b = driver.findElement(By.xpath(param)).isDisplayed();
        System.out.println(b);
    }

    public boolean verifyActionIsValid(String action) {


        if (action.equals(Actions.Action.openUrl.getAction())) {
            return true;
        } else if (action.equals(Actions.Action.Click.getAction())) {
            return true;
        } else if (action.equals(Actions.Action.SetValue.getAction())) {
            return true;
        } else if (action.equals(Actions.Action.Screenshot.getAction())) {
            return true;
        } else if (action.equals(Actions.Action.ClickEnter.getAction())) {
            return true;
        }

        return false;
    }
}
