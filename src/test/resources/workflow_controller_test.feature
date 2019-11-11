Feature: Workflow

  Scenario: Get workflows
    When I get the list of workflows
    Then I receive status code of 200
    And The list of workflows contains 3 elements
