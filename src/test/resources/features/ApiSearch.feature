Feature: Api search track

  @api
  Scenario: search for correct track

    When User search track "showdown", artist "shadowraze" for GET inquiry
    Then Request equals "200"
    And Request contains correct track "showdown", and correct artist "shadowraze"