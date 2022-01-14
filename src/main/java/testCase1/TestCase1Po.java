package testCase1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCase1Po {
    @FindBy(css = ".contact-label.btn.btn-1b")
    WebElement contactUsButton;

    @FindBy(name = "your-name")
    WebElement nameField;

    @FindBy(name = "your-email")
    WebElement emailField;

    @FindBy(name = "mobile-number")
    WebElement mobileField;

    @FindBy(name = "your-subject")
    WebElement subjectField;

    @FindBy(name = "your-message")
    WebElement messageField;

    @FindBy(className = "recaptcha-checkbox-border")
    WebElement recaptchaBox;

    @FindBy(xpath = "//input[@type='submit' and @value='Send']")
    WebElement sendButton;

    @FindBy(xpath = "//span[text()='The e-mail address entered is invalid.']")
    WebElement emailErrorMessage;

}
