# java-automation-accelerator
Automation accelerator framework written in java. This project demonstrates a variety of automation examples including: 
web UI, mobile UI, API automation, database interaction and various automation test runners (Cucumber, TestNG, etc).

## What is it for? 
This framework can be used as a reference for implementing new functionality into an existing automation framework. 
It can also be used to kick-start your automation if you don't have automation in place. 
All in all, the `java-automation-accelerator` is a physical example of best practices and approaches to test automation.

## Dependencies

**Required**
* [IntelliJ IDE - Community Edition](https://www.jetbrains.com/idea/)
* [Java 1.8+](https://www.java.com/en/)
* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)

**Optional**
* [NodeJS](https://www.nodejs.org) - For running mobile tests locally.
* [Appium](https://www.appium.io) - For running mobile tests locally.


## Supported Operating Systems
Since this is a Java project, it can run on most major operating systems. These include: 
* Mac OS X
* Windows
* Linux


## Maven and Build Lifecycle
Once all dependencies are configured and the java-automation-accelerator code downloaded, it should be ready to run. 
Maven is used to manage both dependencies and compiling the solution. For more info, see the [maven documentation](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)

All of the Maven configuration is specified in the pom.xml (located at the project root). This is where we pull selenium, appium, junit, cucumber and all libraries needed to build and run this solution. 
Below are the most relevant maven commands: 

```bash
# Clean the compiled 'target' folder
mvn clean

# Install the dependencies specified in the pom.xml
mvn install 

# Clean and install the dependencies
mvn clean install 
```

## Test Runners/Libraries
This framework showcases various libraries that are commonly used to run automated tests aka 'Test Runners'. 
Each of these test runner implementations are designed independently of one another and can be found in the test package: `src/test/java`. 
Below are the test runners implemented in the accelerator:  

* [Cucumber](https://cucumber.io/) - BDD framework that utilizes Gherkin syntax to make tests more readable. 
* [JUnit](https://junit.org) - Perhaps the mostly widely used Java automation library, JUnit is primarily a unit testing framework with a lot of flexibility.
* [TestNG](https://testng.org) - Similar to JUnit with some extra functionality.

NOTE: In terms of implementing automation for your project - pick just 1 of the test runners. 
If you would like to use more than one runner for you project (NOT Recommended), then split them up into separate code bases.

### Cucumber 
There are two core concepts in cucumber: [features](https://docs.cucumber.io/gherkin/reference/) and [step definitions](https://docs.cucumber.io/cucumber/step-definitions/). 
Features are the `.feature` files which define tests in a human readable format. 
For each step in the feature file, there must be a corresponding 'step definition'. The step definition binds to a feature file step and executes test code. 
In this solution, feature files are located at `src/test/java/resources/cucumber/features` and step definitions are located at `src/test/cucumber`. 

Furthermore, Cucumber requires a 'test runner' and 'hooks' class. The test runner is the entry point when running cucumber tests. 
It tells cucumber where the step definitions and feature files are located. It is also for configuring the reports and tags.
For example, the test runner for web tests is located at `src/test/java/cucumber/web/support/CucumberWebTestRunner.java`. 
The hooks class is used to execute specific logic on a per tag, per scenario or per feature basis. 
An example of this is located at `src/test/java/cucumber/web/support/Hooks.java`

##### Running Cucumber Tests via IntelliJ
In order to run cucumber tests via the IntelliJ IDE, below are the steps. This is for web tests, but it is the same process for API/Mobile cucumber tests. 

1. Open IntelliJ
2. Import the `java-automation-accelerator` project as an existing Maven project
3. Open the IntelliJ terminal: View > Tool Windows > Terminal 
4. Clean and install the Maven dependencies
   ```bash 
    mvn clean install
   ```
5. Ensure the install finishes with SUCCESS. 
6. Open the Cucumber Web Test Runner class: `src/test/java/cucumber/web/support/CucumberWebTestRunner.java`
7. Click the green play icon in the left hand gutter of the CucumberWebTestRunner.java file (next to line numbers).
8. Select either 'Run CucumberWebTestRunner' or 'Debug CucumberWebTestRunner'. Debug will enable breakpoints. 
9. The test should be running in the Chrome browser by default. 


##### Running Cucumber Tests via Command Line
1. Open Terminal (OSX) or Command Prompt (Windows)
2. Go to the `java-automation-accelerator` source code directory: 
   ```bash
    cd <path>\<to>\java-automation-accelerator
   ```
3. Install Maven dependencies:
   ```bash 
    mvn clean install
   ```
4. Ensure the install finishes with SUCCESS. 
5. Run the Cucumber tests: 
   ```bash 
    # Running on Chrome browser 
    mvn clean install -Dtest=CucumberWebTestRunner test
    

### TestNG
There are two core concepts in TestNG: `testng.xml` and test classes. `testng.mxl` is the driving file that defines
tests to be run. Tests can be run in groups with a number of tags and annotations. Although less readable than cucumber, it's
efficient for those more seasoned in code. The test classes can each house multiple test cases, separated by tags. 
In this solution, `testng.xml` file and it's associated classes can be found in the
src/test/java/testng folder.

##### Running TestNG Tests via IntelliJ
In order to run TestNG tests via the IntelliJ IDE, below are the steps. This is for web tests, but it is the same process for API/Mobile TestNG tests. 

1. Open IntelliJ
2. Import the `java-automation-accelerator` project as an existing Maven project
3. Open the IntelliJ terminal: View > Tool Windows > Terminal 
4. Clean and install the Maven dependencies
   ```bash 
    mvn clean install
   ```
5. Ensure the install finishes with SUCCESS. 
6. From the configurations drop down at the top right of the IntelliJ window, select TestNG.
7. Click the green play button next to the dropdown.
8. Which test cases are being run can be altered in the testng.xml file.

##### Running TestNG Tests via Command Line
TODO


## JUnit
TODO

##### Running JUnit Tests via IntelliJ
TODO

##### Running JUnit Tests via Command Line
TODO

## Architecture & Design
Below is information regarding the design and structure of various features within the framework. 

#### UI Automation
For mobile and web UI automation, we follow the Page Object Pattern. 
The general idea is that for a given web or mobile app, there should be a class for each screen (mobile) or page (web) that contains code relevant to the app page/screen.

For example, for a Login PageObject class you might have methods for logging into the app with email and password. You would also place all selectors for the login page within this class. 
This structure allows easier code maintenance and should be more intuitive as the page objects should follow the application. 

#### API Automation
TODO
* REST vs SOAP
* Sending requests
* Receiving responses
* Manipulating response objects

#### Database 
TODO
* Using the JDBC and patterns for DB connections in a re-usable way
* MSSQL, PSQL, etc libraries

#### Containerization
TODO
* How docker works
* Why docker is useful and the purpose it serves
* The types of containers used by this project (dependencies, etc)


## Coding Standards & Best Practices

#### Naming Conventions
* All classes should be named in PascalCase where the first letter of every word should be capitalized. Example: ClassName.java
* All methods should be camelCase where the first letter is lower case and every word after is uppercase. Example: methodNameExample();

#### Dont Repeat Yourself (DRY)
One of the essential code practices is the idea of reducing duplicate code by adhering to DRY principles. 
If you use the same block of code in more than one place - put it into a class/method so that there is only 1 place to update the code instead of several. 
This makes the framework much more robust with easier maintenance and quicker test development.

#### Code Reviews
Doing regular code reviews with members of your team (development or QA) is a great practice to follow. When using GIT, 
one of the best ways to accomplish Code Reviews is in the form of Pull Requests. Essentially, when you check in a new commit to the repo - send it as a pull request.
This way, another person must merge the code into the given branch, instead of yourself. 


## Source Code Management
TODO
* Pull Requests (code reviews)
* GitFlow branching strategy 
* Etc

## Test Data
TODO
* Storing as static files
* Dynamically pulling from database or API
* Best practices

## CI/CD
TODO
* Integration with CI/CD pipeline using docker

## Reporting 
TODO 
* Discuss various reporting options - both custom and canned reports

## UI Element Selectors
In order to build UI automation, you'll need to inspect the application source to find unique identifiers for Selenium/Appium to interact with elements. 

#### Web Tools
Chrome comes with 'Developer Tools' which are an excellent feature for inspecting web elements. 
Open up Chrome, click 'Help' in the toolbar and search 'Developer Tools'. For more information, see [devtools documentation](https://developer.chrome.com/home/devtools-pillar).
 
#### Mobile Tools
Appium provides a desktop application designed specifically for inspecting Android and iOS UI elements. 
It is called Appium Desktop. For instructions and download, go [here](https://github.com/appium/appium-desktop)


## Docs
TODO - add wiki pages for documentation and add a list of links to the pages.
    
    
