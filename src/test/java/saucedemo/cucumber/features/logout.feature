Feature: Logout Page saucedemo

  @Logout @Regression
  Scenario: Success Logout
    Given Halaman login saucedemo2
    When Input username2
    And Input password2
    And Click login button2
    Then User in on dashboard page2
    And User click hamburger menu
    And User click logout
    Then User on login page
