@Ui @Car @Audi
Feature: Validation of Car Search page for Audi
  
  In order to validate car search 
  as a buyer
  I navigate to cars guide website

  Scenario: Searching for a used car
    Given I am on the home page "https://www.carsguide.com.au" of cars guide website
    When I move to Cars For Sale menu
    And I click on "Used"
    And I select Make as "Audi"
    And I select Model as "A4"
    And I select Location as "ACT - All"
    And I select Price is "$10,000"
    And I click on Find My Next Car button
    Then I should see the list of searched cars
    And The page title should be "Used Audi A4 Under 10000 for Sale ACT | carsguide"
