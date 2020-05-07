Feature: Automation of JSON schema
Background:
  Given I set GET test api endpoint
  When Send GET HTTP request
  Then I recevive valid HTTP response code 200
  Then I create Person object from HTTP response body


  Scenario: Validate id field
    Then  I validate id is bigger than 0

  Scenario: Validate name field
    Then I validate name length is smaller than 11

  Scenario: Validate last name field
    Then I validate lastname length is smaller than 11

  Scenario: Validate age field
    Then I validate age is between 0 and 120

  Scenario: Validate gender field
    Then I validate gender is "F" or "M"

  Scenario: Validate response time in in limit
    Then I validate response time is smaller 500 ms

