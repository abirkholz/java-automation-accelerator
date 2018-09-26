package web.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class FindCarePage extends PageObject {
    private RemoteWebDriver driver;

    public FindCarePage(RemoteWebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        trait();
    }

    @Override
    public void trait() {
        Assert.assertTrue("FindCarePage was not displayed.", pageTrait.isDisplayed());
    }

    @Override
    public WebElement getElement(String element) {

        switch (element.toUpperCase()) {
            case "CALL_BUTTON":
                return callButton;
            default:
                throw new IllegalArgumentException(
                        String.format("Could not get element by name: %s. Is it implemented?", element)
                );
        }
    }

    // * * * * * * * * * * * * * * * * SELECTORS * * * * * * * * * * * * * * * * //
    @FindBy(how = How.LINK_TEXT, using = "Schedule online")
    public static WebElement pageTrait;

    @FindBy(how = How.LINK_TEXT, using = "Call 952-967-7676")
    public static WebElement callButton;

}
