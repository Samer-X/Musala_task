package testCase3;

import commonUtils.CommonHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class TestCase3Helper extends TestCase3Po {
    TestCase3Constants testCase3Constants = null;

    public TestCase3Helper(WebDriver driver) {
        PageFactory.initElements(driver, this);
        testCase3Constants = new TestCase3Constants();
    }

    public void clickCareersTab(WebDriver driver) {
        CommonHelper.clickWhenReady(careersMenuButton, driver);
    }

    public void clickCheckOurOpenPositions(WebDriver driver) {
        CommonHelper.clickWhenReady(checkOurOpenPositions, driver);
    }

    public void verifyJoinUsPage(WebDriver driver) {
        CommonHelper.verifyElementAppears(joinUsImage, driver);
    }

    public void assertJoinUsUrl(WebDriver driver) {
        Assert.assertEquals(CommonHelper.getPageUrl(driver), testCase3Constants.joinUsUrl);
    }

    public void choseFromDropDown(WebDriver driver) {
        CommonHelper.selectFromDropDownByText(getLocationDropDown, testCase3Constants.anyWhere, driver);
    }

    public void clickExperiencedAutomationQAEngineer(WebDriver driver) {
        CommonHelper.scrollToElement(experiencedQA, driver);
        CommonHelper.clickWhenReady(experiencedQA, driver);
    }

    public void verifyPageTitles(WebDriver driver) {
        CommonHelper.verifyElementAppears(generalDescriptionTitle, driver);
        CommonHelper.verifyElementAppears(requirementsTitle, driver);
        CommonHelper.verifyElementAppears(responsibilitiesTitle, driver);
        CommonHelper.verifyElementAppears(whatWeOfferTitle, driver);
    }

    public void verifyApplyButtonAppears(WebDriver driver) {
        CommonHelper.scrollToElement(applyButton, driver);
        CommonHelper.verifyElementAppears(applyButton, driver);
    }

    public void clickApplyButton(WebDriver driver) {
        CommonHelper.clickUsingJS(applyButton, driver);
    }


    public void enterInvalidEmail(WebDriver driver,String email) {
        CommonHelper.sendText(emailField, email, driver);
    }

    public void clickSendButton(WebDriver driver) {
        CommonHelper.clickUsingJS(sendButton, driver);
    }

    public void verifyPopUpErrorMessage(WebDriver driver) {
        CommonHelper.verifyElementAppears(mandatoryFieldsErrorMessage, driver);
    }

    public void verifyNameFieldErrorMessage(WebDriver driver) {
        CommonHelper.verifyElementAppears(nameFieldErrorMessage, driver);
    }

    public void verifyMobileFieldErrorMessage(WebDriver driver) {
        CommonHelper.verifyElementAppears(mobileFieldErrorMessage, driver);
    }

    public void verifyEmailFieldErrorMessage(WebDriver driver) {
        CommonHelper.verifyElementAppears(emailFieldErrorMessage, driver);
    }

    public void clickCloseButton(WebDriver driver) {
        CommonHelper.clickUsingJS(closeButton, driver);
    }

    public void uploadYourCv(WebDriver driver) {
        CommonHelper.uploadFile(uploadYourCvField, driver);
    }

    public void validateFieldsError(WebDriver driver) {
        this.verifyEmailFieldErrorMessage(driver);
        this.verifyNameFieldErrorMessage(driver);
        this.verifyMobileFieldErrorMessage(driver);
    }

}

