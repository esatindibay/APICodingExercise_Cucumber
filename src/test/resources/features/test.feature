Feature: Automation of JSON schema

  Scenario: Get Person record
    Given I set GET test api endpoint
    When Send GET HTTP request
    Then I recevive valid HTTP response code 200

  Scenario: Validate id field
    Given I set GET test api endpoint
    When Send GET HTTP request
    Then I recevive valid HTTP response code 200
    Then I create Person object from HTTP response body
    And  I validate id is bigger than 0


  Scenario: Validate name field
    Given I set GET test api endpoint
    When Send GET HTTP request
    Then I recevive valid HTTP response code 200
    Then I create Person object from HTTP response body
    And I validate name length is smaller than 10


  Scenario: Validate last name field
    Given I set GET test api endpoint
    When Send GET HTTP request
    Then I recevive valid HTTP response code 200
    Then I create Person object from HTTP response body
    And I validate lastname length is smaller than 10


  Scenario: Validate age field
    Given I set GET test api endpoint
    When Send GET HTTP request
    Then I recevive valid HTTP response code 200
    Then I create Person object from HTTP response body
    And I validate age is between 0 and 120


  Scenario: Validate gender field
    Given I set GET test api endpoint
    When Send GET HTTP request
    Then I recevive valid HTTP response code 200
    Then I create Person object from HTTP response body
    And I validate gender is "F" or "M"


  Scenario: Validate gender field
    Given I set GET test api endpoint
    When Send GET HTTP request
    Then I recevive valid HTTP response code 200
    Then I create Person object from HTTP response body
    Then I validate response time is smaller 500 ms

