Feature: Test Facebook smoke scenario

  Scenario Outline: Test login with valid Credentials
    Given Open firefox and start application
    When I enter valid "<username>" and "password"
    Then user should be able to login successfully
    Then application should be closed
    

    Examples: 
      | username             | password    |
      | kunal@pedagogy.study | kunal@123   |
      | kunal@pedagogy.study | kunal@1234  |
      | kunal@pedagogy.study | kunal@12345 |
