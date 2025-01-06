Feature: Search by keyword

  @single-letter
  Scenario Outline: Searching by 'typeahead'
    Given Sergey is researching things on the internet
    When he starts to look up "<phrase>"
    When he selects article option "<option>"
    Then he sees the article title contains the '<term>'

    Examples:
    | phrase | option            | term            |
    | Q      | Qatar             | Qatar           |
    | C      | China             | China           |
    | Xer    | Xerxes I          | Xerxes I        |
    | Xer    | Xerox             | Xerox           |
    | KO     | Knockout          | Knockout        |
    | Meio   | Meiosis           | Meiosis         |
    | W      | Wayback Machine   | Wayback Machine |

  @single-keyword
  Scenario: Searching for 'everest'
    Given Sergey is researching things on the internet
    When he looks up "everest"
    Then he should see information about "everest"

  @multiple-keywords
  Scenario: Searching for 'mount everest'
    Given Sergey is researching things on the internet
    When he looks up "mount everest"
    Then he should see information about "mount everest"

  @different-language
  Scenario: Searching for 'mount everest' in another language
    Given Sergey is researching things on the internet
    When he selects article language "Italiano"
    When he looks up "everest"
    Then he should see information about "everest"