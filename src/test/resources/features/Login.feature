Feature: Login to Spotify

  @login
  Scenario: Login with valid credentials

    Given User is on Main page
    When User enters username as ""
    And User enters password as ""
    Then User should be able to login successfully