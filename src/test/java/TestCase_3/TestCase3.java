package TestCase_3;

import Data.LoadProperties;
import Driver.DriverSetup;
import commonUtils.CommonHelper;
import commonUtils.RandomSource;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testCase3.TestCase3Helper;

public class TestCase3 {

    String URL = LoadProperties.useData.getProperty("URL");
    String browser = LoadProperties.useData.getProperty("Browser");
    TestCase3Helper testCase3Helper = null;
    WebDriver driver = null;


    @BeforeTest()
    void initiate() {
        DriverSetup.driverConf(browser);
        driver = DriverSetup.getDriver();
        driver.manage().window().maximize();
        testCase3Helper = new TestCase3Helper(driver);
    }

    @Test(priority = 1)
    void validateJoinUpPageIsOpened() {
        CommonHelper.openWebPage(URL, driver);
        testCase3Helper.clickCareersTab(driver);
        testCase3Helper.clickCheckOurOpenPositions(driver);
        testCase3Helper.verifyJoinUsPage(driver);
    }

    @Test(priority = 2, dependsOnMethods = {"validateJoinUpPageIsOpened"})
    void validateJoinUsURL() {
        testCase3Helper.assertJoinUsUrl(driver);
    }

    @Test(priority = 3, dependsOnMethods = {"validateJoinUsURL"})
    void verifyPageMainSectionsAppear() {
        testCase3Helper.choseFromDropDown(driver);
        testCase3Helper.clickExperiencedAutomationQAEngineer(driver);
        testCase3Helper.verifyPageTitles(driver);
    }

    @Test(priority = 4, dependsOnMethods = {"verifyPageMainSectionsAppear"})
    void verifyApplyButtonAppears() {
        testCase3Helper.verifyApplyButtonAppears(driver);
    }

    @Test(priority = 5, dependsOnMethods = {"verifyApplyButtonAppears"})
    void verifyPopUpErrorMessageAppears() {
        testCase3Helper.clickApplyButton(driver);
        testCase3Helper.enterInvalidEmail(driver, RandomSource.generateRandomString(5));
        testCase3Helper.uploadYourCv(driver);
        testCase3Helper.clickSendButton(driver);
        testCase3Helper.verifyPopUpErrorMessage(driver);
    }


    @Test(priority = 6, dependsOnMethods = {"verifyPopUpErrorMessageAppears"})
    void validateFieldsErrorMessageAppears() {
        testCase3Helper.clickCloseButton(driver);
        testCase3Helper.validateFieldsError(driver);
    }


    @AfterTest()
    void closure() {
        driver.close();
    }
}
