Feature: MyStore complete purchase procedure

  Scenario Outline: MyStore purchase procedure
    Given user is logged in
    When user goes to <item name> page
    And user selects <quantity> and <size>
    And user adds items to cart
    And discount equals <discount> in percent
    When user goes to checkout
    And user confirms address by <alias>
    And user chooses <delivery> method
    And user chooses <payment> definition
    And user confirms order
    Then screenshot with order confirmation and total cost
    And user goes to order history
    And check if order is awaiting for <payment>

    Examples:

    |item name                     |quantity|size|discount|alias          |delivery  |payment         |
    |Hummingbird Printed Sweater   |9       |M   |20      |Lord Commander |My carrier|Pay by bank wire|
#    |Brown Bear Cushion            |10      |    |0       |The Crow       |My carrier|Pay by Check    |
#    |Mug The Adventure Begins      |15      |    |0       |Lord Snow      |PrestaShop|Pay by bank wire|
#    |Mountain Fox Notebook         |7       |    |0       |The Outcast    |PrestaShop|Pay by bank wire|
#    |Hummingbird Printed T-Shirt   |11      |S   |20      |The Last Dragon|PrestaShop|Pay by bank wire|