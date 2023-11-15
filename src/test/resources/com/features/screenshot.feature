Feature: Ugaoo Screenshot Test

  Scenario: Capture screenshot on Ugaoo.com seeds page
    Given I open the Ugaoo.com seeds page
    When I attempt to find a non-existent element
    Then a screenshot is captured on exception
