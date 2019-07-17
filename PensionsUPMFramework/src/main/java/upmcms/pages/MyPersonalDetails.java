package upmcms.pages;

import java.io.FileNotFoundException;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;

public class MyPersonalDetails extends CommonPage{

  public static final Logger log= Logger.getLogger(MyPersonalDetails.class.getName());
  public static WebDriver driver;

  //Page Factory - OR:
  
  @FindBy(xpath="//*[@class='civicaPersonLinks']/a")
  public static List<WebElement> lstPersonalLinks;
  
  @FindBy(xpath="//div[@class='civicaUPMWidget']/div/div/table/tbody")
  public static WebElement lstPersonalWidegetDetails;

  @FindBy(xpath="//*[@type='text' and @aria-labelledby='CivicaFormLabel-1']")
  public static WebElement txtNewEmailAdd;

  @FindBy(xpath="//*[@type='text' and @aria-labelledby='CivicaFormLabel-2']")
  public static WebElement txtRepeatNewEmailAdd;
  
  @FindBy(xpath="//*[@type='text' and @aria-labelledby='CivicaFormLabel-1']")
  public static WebElement txtUpdateNewEmailAdd;

  @FindBy(xpath="//*[@type='text' and @aria-labelledby='CivicaFormLabel-2']")
  public static WebElement txtUpdateRepeatNewEmailAdd;
  
  @FindBy(xpath="//div[@class='civicaformfields civicaformtab']/fieldset/div/div[2]/input")
  public static List<WebElement> txtUpdateMyEmailInputList;
  
  @FindBy(xpath="//*[@class='civicaformfield civicainputfield']/div")
  public static WebElement lbltEmailAddErrorValidation;

  @FindBy(xpath="//span[text()='Submit']")
  public static WebElement btnSubmit;
  
  @FindBy(xpath="//span[text()='Retry']")
  public static WebElement btnRetry;
  
  @FindBy(xpath="//span[text()='Ok']")
  public static WebElement btnOk;
  
  @FindBy(xpath="//*[@class='civicaEmail civicaFieldValue']")
  public static WebElement lblEmail;
  
  @FindBy(xpath="//*[@class='civica-menu hidden-small-only']/ul/li/a")
  public static List<WebElement> lblInThisSection;

  @FindBy(xpath="//*[@class='qtip-content']")
  public static List<WebElement> lblAlert;
  
  @FindBy(xpath="//*[@data-fieldname='PMOC']//select")
  public static WebElement drpdnContactMethod;
  
  @FindBy(xpath="//*[@class='ui-widget-content']/table/tbody")
  public static List<WebElement> tblMyPersonalDetails;
  



  public MyPersonalDetails(WebDriver driver)throws FileNotFoundException{
    driver=TestBase.driver;
    PageFactory.initElements(driver, this);
  }

  public MyPersonalDetails() throws FileNotFoundException{
  }
  //end of class
}
