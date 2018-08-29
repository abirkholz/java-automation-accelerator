package driver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
    private RemoteWebDriver driver;
    private DriverType selectedDriverType;

    private final String operatingSystem = System.getProperty("os.name").toUpperCase();
    private final String systemArchitecture = System.getProperty("os.arch");

    public DriverFactory(){
        DriverType driverType = DriverType.FIREFOX;
        String platform = System.getProperty("platform", String.valueOf(driverType)).toUpperCase();

        try {
            driverType = DriverType.valueOf(platform);
        } catch (Exception e) {
            System.err.println("Unknown driver error, defaulting to '" + driverType + "'...");
        }

        selectedDriverType = driverType;
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

    public void createDriver(DriverType driverType){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        driver = driverType.getDriverObject(desiredCapabilities);
    }


}
