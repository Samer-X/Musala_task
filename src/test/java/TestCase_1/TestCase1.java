package TestCase_1;

import Data.ExcelReader;
import Data.LoadProperties;
import Driver.DriverSetup;
import commonUtils.CommonHelper;
import commonUtils.RandomSource;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import testCase1.TestCase1Helper;

import java.io.IOException;

public class TestCase1 {

    String URL = LoadProperties.useData.getProperty("URL");
    String browser = LoadProperties.useData.getProperty("Browser");
    TestCase1Helper testCase1Helper = null;
    WebDriver driver = null;




    @BeforeTest()
    void initiate() {
        DriverSetup.driverConf(browser);
        driver = DriverSetup.getDriver();
        driver.manage().window().maximize();
        testCase1Helper = new TestCase1Helper(driver);
    }

    @DataProvider(name = "ExcelData")
    public Object[][] userRegistrationData() throws IOException {
        ExcelReader excelReader = new ExcelReader();
        return excelReader.getExcelData();
    }

    @Test(priority = 1, alwaysRun = true, dataProvider = "ExcelData")
    void validateEmailErrorMessage(String email) {
        CommonHelper.openWebPage(URL, driver);
        testCase1Helper.clickContactUsButton(driver);
        testCase1Helper.enterContactUsPageDetails(driver, RandomSource.generateRandomString(5), email,
                RandomSource.generateRandomNumber(11),
                RandomSource.generateRandomString(5),
                RandomSource.generateRandomString(10));

        testCase1Helper.validateEmailErrorMessageAppears(driver);
    }

    @AfterTest()
    void closure() {
        driver.close();
    }
}
