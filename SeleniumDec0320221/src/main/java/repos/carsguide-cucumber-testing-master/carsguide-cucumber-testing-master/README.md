# Cars Guide Website Testing

This is an automation test project that uses the [advance cucumber automation framework](https://github.com/Super-Sujay/advance-cucumber-framework) to test the functionality.
Application URL: https://www.carsguide.com.au

## Requirement
 - Java 1.8 or higher version
 - Apache Maven 3.6.2 or higher version

## Execution
 - Run the command `mvn clean integration-test` in your local system to start the execution of scenarios.
 - Run the command `mvn clean -Dthreads=2 integration-test` in your local system to start the execution of scenarios in parallel in 2 separate browser instances.
 - Run the command `mvn clean -Dremote=true -DseleniumGridURL=http://192.168.1.3:4444/wd/hub integration-test` in your local system to start the execution of tests in the selenium grid provided in the http://192.168.1.3:4444/wd/hub URL.