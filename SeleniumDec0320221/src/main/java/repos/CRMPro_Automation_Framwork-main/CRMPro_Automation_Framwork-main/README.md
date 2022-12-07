
Hello, folks! <img src="https://raw.githubusercontent.com/MartinHeinz/MartinHeinz/master/wave.gif" width="30px">

:heavy_exclamation_mark: `NOTE: This is my learning and practicing project. All comments and suggestions are more than welcome!`

# CRMPro_Automation_Framwork

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

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

## Technologies Used:

* Eclipse/IntelliJ (Java Editor)  
* JDK 12 (Java Development Kit) 
* Selenium WebDriver 
* TestNG (Test Unit Framework) - Data Driven Approach 
* Log4j (logging API) 
* Maven (Build Automation Tool) 
* Apache POI API (Read-Write utilities for Excel - Test Data Handling) 
* Browser - Google Chrome/FireFox

## Automation Framework Architecture: 
* POM (Page Object Model) Design Page Factory API of WebDriver 
* Maven (Build Automation Tool) 
* Test Libraries for different UI Pages 
* Test Utilities for different generic functions 
* Report - Dashboard (Pass/Fail Test) by using Extent Report 
* API Jenkins - Continuous Integration Tool 
* git and GITHub Repo (Code Versioning Tool)

## Features 
* Webdriver Fire Event/WebEventListener - improved console logs and screenshot on failure Location: src\main\java\com\Utils\WebEventListener 
* Extent Report Listener with ITestListener Interface (available at TestNG) Location: src\main\java\com\Listeners\Listener 
* @CacheLookup implementation improves script performance 
* Data Driven approach (xml file reader through TestNG Data Provider)

## Note Make sure you are using the correct browser version. 
* You can update to your browser version by putting the driver file into the drivers folder at the root of the project.
* In this project I use WebDriver Manager dependency in pom.xml, so We don't need to use any driver folder (no need to change the path of the WebDriver each time you clone the project).

## Prerequisites: 
* If config file is not populated set up the account at https://classic.crmpro.com/index.html. 
* Then populate your config.properties with your account values. 
* Set up several contacts at the "Contacts page" - these are the values you are using in your ContactsPage.

## Convert the Project to TestNG

* Right click on the Project, Select TestNG > Convert to TestNG

## Running Test Cases 
* You can run test cases per each page object separately from each class in src\main\java\com\TestCases
* Or the whole suite through the test runner file located here: \CRM_Automation_Framwork\Config File\testng.xml file.

## Checking TestNG Reports 
* Right click on the project name and select "Refresh". 
* Go to test-output folder -> right click on index.html -> Properties -> copy file location -> run index.html file in your browser to see the report.
* To see Extent Report do the same for ExtentReport.html file

## Emailable TestNG Report Email 
* File name: emailable-report.html 
* Go to test-output folder -> right click on emailable-report.html -> copy file location -> run index.html file in your browser to see the report.

## Configuring log4j for logs
* Copy paste the log4j2.xml file here into the Config File Folder 
* Open the LoginTest and write the logs
* Add the tags to pom.xml file to specify where exactly log4j file is available in the project
    - Search for 'Maven filtering' in google 
    - Add the tags under <build> tag
* Run the code and observe that the logs will be printed in the logs file

## Versioning

For the versions available, see the [tags on this repository](https://github.com/HannachiHassen/project/tags). 

## Authors

* **Hassen Hannachi** - *Initial work* - [HassenHannachi](https://github.com/HannachiHassen)

## License

This project is not under any License - Open source 
