Feature: Car Rental Form Submission

  Scenario: Submit form with rental details
    Given open the Rent A Car form page
    When enter rental details
      | John Doe | 9876543210 | 123 Main St | 2024-02-02 | 4 | AB1234567 | Net Banking |
    When select car type SUV
    Then submit the form
    Then get the result
