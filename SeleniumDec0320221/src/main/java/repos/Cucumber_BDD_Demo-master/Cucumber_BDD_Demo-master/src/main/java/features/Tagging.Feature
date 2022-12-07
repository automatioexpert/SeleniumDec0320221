@FunctionalTest
Feature: Free CRM application testing

@SmokeTest @RegressionTest
Scenario: Login with correct username and correct password
Given This is a valid login test

@RegressionTest
Scenario: Login with incorrect username and correct password
Given This is a invalid login test

@SmokeTest
Scenario: Create a contact
Given This is a contact test case

@SmokeTest @RegressionTest
Scenario: Create a deal
Given This is deal test case

@RegressionTest
Scenario: Create a task
Given This a task test case

@SmokeTest
Scenario: Create a case
Given This is a search case test

@SmokeTest @RegressionTest
Scenario: Verify left panel links
Given Clicking on the left panel links

@SmokeTest
Scenario: Search a contact
Given This is a search contact test

@SmokeTest @E2ETest
Scenario: Search a case
Given This is a search case test

@RegressionTest @E2ETest
Scenario: Search a call
Given This is a search call test

@RegressionTest
Scenario: Search an email
Given This is a search email test

@E2ETest
Scenario: Search a doc
Given This is a search doc test


