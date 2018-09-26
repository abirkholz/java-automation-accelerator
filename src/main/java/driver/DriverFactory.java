package driver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
    private RemoteWebDriver driver;
    private DriverType selectedDriverType;

    /**
     * Set config variable from env or system props.
     */
    private final String operatingSystem = System.getProperty("os.name").toUpperCase();
    private final String systemArchitecture = System.getProperty("os.arch");

    public DriverFactory() {
        DriverType driverType = DriverType.CHROME;
        String platform = System.getProperty("platform", String.valueOf(driverType)).toUpperCase();

        try {
            driverType = DriverType.valueOf(platform);
        } catch (Exception e) {
            System.err.println(String.format("Error setting driver type '%s', defaulting to CHROME driver...", platform));
        }

        selectedDriverType = driverType;
    }

    public void createDriver(DriverType driverType) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        driver = driverType.getDriverObject(desiredCapabilities);
    }

    public RemoteWebDriver getDriver() throws Exception {
        if (driver == null) createDriver(selectedDriverType);
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
