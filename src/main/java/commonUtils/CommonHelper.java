package commonUtils;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class CommonHelper {


    public static void openWebPage(String url,WebDriver driver) {
        driver.navigate().to(url);
    }


    public static void waitUntilElementAppears(WebElement po,WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(po));
    }

    public static void clickWhenReady(WebElement po,WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(po)).click();
    }

    public static void verifyElementAppears(WebElement Po,WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(Po));
    }

    public static void sendText(WebElement po, String Text,WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(po)).sendKeys(Text);
    }

    public static void selectFromDropDownByText(WebElement po, String text,WebDriver driver) {
        Select options = new Select(po);
        options.selectByVisibleText(text);
    }

    public static void takeSnapShot(String screenshotName,WebDriver driver) {
        Allure.addAttachment(screenshotName, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    public static void scrollToElement(WebElement po,WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", po);
    }


    public static String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public static void switchToOpenedTab(WebDriver driver) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }


    public static void uploadFile(WebElement po,WebDriver driver) {
        String fileName = "pdfTest.pdf";
        String filePath = System.getProperty("user.dir") + "/Uploads/" + fileName;
        po.sendKeys(filePath);
    }

    public static void clickUsingJS(WebElement po,WebDriver driver) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", po);
    }
}