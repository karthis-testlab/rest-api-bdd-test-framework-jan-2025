Feature: Validate Service Now Rest API Inicident Table Features

  Background: 
    Given Set the base uri of the service now api
    And Set the base path of the service now api
    And Set the basic Auth of the service now api

  @Smoke
  Scenario: Create a incident record and validate the status code
    When Set the header key and header value
      | Key          | Value            |
      | Content-Type | application/json |
      | Accept       | application/json |
    And add the create incident request body as string
    And hit the post http method
    Then validate the status code and status line

  @Regression @Smoke
  Scenario: Fetch incident records and validate the status code
    When hit the get http method
    Then validate the status code and status line of GET method

  @Regression
  Scenario: Fetch the incident record using non existing sys id and validate the status code
    When hit the get http method with non existence sys_id "iewguew784564"
    But validate the status code and status line of non existing sys id

  Scenario Outline: Create a incident record using pojo object and validate the status code
    When Set the header "Content-Type" key and "application/json" as value
    And create the incident record with description <description> in the request body
    And create the incident record with shaort description <short_description> in the request body
    And hit the post http method with request body as the pojo object
    Then validate the status code and status line

    Examples: 
      | description   | short_description                        |
      | APISessionJAN | Adding new record using POST POJO Object |
      | APISessionFEB | Adding new record using POST POJO Object |
