package web.pages;

import org.openqa.selenium.WebElement;
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

    /**
     * trait
     * The 'trait' is a selector for a given page, which is unique to that page.
     * This is a handy method for asserting whether or not the driver is on the correct page.
     */
    public void trait() {
    }

    /**
     * getElement
     * Method used to return an element for a given page.
     *
     * @param element - the name of the element as a string
     * @return WebElement - the selenium web element object
     */
    public WebElement getElement(String element) {
        return null;
    }
}
