package projectName.workflow;

import projectName.pages.ContactsPage;
import projectName.pages.HomePage;

public class HomePageWorkflow extends CommonWorkflow{

	HomePage objeHomePage ;
	ContactsPage objcontactsPage ;


	// Initializing the Page Objects:
	public String verifyHomePageTitle(){
		return HomePage.driver.getTitle();
	}

	public boolean verifyCorrectUserName(){
		return objeHomePage.userNameLabel.isDisplayed();
	}
}
