Feature: Validating Place APIs

  @AddPlace @Regression
  Scenario Outline: Verify if place is successfully added using AddPlaceAPI
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with "POST" http request
    Then the API call is success with status code 200
    And  "status" in response body is "OK"
    And  "scope" in response body is "APP"
    And verify place_Id created maps to "<name>" using "getPlaceAPI"

    Examples:
      | name | language | address            |
      | Aa   | English  | World cross center |
      | bb   | German   | Tata Tata center   |
      | CC   | German   | Bata Bata center   |

  @DeletePlace @Regression
  Scenario: Verify if Delete Place functionality is working
    Given Delete Place Payload
    When user calls "deletePlaceAPI" with "DELETE" http request
    Then the API call is success with status code 200
    And  "status" in response body is "OK"