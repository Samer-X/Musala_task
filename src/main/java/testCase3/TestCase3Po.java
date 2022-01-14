package testCase3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCase3Po {
    @FindBy(xpath = "//div[@id='menu']//a[text()='Careers']")
    WebElement careersMenuButton;

    @FindBy(xpath = "//span[@data-alt='Check our open positions']")
    WebElement checkOurOpenPositions;

    @FindBy(xpath = "//img[@alt='Join Us']")
    WebElement joinUsImage;

    @FindBy(id = "get_location")
    WebElement getLocationDropDown;

    @FindBy(xpath = "//h2[text()='Experienced Automation QA Engineer']")
    WebElement experiencedQA;


    @FindBy(xpath = "//h2[text()='General description']")
    WebElement generalDescriptionTitle;

    @FindBy(xpath = "//h2[text()='Requirements']")
    WebElement requirementsTitle;

    @FindBy(xpath = "//h2[text()='Responsibilities']")
    WebElement responsibilitiesTitle;

    @FindBy(xpath = "//h2[text()='What we offer']")
    WebElement whatWeOfferTitle;

    @FindBy(xpath = "//div[@class='btn-apply-container']/a/input")
    WebElement applyButton;

    @FindBy(name = "your-name")
    WebElement nameField;

    @FindBy(name = "your-email")
    WebElement emailField;

    @FindBy(name = "mobile-number")
    WebElement mobileField;

    @FindBy(xpath = "//input[@type='file']")
    WebElement uploadYourCvField;

    @FindBy(xpath = "//input[@type='submit' and @value='Send']")
    WebElement sendButton;

    @FindBy(xpath = "//button[text()='Close']")
    WebElement closeButton;

    @FindBy(xpath = "//div[text()='One or more fields have an error. Please check and try again.']")
    WebElement mandatoryFieldsErrorMessage;

    @FindBy(xpath = "//input[@name='your-name']/following-sibling::span[text()='The field is required.']")
    WebElement nameFieldErrorMessage;

    @FindBy(xpath = "//input[@name='mobile-number']/following-sibling::span[text()='The field is required.']")
    WebElement mobileFieldErrorMessage;

    @FindBy(xpath = "//span[text()='The e-mail address entered is invalid.']")
    WebElement emailFieldErrorMessage;
}
