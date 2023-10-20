Feature: Add Cart saucedemo

  @AddCart @Regression
  Scenario: Success Add Cart
    Given Halaman login saucedemo3
    When Input username3
    And Input password3
    And Click login button3
    Then User in on dashboard page3
    And User add cart sauce labs backpack
    And User add cart sauce labs bike light
    And User add cart sauce labs bolt t-shirt
    And User add cart sauce labs fleece jacket
    And User add cart sauce labs onesie
    And User add cart sauce labs t-shirt red
    Then Cart added six items