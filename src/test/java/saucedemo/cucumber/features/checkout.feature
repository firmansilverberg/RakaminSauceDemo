Feature: Checkout saucedemo

  @CheckOut @Regression
  Scenario: Checkout Cart
    Given Halaman login saucedemo5
    When Input username5
    And Input password5
    And Click login button5
    Then User in on dashboard page5
    And User add cart sauce labs backpack3
    Then User click cart menu
    And User click checkout button
    And User input first name
    And User input last name
    And User input zip code
    And User click continue button
    Then User click finish button
    And Checkout complete
    And User click back home button
    Then User in on dashboard page6

