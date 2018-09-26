package web.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends PageObject {
    private RemoteWebDriver driver;

    public HomePage(RemoteWebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        trait();
    }

    @Override
    public void trait() {
        Assert.assertTrue("HomePage was not displayed.", pageTrait.isDisplayed());
    }

    @Override
    public WebElement getElement(String element) {

        switch (element.toUpperCase()) {
            case "FIND_CARE_BUTTON":
                return findCareButton;
            default:
                throw new IllegalArgumentException(
                        String.format("Could not get element by name: %s. Is it implemented?", element)
                );
        }
    }

    // * * * * * * * * * * * * * * * *  SELECTORS * * * * * * * * * * * * * * * * //
    @FindBy(how = How.CLASS_NAME, using = "logon-box")
    public static WebElement pageTrait;

    @FindBy(how = How.LINK_TEXT, using = "Find care")
    public static WebElement findCareButton;

    @FindBy(how = How.CSS, using = "div[class='someElement2']")
    public static WebElement someElement2;
}
