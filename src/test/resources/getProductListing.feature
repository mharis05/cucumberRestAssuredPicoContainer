Feature: A Demo feature that tests Product Listings API

  Scenario: Send a request to the Product Listing Endpoint and validate the response code
    Given You have set the baseURI and headers for the request
    When You send the request for Product Listing
    Then Status code returned by Product Listing API is 200
