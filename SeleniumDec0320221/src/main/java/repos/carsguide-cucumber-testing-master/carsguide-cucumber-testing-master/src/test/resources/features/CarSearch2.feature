@Ui @CarSearch
Feature: Validation of Car Search page
  
  In order to validate car search 
  as a buyer
  I navigate to cars guide website

  Background: Navigate to the home page
    Given I am on the home page "https://www.carsguide.com.au" of cars guide website

  @New
  Scenario: Searching for a new car
    
    User should be able to search for a new car with the necessary details provided, 
    so that the user can buy that particular car in the time of his need.

    When I move to Cars For Sale menu
    Then I click on "Search Cars"
    Then I select Make as "BMW"
    And I select Model as "1 Series"
    And I select Location as "ACT - All"
    And I select Price is "$10,000"
    And I click on Find My Next Car button
    Then I should see the list of searched cars
    And The page title should be "Bmw 1 Series Under 10000 for Sale ACT | carsTestguide"

  @Used
  Scenario: Searching for a used car
    
    User should be able to search for a used car with the necessary details provided, 
    so that the user can buy that particular car in the time of his need.

    When I move to Cars For Sale menu
    Then I click on "Used"
    Then I select Make as "Audi"
    And I select Model as "A4"
    And I select Location as "ACT - All"
    And I select Price is "$10,000"
    And I click on Find My Next Car button
    Then I should see the list of searched cars
    And The page title should be "Used Audi A4 Under 10000 for Sale ACT | carsguide"
