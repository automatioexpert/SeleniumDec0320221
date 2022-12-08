# Selenium project template
This project is written in java and will serve an example of implementing a Selenium test project with Selenium3 and Maven. Everything is set up and tests can be added straight away.
## Pre-requisites
 
In order to use this framework, you need JDK8 and allure2.
To install allure2 see the following instructions [here](https://docs.qameta.io/allure/2.0/) and [here](https://github.com/allure-framework/allure2).

Make sure your browser executables are in the PATH of the system. For example, if you want to use firefox you need to add it to your PATH. Otherwise you will get exceptions when running the tests.
Path for executables: /usr/local/bin/ (example: /usr/local/bin/chromedriver)

You can download executables from here:  https://chromedriver.chromium.org/downloads

Version: 79.0.3945.36

## Usage

To execute tests run

```mvn clean test```

To generate a report run

```allure serve allure-results```

## Implemented Browsers
Thanks to the awesome webdrivermanager it supports the following browsers:

- Chrome
- Firefox
- Safari

## Page Objects Pattern
page object pattern is used to have reusable WebElements/small helper methods separated from actual test classes and give the opportunity to have nice structured and easily readable tests (without the overhead of BDD-Frameworks like Cucumber or JBehave).
