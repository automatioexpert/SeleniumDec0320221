# BDD-Java-Framework

## Author: Hemanshu Chauhan
BDD Automation framework for Web Testing.

This framework is created using Cucumber6, Junit, JDK 11+, Maven 3.6+ & Extent Report.

##Steps to Use this Framework: 

1. Install JDK11+ & Maven 3.6+
2. Set Java and Maven home
3. Clone the repository
4. Set config.properties path in ConfigReader.java file. i.e. "config/config.properties"
5. Run "My TestRunner" file OR Execute "mvn install" command in terminal/cmd
6. Check Extent report in "test output" folder
*Example*

```gherkin
    Feature: This feature file contains the various features of the login page
    
      Background: 
        Given User is on the login page
    
      Scenario: As a user I want to validate login Page title
        When User observe the title of the page
        Then Login page title should display "Login - My Store"
    
      Scenario: As a user I want to validate that forget password link should display
        Then Login page should display forget password link
    
      Scenario: As a user I want to login with correct credentials
        When User enters "hemanshutestuser@gmail.com" as a username
        And Enter "Password@1" as a password
        And Click on login button
        Then Home page should display
        And Home page title should be "My account - My Store"
```