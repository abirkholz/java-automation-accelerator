x`# src/main/java
Everything in this package should be applicable to more than one test package. 
This includes any configuration of selenium/appium driver, constants, config files, etc.

## Structure
* api
* config
* driver
* utility 

## api
This package is for general classes that are needed to send and receive API calls. 

## config
This package is for any configuration needed to run tests. It is the entry point where command line options are sent. It is also where constants live. 

## driver
This package is for configuring the various drivers for UI automation - mobile and web. 
* Driver - a class that wraps the RemoteWebDriver object and makes re-usable methods that can be applied to mobile or web driver.
* WebDriverFactory - the class that instantiates or creates the Selenium Web Driver with specific capabilities. For instance, you'll see a getChromeDriver() method. With this method you can specify the chrome version, the local chrome binary, and other options specific to chrome. 
* MobileDriverFactory - a class similar to WebDriverFactory, but for Mobile automation. You can specify AppiumCapabilities or options for either iOS or Android, including the OS and version of the device.

## utility
This package is for any classes or methods that serve as generic utilities. For instance, parsing a file or calculating a value. Utilities should be very generic and usable across the project. 

