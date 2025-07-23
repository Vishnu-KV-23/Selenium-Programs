Feature: User Details Form

  Scenario: Submitting User Details
    Given Navigate to User Details page
    When  Enter Details: "Jamy Paxton", "Texin St.", "9965603427", "jamy@example.com"
    And   Submit the form
    Then  Display result
