Feature: Remove Cart saucedemo

  @RemoveCart @Regression
  Scenario: Success Remove Cart
    Given Halaman login saucedemo4
    When Input username4
    And Input password4
    And Click login button4
    Then User in on dashboard page4
    And User add cart sauce labs backpack2
    And User add cart sauce labs bike light2
    And User add cart sauce labs bolt t-shirt2
    And User add cart sauce labs fleece jacket2
    And User add cart sauce labs onesie2
    And User add cart sauce labs t-shirt red2
    Then Cart added six items2
    And User remove cart sauce labs backpack
    And User remove cart sauce labs bike light
    And User remove cart sauce labs bolt t-shirt
    And User remove cart sauce labs fleece jacket
    And User remove cart sauce labs onesie
    And User remove cart sauce labs t-shirt red
    Then Cart zero items
