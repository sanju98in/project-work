package projectName.step_definitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import projectName.pages.LoginPage;
import projectName.workflow.CommonWorkflow;
import projectName.workflow.ContactsWorkflow;
import projectName.workflow.loginWorkflow;


public class ContactsPageTest extends ContactsWorkflow{
	
	LoginPage loginpage;
	loginWorkflow objloginWfl;
	loginTest objloginTest;
	CommonWorkflow objCmnWfl;

	public static String title,firstName,lastName,company;
	String url= "http://www.freecrm.com/";
	public ContactsPageTest() throws FileNotFoundException {
	}

	@Given("^I am on login page$")
	  public void I_am_on_login_page() throws InterruptedException {
		
		navigate(url);
		log.info("I_am_on_the_company_login_page method started");
		
		objloginWfl = new loginWorkflow();
	   // waitImplicit(20);
	
	   log.info("I_am_on_the_company_login_page method completed");
	}
	
	@When("^logon with valid credentials$")
	public void logon_with_valid_credentials() throws Exception {
		log.info("I_login_with_Valid_credentials Started");

		//initialize page factory
		loginpage = new LoginPage(driver);
		
		objCmnWfl = new CommonWorkflow();

		//login to the application
		objCmnWfl.loginToApplication(testdataprop.getProperty("username"), testdataprop.getProperty("password"));
		
		log.info("I_login_with_Valid_credentials Ended");
	}
	
	@And("^I mouse hover contacts menu$")
	public void I_mouse_hover_contacts_menu() throws FileNotFoundException, InterruptedException{
		//click contact menu
		clickcontactsMenu();
		}
	
	@Then("^I click create new contacts menu option$")
    public void I_click_create_new_contacts_menu_option () throws FileNotFoundException, InterruptedException {
		//click new contacts menu >> Contacts
		clickNewContactsMenu();
    }
	
	@Then("^I enter new contact details \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\"$")
	public void I_enter_new_contact_details(String title,String firstname,String lastname,String company) throws Exception {
		//Create new contact
		createNewContact(title,firstname,lastname,company);
	}
	@Then ("^I verify page title$")
	public void I_verify_page_title() throws IOException, InterruptedException {
		objloginWfl = new loginWorkflow();

		//verify page title
		loginWorkflow.loginPageTitle(driver.getTitle());
	}
	@Then("^I logOff and quit the application$")
	public void I_logOff_and_quit_the_application() throws FileNotFoundException, InterruptedException {
		objloginTest = new loginTest();

		//verify logout link
		objloginTest.I_must_see_the_logout_option();
	}
	
   }
