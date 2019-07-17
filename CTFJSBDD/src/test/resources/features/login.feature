Feature: Validate login 

	In order to create a new contact
  	As a normal user
  	I want to be able to perform login to Free CRM

  @login_positive
  Scenario: login with valid credentials
  	Given I am on the company login page
    When I login with valid credentials
    Then  I should be logged in 
    Then I must see the logout option
    
  @login_negative
  Scenario: invalid credentails
  	Given I am on login page
    When I login with invalid credentials
    Then I should be on the company login page
   