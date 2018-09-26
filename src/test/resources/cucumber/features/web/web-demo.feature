Feature: Web Demo

  @demo
  Scenario: Open Healthpartners.com homepage and go to find care
    Given I am on the healthpartners homepage
    When I click the "FIND_CARE_BUTTON" on the homepage
    Then I should see the "CALL_BUTTON" displayed on the find care page