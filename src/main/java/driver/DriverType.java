package driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.HashMap;

/**
 * DriverType is an enum for defining the type of Selenium or Appium driver.
 * It is called by DriverFactory, where you can set driver capabilities specific
 * to the mobile device or browser under test. For example, when setting DriverType.ANDROID
 * you can specify the platformVersion and deviceName as DesiredCapabilities. Also, any
 * capabilities that are always needed for a specific DriverType can be stored within the
 * enum getDriverObject() method.
 */
public enum DriverType implements DriverSetup {

    CHROME {
        @Override
        public RemoteWebDriver getDriverObject(DesiredCapabilities capabilities) {
            HashMap<String, Object> chromePreferences = new HashMap<>();
            ChromeOptions options = new ChromeOptions();
            options.merge(capabilities);
            options.addArguments("--start-maximized");
            options.setExperimentalOption("prefs", chromePreferences);
            System.setProperty("webdriver.chrome.driver", getDriverBinaryPath("chrome"));
            return new ChromeDriver(options);
        }
    },
    FIREFOX {
        @Override
        public RemoteWebDriver getDriverObject(DesiredCapabilities capabilities) {
            FirefoxOptions options = new FirefoxOptions();
            options.merge(capabilities);
            System.setProperty("webdriver.gecko.driver", getDriverBinaryPath("firefox"));
            return new FirefoxDriver(options);
        }
    },
    IE {
        @Override
        public RemoteWebDriver getDriverObject(DesiredCapabilities capabilities) {
            InternetExplorerOptions options = new InternetExplorerOptions();
            options.merge(capabilities);
            options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
            options.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
            options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);

            return new InternetExplorerDriver(options);
        }
    },
    EDGE {
        @Override
        public RemoteWebDriver getDriverObject(DesiredCapabilities capabilities) {
            EdgeOptions options = new EdgeOptions();
            options.merge(capabilities);

            return new EdgeDriver(options);
        }
    },
    SAFARI {
        @Override
        public RemoteWebDriver getDriverObject(DesiredCapabilities capabilities) {
            SafariOptions options = new SafariOptions();
            options.merge(capabilities);

            return new SafariDriver(options);
        }
    },
    ANDROID {
        @Override
        public RemoteWebDriver getDriverObject(DesiredCapabilities capabilities) {
            capabilities.setCapability("unicodeKeyboard", true);
            capabilities.setCapability("resetKeyboard", true);
            return new AndroidDriver<MobileElement>(capabilities);
        }
    },
    IOS {
        @Override
        public RemoteWebDriver getDriverObject(DesiredCapabilities capabilities) {
            capabilities.setCapability("automationName", "XCUITEST");
            return new IOSDriver<MobileElement>(capabilities);
        }
    };

}
