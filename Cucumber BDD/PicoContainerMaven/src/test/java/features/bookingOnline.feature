Feature: Airline Online Booking
   
     Scenario: Book flight using user data    
      When the booking form is filled with "<name>", "<gender>", "<age>", "<address>", "<email>", "<mobile>", "<travelClass>", "<source>", "<destination>", "<date>"
       And booking form is submitted
       Then confirmation table should be visible
       
       Examples:
      | name     | gender | age | address          | email              | mobile     | travelClass   | source | destination | date      |
      | John Doe | Male   | 30  | 123 Elm St, City | john@example.com   | 9876543210 | Economy Class | MUMBAI | CHENNAI     | 7/30/2024 |