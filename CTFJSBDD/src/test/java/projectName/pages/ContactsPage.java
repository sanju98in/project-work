package projectName.pages;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactsPage extends CommonPage {

	public static final Logger log= Logger.getLogger(LoginPage.class.getName());
	public static WebDriver driver;
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	public
	WebElement contactsLabel;

	@FindBy(name="title")
	public static 
	WebElement title;

	@FindBy(id="first_name")
	public static
	WebElement firstName;

	@FindBy(id="surname")
	public static
	WebElement lastName;

	@FindBy(name="client_lookup")
	public static
	WebElement company;

	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	public static
	WebElement saveBtn;



	// Initializing the Page Objects:
	public ContactsPage(WebDriver driver) throws FileNotFoundException{
		ContactsPage.driver=CommonPage.driver;
		PageFactory.initElements(driver, this);
	}

	public void open() {

	}


	public WebElement getFirstName() {
		return firstName;
	}

	public void setFirstName(WebElement firstName) {
		ContactsPage.firstName = firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public void setLastName(WebElement lastName) {
		ContactsPage.lastName = lastName;
	}

	public WebElement getCompany() {
		return company;
	}

	public void setCompany(WebElement company) {
		ContactsPage.company = company;
	}




}
