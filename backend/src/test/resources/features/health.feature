Feature: Application health
  To determine whether the application is ready to serve requests
  As an operator
  I want the health endpoint to report the application status

  Scenario: The application reports that it is up
    Given the application has started
    When I request the application health status
    Then the response status is 200
    And the response body reports the status "UP"
