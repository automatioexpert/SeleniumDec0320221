@Ui @Car
Feature: Validation of Car Search page for BMW
  
  In order to validate car search 
  as a buyer
  I navigate to cars guide website

  Scenario: Searching for a new car
    Given I am on the home page "https://www.carsguide.com.au" of cars guide website
    When I move to Cars For Sale menu
    And I click on "Search Cars"
    And I select Make as "BMW"
    And I select Model as "1 Series"
    And I select Location as "ACT - All"
    And I select Price is "$10,000"
    And I click on Find My Next Car button
    Then I should see the list of searched cars
    And The page title should be "Bmw 1 Series Under 10000 for Sale ACT | carsguide"
