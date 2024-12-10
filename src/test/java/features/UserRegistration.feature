@UserRegistration
Feature: User registration on shopping portal
  In order to do shopping, user needs to create account on shopping portal
  This gives user the access to view, order and pay for the product

  Scenario: Create a account
    Given Shopping home page is displayed
    When User navigates to SignIn tab
    And Enter "afdas221111df@gegge.com" email address in input
    And Click Create An Account button
    Then Personal information page should be displayed
    When User provides first name "John", last name "Carter", gender "Male", password "123456123" and date of birth in dd-mm-yyyy format "15-10-1997"
    And Click on Register button
    Then User's account home page should be displayed

