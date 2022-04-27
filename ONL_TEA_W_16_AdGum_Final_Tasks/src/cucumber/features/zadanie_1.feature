Feature: MyStore user addresses management

  Scenario Outline: Adding new user's address
    Given user is on login home page
    When user clicks +Create new address button
    When user fills New address with <alias>, <address>, <city>, <postalCode>, <country>, <phone>
    Then added address must be added correctly
    And added last address is deleted

    Examples:
    |alias            |address               |city     |postalCode|country       |phone    |
    |The Bastard      |Winterfell 3/10       |Westeros |01-560    |United Kingdom|213439802|
    |Lord Snow        |Black Castle 1        |Westeros |01-900    |United Kingdom|213439802|
    |The Crow         |Hardhorne 69          |The North|00-001    |United Kingdom|213439802|
    |The Survivor     |Black Castle 1        |Westeros |01-900    |United Kingdom|213439802|
    |Lord Commander   |Black Castle 1        |Westeros |01-900    |United Kingdom|213439802|
    |The Traitor      |Black Castle 1        |Westeros |01-900    |United Kingdom|213439802|
    |King of The North|Winterfell 3/10       |Westeros |01-560    |United Kingdom|213439802|
    |The Last Dragon  |King's Landing 12     |Westeros |03-340    |United Kingdom|213439802|
    |The Outcast      |Somewhere in The North|The North|00-000    |United Kingdom|213439802|
