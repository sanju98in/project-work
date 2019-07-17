package financialWeb.pages;

import java.io.FileNotFoundException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;

public class CreditorMaintenance extends CommonPage {

  public static final Logger log = Logger.getLogger(CreditorMaintenance.class.getName());
  public static WebDriver driver;

  // Page Factory - OR:
  @FindBy(xpath = "//*[@id='ctl00_Main_WCFinancialsFind0_proxy_txt_1']")
  public static WebElement txtPostCode;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_OBJ_Upd0_proxy_txt_1']")
  //@FindBy(xpath = "//label[contains(text(),'Creditor Number')]/parent::td/following-sibling::td/input[@type='text']")
  public static WebElement txtCreditorNumber;
  
  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_find_1']")
  public static WebElement btnFindCreditorNumber;
  
  @FindBy(xpath = "//*[@name='ctl00$Main$WCFinancialsFind0$proxy_txt_2']")
  public static WebElement btnFindCreditorName;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd1$proxy_txt_4']")
  public static WebElement txtInsertCreditorName;
  
  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_3']")
  public static WebElement txtContactName;
  
  @FindBy(xpath = "//*[contains(@value,'Purchasing Details') and @type='button']")
  public static WebElement tabPpurchasingDetails;


  @FindBy(xpath = "//*[contains(@value,'Other Details') and @type='button']")
  public static WebElement tabOtherDetails;
  
  @FindBy(xpath = "//*[contains(@value,'Main') and @type='button']")
  public static WebElement tabMain;
  
  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_4']")
  public static WebElement txtJobTitle;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_4']")
  public static WebElement txtName;

  @FindBy(xpath = "//input[@id='ctl00_Main_WC_FIN_OBJ_Upd0_proxy_txt_6']")
  public static WebElement txtDefaultAddedAdd;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_OBJ_Upd0_proxy_txt_9']")
  public static WebElement txtTelephoneNumber;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_OBJ_Upd0_proxy_txt_13']")
  public static WebElement txtInsertEmail;
  
  // @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_OBJ_Upd0_proxy_txt_16']")
  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_OBJ_Upd0_proxy_txt_13']")
  public static WebElement txtEmailAdd;
  
  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_OBJ_Upd1_proxy_txt_13']")
  public static WebElement txtInsertEmailAddress;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_OBJ_Upd0_proxy_txt_14']")
  public static WebElement txtInsertContactEmailAdd;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_15']")
  public static WebElement txtComment;

  @FindBy(xpath = "//input[@id='ctl00_Main_WC_FIN_OBJ_Upd0_proxy_txt_16']")
  public static WebElement txtDefaultAddedPostCode;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_24']")
  public static WebElement txtAddComment;


  @FindBy(xpath = "//label[contains(text(),'Creditor Status')]/parent::td/following-sibling::td/input[@type='text']")
  //@FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_OBJ_Upd0_proxy_txt_25']")
  public static WebElement txtCreditorStatus;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_OBJ_Upd1_proxy_txt_27']")
  public static WebElement txtInsertCreditorStatus;
  
  @FindBy(xpath = "//input[@id='ctl00_Main_WC_FIN_OBJ_Upd0_proxy_txt_27']")
  public static WebElement txtDefaultAddedEmailAdd;
  
  @FindBy(xpath = "//input[@id='ctl00_Main_WC_FIN_OBJ_Upd0_proxy_txt_30']")
  public static WebElement txtInsertAddLineOne;
  
  @FindBy(xpath = "//input[@id='ctl00_Main_WC_FIN_OBJ_Upd0_proxy_txt_40']")
  public static WebElement txtInsertPostCode;
  
  @FindBy(xpath = "//input[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_43']")
  public static WebElement txtInsertEmailAdd;
 
  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$WC_Fin_Combo_6$cboCombo']")
  public static WebElement drpdnAInsertPaymentMethod;
  
  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$WC_Fin_Combo_4$cboCombo']")
  public static WebElement drpdnAddType;

  // @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_OBJ_Upd0_WC_Fin_Combo_8_cboCombo']")
  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_OBJ_Upd0_WC_Fin_Combo_8_cboCombo']")
  public static WebElement drpdnPaymentMethod;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$WC_Fin_Combo_8$cboCombo']")
  public static WebElement drpDnTelDescription;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$WC_Fin_Combo_12$cboCombo']")
  public static WebElement drpDnPrintMethod;

  //@FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$WC_Fin_Combo_14$cboCombo']")
  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$WC_Fin_Combo_14$cboCombo']")
  public static WebElement drpdnInsertAccessLevel;
  
  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$WC_Fin_Combo_11$cboCombo']")
  public static WebElement drpdnInsertLocation;
  
  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$WC_Fin_Combo_3$cboCombo']")
  public static WebElement drpdnInsertTypeOfCreditor;
  
  
  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_OBJ_Upd0_WC_Fin_Combo_18_cboCombo']")
  public static WebElement drpdnPaymentDay;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_OBJ_Upd0_WC_Fin_Combo_17_cboCombo']")
  // @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_OBJ_Upd0_WC_Fin_Combo_20_cboCombo']")
  public static WebElement drpdnAccessLevel;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_OBJ_Upd0_WC_Fin_Combo_18_cboCombo']")
  //@FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_OBJ_Upd0_WC_Fin_Combo_21_cboCombo']")
  public static WebElement drpdnLocation;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_OBJ_Upd0_WC_Fin_Combo_19_cboCombo']")
  //@FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_OBJ_Upd0_WC_Fin_Combo_5_cboCombo']")
  public static WebElement drpdnTypeOfCreditor;
  
  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_OBJ_Upd0_WC_Fin_Combo_28_cboCombo']")
  public static WebElement drpdnInsertAddType;

  @FindBy(xpath = "//*[@type='submit' and @value='Edit Address']")
  public static WebElement btnEditAddress;

  @FindBy(xpath = "//*[@type='button' and @value='Submit']")
  public static WebElement btnSubmit;
  
  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$btn_Clear']")
  public static WebElement btnClear;

  @FindBy(xpath = "//*[@type='submit' and @value='Insert Address']")
  public static WebElement btnInsertAddress;
                            
  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_1']")
  public static WebElement txtCrNumber;
  
  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_10']")
  public static WebElement txtBankAcNumber;
  
  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_11']")
  public static WebElement txtBankAcSortCode;
  
  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_13']")
  public static WebElement txtBankAcName;
  
  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_25']")
  public static WebElement txtCrStatus;
  
  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_27']")
  public static WebElement txtCreditorMaintenanceStatus;
  
  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$WC_Fin_Combo_13$cboCombo']")
  public static WebElement drpdnReason;
  
  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_chk_3']")
  public static WebElement chkPurchasingSupplier;
  
  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_8']")
  public static WebElement txtOtherEmailAdd;
  
  @FindBy(xpath = "//*[@name='ctl00$Main$WCFinancialsFind0$proxy_txt_3']")
  public static WebElement txtCrAdd;
  
  @FindBy(xpath = "//*[@name='ctl00$Main$WCFinancialsFind0$proxy_txt_4']")
  public static WebElement txtCrPostCode;
  
  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd1$proxy_txt_27']")
  public static WebElement txtCrMaintenanceStatus;
  
  
  public static String getTxtCrMaintenanceStatus() {
    return txtCrMaintenanceStatus.getAttribute("value");
  }

  // parameterize constructor to initalize driver and page factory web element
  public CreditorMaintenance(WebDriver driver) throws FileNotFoundException {
    driver = TestBase.driver;
    PageFactory.initElements(driver, this);
  }

  public CreditorMaintenance() throws FileNotFoundException {}
  
  public static void setValueCrNumber(String data) {
    setText(txtCrNumber,data);
  }
  
  public static void setBankACNumber(String data) {
    setText(txtBankAcNumber,data);
  }
  
  public static void setBankSortCode(String data) {
    setText(txtBankAcSortCode,data);
  }
  
  public static void setBankAccountName(String data) {
    setText(txtBankAcName,data);
  }

  public static void setLiableReason(String data) throws InterruptedException {
    selectDropDown(drpdnReason, data);
  }

  public static void OtherEmailAddress(String data) {
   setText(txtOtherEmailAdd, data);
  }
  
  public static void clickCreditorNumber() throws InterruptedException {
    clickElement(btnFindCreditorNumber);
   }

  public static void crName(String data) {
    setText(btnFindCreditorName, data);
    
  }

  public static void crAddress(String data) {
    setText(txtCrAdd, data);
  }

  public static void crPostCode(String data) {
    setText(txtCrPostCode, data);
  }
  
}

