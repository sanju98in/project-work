package financialWeb.pages;

import java.io.FileNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;
public class DebtorsNotes extends CommonPage {
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_14']")
  public static WebElement txtMsg;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_14']")
  public static WebElement txtUpdateMsg;

  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_chk_25']")
  public static WebElement chkSetReminderCheckBox;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_chk_27']")
  public static WebElement chkSendToSelfCheckBox;
       
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_26_imgDte']")
  public static WebElement dtReminderDate;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Date_26_imgDte']")
  public static WebElement dtUpdateReminderDate;
 
  @FindBy(xpath="//*[@id='brd_ctl00_Main_WCFinancialsTest1']")
  public static WebElement tabNotesDebtorTab;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Date_26$txtDate']")
  public static WebElement txtReminderDate;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Date_26$txtDate']")
  public static WebElement txtUpdateReminderDate;
  
  public static void setDtUpdateReminderDate() throws InterruptedException {
    clickElement(DebtorsNotes.dtUpdateReminderDate);
  }
  
  public static String getTxtUpdateMsg() {
    return txtUpdateMsg.getAttribute("value");
  }

  public static void setTxtUpdateMsg(String data) {
    setText(DebtorsNotes.txtUpdateMsg,data);
  }
  
  public static String getTxtUpdateReminderDate() {
    return txtUpdateReminderDate.getAttribute("value");
  }

  public static String getTxtReminderDate() {
    return txtReminderDate.getAttribute("value");
  }

  public static void setDbNotesDebtorTab() {
    DebtorsNotes.tabNotesDebtorTab.click();
  }

  public static void setSendToSelfCheckBox() {
    checkCheckBox(DebtorsNotes.chkSendToSelfCheckBox);
  }

  public static WebElement getReminderDate() {
    return dtReminderDate;
  }

  public static void setReminderDate() throws InterruptedException {
    clickElement(DebtorsNotes.dtReminderDate);
  }

  public static String getTxtMsg() {
    return txtMsg.getAttribute("value");
  }

  public static void setTxtMsg(String data) {
    setText(DebtorsNotes.txtMsg,data);
  }

  public static void setSetReminderCheckBox() {
    checkCheckBox(DebtorsNotes.chkSetReminderCheckBox);
  }

    //parameterize constructor to initalize driver and page factory web element
  public DebtorsNotes(WebDriver driver) throws FileNotFoundException{
        driver=TestBase.driver;
        PageFactory.initElements(driver, this);
  }
    
  public DebtorsNotes()  throws FileNotFoundException{
    
  }
   
}
