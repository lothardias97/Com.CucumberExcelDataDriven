@Smoke
Feature: Register for Membership card

  Scenario Outline: User can register Membership card on coop member url
    Given User is on Coop Membership URL nad click on join membership button
    When  User Select No radio button for member card and click Next
    And   User fills form from given sheet name "<Sheet>" and row number <Row>
    Then  User must register Successfully
     Examples:
      |Sheet       |Row|
      |coopRegister|0  |

