package projectName.workflow;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import projectName.pages.ContactsPage;
import projectName.pages.HomePage;
import projectName.pages.LoginPage;
import util.TestBase;
public class CommonWorkflow extends TestBase{
	
	static HomePage objHomepage;
	static ContactsPage objContactPage;
	
	static LoginPage objloginPage;

	
	public static void createNewContact(String prefix, String ftName, String ltName, String comp) throws Exception{
		
		log("createNewContact Started");
	
		waitImplicit(10);
		selectDropDownValue(ContactsPage.title,prefix);
		waitImplicit(10);
		setText(ContactsPage.firstName,ftName);
		waitImplicit(5);
		setText(ContactsPage.lastName,ltName);
		waitImplicit(5);
		setText(ContactsPage.company,comp);
		waitImplicit(5);
		clickElement(ContactsPage.saveBtn);
		
		log("createNewContact Ended");
	}
	
	public void loginToApplication(String strUserName,String strPasword) throws Exception{
		objloginPage = new LoginPage(driver);
		
		log("loginToApplication method Started");
		
		//set the value in text box
		setText(LoginPage.username,strUserName);
		setText(LoginPage.password,strPasword);
		
		//click login button
		clickElement(LoginPage.loginBtn);

		log("loginToApplication method Completed");
	}
	
	public void logoutApp(String href, String frame) throws FileNotFoundException, InterruptedException {
		log("logoutApp method Started");
		//initialize page factory
		objloginPage = new LoginPage(driver);
		
		//switch to main panel to click menu items
		if(frame == null) {
		clickLinkByHref(href);
		}else {
			switchToFrame("mainpanel");
			clickLinkByHref(href);
		}
		log("logoutApp method Completed");
	}
	
	public void clickLinkByHref(String href) throws InterruptedException {
		
		log("clickLinkByHref method Started");
		List<WebElement> anchors = driver.findElements(By.tagName("a"));
        Iterator<WebElement> i = anchors.iterator();

        while(i.hasNext()) {
            WebElement anchor = i.next();
            waitImplicit(5);
            if(anchor.getAttribute("href").contains(href)) {
            	log.info("Href link exist ");
            	waitImplicit(5);
                anchor.click();
                break;
            }
        }
        log("clickLinkByHref method ended");
    }

}