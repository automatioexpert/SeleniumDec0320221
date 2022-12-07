#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table

@tag
Feature: Searching Google should return the name of the query 
  In order to perform a sucessful Google serach
	As a user
	I want to serach on Google webapp
	
  @tag1
  Scenario: Google serach with scenario
    Given User open Chrome Browser
    And User Navigates to Google webapp
    When user searches for a "LambdaTest"
    And click on serach button
    Then the page should start with "LambdaTest"
    
  @tag2
  Scenario Outline: Searching google using scenario outline and examples
    Given User open Chrome Browser
    And User Navigates to Google webapp
    When user seraches for <query> 
    And click on serach button
    Then the page should start with <query>

    Examples: 
      | query    | 
      | cucumber |    
      | Java     |     

