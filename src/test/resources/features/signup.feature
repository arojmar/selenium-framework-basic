Feature: Client sign up

  Scenario: Client wants to sign up sucessfully
    Given client wants to have an account
    When he sends requires information to get the account
    Then he would be told that the account was created