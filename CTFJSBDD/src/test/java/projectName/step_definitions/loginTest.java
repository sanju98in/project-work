package projectName.step_definitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import projectName.workflow.loginWorkflow;
import util.TestBase;

public class loginTest extends loginWorkflow{

	loginWorkflow lwf;
	//String url= "http://www.freecrm.com/";

	@Given("^I am on the company login page$")
	  public void I_am_on_the_company_login_page() throws InterruptedException {
		TestBase.log.info("I_am_on_the_company_login_page method started");
		lwf=  new loginWorkflow();
		
		//navigate(url);
		//waitImplicit(5);
	
		//verify the homepage title
		loginWorkflow.homePageTitle(driver.getTitle());
	   
		TestBase.log.info("I_am_on_the_company_login_page method completed");
	}
	
    @When("^I login with valid credentials$")
	public void I_login_with_Valid_credentials() throws Exception{
		
    	TestBase.log.info("I_login_with_Valid_credentials Started");
    	lwf=  new loginWorkflow();

    	// Login is a common and basic steps to verify any further functionalities, created logintoApp... method in common workflow file
    	lwf.loginToApplication(TestBase.testdataprop.getProperty("username"), TestBase.testdataprop.getProperty("password"));
    			
		// verify after login title is displayed correctly
    	loginWorkflow.loginPageTitle(driver.getTitle());
		
    	TestBase.log.info("I_login_with_Valid_credentials completed");
	}
    
    @Then("^I should be logged in$")
    public void I_should_be_logged_in() throws InterruptedException, IOException  {
    
    	TestBase.log.info("I_should_be_logged_in method started");
    	lwf=  new loginWorkflow();
    	// verify login page title
    	loginWorkflow.loginPageTitle(driver.getTitle());
   		
   		TestBase.log.info("I_should_be_logged_in method completed");
    }
    
    @Then("^I must see the logout option$")
    public void I_must_see_the_logout_option() throws FileNotFoundException, InterruptedException {
    	String logoutHref="https://www.freecrm.com/index.cfm?logout";
    	lwf=  new loginWorkflow();

    	//click logout link
    	lwf.logoutApp(logoutHref,null);
    }
    
    @Given("^on the login page$")
     public void on_the_login_page() throws InterruptedException {
    	TestBase.log.info("I_am_on_the_company_login_page method started");

    	//navigate(url);
 
    	TestBase.waitImplicit(5);
    	
    	//verify application title
		loginWorkflow.homePageTitle(driver.getTitle());

		TestBase. log.info("I_am_on_the_company_login_page method completed");
	}
    
    
    @When("^I login with invalid credentials$")
	public void I_login_with_invalid_credentials () throws Exception {
    	TestBase.log.info("I_login_with_invalid_credentials method Started");
    	lwf=  new loginWorkflow();
    	
    	// Login is a common and basic steps to verify any further functionalities, created logintoApp... method in common workflow file
    	lwf.loginToApplication(TestBase.testdataprop.getProperty("invalidusername"), TestBase.testdataprop.getProperty("invalidpassword"));
    			
    	TestBase.log.info("I_login_with_invalid_credentials method completed");
	}
    
    @Then("^I should be on the company login page$")
	  public void I_should_be_on_the_company_login_page() throws InterruptedException, IOException {
		
    	TestBase.log.info("I_should_be_on_the_company_login_page method started");

	    // verify login is not successful
	    loginWorkflow.homePageTitle(driver.getTitle());
	   
	    TestBase.log.info("I_should_be_on_the_company_login_page method completed");
	}
}