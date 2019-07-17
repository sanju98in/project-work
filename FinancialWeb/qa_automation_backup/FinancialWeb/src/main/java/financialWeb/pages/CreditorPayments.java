package financialWeb.pages;

import java.io.FileNotFoundException;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.TestBase;

public class CreditorPayments extends CommonPage {

  public static final Logger log= Logger.getLogger(CreditorPayments.class.getName());
    public static WebDriver driver;
    
    //Page Factory - OR:
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_2$cboCombo']")
    private static WebElement drpdnTemplate;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_3']")
    public static WebElement txtVoucherNumber ;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_5']")
    public static WebElement txtPaymentNo ;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_7']")
    public static WebElement txtTemplatename ;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_9']")
    public static WebElement txtCrNumber;

    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Date_8$txtDate']")
    public static WebElement txtDueDate;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Date_9$txtDate']")
    public static WebElement txtPaymentDate;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Date_11$txtDate']")
    public static WebElement txtGLPostingDate;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_6']")
    public static WebElement txtManualPaymentNo; 
    
   // @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_List0$proxy_txt_7']")
    @FindBy(xpath="//*[contains(text(),'Voucher Number')]/parent::td/following-sibling::td//input[@type='text']")
    public static WebElement txtVoucherNo; 
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_14']")
    public static WebElement txtManualPaymentCrNumber; 
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_15']")
    public static WebElement txtInvoiceNumber;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_ChbDiv_PROCESSES']")
    public static WebElement tblProcess;
    
    @FindBy(xpath="//*[@type='button' and @value='Refresh']")
    public static WebElement btnRefresh;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_ChbDiv_PROCESSES']/tbody/tr/td/span")
    public static List <WebElement> lstSpan ;
  
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_8_imgDte']")
    public static WebElement dtDueDate ;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_9_imgDte']")
    public static WebElement dtPaymentDate ;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_11_imgDte']")
    public static WebElement dtGlPostingDate ;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_17_imgDte']")
    public static WebElement dtInvoiceDate ;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_18_imgDte']")
    public static WebElement dtManualPaymentDate ;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_20_imgDte']")
    public static WebElement dtManualPaymentGlDate ;
  
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_1$cboCombo']")
    public static WebElement drpdnTransCode ;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_3$cboCombo']")
    public static WebElement drpdnCrPaymentTransCode;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_7$cboCombo']")
    public static WebElement drpdnBankCode;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_27$cboCombo']")
    public static WebElement drpdnCrManualpaymentStatus;
        
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_39$cboCombo']")
    public static WebElement drpdnSundryInvoiceStatus;
        
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_13$cboCombo']")
    public static WebElement drpdnBankAccount;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Curr_14$txtCurr']")
    public static WebElement txtNoOfInvoicesPerRemittance;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Curr_18$txtCurr']")
    public static WebElement txtGrossAmount;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Curr_20$txtCurr']")
    public static WebElement txtVatAmount;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Curr_24$txtCurr']")
    public static WebElement txtExchangeRate;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Curr_25$txtCurr']")
    public static WebElement txtPaymentAmount;
       
    @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_LINE_ITEM_1_6']")
    public static WebElement txtGlCode;
    
    @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_LINE_ITEM_1_7']")
    public static WebElement txtAnalysisCode;
    
    @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_LINE_ITEM_1_9']")
    public static WebElement txtGoodsAmt;
    
    @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_LINE_ITEM_1_10']")
    public static WebElement drpdnVatCode;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_List0_toggleCHK']")
    public static WebElement chkTransCodeCheckbox;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsTest1_proxy_chk_2']")
    public static WebElement chkInProgressCheckbox;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsTest1_proxy_chk_3']")
    public static WebElement chkFinishedCheckbox;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsTest1_proxy_chk_4']")
    public static WebElement chkFailedCheckbox;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsTest1_ResultsHeadRow']")
    public static List<WebElement> lblCrPaymentColumnHeaders;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsTest1_ResultsHeadRow']/th")
    public static WebElement tblCrPaymentRunControl;
    
    public static void setChkFinishedCheckbox() {
      checkCheckBox(CreditorPayments.chkFinishedCheckbox);
    }

    public static void setChkFailedCheckbox() {
      checkCheckBox(CreditorPayments.chkFailedCheckbox);
    }
        
    public static void setChkTransCodeCheckbox() {
      checkCheckBox(CreditorPayments.chkTransCodeCheckbox);
    }

    public static void setTxtCrNumber(String data) throws InterruptedException {
      setText(CreditorPayments.txtCrNumber,data);
      CreditorPayments.txtCrNumber.sendKeys(Keys.TAB);
      Thread.sleep(3000);
    }
    
    public static String getDrpdnSundryInvoiceStatus() {
      Select oSelect = new Select(CreditorPayments.drpdnSundryInvoiceStatus);
      String sundryStatus = oSelect.getFirstSelectedOption().getText();
      return sundryStatus;
    }
    
    public static String getDrpdnCrManualpaymentStatus() {
      Select oSelect = new Select(CreditorPayments.drpdnCrManualpaymentStatus);
      String maunalPaymentStatus = oSelect.getFirstSelectedOption().getText();
      return maunalPaymentStatus;
    }
    
    public static String getTxtManualPaymentNo() {
      return txtManualPaymentNo.getAttribute("value");
    }
    
    public static String getTxtTemplatename() {
      return txtTemplatename.getAttribute("value");
    }
    
    public static String getTxtVoucherNumber() {
      return txtVoucherNumber.getAttribute("value");
    }
    
    public static void setTxtTemplatename(String data) {
      setText(CreditorPayments.txtTemplatename,data);
    }
    
    public static void setTxtVoucherNo(String data) {
      setText(CreditorPayments.txtVoucherNo,data);
    }
        
    public static void setDtManualPaymentDate() {
      CreditorPayments.dtManualPaymentDate.click();
    }
    public static void setDtManualPaymentGlDate() {
      CreditorPayments.dtManualPaymentGlDate.click();
    }
    public static void setTxtPaymentAmount(String data) {    
      setText(CreditorPayments.txtPaymentAmount,data);
    }
    public static void setTxtExchangeRate(String data) {
      setText(CreditorPayments.txtExchangeRate,data);
    }
    
    public static void setDrpdnBankCode(String data) throws InterruptedException {
      selectDropDown(CreditorPayments.drpdnBankCode,data);
    }
    
    public static void setDrpdnCrPaymentTransCode(String data) throws InterruptedException {
      selectDropDown(CreditorPayments.drpdnCrPaymentTransCode,data);
    }
    
    public static void setTxtManualPaymentCrNumber(String data) throws InterruptedException {
      setText(CreditorPayments.txtManualPaymentCrNumber,data);
      CreditorPayments.txtManualPaymentCrNumber.sendKeys(Keys.TAB);
      Thread.sleep(3000);
    }
    
    public static void setDrpdnVatCode(String data) throws InterruptedException {
      selectDropDown(CreditorPayments.drpdnVatCode,data);
    }
    public static void setTxtGoodsAmt(String data) {
      setText(CreditorPayments.txtGoodsAmt,data);
    }
    public static void setTxtAnalysisCode(String data) {
      setText(CreditorPayments.txtAnalysisCode,data);
    }
    
    public static void setTxtGlCode(String data) throws InterruptedException {
      setText(CreditorPayments.txtGlCode,data);
      CreditorPayments.txtGlCode.sendKeys(Keys.TAB);
      Thread.sleep(3000);
    }
    
    public static WebElement getTxtVatAmount() {
      return txtVatAmount;
    }
    
    public static void setDtInvoiceDate() throws InterruptedException {
      CreditorPayments.dtInvoiceDate.click();
      Thread.sleep(2000);
    }
    
    public static void setTxtVatAmount(String data) {
      setText(CreditorPayments.txtVatAmount,data);
    }
    public static WebElement getTxtGrossAmount() {
      return txtGrossAmount;
    }
    public static void setTxtGrossAmount(String data) {
      setText(CreditorPayments.txtGrossAmount,data);
    }
    public static WebElement getTxtInvoiceNumber() {
      return txtInvoiceNumber;
    }
    public static void setTxtInvoiceNumber(String data) {
      setText(CreditorPayments.txtInvoiceNumber,data);
    }
    
    public static void setDrpdnTransCode(String data) throws InterruptedException {
      selectDropDown(CreditorPayments.drpdnTransCode,data);
    }
    
    public static void setTxtNoOfInvoicesPerRemittance(String data) {
      setText(CreditorPayments.txtNoOfInvoicesPerRemittance,data);
    }
    public static WebElement getDrpdnSection() {
      return drpdnBankAccount;
    }
    public static void setDrpdnBankAccount(String data) throws InterruptedException {
      selectDropDown(CreditorPayments.drpdnBankAccount,data);
    }
    public static void setDtDueDate() {
      CreditorPayments.dtDueDate.click();
    }
    
    public static void setDtPaymentDate() {
      CreditorPayments.dtPaymentDate.click();
    }
    
    public static void setDtGlPostingDate() {
      CreditorPayments.dtGlPostingDate.click();
    }
    
    public static void selectTemplate(String data) throws InterruptedException {
      selectDropDown(drpdnTemplate,data);
    }
    
    public static String getDueDate(String data) throws InterruptedException {
      return txtDueDate.getAttribute("value");
    }
    
    public static String getPaymentDate(String data) throws InterruptedException {
      return txtPaymentDate.getAttribute("value");
    }
    
    public static String getGLPostingDate(String data) throws InterruptedException {
      return txtGLPostingDate.getAttribute("value");
    }
    
    public static String getPaymentNo() throws InterruptedException {
      highlightElement(txtPaymentNo);
      return txtPaymentNo.getAttribute("value");
    }
    
    //parameterize constructor to initalize driver and page factory web element
    public CreditorPayments(WebDriver driver) throws FileNotFoundException{
        driver=TestBase.driver;
        PageFactory.initElements(driver, this);
    }
    public CreditorPayments()  throws FileNotFoundException{
    }
   
}
