Feature: Framework is able to write in database

  @database
  Scenario: Able to get and write data in database
    Given Agent already registered an user
    When agent asks for the user
    Then agent should get a registered user