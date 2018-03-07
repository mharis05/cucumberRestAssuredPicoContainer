Feature: Add New Wishlist

  Scenario: User adds a new Wishlist
    Given API Headers are set
    And JSON document is ready
    When User sends a POST Request to "/users/wishlists"
    Then Validate that response contains correct information
    And See if database has been updated