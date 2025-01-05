Feature: Donation frequency

  @monthly
  Scenario: Paying monthly
    Given Sergey is deciding to donate to Wikipedia
    When he chooses to donate monthly
    When he chooses to donate a custom '2'
    When he chooses to donate by 'paymentmethod-google'
    Then he should see relevant details for donating monthly

  @just-once
  Scenario: Paying just once
    Given Sergey is deciding to donate to Wikipedia
    When he chooses to donate just once
    When he chooses to donate a custom '2'
    When he chooses to donate by 'paymentmethod-google'
    Then he should see relevant details for donating just once