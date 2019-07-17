package projectName.workflow;

import java.io.FileNotFoundException;
import org.junit.Assert;

import projectName.pages.LoginPage;

/**
 * @author CIVICA
 */
public class loginWorkflow extends CommonWorkflow{

	

	public boolean validateCRMImage(){
		return LoginPage.crmLogo.isDisplayed();
	}

	public static void homePageTitle(String expected) throws InterruptedException{

		log("homePageTitle method Started");
		//Verify Home page/landing page title of the application
		String actuals=testdataprop.getProperty("logintitle");
		
		//Compare title of the application before login/ home page title
		Assert.assertEquals(expected, actuals);

		log("homePageTitle method Completed");
	}

	public static void loginPageTitle(String expected) throws InterruptedException, FileNotFoundException{

		log("loginPageTitle method Started");
		
		//read the expected title of landing page from property file 
		String actuals=testdataprop.getProperty("hometitle");

		//Compare title of the application after successful login
		Assert.assertEquals(expected, actuals);
		waitImplicit(10);
		log("loginPageTitle method Completed");
	}
}
