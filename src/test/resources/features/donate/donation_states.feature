Feature: Donate by state

  @states
  Scenario: Record my state correctly
    Given Sergey is deciding to donate to Wikipedia
    When he chooses to donate a custom '2'
    When he chooses to donate by 'paymentmethod-google'
    When he chooses to use '<state>' as a state
    Then he should see relevant details for '<state>'

    Examples:
    | state                             |
    | Ashmore and Cartier Islands       |
    | Australian Antarctic Territory    |
    | Australian Capital Territory      |
    | Christmas Island                  |
    | Cocos (Keeling) Islands           |
    | Coral Sea Islands                 |
    | Heard Island and McDonald Islands |
    | Jervis Bay Territory              |
    | New South Wales                   |
    | Norfolk Island                    |
    | Northern Territory                |
    | Queensland                        |
    | South Australia                   |
    | Tasmania                          |
    | Victoria                          |
    | Western Australia                 |
