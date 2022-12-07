Feature: Free CRM Contacts Feature

#Data Driven approach with Scenario Outline and Examples keyword
Scenario Outline: Free CRM Create a New Contact scenario

Given user is already on login page
When title of login page is Free CRM
Then user enters "<username>" and "<password>"
Then user clicks the login button
Then the user is on home page
Then user clicks New contact link
Then user enters contacts details "<firstname>" and "<lastname>" and "<position>"
Then user clicks on save button
Then close the browser

Examples:
| username | password | firstname | lastname | position |
| ananda   | 123456   | cucuber10 | bdd10    | manager  |
| ananda   | 123456   | cucuber20 | bdd20    | analyst  |