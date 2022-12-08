Feature: Verify login functionality

Scenario: Verify login functionality with valid password
Given User is on login page
When User provides valid username and password
Then User clicks on login button
Then User should navigate to home page

Scenario: Verify login functionality with invalid password
Given User is on login page
When User provides invalid username and password
Then User clicks on login button
Then User should not navigate to home page

Scenario: Verify login functionality with invalid user valid password
Given User is on login page
When User provides invalid username and valid password
Then User clicks on login button
Then User should not navigate to home page
