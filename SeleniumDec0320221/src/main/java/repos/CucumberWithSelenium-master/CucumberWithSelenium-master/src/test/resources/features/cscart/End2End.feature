Feature: End 2 end flow of e commerce web site

	@e2e
  Scenario: End to End Flow from Login till Order Details
    Given I have browser opened with url of cscart
    And I login in to the application
    When I search "laptop" and add product "V0229W5J8F" to cart
    And I search "mobile" and add product "M0073Q30SG" to cart
    And I navigate to View Cart and validate products are added
    And I navigate to Check out page and validate the ammount
    And I enter payment details
    And I click on Place Order
    Then Order has been received page is displayed
    And Order details are correctly displayed
       
#        |mobile|M0073Q30SG|
#    |laptop|V0229W5J8F|

