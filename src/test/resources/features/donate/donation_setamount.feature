Feature: Donate set amounts

  @set-amounts-correct
  Scenario Outline: Set amount without promotional emails request
    Given Sergey is deciding to donate to Wikipedia
    When he chooses to use '<country>' bank accounts
    When he chooses to donate a set '<amount>'
    When he chooses to donate by 'paymentmethod-google'
    Then he sees the selected amount is '<output>'

    Examples:
      | country       | amount    | output   |
      | Australia     | 0         | $2.75    |
      | Australia     | 1         | $5.00    |
      | Australia     | 2         | $10.00   |
      | Australia     | 3         | $20.00   |
      | Australia     | 4         | $30.00   |
      | Australia     | 5         | $50.00   |
      | Australia     | 6         | $100.00  |
      | United States | 0         | $2.75    |
      | United States | 1         | $5.00    |
      | United States | 2         | $10.00   |
      | United States | 3         | $20.00   |
      | United States | 4         | $30.00   |
      | United States | 5         | $50.00   |
      | United States | 6         | $100.00  |

  @set-amounts-eu-correct
  Scenario Outline: Set amount with promotional emails request
    Given Sergey is deciding to donate to Wikipedia
    When he chooses to use '<country>' bank accounts
    When he chooses to donate a set '<amount>'
    When he accepts promotional emails
    When he chooses to donate by 'paymentmethod-google'
    Then he sees the selected amount is '<output>'

    Examples:
      | country        | amount    | output   |
      | France         | 0         | €2.50    |
      | France         | 1         | €5.00    |
      | France         | 2         | €10.00   |
      | France         | 3         | €20.00   |
      | France         | 4         | €30.00   |
      | France         | 5         | €50.00   |
      | France         | 6         | €100.00  |
      | United Kingdom | 0         | £2.00    |
      | United Kingdom | 1         | £5.00    |
      | United Kingdom | 2         | £10.00   |
      | United Kingdom | 3         | £20.00   |
      | United Kingdom | 4         | £30.00   |
      | United Kingdom | 5         | £50.00   |
      | United Kingdom | 6         | £100.00  |