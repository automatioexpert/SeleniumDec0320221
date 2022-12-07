# Advance Cucumber Framework

This is an advance cucumber automation framework which can be use for automating any web based application.
Implementation of this framework is provided in the [carsguide cucumber testing](https://github.com/Super-Sujay/carsguide-cucumber-testing) project repository.

## Features
 - Execution of tests using TestNG or JUnit framework.
 - Reporting functionality provided (Basic and Custom Reporting).
 - Page object model implementation.
 - Parallel execution of scenarios (in case of TestNG) and feature files (in case of JUnit).
 - Ability to connect to an external selenium grid.
 - Ability to connect to a web based application using proxy settings.

## Requirement
 - Java 1.8 or higher version
 - Apache Maven 3.6.2 or higher version

## Installation
 - Clone the project in your local system.
 - Run the command `mvn clean install` in your local system.
 - Use the below mentioned dependency in the project you want to use the framework.
```
    <dependency>
    	<groupId>org.automation.project</groupId>
    	<artifactId>advance-cucumber-framework</artifactId>
    	<version>1.0.0</version>
    </dependency>
```