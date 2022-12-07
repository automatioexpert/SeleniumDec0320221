Feature: OrangeHRM Login
 
  Scenario: Logo presence on OrageHRM Home Page
    Given I launch chrome browser
    When I open orage HRM home page
    Then I verify that the logo present on the page
    And close browser