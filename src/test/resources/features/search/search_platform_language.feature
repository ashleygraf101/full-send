Feature: Choose platform language

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