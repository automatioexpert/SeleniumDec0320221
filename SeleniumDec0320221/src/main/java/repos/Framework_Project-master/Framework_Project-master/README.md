## Developing a Framework and Automating Live Project

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites
* Developing Software 
     - Download Java JDK 
     - Download Eclipse or IntelliJ IDEA
     - Download Apache Maven

## Built With

* [Java](https://www.oracle.com/java/) - Java JDK
* [Eclipse](https://www.eclipse.org/) - Eclipse IDE
* [Maven](https://maven.apache.org/) - Dependency Management

## Create a Maven Quick-start Project
## Add the dependency tags for below:

* WebDriverManger
* Selenium Java
* TestNG
* Log4j (log4j-api and log4j-core)
* Apache Commons IO
* ExtentReports

## Create a Base class 

* Create resources package under 'src/main/java'
* Create Base class under this package
* Create a method for initializeBrowser inside the Base class 
* Read the browser name from Properties file, instead of hardcoding it
     - Create config.properties file under Config File Folder 
     - Add this property browser=chrome to the file
     - Modify the initializeBrowser code accordingly 
 
## Create a Class for 'LoginTest' under 'src/test/java' under 'testCases' package
 
* Create a method say 'login' and annotate with @Test 
* Extend the LoginTest class with Base class
* Write the code to initialize the browser and open the Application URL
* Run the LoginTest to see, if this is executing so far. 
* Remove the URL hardcoding and read the URL from the properties file 
* Run the LoginTest to see, if this is executing after this change
        - Add this property url= http://tutorialsninja.com/demo/ to the properties file
    
## Write the remaining code of LoginTest by creating Page Objects

* Create a package under 'src/main/java' as 'pageObject'
* Create a class say 'LandingPage' under this package with page objects 
* Create an object for LandingPage from LoginTest and perform required operations 
* Run the LoginTest to see, if this is executing so far.
* Create a class say 'LoginPage' under this package with page objects 
* Create an object for LoginPage from LoginTest and perform required operations 
* Run the LoginTest to see, if this is executing so far.
* Create a class say 'AccountPage' under this package with page objects
* Create an object for AccountPage from LoginTest and perform required operations 
* Run the LoginTest to see, if this is executing so far.
* Remove the email and password hardcoding and read them from the properties file
* Write @AfterMethod to close the browser 

## Parameterize the Test by passing multiple sets of data from DataProvider annotated method

* Create a DataProvider annotated method and pass the data to the Test annotated method 

## Create @BeforeMethod

* Organize the code for opening the Application 

## Create some dummy Test Classes with simple SOP statements

* TestTwo 
* TestThree
* TestFour

## Convert the Project to TestNG

* Right click on the Project, Select TestNG > Convert to TestNG
* Execute the Tests as a group using testng.xml file

## Integrate with Maven to run the Project from the command line

* Search for Maven TestNG configuration and add the plugin for Maven Surefire plugin having configuration tags 
* Run from the command prompt - mvn test

## Configuring log4j for logs
* Copy paste the log4j2.xml file here into the Config File Folder 
* Open the LoginTest and write the logs
* Add the tags to pom.xml file to specify where exactly log4j file is available in the project
    - Search for 'Maven filtering' in google 
    - Add the tags under <build> tag
* Run the code and observe that the logs will be printed in the logs file

## Enable Parallel execution using TestNG

* Adding sample automation code in all the Test Classes and Run them as a group to see whether they are running one after the other
* Modify the testng.xml file as below:
    - Separate individual classes to separate tags
    - Add parallel=tests
* Run the code and observe that all the tests will run in parallel

## Taking screenshots for failing Tests

* Create a listeners package under src/main/java
* Create a Listeners class under it and make it implement ITestListener interface
     - Add TestNG library if unable to resolve the errors
* Select 'Source' menu in Eclipse IDE < Override/Implement Methods and select all the check boxes of ITestListerner
* Create reusable method for taking screenshots in Base class with two parameters
* Extend the Listeners class with Base class 
* Update the onTestFailure() method of Listeners class
* Add the Listeners tags in testng.xml file
* Make the driver of the Test Classes to global and public
* Intentionally fail a test and run the testng.xml file 

## Integrating ExtentReports to the framework

* Create a package say 'utilities' under 'src/main/java'
* Create a class under this package say 'ExtentReporter' 
* Create a method say 'getExtentReport'
* Make the getExtentReport method static 
* Write extent report code into different Listeners methods ( onTestStart, onTestSuccess, onTestFailure and onFinish)
* Remove parallel execution from testng.xml file and Run  
* Make ExtentReports thread-safe, by adding this code to Listeners class
   - Add parallel execution to testng.xml file
   - Add this line to the Listeners class
     - ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();
   - Add this line inside onTestStart 
     - extentTestThread.set(extentTest);
   - Replace existing line with this line inside onTestSuccess
     - extentTestThread.get().log(Status.PASS,"Test Passed");
   - Replace existing line with this link inside onTestFailure
     - extentTestThread.get().fail(result.getThrowable());
* Adding the screenshot to the ExtentReports
     - Make the takeScreenshot() method return the destination file path
     - Update the onTestFailure method
        - String screenshotFilePath = takeScreenshot(testMethodName,driver);
        - extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testMethodName);

* Run the testng.xml file

## Applying Encapsulation in the framework
* Make all the Page Objects as private

## Integrating Cucumber BDD into this Framework

* Add the dependencies for Cucumber
     - Cucumber-Java 
     - Cucumber-testng
* Verify whether the Cucumber Eclipse IDE plugin is installed
* Create a package 'features' under 'src/test/java'
* Create a feature file  'Login.feature' under this package
* Create a package 'stepDefinitions' under 'src/test/java'
* Create a Class 'Login.java' under this package
* Auto-generate the Step definitions using TinyGerkhin Chrome Plugin
* Move the automation code to respective step definitions methods
* Create a runner package 
* Create a Runner class under it
    - Extend AbstractTestNGCucumberTests
* Generate a testng2.xml file and modify it
* Run the testng2.xml file
* Mention this testng2.xml file in maven surefire plugin of pom.xml and run using the Maven command (mvn test)

## Versioning

For the versions available, see the [tags on this repository](https://github.com/HannachiHassen/project/tags). 

## Authors

* **Hassen Hannachi** - *Initial work* - [HassenHannachi](https://github.com/HannachiHassen)

## License

This project is not under any License - Open source 
 
    