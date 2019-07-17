package financialWeb.pages;

import java.io.FileNotFoundException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.TestBase;
public class DebtorsVouchers extends CommonPage {
    
    public static final Logger log= Logger.getLogger(DebtorsVouchers.class.getName());
    public static WebDriver driver;
   
    static DebtorsVouchers objDebtorsVouchers;  
    //Page Factory - OR:
   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_1$cboCombo']")
   public static WebElement drpdnDBCreditNoteTransCode;
   
   @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Combo_34_cboCombo']")
   public static WebElement drpdnTypeOfSupply;
   
   @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Combo_35_cboCombo']")
   public static WebElement drpdnDBInvoiceTypeOfSupply;
                             
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_11']")
   public static WebElement txtDBCreditNoteDebtorNo;
                            
   @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_22_imgDte']")
   public static WebElement dtTaxPoint;
   
   @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_21_imgDte']")
   public static WebElement dtCrSundryGlDate;
   
   @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_23_imgDte']")
   public static WebElement dtGLDate;
   
   @FindBy(xpath="//*[@id='ifrmDate']")
   public static WebElement dtFrame;
   
   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$btn_Table_Results']")
   public static WebElement btnLoad;
   
   @FindBy(xpath="//*[@id='TodayLink']")
   public static WebElement lnkTodayDate;
 
   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_31$cboCombo']")
   public static WebElement drpdnReasonForCredit;
 
   @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_CHARGE_LINES_1_11']")
   public static WebElement txtDescription;
   
   @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_CHARGE_LINES_1_12']")
   public static WebElement txtQty;
   
   @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_CHARGE_LINES_1_13']")
   public static WebElement txtPrice;
   
   @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_CHARGE_LINES_1_14']")
   public static WebElement drpdnVatCodex;
   
   @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_CHARGE_LINES_1_24']")
   public static WebElement txtGLCode;
   
   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Curr_28$txtCurr']")
   public static WebElement txtAmount;

   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_3']")
   public static WebElement txtReference;
   
   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_3']")
   public static WebElement txtRefrence;

   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_38']")
   public static WebElement txtStatus;
   
   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_39']")
   public static WebElement txtDBCreditNoteStatus;
   
   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_17']")
   public static WebElement txtInvoice;

   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_8']")
   public static WebElement txtDBNumber;
   
   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$btnPNT_Complete_2']")
   public static WebElement btnCompleteDBCreditNote;

   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Curr_24$txtCurr']")
   public static WebElement txtDBInvoiceAmount;
   
   @FindBy(xpath="//*[@name='ctl00$Main$WCFinancialsTest1$ctl01']")
   public static WebElement btnAuthorise;
   
   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_41']")
   public static WebElement txtCommentForInvoice;
   
   @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_ErrorLabel']")       
   public static WebElement lblWarningMsg;

   @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Date_19_imgDte']")
   public static WebElement dtGroupDate;
   
   @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_16_imgDte']")
   public static WebElement dtGlDate;
   
   public static void setDtGlDate() {
    DebtorsVouchers.dtGlDate.click();
  }
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_25']")
   public static WebElement txtCommentForDBRecoveryGroup;
   
   @FindBy(xpath="//*[@type='checkbox' and @title='Select\\Unselect All']")
   public static WebElement checkSelectAllCheckbox;
   
   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_27']")
   public static WebElement txtGroupStatus;
   
   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$btn_Table_Results']")
   public static WebElement btnInsert;
   
   @FindBy(xpath="//*[@type='button' and @value='Authorise']")
   public static WebElement btnAuthorize;
   
   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_chk_21']")
   public static WebElement chkChangeRcvryRoute;
   
   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$WC_Fin_Combo_22$cboCombo']")
   public static WebElement drpdnRoute;
   
   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$WC_Fin_Combo_23$cboCombo']")
   public static WebElement drpdnStage;
   
   @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_OBJ_Upd0_WC_Fin_Date_25_imgDte']")
   public static WebElement dtStageDate;
   
   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd1$WC_Fin_Combo_17$cboCombo']")
   public static WebElement drpdnProvRoute;
   
   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd1$WC_Fin_Combo_18$cboCombo']")
   public static WebElement drpdnProvStage;
   
   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd2$proxy_txt_14']")
   public static WebElement txtMessage;
   
   @FindBy(xpath="//*[@id='brd_ctl00_Main_WCFinancialsFind0']")
   public static WebElement tabDBNotesForRcvryGroup;
   
   @FindBy(xpath="//*[@type='button' and @value='Add to Recovery Group']")
   public static WebElement btnAddTpRcvryGroup;
   
   @FindBy(xpath="//input[starts-with(@id, 'ctl00_Main_WC_FIN_Grid_Upd')  and contains(@id, '_txtPIN_TIDYBETWEENPLSELECTED_2_13')]")
   public static WebElement txtInvoceTidyAmt;
 
   @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_find_3']")
   public static WebElement btnFindReference;
 
   
    //parameterize constructor to initalize driver and page factory web element
    public DebtorsVouchers(WebDriver driver) throws FileNotFoundException{
        driver=TestBase.driver;
        PageFactory.initElements(driver, this);
    }
    
    public DebtorsVouchers()  throws FileNotFoundException{
    }
   
    public static String getDropdnDBInvoiceTypeOfSupply() {
      Select oSelect = new Select(DebtorsVouchers.drpdnDBInvoiceTypeOfSupply);
      return oSelect.getFirstSelectedOption().getText();
    }
    
    public static void setDBCreditNoteTransCode(String data) throws InterruptedException, FileNotFoundException {
      objDebtorsVouchers = new DebtorsVouchers(driver);
      selectDropDown(DebtorsVouchers.drpdnDBCreditNoteTransCode,data);
    }
    public static String getDBCreditNoteTransCode() throws InterruptedException, FileNotFoundException {
      objDebtorsVouchers = new DebtorsVouchers(driver);
      String transCode = DebtorsVouchers.drpdnDBCreditNoteTransCode.getAttribute("value");
      return transCode;
    }
    
    public static void setDBCreditNoteDebtorNo(String data) throws FileNotFoundException, InterruptedException {
      objDebtorsVouchers = new DebtorsVouchers(driver);
      setText(DebtorsVouchers.txtDBCreditNoteDebtorNo,data);
      Thread.sleep(3000);
    }
    
    public static void setDBCreditLineDescription(String data) throws FileNotFoundException {
      objDebtorsVouchers = new DebtorsVouchers(driver);
      setText(DebtorsVouchers.txtDescription, data);
    }
    public static String getDBCreditLineDescription() throws FileNotFoundException {
      objDebtorsVouchers = new DebtorsVouchers(driver);
      return DebtorsVouchers.txtDescription.getAttribute("value");
    }

    public static void setDrpdnReasonForCredit(String data) throws InterruptedException {
      selectDropDown(DebtorsVouchers.drpdnReasonForCredit,data);
    }
    public static void creditLineQty(String data) throws FileNotFoundException {
      objDebtorsVouchers = new DebtorsVouchers(driver);
      setText(DebtorsVouchers.txtQty,data);
    }
    public static String getcreditLineQty() throws FileNotFoundException {
      objDebtorsVouchers = new DebtorsVouchers(driver);
      return DebtorsVouchers.txtQty.getAttribute("value");
    }
    public static void CreditLinePrice(String data) throws FileNotFoundException {
      objDebtorsVouchers = new DebtorsVouchers(driver);
      setText(DebtorsVouchers.txtPrice,data);
    }
    public static String getCreditLinePrice() throws FileNotFoundException {
      objDebtorsVouchers = new DebtorsVouchers(driver);
      return DebtorsVouchers.txtPrice.getAttribute("value");
    }
    public static void creditLineVat(String data) throws FileNotFoundException, InterruptedException {
      objDebtorsVouchers = new DebtorsVouchers(driver);
      selectDropDown(DebtorsVouchers.drpdnVatCodex,data);
    }
    public static String getcreditLineVat() throws FileNotFoundException {
      objDebtorsVouchers = new DebtorsVouchers(driver);
      return DebtorsVouchers.drpdnVatCodex.getAttribute("value");
    }
    public static void setGLCode(String data) throws FileNotFoundException, InterruptedException {
      objDebtorsVouchers = new DebtorsVouchers(driver);
      setText(DebtorsVouchers.txtGLCode,data);
      Thread.sleep(2000);
      
    }
    
    public static String getReference() throws FileNotFoundException {
      objDebtorsVouchers = new DebtorsVouchers(driver);
      return txtReference.getAttribute("value");
    }
    
    public static String setDBCreditNoteReference(String data) throws FileNotFoundException {
      objDebtorsVouchers = new DebtorsVouchers(driver);
      setText(DebtorsVouchers.txtReference, data);
      return data;
    }
    
   
    
    public static String getStatus() throws FileNotFoundException, InterruptedException {
      objDebtorsVouchers = new DebtorsVouchers(driver);
    return txtStatus.getAttribute("value");
    }
    
    public static String getCRNoteStatus() throws FileNotFoundException, InterruptedException {
      objDebtorsVouchers = new DebtorsVouchers(driver);
    return txtDBCreditNoteStatus.getAttribute("value");
    }
    
    public static void setDBCreditNoteInvoice(String data) {
      setText(DebtorsVouchers.txtInvoice, data);
    }
    
    public static void setDBInvoiceDebtorNumber(String data) throws InterruptedException, FileNotFoundException {
      setText(CreditorPayments.txtCrNumber, data);
      Thread.sleep(3000);
    }
    public static void setCrCreditNoteNumber(String data) throws InterruptedException, FileNotFoundException {
      setText(DebtorsVouchers.txtDBNumber, data);
      Thread.sleep(3000);
    }
    public static void setTxtCommentForInvoice(String data) {
      setText(DebtorsVouchers.txtCommentForInvoice,data);
    }
    public static String getTxtCommentForInvoice() throws FileNotFoundException {
      return DebtorsVouchers.txtCommentForInvoice.getAttribute("value");
    }
    public static String getDropdnTypeOfSupply() {
      Select oSelect = new Select(DebtorsVouchers.drpdnTypeOfSupply);
      return oSelect.getFirstSelectedOption().getText();
    }
    public static void clickGroupDate() throws InterruptedException {
      clickElement(dtGroupDate);
    }

    public static void setRecoveryGroupComment(String data) throws InterruptedException {
      setText(txtCommentForDBRecoveryGroup,data);
    }

    public static void selectAllCheckBox() {
      checkCheckBox(checkSelectAllCheckbox);
    }
    
    public static String getGroupStatus() throws InterruptedException {

      return txtGroupStatus.getAttribute("value");
    }

    public static void insert() throws InterruptedException {
     clickElement(btnInsert);
    }
    
    public static void authorize() throws InterruptedException, FileNotFoundException {
      objDebtorsVouchers = new DebtorsVouchers(driver);
      btnAuthorize.click();
   }
    public static void setMessage(String data) throws InterruptedException {
      setText(txtMessage, data);
     }
}
