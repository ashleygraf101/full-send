Feature: Donate set amounts

  @with-transaction-fee
  Scenario Outline:
    Given Sergey is deciding to donate to Wikipedia
    When he chooses to donate a set '<amount>'
    When he chooses to donate by 'paymentmethod-google'
    Then he sees the selected amount is '<output>'

    Examples:
      | amount     | output    |
      | 0          | $2.75     |
      | 1          | $5.00     |
      | 2          | $10.00    |
      | 3          | $20.00    |
      | 4          | $30.00    |
      | 5          | $50.00    |
      | 6          | $100.00   |