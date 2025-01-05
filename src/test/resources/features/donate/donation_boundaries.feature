Feature: Donation frequency

  @minimum
  Scenario: Paying below 'country' minimum
    Given Sergey is deciding to donate to Wikipedia
    When he chooses to use '<country>' bank accounts
    When he chooses to donate a custom '<amount>'
    When he chooses to donate by '<paymentMethod>'
    Then he should see a lower limit error message '<error>'

    Examples:
    | country  | paymentMethod  | error | amount |
    | Australia | paymentmethod-cc | Please select an amount (minimum 1.50 AUD) | 1.49 |
    | United States | paymentmethod-cc | Please select an amount (minimum 1 USD) | 0.99 |

  @maximum
  Scenario Outline: Paying above 'country' maximum
    Given Sergey is deciding to donate to Wikipedia
    When he chooses to use '<country>' bank accounts
    When he chooses to donate a custom '<amount>'
    When he chooses to donate by '<paymentMethod>'
    Then he should see an upper limit error message '<error>'

    Examples:
      | country       | paymentMethod    | error | amount |
      | Australia     | paymentmethod-cc | We cannot accept donations greater than USD 25,000 (37,500 AUD) through our website. Please contact our major gifts staff at benefactors@wikimedia.org. | 37501  |
      | United States | paymentmethod-cc | We cannot accept donations greater than USD 25,000 through our website. Please contact our major gifts staff at benefactors@wikimedia.org.              | 25001  |
