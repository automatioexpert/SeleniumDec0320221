#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Application Login
  I want to use this template for my feature file

  @tag1
  Scenario: Login with valid credentials
    Given Open any Browser
    And Navigate to Login page
	  When User enters username as "arun.selenium@gmail.com" and password as "Second@123" into the fields
	  And User clicks on Login button
	  Then Verify user is able to successfully login