@Ui @CarsGuide
Feature: Validation of Car Search page
  
  In order to validate car search 
  As a buyer
  I want to buy a car

  Background: Navigate to the home page
    Given I am on the home page "https://www.carsguide.com.au" of cars guide website

  Scenario Outline: Searching for a car
    
    User should be able to search for a particular car with the necessary details provided, 
    so that the user can buy that particular car in the time of his need.

    When I move to Cars For Sale menu
    Then I click on "<Menu>"
    And I select Make as "<Make>"
    And I select Model as "<Model>"
    And I select Location as "<Location>"
    And I select Price is "<Price>"
    And I click on Find My Next Car button
    Then I should see the list of searched cars
    And The page title should be "<Page Title>"

    Examples: 
      | Menu        | Make | Model    | Location  | Price   | Page Title                                         |
      | Used        | Audi | A4       | ACT - All | $10,000 | Used Audi A4 Under 10000 for Sale ACT \| carsguide |
      | Search Cars | BMW  | 1 Series | ACT - All | $10,000 | Bmw 1 Series Under 10000 for Sale ACT \| carsguide |
