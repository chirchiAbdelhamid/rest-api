Feature: Workflow categories

  Scenario: Get workflow categories
    When I get the list of workflow categories
    Then I receive status code of 200
    And The list of categories contains 5 elements
