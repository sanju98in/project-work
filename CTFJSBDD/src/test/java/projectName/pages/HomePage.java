package projectName.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;

import org.openqa.selenium.interactions.Actions;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonPage{

	public static final Logger log= Logger.getLogger(LoginPage.class.getName());
	public static WebDriver driver;
	
	//Page Factory - OR:
	@FindBy(xpath = "//td[contains(text(),'User: test test')]")
	@CacheLookup
	public
	WebElement userNameLabel;

	@FindBy(xpath="//*[@id=\"navmenu\"]/ul/li[4]/a")
	public
	WebElement contactsLink;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	public
	WebElement newContactLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	public
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	public
	WebElement tasksLink;

	public HomePage(WebDriver driver)throws FileNotFoundException{
		driver=TestBase.driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage() throws FileNotFoundException{
		// TODO Auto-generated constructor stub
	}

	public void clickOnContactsLink() throws InterruptedException {

		log("clickOnContactsLink Started");

		wait(3);
		contactsLink.click();
		wait(3);

		log("clickOnContactsLink Ended");
	}


	public void clickOnNewContactLink() throws InterruptedException{

		log("clickOnNewContactLink Started");

		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();

		wait(10);

		newContactLink.click();

		wait(10);

		log("clickOnNewContactLink Ended");
	}



}
