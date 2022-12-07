Feature: Login Feature

  Scenario: Check User email is already present in the login pop up
    Given I open "chrome" browser
    And I navigate to url as "http://demo.cs-cart.com/"
    When I click on Account Menu link at top right corner of the page
    And I click on Sign In button
    Then Email is already displayed as "customer@example.com"

  Scenario: Check user is able to login in to the application
    Given I open "chrome" browser
    And I navigate to url as "http://demo.cs-cart.com/"
    When I click on Account Menu link at top right corner of the page
    And I click on Sign In button
    And I click on Sign In button on the pop up
    Then User is signed in and Sign out button is displayed after clicking on My Account button
    
   Scenario: Negative Test: Enter In-correct email format in the User name Box and check error message
    Given I open "chrome" browser
    And I navigate to url as "http://demo.cs-cart.com/"
    When I click on Account Menu link at top right corner of the page
    And I click on Sign In button
    And I remove previous email
    And I enter email address as "wrongemail"
    And I click on Sign In button on the pop up
    Then Application should throw error as "The email address in the E-mail field is invalid."
  
   Scenario: Negative Test: Enter In-correct email in the User name Box and check error message
    Given I open "chrome" browser
    And I navigate to url as "http://demo.cs-cart.com/"
    When I click on Account Menu link at top right corner of the page
    And I click on Sign In button
    And I remove previous email
    And I enter email address as "wrongemail"
    And I click on Sign In button on the pop up
    Then Application should throw error as "The username or password you have entered is invalid. Please try again."