Feature: create new contacts
	In order to create a new contact
  	As a normal user
  	I want to be login to Free CRM application

  @create_newContacts
  Scenario Outline: login with valid credentials then go to contacts and create new contacts
  	Given I am on login page
    When logon with valid credentials
    And I mouse hover contacts menu
    Then I click create new contacts menu option
    Then  I enter new contact details "<title>" , "<firstname>" , "<lastname>" and "<company>"
    Then I verify page title
    Then I logOff and quit the application
    
   Examples: 
  	|title|firstname|lastname|company|
	|Mr.|Sachin|Patidar|Duetch Bank|
