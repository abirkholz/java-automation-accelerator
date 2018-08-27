# java-automation-acceleator
Automation accelerator framework written in java

## Dependencies

**Required**
* [IntelliJ IDE - Community Edition](https://www.jetbrains.com/idea/)
* [Java 1.8+](https://www.java.com/en/)
* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)

**Optional**
* [NodeJS](https://www.nodejs.org) - If not running mobile tests on Sauce Labs.
* [Appium](https://www.appium.io) - If not running mobile tests on Sauce Labs.


## Supported Operating Systems
Since this is a Java project, it can run on most major operating systems. These include: 
* Mac OS X
* Windows
* Linux

## Getting Started
Once all dependencies are configured and the java-automation-accelerator code downloaded, it should be ready to run. There are two ways to execute tests: IntelliJ or command line. 

**Running via IntelliJ**
1. Open IntelliJ
2. Import the java-automation-accelerator project as an existing Maven project
3. Open the IntelliJ terminal: View > Tool Windows > Terminal 
4. Clean and install the Maven dependencies
   ```bash 
    mvn clean install
   ```
5. Ensure the install finishes with SUCCESS. 
6. Open the Cucumber Test Runner class: DesktopTestRunner.java
7. Click the green play icon in the left hand gutter of the DesktopTestRunner.java file (next to line numbers).
8. Select either 'Run DesktopTestRunner' or 'Debug DesktopTestRunner'. Debug will enable breakpoints. 
9. The test should be running in the Chrome browser by default. 

**Running via Command Line**
1. Open Terminal (OSX) or Command Prompt (Windows)
2. Go to the java-automation-accelerator source code directory: 
   ```bash
    cd <path>\<to>\java-automation-accelerator
   ```
3. Install Maven dependencies:
   ```bash 
    mvn clean install
   ```
4. Run the Cucumber tests: 
   ```bash 
    # Running on Chrome browser against QA env
    mvn clean install -Dtest=DesktopTestRunner -DplatformName="chrome" -Durl= <app_url_here>" test
    
    # Running on iOS 9.3 device on SauceLabs/TestObject
    # NOTE: Saucelabs will pick up any available iOS device which has the 9.3 OS
    mvn clean install -Dtest=MobileTestRunner -DplatformName="ios" -DplatformVersion="9.3" test
    
    # Running on Android 7.0 device on SauceLabs/TestObject
    # NOTE: Saucelabs will pick up any available Android device which has the 7.0 OS
    mvn clean install -Dtest=MobileTestRunner -DplatformName="android" -DplatformVersion="7.0" test
   ```

## Coding Standards
TODO

#### Naming Conventions
* All classes should be named in PascalCase where the first letter of every word should be capitalized. Example: ClassName.java
* All methods should be camelCase where the first letter is lower case and every word after is uppercase. Example: methodNameExample();


## Docs
TODO - add wiki pages for documentation and add a list of links to the pages.
    