#Background: List of steps run before each of the scenarios

@tag
Feature: Searching Google should return the name of the query 
  In order to perform a sucessful Google serach
	As a user
	I want to serach on Google webapp

Background:
 Given User open Chrome Browser
 And User Navigates to Google webapp
 
  @tag1
  Scenario: Google serach with scenario
    When user searches for a "LambdaTest"
    And click on serach button
    Then the page should start with "LambdaTest"
    
  @tag2
  Scenario Outline: Searching google using scenario outline and examples
    When user seraches for <query> 
    And click on serach button
    Then the page should start with <query>

    Examples: 
      | query    | 
      | cucumber |    
      | Java     |     
