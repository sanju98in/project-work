package financialWeb.pages;

import java.io.FileNotFoundException;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;
public class DebtorsInvoice extends CommonPage {
    
    public static final Logger log= Logger.getLogger(DebtorsInvoice.class.getName());
    public static WebDriver driver;
   
    static DebtorsInvoice objDebtorsInvoice;
    //Page Factory - OR:
   @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_14_imgDte']")
   public static WebElement dtTaxPoint;
   
     @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_15_imgDte']")
   public static WebElement dtGLDate;
   
   @FindBy(xpath="//*[@id='ifrmDate']")
   public static WebElement dtFrame;
   
   @FindBy(xpath="//*[@id='TodayLink']")
   public static WebElement lnkTodayDate;
 
   @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_CHARGE_LINES_1_25']")
   public static WebElement txtDBInvoiceGLCode;
   
   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Curr_24$txtCurr']")
   public static WebElement txtDBInvoiceAmount;
   
   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_43']")
   public static WebElement txtDBInvoiceStatus;
   
    //parameterize constructor to initalize driver and page factory web element
    public DebtorsInvoice(WebDriver driver) throws FileNotFoundException{
        driver=TestBase.driver;
        PageFactory.initElements(driver, this);
    }
    
    public DebtorsInvoice()  throws FileNotFoundException{
    }
   
    public static void setDBInvoiceTaxPoint() throws FileNotFoundException, InterruptedException {
      objDebtorsInvoice = new DebtorsInvoice(driver);
      Thread.sleep(1000);
      clickElement(DebtorsInvoice.dtTaxPoint);
    }

    public static void setDBInvoiceGLDate() throws FileNotFoundException, InterruptedException {
      objDebtorsInvoice = new DebtorsInvoice(driver);
      clickElement(DebtorsInvoice.dtGLDate);
      Thread.sleep(2000);
    }
    
    public static void setGLCode(String data) throws FileNotFoundException, InterruptedException {
      objDebtorsInvoice = new DebtorsInvoice(driver);
      setText(DebtorsInvoice.txtDBInvoiceGLCode,data);
      DebtorsInvoice.txtDBInvoiceGLCode.sendKeys(Keys.TAB);
      Thread.sleep(2000);
    }
    public static String getGLCode() throws FileNotFoundException, InterruptedException {
      objDebtorsInvoice = new DebtorsInvoice(driver);
      String glCode = DebtorsInvoice.txtDBInvoiceGLCode.getAttribute("value");
      return glCode;
    }
   
    public static String getDBInvoiceStatus() throws FileNotFoundException, InterruptedException {
      objDebtorsInvoice = new DebtorsInvoice(driver);
    return txtDBInvoiceStatus.getAttribute("value");
  }
    
    public static void setDBInvoiceStatus(String data) throws FileNotFoundException, InterruptedException {
      objDebtorsInvoice = new DebtorsInvoice(driver);
      setText(txtDBInvoiceStatus,data);
  }
   
}
