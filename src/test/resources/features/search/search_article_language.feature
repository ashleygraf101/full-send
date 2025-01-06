Feature: Choose article language

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
      | Qatar       | 248           |
      | Xerox       | 52            |
