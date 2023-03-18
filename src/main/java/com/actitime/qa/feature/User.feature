Feature: as a admin I should be able to add new users using external excel sheet

  Scenario Outline: adding new user
    Given admin of the Actitime add new user
    When admin login to the system with username and password as  "<username>" "<password>"
    Then admin navigate to users page
    Then admin click on add new user button
    Then fill all the mandatory fields using the excel sheet and send the invitation and validate user creation  "<firstname>" "<lastname>" "<middlename>" "<email>"
    Examples:
      |firstname  |lastname |middlename |email  |username |password |
      |Ahamed     | Aathil         |A   |Ahamedaathil.5@gmail.com |admin  |manager  |


