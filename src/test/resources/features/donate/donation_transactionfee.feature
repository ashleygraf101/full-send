Feature: Donate with transaction fee

  @with-transaction-fee
  Scenario Outline: Transaction fee for between $2 and $9
    Given Sergey is deciding to donate to Wikipedia
    When he chooses to donate a custom '<amount>'
    When he chooses to donate the transaction fee
    When he chooses to donate by 'paymentmethod-google'
    Then he sees the charge with '<fullprice>'

    Examples:
      | amount     | fullprice |
      | 2          | $2.35     |
      | 3          | $3.35     |
      | 4          | $4.35     |
      | 5          | $5.35     |
      | 6          | $6.35     |
      | 7          | $7.35     |
      | 8          | $8.35     |
      | 9          | $9.36     |

  @transaction-fee-rate
  Scenario Outline: Transaction fee is correct
    Given Sergey is deciding to donate to Wikipedia
    When he chooses to donate a custom '<amount>'
    Then he sees the '<fee>'

    Examples:
      | amount | fee     |
      | 1      | $0.35   |
      | 2      | $0.35   |
      | 3      | $0.35   |
      | 4      | $0.35   |
      | 5      | $0.35   |
      | 6      | $0.35   |
      | 7      | $0.35   |
      | 8      | $0.35   |
      | 9      | $0.36   |
      | 10     | $0.40   |
      | 11     | $0.44   |
      | 12     | $0.48   |
      | 13     | $0.52   |
      | 14     | $0.56   |
      | 15     | $0.60   |
      | 16     | $0.64   |
      | 17     | $0.68   |
      | 18     | $0.72   |
      | 19     | $0.76   |
      | 20     | $0.80   |
      | 40     | $1.60   |
      | 400    | $16     |
      | 1000   | $40     |
      | 10000  | $400    |

  @without-transaction-fee
  Scenario: Transaction fee is covered by Wikipedia
    Given Sergey is deciding to donate to Wikipedia
    When he chooses to donate a custom '2'
    When he chooses to donate by 'paymentmethod-google'
    Then he sees the '$2.00' charge without fee