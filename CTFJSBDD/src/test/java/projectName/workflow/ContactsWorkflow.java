package projectName.workflow;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import projectName.pages.ContactsPage;
import projectName.pages.HomePage;
import projectName.pages.LoginPage;

public class ContactsWorkflow extends CommonWorkflow{
	
	public static final Logger log= Logger.getLogger(ContactsWorkflow.class.getName());

	static HomePage objHomepage;
	static ContactsPage objContactPage;
	
	static LoginPage objloginPage;
	
	public ContactsWorkflow() throws FileNotFoundException {
		objContactPage = new ContactsPage(driver);
	}
	
	public boolean verifyContactsLabel(){
		return objContactPage.contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name){
		
		ContactsPage.driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	
	
	public static void clickcontactsMenu() throws FileNotFoundException, InterruptedException {
		
		objHomepage = new HomePage(driver);
		objContactPage = new ContactsPage(driver);

		//switch to main panel to click menu items
		switchToFrame("mainpanel");
		
		// use common methods for actions like mouse hover and click 
		mouseHover(objHomepage.contactsLink);
		
	}
	
	public static void clickNewContactsMenu() throws InterruptedException, FileNotFoundException  {
		
		objHomepage = new HomePage(driver);
		//objContactPage = new ContactsPage(driver);

		// use common methods for actions like mouse hover and click 
		clickElement(objHomepage.newContactLink);
		
	}
}
