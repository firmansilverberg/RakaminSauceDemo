Feature: Fail Checkout saucedemo

  @FailCheckOut @Regression
  Scenario: Fail Checkout Cart
    Given Halaman login saucedemo6
    When Input username6
    And Input password6
    And Click login button6
    Then User in on dashboard page7
    And User add cart sauce labs backpack4
    Then User click cart menu2
    And User click checkout button2
    And User input first name2
    And User input last name2
    And User input zip code2
    And User click continue button2
    Then Error alert show up
