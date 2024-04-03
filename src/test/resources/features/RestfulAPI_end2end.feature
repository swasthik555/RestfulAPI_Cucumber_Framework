@Restful
Feature: Testing of the RESTful API's

@get
  Scenario: Verify the get api for the products
    Given I hit the url of get products api endpoints
    When I pass the url of products in the request
    Then I receive the response code as 200

  Scenario Outline: Verify the capacity of the first product is correct
    Given I hit the url of get products api endpoints
    When I pass the url of products in the request
    Then I verify that the capacity of the first product is "<FirstProductCapacity>"

    Examples: 
      | FirstProductCapacity |
      | 128 GB               |

  Scenario: Validate post product api status code works correctly
    Given I hit the url of post product api endpoint
    When I pass the url of products in the request
    And I pass the request body of the device
    Then I receive the response code as 200

  Scenario: Validate post product api generate id works correctly
    Given I hit the url of post product api endpoint
    When I pass the url of products in the request
    And I pass the request body of the device
    Then I receive the response body with id

  Scenario: Validate put product api status code works correctly
    Given I hit the url of put product api endpoint
    When I pass the request body of put api and pass the url of products in the request with id
    Then I receive the response code as 200

  Scenario: Verify the device is updated
    Given I hit the url of get products api endpoints
    When I pass the url of device in the request with id
    And I receive the response code as 200
    Then I verify the values are updated

  Scenario: Verify the Delete request API
    Given I hit the url of delete request api endpoints
    When I pass the delete request of device in the request with id
    Then I receive the response code as 200 and response body
