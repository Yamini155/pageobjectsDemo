Feature: Login Application

Scenario Outline: Login validation
    Given application is launched
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on login button
    Then login is "<result>"

    Examples:
      | username                 | password     | result  |
      | standard_user            | secret_sauce | valid   |
      | locked_out_user          | secret_sauce | invalid |
      | problem_user             | secret_sauce | valid   |
      | performance_glitch_user  | secret_sauce | valid   |
      | error_user               | secret_sauce | valid   |
      | visual_user              | secret_sauce | valid   |

