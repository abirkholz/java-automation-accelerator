package web.pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * The core page object from which all other pages extend.
 * Only put methods in this class if they are applicable to all pages.
 */
public class PageObject {
    private RemoteWebDriver driver;

    public PageObject(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

}
