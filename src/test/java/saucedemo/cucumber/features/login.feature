Feature: Login Page saucedemo

  @TDD
  Scenario Outline: User login to saucedemo
      Given Halaman login saucedemo
      When I input <username> as username
      And I input <password> as password
      And Click login button
      Then I verify <status> login result

      Examples:
      | username        | password      | status  |
      | standard_user   | secret_sauce  | success |
      | standard_userr  | secret_sauce  | failed  |

  @Negative
  Scenario: Failed Login
    Given Halaman login saucedemo
    When Input username
    And Input invalid password
    And Click login button
    Then User get error message

  @Regression @Positive
    Scenario: Success Login
    Given Halaman login saucedemo
    When Input username
    And Input password
    And Click login button
    Then User in on dashboard page