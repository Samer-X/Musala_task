package TestCase_1;

import Data.ExcelReader;
import Data.LoadProperties;
import Driver.DriverSetup;
import commonUtils.CommonHelper;
import commonUtils.RandomSource;
import org.testng.annotations.*;
import testCase1.TestCase1Helper;

import java.io.IOException;

public class TestCase1 extends DriverSetup {

    String URL = LoadProperties.useData.getProperty("URL");
    TestCase1Helper testCase1Helper = null;


    @BeforeSuite()
    void initiate() {
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
        testCase1Helper.enterContactUsPageDetails(driver,RandomSource.generateRandomString(5), email,
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
