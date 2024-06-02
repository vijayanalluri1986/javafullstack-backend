@User
Feature: User Feature

  Scenario: Verify User scenarios
    When Create The user with following Details
      | id | name   | address   |
      | 1  | Vijaya | Boston    |
      | 2  | Ravi   | Bangalore |
    Then Verify The User Details
      | id | name   | address   |
      | 1  | Vijaya | Boston    |
      | 2  | Ravi   | Bangalore |

