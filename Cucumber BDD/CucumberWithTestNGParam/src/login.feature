Feature: Login Form Submission

  # NAME: Validate User Credentials
  #
  # Steps
  #   1. Start Firefox browser and open the application
  #   2. User enters login credentials from TestNG parameter
  #   3. Get the result from the web page

  Scenario: Validate User Credentials
    Given Start firefox browser and open the application
    When  User enters login credentials from testNG parameter
    Then  Get the result from the web page
