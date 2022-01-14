package testCase4;

import commonUtils.CommonHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import testCase3.TestCase3Constants;
import testCase3.TestCase3Po;

import java.util.ArrayList;


public class TestCase4Helper extends TestCase4Po {
    ArrayList<String> outPutTitles = null;
    ArrayList<String> outPutLinks = null;
    TestCase4Constants testCase4Constants;

    public TestCase4Helper(WebDriver driver) {
        PageFactory.initElements(driver, this);
        outPutTitles = new ArrayList<String>();
        outPutLinks = new ArrayList<String>();
        testCase4Constants = new TestCase4Constants();
    }

    public void clickCareersTab(WebDriver driver) {
        CommonHelper.clickWhenReady(careersMenuButton, driver);
    }

    public void clickCheckOurOpenPositions(WebDriver driver) {
        CommonHelper.clickWhenReady(checkOurOpenPositions, driver);
    }

    public void getCityTitlesAndLinks(WebDriver driver,String city) {
        CommonHelper.selectFromDropDownByText(getLocationDropDown, city, driver);
        System.out.println(city);
        CommonHelper.waitUntilElementAppears(joinUsImage, driver);
        for (int count = 0; count < openPositionsTitleList.size(); count++) {
            outPutTitles.add(openPositionsTitleList.get(count).getText());
            outPutLinks.add(openPositionsLinksList.get(count).getAttribute("href"));
            System.out.println("Position : " + outPutTitles.get(count));
            System.out.println("More Info : " + outPutLinks.get(count));
        }
        System.out.println("-----------------------------------------");

    }

}

