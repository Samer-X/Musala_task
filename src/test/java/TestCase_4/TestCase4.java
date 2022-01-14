package TestCase_4;

import Data.LoadProperties;
import Driver.DriverSetup;
import commonUtils.CommonHelper;
import commonUtils.RandomSource;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testCase3.TestCase3Helper;
import testCase4.TestCase4Helper;

public class TestCase4 extends DriverSetup {

    String URL = LoadProperties.useData.getProperty("URL");
    String browser = LoadProperties.useData.getProperty("Browser");
    TestCase4Helper testCase4Helper = null;


    @BeforeTest()
    void initiate() {
        testCase4Helper = new TestCase4Helper(driver);
    }

    @Test(priority = 1)
    void getSofiaCityOpenPositions() {
        CommonHelper.openWebPage(URL, driver);
        testCase4Helper.clickCareersTab(driver);
        testCase4Helper.clickCheckOurOpenPositions(driver);
        testCase4Helper.getCityTitlesAndLinks(driver,"Sofia");
    }

    @Test(priority = 2, dependsOnMethods = {"getSofiaCityOpenPositions"})
    void getSkopjeCityOpenPositions() {
        testCase4Helper.getCityTitlesAndLinks(driver,"Skopje");
    }

    @AfterTest()
    void closure() {
        driver.quit();
    }
}
