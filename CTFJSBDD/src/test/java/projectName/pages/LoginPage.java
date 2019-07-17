package projectName.pages;

import java.io.FileNotFoundException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonPage {

	public static final Logger log= Logger.getLogger(LoginPage.class.getName());
	public static WebDriver driver;
	
	//Page Factory - OR:
	@FindBy(name="username")
	public static
	WebElement username;

	@FindBy(name="password")
	public static
	WebElement password;

	@FindBy(xpath="//input[@type='submit']")
	public static
	WebElement loginBtn;

	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	public static
	WebElement signUpBtn;

	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	public static
	WebElement crmLogo;

	public LoginPage(WebDriver driver) throws FileNotFoundException{
		LoginPage.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage()  throws FileNotFoundException{
		// TODO Auto-generated constructor stub
	}
}
