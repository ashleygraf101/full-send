Feature: Search by keyword
  As a
  I want
  So that

  @choose-central-language
  Scenario Outline: Featured language wheel internationalises
    Given Sergey is researching things on the internet
    When he selects language '<language>'
    Then he should see donate link as '<donate>'

    Examples:
    | language  | donate                |
    | English   | Donate                |
    | Français  | Faire un don          |
    | Italiano  | Fai una donazione     |
    | Español   | Donaciones            |
    | Português | Donativos             |

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

  @article-language
  Scenario Outline: Select article language
    Given Sergey is researching things on the internet
    When he looks up '<term>'
    When he selects article language '<language>' from article
    Then he sees the article title contains the '<selectedTerm>'

    Examples:
      | language        | term            | selectedTerm |
      | Simple English  | Image           | Picture |
      | Esperanto       | Xerxes I        | Kserkso la 1-a (Persio)  |
      | Français        | Xerxes I        | Xerxès Ier               |
      | Türkçe          | Xerxes I        | I. Serhas       |

  @article-language-excluded
  Scenario Outline: Article language is excluded
    Given Sergey is researching things on the internet
    When he looks up '<term>'
    When he searches for article language '<languageSearched>' from article and selects '<language>'
    Then he should not see '<language>' in the article language list

    Examples:
      | term       | languageSearched | language     |
      | Xerxes I   | Francais         | Français     |
      | Xerxes I   | Turk             | Türkçe       |
      | Xerxes 1   | Span             | Español      |

  @article-language-count
  Scenario Outline: The count of article languages is accurate
    Given Sergey is researching things on the internet
    When he looks up '<term>'
    When he sees the language count for the article is '<count>'

    Examples:
      | term        | count         |
      | Xerxes I    | 83            |
      | China       | 310           |
      | Image       | 87            |
      | Qatar       | 247           |
      | Xerox       | 52            |


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