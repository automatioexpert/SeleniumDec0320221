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
