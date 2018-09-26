package driver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static config.Constants.CHROME;
import static config.Constants.FIREFOX;

/**
 * Interface utilized by the DriverType enum.
 * Any methods needed by the driver type should go here.
 */

public interface DriverSetup {
    // Abstract method for getting variations of the driver

    /**
     * getDriverObject
     * Abstract method consumed by the DriverFactory to return the specified driver with unique Selenium WebDriver capabilities.
     *
     * @param capabilities - the DesiredCapabilities for configuring the Selenium WebDriver
     * @return the Driver instance for test execution.
     */
    RemoteWebDriver getDriverObject(DesiredCapabilities capabilities);

    /**
     * getDriverBinaryPath
     * Abstract method used for running web tests locally with the driver binary (e.g. chromedriver).
     *
     * @param driverName - String that tells the framework which driver binary to use.
     * @return the path to the driver binary
     */
    default String getDriverBinaryPath(String driverName) {

        String osType = System.getProperty("os.name");
        String cwd = System.getProperty("user.dir");
        String driverPath = cwd + "/src/main/resources/drivers/";

        switch (driverName.toLowerCase()) {
            case CHROME:
                if (osType.contains("Windows")) driverPath = driverPath + "chromedriver.exe";
                else driverPath = driverPath + "chromedriver";
                break;
            case FIREFOX:
                if (osType.contains("Windows")) driverPath = driverPath + "geckodriver.exe";
                else driverPath = driverPath + "geckodriver";
                break;
            default:
                driverPath = null;
                break;
        }
        return driverPath;
    }
}
