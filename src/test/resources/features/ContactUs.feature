@Sanity
Feature: Contact Us feature

  Scenario Outline: Contact us feature with different data set
    Given User navigate to contact us page
    When  User fills the form from given sheet name "<SheetName>" and row number <RowNumber>
    And   User click on submit button
    Then  User verify the successful message "Your message has been successfully sent to our team."
     Examples:
        |SheetName|RowNumber|
        |contactus|0        |
        |contactus|1        |