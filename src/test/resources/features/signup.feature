Feature: Client sign up

  @run
  Scenario: Client wants to sign up sucessfully
    Given client wants to have an account
    When he sends requires information to get the account
    Then he would be told that the account was created

  Scenario: Client wants to sign up forgetting fill in some required fields
    Given client wants to have an account
    When doesn't send all the required information to get the account
    Then he would be told that the account was not created