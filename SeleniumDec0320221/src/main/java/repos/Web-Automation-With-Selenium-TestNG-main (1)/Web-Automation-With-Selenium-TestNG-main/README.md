# Web-Automation-With-Selenium-TestNG


## Tool used in this Project
 - Selenium


## Framework used in this Project
 - TestNG


 ## Project Scenarios
 - Admin can Login to the System.
 - Admin can Create 2 Emoloyees Id.
 - Admin can Search the Employees by their Id.
 - Employee can Login with their self Credentials.
 - Employee can Update their Information.
 - Employee can Logout from the System.

 ## How to run this project:
 - Clone this project [Web-Automation-with-Selenium_TestNG](https://github.com/ahnafahmad/Web-Automation-With-Selenium-TestNG.git)
 - hit the following command:
  ```
 gradle clean test
 ```
 
  ## How to Generate Allure Report: 
 Automated Orange HRM Websited using Selenium & JUnit where test cases are added for Admin Login, Creating Employee Id, Searching Employees By their Id, Employee login, Updating the Employee Information & Logout from the System.
 Steps to generate the report:
 - Give the following commands by opening terminal in the project folder to create Allure Report:
```
allure generate allure-results --clean -o allure-report
 ```
 ```
 allure serve allure-results
```

 ## Prerequisite
  - Some gradle dependency is must for run this project
  These are: 
 ```
 // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    implementation group: 'org.seleniumhq.selenium', name: 'selenium-java', version: '4.5.0'
 ```
 ```
 // https://mvnrepository.com/artifact/org.testng/testng
    testImplementation group: 'org.testng', name: 'testng', version: '7.5'
```
```
// https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
    implementation group: 'io.github.bonigarcia', name: 'webdrivermanager', version: '5.3.0'
```
```
// https://mvnrepository.com/artifact/com.github.javafaker/javafaker
    implementation group: 'com.github.javafaker', name: 'javafaker', version: '1.0.2'
```
```
// https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple
    implementation group: 'com.googlecode.json-simple', name: 'json-simple', version: '1.1.1'
```
```
// https://mvnrepository.com/artifact/io.qameta.allure/allure-testng
    implementation group: 'io.qameta.allure', name: 'allure-testng', version: '2.17.3'
```
```
// https://mvnrepository.com/artifact/org.projectlombok/lombok
    compileOnly group: 'org.projectlombok', name: 'lombok', version: '1.18.24'
```
```     
// https://mvnrepository.com/artifact/org.projectlombok/lombok
    testImplementation group: 'org.projectlombok', name: 'lombok', version: '1.18.24'
```
```     
// https://mvnrepository.com/artifact/org.projectlombok/lombok
    testAnnotationProcessor group: 'org.projectlombok', name: 'lombok', version: '1.18.24'
```

## Testcases for this Report

[Orange HRM-Website-Automation-Selenium-TestNG](https://docs.google.com/spreadsheets/d/1ETQPF2jd0ygaB65IUPpsAGzJ74iXErXLA00gbPkCdog/edit#gid=0)

## Selenium TestNG Automation Report Image


![TestNG Automation-1](https://user-images.githubusercontent.com/58990500/202847791-ff733fd2-f304-47b1-9609-b52f4a65e658.PNG)



![TestNG Automation-5](https://user-images.githubusercontent.com/58990500/202847802-e3a93a98-15ff-4452-9d17-47622fe7249e.PNG)



![TestNG Automation-2](https://user-images.githubusercontent.com/58990500/202847812-8475e868-a082-484d-bad9-5ee2fbbc91e9.PNG)



![TestNG Automation-3](https://user-images.githubusercontent.com/58990500/202847826-e1744540-4198-4f38-b37a-586ddeccde6b.PNG)



![TestNG Automation-4](https://user-images.githubusercontent.com/58990500/202847838-ece94585-6b0a-4868-96c0-0ac4a68b01cc.PNG)


## Output Video of the Project


https://user-images.githubusercontent.com/58990500/202848207-3a906835-01c6-4242-ab03-320d3c90cd72.mp4

