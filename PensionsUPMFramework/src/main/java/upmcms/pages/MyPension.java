package upmcms.pages;

import java.io.FileNotFoundException;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;

public class MyPension extends CommonPage{

  public static final Logger log= Logger.getLogger(MyPension.class.getName());
  public static WebDriver driver;

  //Page Factory - OR:
  
  @FindBy(xpath="//*[@type='password']")
  public static WebElement txtPassword;
  
  @FindBy(xpath="//*[@class='civicaformfield civicainputfield']/div")
  public static WebElement lblIncorrectPassword;
  
  @FindBy(xpath="//*[@class='civicaAnswer']/input")
  public static List <WebElement> txtSecQAns;
  
  @FindBy(xpath="//*[@data-fieldname='newUsername']//input")
  public static WebElement txtNewUserName;
  
  @FindBy(xpath="//*[@data-fieldname='retypedUsername']//input")
  public static WebElement txtRetypedUsername;
  
  @FindBy(xpath="//*[@data-fieldname='CurrentPwdinputsecret']/div[2]/input")
  public static WebElement txCurrentPwd;
  
  @FindBy(xpath="//*[@data-fieldname='NewPwdinputsecret']/div[2]/input")
  public static WebElement txtNewPwd;
  
  @FindBy(xpath="//*[@data-fieldname='RetypedNewPwdinputsecret']/div[2]/input")
  public static WebElement txtRetypedNewPwd;
  
  @FindBy(xpath="//*[@class='home-hero hidden-small-only']/div/h1")
  public static WebElement lblDashboard;

  @FindBy(xpath="//*[@class='civicaUPMWidget']//a")
  public static List<WebElement> lstMembershipDetailsLinks;
  
  @FindBy(xpath="//*[@class='civicaUPMWidget']/div[1]//table/tbody")
  public static List<WebElement> tblMembershipDetails;
  
  @FindBy(xpath="//*[@class='civicaformfields civicaformtab']/fieldset/div[1]/div/label")
  public static WebElement lblUpdateMyNomination;

  @FindBy(xpath="//*[@class='civicaformfield civicainputfield']/div")
  public static WebElement lblUpdateMyNominationMsg;

  @FindBy(xpath="//*[@data-fieldname='NOM1']/div[2]/input")
  public static WebElement txtNominee;
  
  @FindBy(xpath="//*[@data-fieldname='RTM1']/div[2]/select")
  public static WebElement drpdnRlToMember;
  
  @FindBy(xpath="//*[@data-fieldname='DOB1']/div[2]/button/i")
  public static WebElement calDOB;
  
  @FindBy(xpath="//*[@class='ui-datepicker-trigger']/i")
  public static WebElement calEffectiveDateOfChange;
  
  @FindBy(xpath="//*[@data-fieldname='NTY1']/div[2]/select")
  public static WebElement drpdnNominationType;
  
  @FindBy(xpath="//*[@data-fieldname='POB1']/div[2]/input")
  public static WebElement txtPctOfBenefits;
  
  @FindBy(xpath="//*[@data-fieldname='ADD1']/div[2]/select")
  public static WebElement drpdnAddNominee;
  
  @FindBy(xpath="//*[@data-fieldname='POB2']/div[2]/input")
  public static WebElement txtPctOfBenefitsNmneTwo;
  
  @FindBy(xpath="//*[@class='civicaRadioList']/div/input")
  public static List<WebElement> rdbNewBankAcInUK;
  
  @FindBy(xpath="//*[@data-fieldname='SortCode']//input")
  public static WebElement txtBankSortCode;
  
  @FindBy(xpath="//*[@class='civicaRadioList']//input")
  public static List<WebElement> rdbRadioOptions;

  @FindBy(xpath="//*[@data-fieldname='Branch']//input")
  public static WebElement txtBankBranch;
  
  @FindBy(xpath="//*[@data-fieldname='Name']//input")
  public static WebElement txtBankName;
  
  @FindBy(xpath="//*[@class='civicaFolder ui-accordion ui-widget ui-helper-reset']//a")
  public static List<WebElement> lstMyMembershipLinks;
  
  @FindBy(xpath="//*[@data-fieldname='PensionAccountName']//input")
  public static WebElement txtAccountName;
  
  @FindBy(xpath="//*[@data-fieldname='AccountName']//input")
  public static WebElement txtBankAccountName;
  
  @FindBy(xpath="//*[@data-fieldname='PensionAccountNo']//input")
  public static WebElement txtAccountNo;
  
  @FindBy(xpath="//*[@data-fieldname='AccountNumber']//input")
  public static WebElement txtBankAccountNo;
  
  @FindBy(xpath="//*[@data-fieldname='PensionPaymentReference']//input")
  public static WebElement txtPaymentRef;
  
  @FindBy(xpath="//*[@data-fieldname='BSocRef']//input")
  public static WebElement txtBldgSctyRef;
  
  @FindBy(xpath="//*[@data-bind='attr: { href: DownloadPDFLink }']")
  public static WebElement lnkViewPayslip; 
  
  public MyPension(WebDriver driver)throws FileNotFoundException{
    driver=TestBase.driver;
    PageFactory.initElements(driver, this);
  }

  public MyPension() throws FileNotFoundException{
  }
  //end of class
}
