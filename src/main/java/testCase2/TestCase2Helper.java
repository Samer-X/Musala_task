package testCase2;

import commonUtils.CommonHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TestCase2Helper extends TestCase2Po {

    WebDriver driver;
    TestCase2Constants testCase2Constants = new TestCase2Constants();

    public TestCase2Helper(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickCompanyTab(WebDriver driver) {
        CommonHelper.clickWhenReady(companyMenuButton, driver);
    }

    public void verifyLeadershipSection() {
        CommonHelper.verifyElementAppears(leaderShipTitle, driver);
    }

    public void clickFacebookLink(WebDriver driver) {
        CommonHelper.scrollToElement(facebookLink, driver);
        CommonHelper.clickWhenReady(facebookLink, driver);
    }


    public void assertCompanyUrl(WebDriver driver) {
        Assert.assertEquals(CommonHelper.getPageUrl(driver), testCase2Constants.companyUrl);
    }

    public void assertFacebookUrl(WebDriver driver) {
        Assert.assertEquals(CommonHelper.getPageUrl(driver), testCase2Constants.facebookUrl);
    }

    public void assertFacebookProfilePicture(WebDriver driver) {
        CommonHelper.verifyElementAppears(facebookProfilePicture, driver);
    }


    public void switchToOpenedTab(WebDriver driver) {
        CommonHelper.switchToOpenedTab(driver);
    }
}

