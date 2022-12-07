@Regression

Feature: Verify Subscription Popup
  Scenario Outline: Verify that user is able to see Subscription popup on the articles page
    Given I am on Financial Review- Foreign Affairs website
    When I navigate to "<Article>" article on this page
    Then I verify if the subscription prompt is popped up from the bottom of the page
    And I scroll down to the end of the page
    And I Wait for 10 seconds
    And I verify if the subscription pop up disappears from the article
    
    Examples:
    |Article|
    |capability-edge-and-keeping-south-china-sea-open-crucial--christopher-pyne-20180924-h15rq9|