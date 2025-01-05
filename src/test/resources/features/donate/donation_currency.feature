Feature: Donate by currency

  @countries
  Scenario Outline: Paying with Different Currency
    Given Sergey is deciding to donate to Wikipedia
    When he chooses to use '<country>' bank accounts
    Then he should see relevant details for '<country>', '<currency>', '<currencySymbol>'

    Examples:
    | country       | currency   | currencySymbol |
    | Italy         | EUR        | €              |
    | France        | EUR        | €              |
    | United States | USD        | $              |
    | Chile         | CLP        | $              |
    | Brazil        | BRL        | R$             |
    | Australia     | AUD        | $              |