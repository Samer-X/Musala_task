package TestCase_2;

import Data.LoadProperties;
import Driver.DriverSetup;
import commonUtils.CommonHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testCase2.TestCase2Helper;

public class TestCase2 {

    String URL = LoadProperties.useData.getProperty("URL");
    String browser = LoadProperties.useData.getProperty("Browser");
    TestCase2Helper testCase2Helper = null;
    WebDriver driver = null;


    @BeforeTest()
    void initiate() {
        DriverSetup.driverConf(browser);
        driver = DriverSetup.getDriver();
        driver.manage().window().maximize();
        testCase2Helper = new TestCase2Helper(driver);
    }

    @Test(priority = 1)
    void validateCompanyUrl() {
        CommonHelper.openWebPage(URL, driver);
        testCase2Helper.clickCompanyTab(driver);
        testCase2Helper.assertCompanyUrl(driver);
    }

    @Test(priority = 2, dependsOnMethods = {"validateCompanyUrl"})
    void validateFaceBookURL() {
        testCase2Helper.clickFacebookLink(driver);
        testCase2Helper.switchToOpenedTab(driver);
        testCase2Helper.assertFacebookUrl(driver);
    }

    @Test(priority = 3, dependsOnMethods = {"validateFaceBookURL"})
    void validateFaceBookProfilePicture() {
        testCase2Helper.assertFacebookProfilePicture(driver);
    }


    @AfterTest()
    void closure() {
        driver.close();
    }
}
