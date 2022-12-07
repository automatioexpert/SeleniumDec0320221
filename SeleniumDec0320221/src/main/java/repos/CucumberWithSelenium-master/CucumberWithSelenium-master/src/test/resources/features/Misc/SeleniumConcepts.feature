Feature: Selenium Concepts

  Scenario: Action Operation for Drag and Drop Operation
    Given I Open Chrome Browser
    And I navigate to URL as "https://jqueryui.com/"
    And I Click on "Droppable" Link
    When I drag Source Section and drop it on Target Section
    
    @wip
  Scenario: Action Operation for Slide Operation
    Given I Open Chrome Browser
    And I navigate to URL as "https://jqueryui.com/"
    And I Click on "Slider" Link
    When I Slide slider from point 0 to point 300

  Scenario Outline: Action Operation for Tool tip
    Given I Open Chrome Browser
    And I navigate to URL as "https://jqueryui.com/"
    And I Click on "Tooltip" Link
    When I hover on "<ToolTipName>" link
    Then Hover text appears with text as "<HoverTextToVerify>"
    
  Examples:
  |ToolTipName|HoverTextToVerify                                 |
  |tooltips   |That's what this widget is                        |
  |ThemeRoller|ThemeRoller: jQuery UI's theme builder application|
    
  
    