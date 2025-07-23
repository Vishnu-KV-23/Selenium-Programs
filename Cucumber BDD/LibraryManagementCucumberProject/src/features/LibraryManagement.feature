Feature: Library Management Registor

  Scenario Outline: Add the borrower details and verify result
    Given Start firefox browser and open the application
    When  check the title "<Title>"
    When  enter borrower details "<Name>" "<Type>" "<Date>" "<BookName>" "<BookAuthor>" "<BookCategory>"
    Then  register "<Name>"

    Examples:
      | Title              | Name | Type        | Date       | BookName | BookAuthor | BookCategory |
      | LIBRARY MANAGEMENT | abc  | Member      | 13/07/2025 | abc      | abc        | Science      |
      | LIBRARY MANAGEMENT | xyz  | Non Member  | 15/07/2025 | xyz      | xyz        | Computer     |
