Feature: Login to Spotify

  @login
  Scenario: Login with valid credentials

    Given User is on Main page
    When User enters username as "LOGIN"
    And User enters password as "PASSWORD"
    Then User should be able to login successfully