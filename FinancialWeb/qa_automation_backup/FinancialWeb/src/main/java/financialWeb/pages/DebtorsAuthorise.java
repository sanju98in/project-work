package financialWeb.pages;

import java.io.FileNotFoundException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;
public class DebtorsAuthorise extends CommonPage {
    
    public static final Logger log= Logger.getLogger(DebtorsAuthorise.class.getName());
    public static WebDriver driver;
   
   static DebtorsAuthorise objDebtorsAuthorise;
    //Page Factory - OR:
   @FindBy(xpath="//*[@name='ctl00$Main$WCFinancialsTest1$proxy_txt_1']")
   public static WebElement txtDebtorNumber;
   
   @FindBy(xpath="//*[@name='ctl00$Main$WCFinancialsTest1$proxy_txt_6']")
   public static WebElement txtRefernceOne;
   
   @FindBy(xpath="//*[@name='ctl00$Main$WCFinancialsTest1$proxy_txt_5']")
   public static WebElement txtDBFindCrNoteRefOne;
   
   @FindBy(xpath="//*[@name='ctl00$Main$WCFinancialsTest1$chk_Mr0']")
   public static WebElement chkAuthorise;
   
   @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsTest1_WC_Fin_Date_9_imgDte']")
   public static WebElement dtTransDate;
   
    //parameterize constructor to initalize driver and page factory web element
    public DebtorsAuthorise(WebDriver driver) throws FileNotFoundException{
        driver=TestBase.driver;
        PageFactory.initElements(driver, this);
    }
    public DebtorsAuthorise()  throws FileNotFoundException{
    }
    
    public static void setDBAuthorizreDebtorNumber(String data) throws FileNotFoundException {
      objDebtorsAuthorise = new  DebtorsAuthorise(driver);
      setText(DebtorsAuthorise.txtDebtorNumber,data);
    }
   
    public static void setDBAuthorizeReferneceOne(String data) throws FileNotFoundException {
      objDebtorsAuthorise = new  DebtorsAuthorise(driver);
      setText(DebtorsAuthorise.txtRefernceOne,data);
    }
    
    public static void selectCheckboxAuthorize() throws FileNotFoundException, InterruptedException {
      objDebtorsAuthorise = new  DebtorsAuthorise(driver);
      clickElement(DebtorsAuthorise.chkAuthorise);
    }
    
    public static void setDBFindCrNoteReferneceOne(String data) throws FileNotFoundException {
      objDebtorsAuthorise = new  DebtorsAuthorise(driver);
      setText(DebtorsAuthorise.txtDBFindCrNoteRefOne,data);
    }
    
    public static void clickTransactionDate() throws FileNotFoundException, InterruptedException {
      objDebtorsAuthorise = new DebtorsAuthorise(driver);
      Thread.sleep(1000);
      clickElement(DebtorsVouchers.dtTaxPoint);
    }
    
   }
