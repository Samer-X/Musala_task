package testCase1;

import commonUtils.CommonHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestCase1Helper extends TestCase1Po {

    public TestCase1Helper(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickContactUsButton(WebDriver driver) {
        CommonHelper.scrollToElement(contactUsButton, driver);
        CommonHelper.clickUsingJS(contactUsButton, driver);
    }

    public void enterName(WebDriver driver, String firstName) {
        CommonHelper.sendText(nameField, firstName, driver);
    }

    public void enterEmail(WebDriver driver, String email) {
        CommonHelper.sendText(emailField, email, driver);
    }


    public void enterMobile(WebDriver driver, String mobileNumber) {
        CommonHelper.sendText(mobileField, mobileNumber, driver);
    }

    public void enterSubject(WebDriver driver, String subject) {
        CommonHelper.sendText(subjectField, subject, driver);
    }

    public void enterMessage(WebDriver driver, String message) {
        CommonHelper.sendText(messageField, message, driver);
    }

    public void clickSendButton(WebDriver driver) {
        CommonHelper.clickWhenReady(sendButton, driver);
    }


    public void enterContactUsPageDetails(WebDriver driver, String name, String email, String mobileNumber, String subject, String message) {
        this.enterName(driver, name);
        this.enterEmail(driver, email);
        this.enterMobile(driver, mobileNumber);
        this.enterSubject(driver, subject);
        this.enterMessage(driver, message);
        this.clickSendButton(driver);
    }

    public void validateEmailErrorMessageAppears(WebDriver driver) {
        CommonHelper.verifyElementAppears(emailErrorMessage, driver);
    }
}

