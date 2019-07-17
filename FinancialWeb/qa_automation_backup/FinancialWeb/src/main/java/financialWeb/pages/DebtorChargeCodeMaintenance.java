package financialWeb.pages;

import java.io.FileNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;

/**Some common methods which can be used for any page actions.
 */

public class DebtorChargeCodeMaintenance extends TestBase {
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_1']")
  public static WebElement txtChargeCode;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_4']")
  public static WebElement txtShortDescription;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_5']")
  public static WebElement txtDescription;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_6$cboCombo']")
  public static WebElement popUpTextDropDn;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_7$cboCombo']")
  public static WebElement unitOfChargeDropDn;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_chk_8']")
  private static WebElement chkPriceInclusiveOfVAT;
   
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Curr_9$txtCurr']")
  public static WebElement txtDefaultQuantity;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_12$cboCombo']")
  public static WebElement vatCodeDropDn;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_CHARGE_PRICE_1_3']")
  public static WebElement txtStartDate;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_CHARGE_PRICE_1_4']")
  public static WebElement txtPrice;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_chk_11']")
  public static WebElement uncheckSuspendChargeCheckBox;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_CHARGE_LEDGER_SPLIT_1_3']")
  public static WebElement txtGLCode;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_CHARGE_PRICE_2_3']")
  public static WebElement txtsecondStartDate;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_CHARGE_PRICE_2_4']")
  public static WebElement txtSecondPrice;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_CHARGE_LEDGER_SPLIT_1_4']")
  public static WebElement txtAnalysisCode;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WCFinancialsTest1_tvDatan8CheckBox']")
  public static WebElement architecturalCheckBox;
  
  //@FindBy(xpath="//*[@name='ctl00_Main_WCFinancialsTest1_tvDatan271CheckBox']")
  @FindBy(xpath="//*[@name='ctl00_Main_WCFinancialsTest1_tvDatan270CheckBox']")
  public static WebElement housingCheckBox;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WCFinancialsFind0$proxy_txt_1']")
  public static WebElement txtDBfindChargeCode;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WCFinancialsTest1_tvDatan20CheckBox']")
  public static WebElement chiefExecCheckBox;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$btn_Clear']")
  public static WebElement btnclear;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_chk_15']")
  private static WebElement chkAllowOverrideDesc;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_chk_17']")
  private static WebElement chkAllowOverridePrice;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_chk_19']")
  private static WebElement chkAllowOverrideVatCode;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_chk_21']")
  private static WebElement chkAllowOverrideLedgerCode;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_chk_23']")
  private static WebElement chkAllowOverrideUnitOfCharge;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WCFinancialsTest1$ctl01']")
  public static WebElement btnUpdate;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WCFinancialsTest1$ctl02']")
  public static WebElement btnClose;
  
  @FindBy(xpath="//*[@id='divmastermsgbox_Question_OK']")
  public static WebElement msgboxQuestionOK;
  
  public DebtorChargeCodeMaintenance(WebDriver driver)throws FileNotFoundException{
    driver=TestBase.driver;
      PageFactory.initElements(driver, this);
  }

  public DebtorChargeCodeMaintenance() throws FileNotFoundException{
  }
  
  public static String getChargeCode() throws InterruptedException {
    highlightElement(txtChargeCode);
    return txtChargeCode.getAttribute("value");
  }
  
  
  public static void checkPriceInclusiveOfVAT() {
    checkCheckBox(chkPriceInclusiveOfVAT);
  }
  
  public static void allowOverrideDesc() {
    checkCheckBox(chkAllowOverrideDesc);
  }
  public static void allowOverridePrice() {
    checkCheckBox(chkAllowOverridePrice);
  }
  public static void allowOverrideVatCode() {
    checkCheckBox(chkAllowOverrideVatCode);
  }
  public static void allowOverrideLedgerCode() {
    checkCheckBox(chkAllowOverrideLedgerCode);
  }
  
  public static void allowOverrideUnitOfCharge() {
    checkCheckBox(chkAllowOverrideUnitOfCharge);
  }
  
  public static void updateDBChargeCodeSecurity() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    btnUpdate.click();
  }
  
  public static void closeDBChargeCodeSecurity() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    btnClose.click();
    waitforPanelLoad();
  }
}//end of class