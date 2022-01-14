package TestCase_2;

import Data.LoadProperties;
import Driver.DriverSetup;
import commonUtils.CommonHelper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import testCase2.TestCase2Helper;

public class TestCase2 extends DriverSetup {

    String URL = LoadProperties.useData.getProperty("URL");
    TestCase2Helper testCase2Helper = null;

    @BeforeSuite()
    void initiate() {
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
