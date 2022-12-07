@tag
Feature: Error validation
  I want to use this template for my feature file

  @ErrorValidations
  Scenario Outline:Negative test of verification
    Given I landed on Ecommerce Page
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name                 | password    |
      | srilekha12@gmail.com | @Srilekha18 |
