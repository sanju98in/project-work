/*package financialWeb.pages;

import java.io.FileNotFoundException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;

*//**Some common methods which can be used for any page actions.
 *//*

public class PreRequisitesPage extends TestBase {
  
  public static final Logger log= Logger.getLogger(PreRequisitesPage.class.getName());
  public static WebDriver driver;
  
  @FindBy(xpath="//*[text()= 'Sign Out']")
  public static WebElement signOut;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_8']")
  public static WebElement txtTransactionCode;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_9']")
  public static WebElement txtDescription;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_11']")
  public static WebElement txtRefrenceOneCaption;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_13']")
  public static WebElement txtRefrenceTwoCaption;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_12']")
  public static WebElement txtPrefix;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_14']")
  public static WebElement txtKeyOneValue;

  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_RULES_6_9']")
  public static WebElement drpdnInvoiceAuthorisation;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_chkPIN_RULES_13_8']")
  public static WebElement chkAllowNegativeQty;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_chkPIN_RULES_20_8']")
  public static WebElement chkDisplayTxtDebtorRecord;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_chkPIN_RULES_21_8']")
  public static WebElement chkAllowZeroValueInvoices;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_RULES_27_9']")
  public static WebElement drpdnDefaultNextPrintStatus;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_RULES_28_9']")
  public static WebElement drpdnTypeOfSupply;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_RULES_41_9']")
  public static WebElement drpdnDefaultPrintReportStyle;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_RULES_42_9']")
  public static WebElement drpdnDefaultPrintExactReportStyle;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_chkPIN_RULES_43_8']")
  public static WebElement chkAllowDDOnInvoiceWithoutInstallments;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_2$cboCombo']")
  public static WebElement drpdnCompany;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_3$cboCombo']")
  public static WebElement drpdnModule;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_4$cboCombo']")
  public static WebElement drpdnUserGroupName;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WCFinancialsTest1$WC_Fin_Combo_5$cboCombo']")
  public static WebElement drpdnRangeType;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd2$WC_Fin_Combo_14$cboCombo']")
  public static WebElement drpdnPrefixOne;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_chk_9']")
  public static WebElement chkSuspend;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd2$proxy_txt_11']")
  public static WebElement txtTransCodeKey;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd2$proxy_txt_12']")
  public static WebElement txtDeptSectKey;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd2$WC_Fin_Curr_22$txtCurr']")
  public static WebElement txtRangeFrom;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd2$WC_Fin_Curr_23$txtCurr']")
  public static WebElement txtRangeTo;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd2$WC_Fin_Curr_24$txtCurr']")
  public static WebElement txtLastNumber;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd2$WC_Fin_Curr_26$txtCurr']")
  public static WebElement txtLength;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd2$WC_Fin_Combo_1$cboCombo']")
  public static WebElement drpdnTransCode;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_chkPIN_RULES_12_8']")
  public static WebElement chkNegativeQtyAllow;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_chkPIN_RULES_15_8']")
  public static WebElement chkAllowPostingGlYearInCloseDown;

  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_RULES_17_9']")
  public static WebElement drpdnReason;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_RULES_21_9']")
  public static WebElement drpdnCrNoteDefaultPrintStatus;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_RULES_22_9']")
  public static WebElement drpdnCrNoteDefaultTypeOfSupply;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_chkPIN_RULES_23_8']")
  public static WebElement chkUnallocatedAmount;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_RULES_31_9']")
  public static WebElement drpdnCrNoteDefaulrPrintNowReportStyle;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_RULES_32_9']")
  public static WebElement drpdnCrNoteDefaultPrintExactCopyReportStyle;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_chkPIN_RULES_33_8']")
  public static WebElement chkDepartmentAndSectionInvoice;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_RULES_1_9']")
  public static WebElement drpdnAutoGenPimNumber;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_chkPIN_RULES_9_8']")
  public static WebElement chkDisplayTextFromDebtor;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_chkPIN_RULES_10_8']")
  public static WebElement chkAllowZeroValuePIMToBeEntered;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_chkPIN_RULES_10_8']")
  public static WebElement drpdnPimDefaultPrintStatus;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_chkPIN_RULES_12_8']")
  public static WebElement chkUnallocatedCashHeldAgainstPim;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_RULES_13_9']")
  public static WebElement drpdnTransCodeForInvoiceGeneration;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_chkPIN_RULES_14_8']")
  public static WebElement chkPrintMandateReqByDefault;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_chkPIN_RULES_15_8']")
  public static WebElement chkPrintAgreementLetterByDefault;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_RULES_16_9']")
  public static WebElement drpdnGlPeriodOverride;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_RULES_23_7']")
  public static WebElement txtNumberOfDaysPriorToRaiseInvoice;

  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_RULES_2_9']")
  public static WebElement drpdnAutoGenerateControlNumber;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_RULES_3_9']")
  public static WebElement drpdnControlExpAmtRequired;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_RULES_4_9']")
  public static WebElement drpdnControlExpNumberRequired;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_RULES_5_9']")
  public static WebElement drpdnAutoGenCrNoteNumber;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_RULES_10_9']")
  public static WebElement drpdnAdditionalRefRequired;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_chkPIN_RULES_28_8']")
  public static WebElement chkAdjustUseOrgDeptAndSection;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_RULES_7_9']")
  public static WebElement drpdnPaymentAuthorisation;
  

  //parameterize constructor to initalize driver and page factory web element
  public PreRequisitesPage(WebDriver driver) throws FileNotFoundException{
        driver=TestBase.driver;
        PageFactory.initElements(driver, this);
  }
  
  public PreRequisitesPage()  throws FileNotFoundException{
    
  }

}//end of class*/