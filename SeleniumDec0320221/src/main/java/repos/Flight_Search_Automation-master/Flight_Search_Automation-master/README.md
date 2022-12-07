

# Flight_Search_Automation: Selenium-Java with Page Object Model
Flight Search Automation is a test automation project created to build a trial UI framework . Website is  in test is [WeGo](https://www.wego.com). One way and Round trip test is implemented as part of this project.

This project provides an example framework for testing a heavily used shadow DOM UI with Selenium WebDriver, using the Page Object Model design pattern with TestNg.

## Framework Overview
 As stated above, this project contains a Selenium Java test framework, implements the Page Object Model design pattern and data driven test by driving data from external excel file. As such, it follows test automation best practices. 

The Page Object Model means that each individual webpage has its own class, each containing the methods specific to controls on that page. Thus, each page is independent and separate from the tests, meaning any changes to the page are isolated to only the corresponding page class. This makes for code that is cleaner, easier to read and maintain, and contains less duplication.

The use of Data Driven strategy differentiate test code from test data. Anyone can change, add or remove new test data  without changing test codes.

This project integrated extent reporting which is neat and clear to understand and provide a nice and clean looking report after test execution 

## Technology
As this is a Java project, build and dependency management is handled by Maven, so there is a pom.xml defining the versions of the dependencies:
1. Selenium [v4.3.0]
2. TestNg [v6.8]
3. Webdriver manager [v4.2.2]
4. Apache Poi [v4.1.2]
5. Extent Report [v5.0.1]

Selenium is used to automate the browser interaction to simulate the operations on page. Webdriver-manager is used to manage the driver for browser interaction. TestNg is used as main validation framework where TestNg data provider drive the test data for our test.

Finally, Extent report generate the report and attach the log and screenshot in report. ItestListener interface is implemented to add the listener functionality to reporter.

## Project Structure

The project uses a standard structure and naming convention:

- **main** Contains all the directory, packages and resources. 
- **test** : Standard test folder which contains the test cases.

- **pages**  : the Page Object Model implementation of the individual website pages, one class file per page. Each class is named after the corresponding page e.g. FlightSearchPage, FlightSearchResultPage etc. There is also a BasePage which the other page classes implement/extend through inheritance. BasePage contains all kind of shared methods implementation which other class used.

- **resources**  : Standard resource directory which contains **testdata**, **testsuites** and **config** subdirectory to store related resource file.

- **utility** : This package contains the utility function needed throughout the test. right now, it has propertyHelper, environment and config helper related functionality 

- **driver**  : This package contains the main driver provider class and other driver helper method.
- **dataprovider**  :  contains necessary code to read data from excel file and implement data provider for testng dataprovider. Apache Poi is used as a library to interact with excel file.

- **reporters** this package contains the necessary class needed for reporting. which include extent reporter class, report manager class and listener implementation.

## Supported Browsers
The driver module uses the Webdriver-Manager dependency to manage the various browser drivers. 
**Though driver modules can provide both Chrome and Firefox but selenium 4 getShadowRoot is supported by only Chrome so test will fail in Firefox.**
 - Chrome - the default option
 -  Firefox [Not recommended until geckodriver add support for ShadowDom]

 The browser parameter can be configured via the **Aplication.properties** file.

The Webdriver-Manager package also has support for Edge, Opera and Internet Explorer but those options are not enabled yet.

##  Execute Test
To run the project first make sure you have maven installed in your system if not please install maven. After installing maven project can be run by executing below command.

 Move to root directory of the project where pom.xml is located and run using  command

    mvn clean verify test -DsuiteFile=src\main\resources\testsuite\flightSearchTest.xml


## Test Report

Extent report will be found in **reports** directory under root. **reports** contain both html report and screenshot of failure test. Open the **index.html** file  with any modern browser to view the reports.   

## N.B. 
Selenium 4 has shadowDom support but only for chrome right now. Also, shadowDom support is limited to a few functionality and some functionality is flaky so that may lead to some flaky scenario.
