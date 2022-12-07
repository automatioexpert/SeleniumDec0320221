Feature: Search Feature

  Scenario: User wants to search for product using search text box
    Given I open "chrome" browser
    And I navigate to url as "http://demo.cs-cart.com/"
    When I enter text in search text box as "computer"
    And I click on Search button
    Then Search results are displayed
