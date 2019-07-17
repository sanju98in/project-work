package financialWeb.pages;

import java.io.FileNotFoundException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.TestBase;

public class CreditorEnquiries extends CommonPage {

  public static final Logger log = Logger.getLogger(CreditorEnquiries.class.getName());
  public static WebDriver driver;

  @FindBy(xpath = "//*[@name='ctl00$Main$WCFinancialsTest1$WC_Fin_Combo_2$cboCombo']")
  public static WebElement drpdnDepartment;

  // @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_3$cboCombo']")
    @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Combo_3_cboCombo']")
  public static WebElement drpdnTransactionCode;

  // @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_27$cboCombo']")
   @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Combo_27_cboCombo']")
  public static WebElement drpdnCrManualpaymentStatus;

  // @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Date_18_imgDte']")
  @FindBy(xpath = "//*[contains(text(),'Payment Date')]/parent::*/following-sibling::*//img")
  public static WebElement dtManualPaymentDate;

   @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Date_20_imgDte']")
  //@FindBy(xpath = "//*[contains(text(),'GL Date')]/parent::*/following-sibling::*//img")
  public static WebElement dtManualPaymentGlDate;

  // @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Curr_24$txtCurr']")
  @FindBy(xpath = "//*[contains(text(),'Exchange Rate')]/parent::td/following-sibling::td//input[@type='text']")
  public static WebElement txtExchangeRate;

  // @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Curr_25$txtCurr']")
  @FindBy(      xpath = "//*[contains(text(),'Payment Amount')]/parent::td/following-sibling::td//input[@type='text']")
  public static WebElement txtPaymentAmount;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Enq0$proxy_txt_1']")
  public static WebElement txtCrNumber;
  
  @FindBy(xpath = "//*[contains(text(),'Amount')]/parent::td/following-sibling::td//input[@type='text' and @class='currfield']")
  public static WebElement txtAmount;

  // @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_6']")
  @FindBy(
      xpath = "//*[contains(text(),'Payment Number')]/parent::td/following-sibling::td//input[@type='text']")
  public static WebElement txtManualPaymentNo;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_12']")
  public static WebElement txtTypeOfBankAccount;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_14']")
  public static WebElement txtBankRefNumber;

  @FindBy(xpath = "//*[@type='submit' and @value='Submit']")
  public static WebElement btnSubmit;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_OBJ_Enq0_TabClick_Bank_Details']")
  public static WebElement lblBankDetailsTab;

  public static void setLblBankDetailsTab() {
    CreditorEnquiries.lblBankDetailsTab.click();
  }

  public static void setBtnSubmit() throws InterruptedException {
    CreditorEnquiries.btnSubmit.click();
    waitForPageLoad();
  }

  public static void setTxtCrNumber(String data) {
    setText(CreditorEnquiries.txtCrNumber, data);
  }

  public static void setTxtBankRefNumber(String data) {
    setText(CreditorEnquiries.txtBankRefNumber, data);
  }

  public static void setTxtTypeOfBankAccount(String data) {
    setText(CreditorEnquiries.txtTypeOfBankAccount, data);
  }

  public static String getTxtManualPaymentNo() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    return txtManualPaymentNo.getAttribute("value");
  }

  public static String getTxtAmont() {
    return txtAmount.getAttribute("value");
  }

  public static String getDrpdnCrManualpaymentStatus() {
    Select oSelect = new Select(CreditorEnquiries.drpdnCrManualpaymentStatus);
    String maunalPaymentStatus = oSelect.getFirstSelectedOption().getText();
    return maunalPaymentStatus;
  }

  public static void setTxtPaymentAmount(String data) {
    setText(CreditorEnquiries.txtPaymentAmount, data);
  }

  public static void setTxtExchangeRate(String data) {
    setText(CreditorEnquiries.txtExchangeRate, data);
  }

  public static String getTxtExchangeRate() {
    return CreditorEnquiries.txtExchangeRate.getAttribute("value");
  }

  public static void setDtManualPaymentGlDate() throws InterruptedException {

    clickElement(CreditorEnquiries.dtManualPaymentGlDate);
    Thread.sleep(2000);

  }

  public static void setDtManualPaymentDate() throws InterruptedException {
    clickElement(CreditorEnquiries.dtManualPaymentDate);
    Thread.sleep(2000);
  }

  public static void setDrpdnTransactionCode(String data) throws InterruptedException {
    selectDropDown(CreditorEnquiries.drpdnTransactionCode, data);
  }

  public static void setDrpdnDepartment(String data) throws InterruptedException {
    selectDropDown(CreditorEnquiries.drpdnDepartment, data);
  }

  // parameterize constructor to initalize driver and page factory web element
  public CreditorEnquiries(WebDriver driver) throws FileNotFoundException {
    driver = TestBase.driver;
    PageFactory.initElements(driver, this);
  }

  public CreditorEnquiries() throws FileNotFoundException {

  }

}
