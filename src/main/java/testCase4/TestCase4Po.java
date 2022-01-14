package testCase4;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TestCase4Po {
    @FindBy(xpath = "//div[@id='menu']//a[text()='Careers']")
    WebElement careersMenuButton;

    @FindBy(xpath = "//span[@data-alt='Check our open positions']")
    WebElement checkOurOpenPositions;

    @FindBy(xpath = "//img[@alt='Join Us']")
    WebElement joinUsImage;

    @FindBy(id = "get_location")
    WebElement getLocationDropDown;

    @FindBy(css = ".card-jobsHot__title")
    List <WebElement> openPositionsTitleList;

    @FindBy(css = ".card-jobsHot__link")
    List <WebElement> openPositionsLinksList;


}
