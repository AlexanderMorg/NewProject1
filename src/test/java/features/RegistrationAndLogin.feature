Feature: Registration and Login

  Scenario: Registration and Login

    Given Navigate to www.sharelane.com
    When You've been navigated to it, click Sign-Up
    And Enter zipCode
    And Click Continue
    And Fill FirstName
    And Fill Email
    And Fill Password
    And Fill confirm password
    Then Click Register
    When You've been registered, click underlined here
    Then Enter email
    And Enter password
    And Click Login

    