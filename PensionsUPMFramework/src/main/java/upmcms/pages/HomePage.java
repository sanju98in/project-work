package upmcms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;

import java.io.FileNotFoundException;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonPage{

  public static final Logger log= Logger.getLogger(HomePage.class.getName());
  public static WebDriver driver;

  //Page Factory - OR:
  @FindBy(xpath="/html/body/div/div/div/p")
  public static List<WebElement> myPsnsionsLinks;
  
  @FindBy(xpath="//*[@class='home-hero hidden-small-only']/nav")
  public static List<WebElement> lnkHomePageTopMenuLink;

  @FindBy(xpath="//span[text()='Submit']")
  public static WebElement btnSumit;

  @FindBy(xpath="//span[text()='Back']")
  public static WebElement btnBack;
  
  @FindBy(xpath="//*[@data-fieldname='submit']//a")
  public static WebElement btnNext;
  
  @FindBy(xpath="//span[text()='Complete']")
  public static WebElement btnComplete;
  
  @FindBy(xpath="//span[text()='Confirm']")
  public static WebElement btnConfirm;
  
  @FindBy(xpath="//span[text()='Search']")
  public static WebElement btnSearch;
  
  public HomePage(WebDriver driver)throws FileNotFoundException{
    driver=TestBase.driver;
    PageFactory.initElements(driver, this);
  }

  public HomePage() throws FileNotFoundException{
  }
  //end of class
}
