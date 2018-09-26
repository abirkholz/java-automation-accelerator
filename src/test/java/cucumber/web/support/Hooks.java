package cucumber.web.support;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.DriverFactory;
import driver.DriverType;
import org.openqa.selenium.remote.RemoteWebDriver;

import static config.Constants.DEFAULT_WEB_URL;
import static driver.DriverType.CHROME;
import static driver.DriverType.FIREFOX;

public class Hooks extends CucumberWebTestRunner {

    private static boolean isSetup = false;
    private DriverType browser = CHROME;
    public static DriverFactory factory;

    @Before(order = 1)
    public void beforeAll() {
        if (!isSetup) {
            factory = new DriverFactory();
        }
    }

    @Before(order = 2)
    public void beforeScenario() throws Exception {
        factory.createDriver(browser);
        factory.getDriver().get(DEFAULT_WEB_URL);
    }

    @After(order = 1)
    public void afterAll(Scenario scenario) {

    }

    @After(order = 2)
    public void afterScenario(Scenario scenario) {
        factory.quitDriver();
    }
}
