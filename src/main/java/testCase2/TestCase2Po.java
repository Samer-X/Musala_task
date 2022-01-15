package testCase2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class TestCase2Po {
    @FindBy(xpath = "//div[@id='menu']//a[text()='Company']")
    WebElement companyMenuButton;

    @FindBy(xpath = "//h2[text()='Leadership']")
    WebElement leaderShipTitle;

    @FindBy(css = ".musala.musala-icon-facebook")
    WebElement facebookLink;

    @FindAll({
            @FindBy(xpath = "//div[@aria-label='Page profile photo']"),
            @FindBy(xpath = "//a[@aria-label='Musala Soft profile photo']")
    })
    WebElement facebookProfilePicture;


}
