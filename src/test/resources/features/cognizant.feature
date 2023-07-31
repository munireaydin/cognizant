Feature: Cognizant module "Industries" verification
  Agile story: As a user, when I am on the home page
  I should go to Automotive title under Industries module and fill the contact form

  Scenario: User checks the module names
    Given User is on the Cognizant home page
    Then User should see the module names as listed
      | Industries |
      | Services   |
      | Insights   |
      | About      |

  Scenario: User should be able to fill the contact form on Automotive page
    Given User is on the Cognizant home page
    When User clicks on "Industries" module
    And User clicks on "Automotive" title
    And User clicks on Contact button
    And User should be able to write a valid email on Email box
    And User should be able to fill ContactUs form
    And User should  click on checkbox
    #And User should click on CAPTCHA box
    Then User should be able to click on "Submit" button
