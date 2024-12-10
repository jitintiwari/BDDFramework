@LoginLogout
Feature: LoginLogout functionality
  To check different login functionalities like login, logout

  Scenario: Login user
    Given Shopping home page is displayed
    When User navigates to SignIn tab
    And Enter email address "afdas2211df@gegge.com", password "123456123" and click on SignIn button
    Then User's account home page should be displayed


  Scenario: Logout user
    Given Shopping home page is displayed
    When User navigates to SignIn tab
    And Enter email address "afdas2211df@gegge.com", password "123456123" and click on SignIn button
    Then User's account home page should be displayed
    When User clicks on Sign out button
    Then User should be logged out
