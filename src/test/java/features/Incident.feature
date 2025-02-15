Feature: Validate Service Now Rest API Inicident Table Features

  Scenario: Create a incident record and validate the status code
    Given Set the base uri of the service now api
    And Set the base path of the service now api
    And Set the basic Auth of the service now api
    And Set the header "Content-Type" key and "application/json" as value
    When add the create incident request body as string
    And hit the post http method
    Then validate the status code and status line
    