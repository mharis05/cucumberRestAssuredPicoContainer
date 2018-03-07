Feature: A Demo feature that tests Product Details API

  Scenario: Send a request to the Product Details Endpoint and validate the response code
    Given You have set the baseURI and headers for the request
    When You send the request for Product Details
    Then Status code returned by Product Details API is 200
    And Response body contains the required product name
      | id        | em1-Embellished round frame acetate and gold tone sunglasses |
      | sku       | nike55                                                       |
      | item.code | em1                                                          |

