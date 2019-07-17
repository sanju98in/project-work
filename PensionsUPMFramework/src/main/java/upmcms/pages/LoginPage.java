package upmcms.pages;

import java.io.FileNotFoundException;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonPage {

	public static final Logger log= Logger.getLogger(LoginPage.class.getName());
	public static WebDriver driver;

	//Page Factory - OR:
	
	@FindBy(xpath="//*[@type='text']")
    public static WebElement txtLogin;
	
	@FindBy(xpath="//*[@type='password']")
    public static WebElement txtPassword;
	
	@FindBy(xpath="//*[@class='ui-button-text']")
	public static List<WebElement> btnLabelMatch;
	
	@FindBy(xpath="//*[@class='civica-hellotext']")
	 public static WebElement lblLogoutDrodown;
	
	@FindBy(xpath="//*[@class='civica-logout']/div")
    public static WebElement lblLogoutDrodownListItems;
	
	@FindBy(xpath="//div[@class='civicainfoblock  ui-state-error ui-corner-all']/span")
	public static WebElement lblIncorrectAuth;
	
	
  //parameterize constructor to initalize driver and page factory web element
	public LoginPage(WebDriver driver) throws FileNotFoundException{
		LoginPage.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage()  throws FileNotFoundException{
		// TODO Auto-generated constructor stub
	}
}
