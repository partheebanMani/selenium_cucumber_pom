@Cat
Feature: This feature file is to test cat database
  Postgres SQL database is used for this


  Scenario Outline: POSTGRES SQL query to test the database tables
    When Run query '<query>' in cat service
    Then verify result is matching with expected <expected>
    Examples:
      | query                                                        | expected |
      | select count(*) as count from cuttable                       | 4        |
      | select count(*) as count from cuttable where catnap=\'ramu\' | 1        |
