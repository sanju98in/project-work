package financialWeb.pages;

import java.io.FileNotFoundException;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import financialWeb.workflow.CommonWorkflow;
import util.TestBase;

public class DebtorsCreditNotes extends CommonPage {

  public static final Logger log = Logger.getLogger(DebtorsCreditNotes.class.getName());
  public static WebDriver driver;

  static DebtorsCreditNotes objDebtorsCreditNotes;
  // Page Factory - OR:

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_30$cboCombo']")
  public static WebElement drpdnDBCreditNoteReasonForCredit;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_10']")
  public static WebElement txtCreditNoteDebtorNo;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_chk_43']")
  public static WebElement chkTakeDetailsFromInvoice;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_chk_44']")
  public static WebElement chkAllocateCreditToInvoice;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_1$cboCombo']")
  public static WebElement drpdnTransactionCode;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_1$cboCombo']")
  public static WebElement drpdnDBCreditLineTransactionCode;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Date_21_imgDte']")
  public static WebElement dtTaxPoint;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Date_22_imgDte']")
  public static WebElement dtGLDate;

  @FindBy(xpath = "//*[@name='ctl00_Main_WC_FIN_Grid_Upd1_txtPIN_CHARGE_LINES_1_11']")
  public static WebElement txtCreditNoteAddLineDesc;

  @FindBy(xpath = "//*[@name='ctl00_Main_WC_FIN_Grid_Upd1_txtPIN_CHARGE_LINES_1_12']")
  public static WebElement txtCreditNoteAddLineQty;

  @FindBy(xpath = "//*[@name='ctl00_Main_WC_FIN_Grid_Upd1_txtPIN_CHARGE_LINES_1_13']")
  public static WebElement txtCreditNoteAddLinePrice;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_cboPIN_CHARGE_LINES_1_14']")
  public static WebElement drpdnCreditNoteAddLineVatCodex;

  @FindBy(xpath = "//*[@name='ctl00_Main_WC_FIN_Grid_Upd1_txtPIN_CHARGE_LINES_1_22']")
  public static WebElement txtCreditNoteAddLineGLCode;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_3']")
  public static WebElement txtCreditNoteReference;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_List0$proxy_txt_7']")
  public static WebElement txtNewCrNoteAllocReferenceOne;

  @FindBy(xpath = "//*[@name='ctl00_Main_WC_FIN_Grid_List0_toggleCHK']")
  public static WebElement chkAddToAllocation;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_38']")
  public static WebElement txtStatus;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$btnPNT_Adjust_3']")
  public static WebElement btnAdjust;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$btnPNT_CANCEL_1']")
  public static WebElement btnCancelCreditNote;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_10$cboCombo']")
  public static WebElement btnCancelReason;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Date_11_imgDte']")
  public static WebElement calCancellationDate;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Date_12_imgDte']")
  public static WebElement calCancellationGLDate;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Date_23_imgDte']")
  public static WebElement dtCrNoteGLDate;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_13']")
  public static WebElement txtCancellationComment;

  @FindBy(xpath = "//*[@type='button' and @name='ctl00$Main$WC_FIN_Grid_Upd1$btn_Table_Results']")
  public static WebElement btnCancellationSave;

  @FindBy(xpath = "//*[@type='button' and @name='ctl00$Main$WC_FIN_Grid_Upd1$btnPNT_CLOSE_1']")
  public static WebElement btnCancellationClose;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Enq0$proxy_txt_1']")
  public static WebElement txtCreditNoteNumber;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_16$cboCombo']")
  public static WebElement drpdnDBCrNoteDepartment;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_17$cboCombo']")
  public static WebElement drpdnDBCrNoteSection;

  @FindBy(xpath = "//*[@name='ctl00_Main_WC_FIN_Grid_Upd1_txtPIN_CHARGE_LINES_1_9']")
  public static WebElement txtAddLineChargeCode;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Curr_28$txtCurr']")
  public static WebElement txtDBCreditLineAmount;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_9$cboCombo']")
  public static WebElement drpdnDBAdjustCrNoteTransCode;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Date_14$txtDate']")
  public static WebElement dtDBAdjustCrNoteDate;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Date_15$txtDate']")
  public static WebElement dtDBAdjustCrNoteGLDate;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_16$cboCombo']")
  public static WebElement drpdnBankAccount;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_17$cboCombo']")
  public static WebElement drpdnReverseOverpaymentReason;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_11$cboCombo']")
  public static WebElement drpdnNewDept;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_12$cboCombo']")
  public static WebElement drpdnNewSect;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$btn_Table_Results']")
  public static WebElement btnSave;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_18']")
  public static WebElement txtComments;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_11']")
  public static WebElement txtReferenceOne;

  @FindBy(xpath = "//*[@type='button' and @name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_find_3']")
  public static WebElement btnFindCreditNote;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$btnPNT_CLOSE_1']")
  public static WebElement btnClose;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_31$cboCombo']")
  public static WebElement txtReasonForCredit;
  
  @FindBy(xpath = "//*[contains(text(),'Authorised:  Invoices')]/parent::tr/following-sibling::tr[1]/td[2]/a")
  public static WebElement txtAuthorisedCreditNotes;

  public static String getTxtAuthorisedCreditNotes() {
    return txtAuthorisedCreditNotes.getText();
  }

  public static void setDtCrNoteGLDate() {
    DebtorsCreditNotes.dtCrNoteGLDate.click();
  }

  public static void setDebtorNumber(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    CommonWorkflow.setRandomWebElementValue(msgprop.getProperty("lbldebtornumber"), data);
    //setText(DebtorsCreditNotes.txtReferenceOne, data);
  }

  public static void selectReasonForCredit(String data) throws InterruptedException {
    selectDropDown(txtReasonForCredit, data);

  }


  // parameterize constructor to initalize driver and page factory web element
  public DebtorsCreditNotes(WebDriver driver) throws FileNotFoundException {
    driver = TestBase.driver;
    PageFactory.initElements(driver, this);
  }

  public DebtorsCreditNotes() throws FileNotFoundException {
  }


  public static void selectDBCreditNoteReasonForCredit(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    selectDropDown(DebtorsCreditNotes.drpdnDBCreditNoteReasonForCredit, data);
  }

  public static void selectInvoice() throws FileNotFoundException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    checkCheckBox(DebtorsCreditNotes.chkTakeDetailsFromInvoice);
  }

  public static void selectAllocateInvoice() throws FileNotFoundException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    checkCheckBox(DebtorsCreditNotes.chkAllocateCreditToInvoice);
  }

  public static void setDBCreditLineTransCode(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    selectDropDown(DebtorsCreditNotes.drpdnTransactionCode, data);
  }

  public static void setDBCreditLineDebtorNumber(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    setText(DebtorsCreditNotes.txtCreditNoteDebtorNo, data);
    DebtorsCreditNotes.txtCreditNoteDebtorNo.sendKeys(Keys.TAB);
    Thread.sleep(2000);
  }

  public static void setDBTransCode(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    selectDropDown(DebtorsCreditNotes.drpdnDBCreditLineTransactionCode, data);
  }


  public static void clickDBCreditNoteTaxPointDatepicker()
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    Thread.sleep(2000);
    clickElement(DebtorsCreditNotes.dtTaxPoint);
  }

  public static void clickDBCreditNoteGLDatepicker()
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    clickElement(DebtorsCreditNotes.dtGLDate);
  }

  public static void setDBCreditLineDesc(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    setText(DebtorsCreditNotes.txtCreditNoteAddLineDesc, data);
  }

  public static void setDBCreditLineQty(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    setText(DebtorsCreditNotes.txtCreditNoteAddLineQty, data);
  }

  public static void setDBCreditLinePrice(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    setText(DebtorsCreditNotes.txtCreditNoteAddLinePrice, data);
  }

  public static WebElement setDBCreditLineGLCode(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    setText(DebtorsCreditNotes.txtCreditNoteAddLineGLCode, data);
    return DebtorsCreditNotes.txtCreditNoteAddLineGLCode;
  }

  public static void setDBCreditLineVatCodex(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    selectDropDown(DebtorsCreditNotes.drpdnCreditNoteAddLineVatCodex, data);
  }

  public static String getCreditLineReference() throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    highlightElement(txtCreditNoteReference);
    return DebtorsCreditNotes.txtCreditNoteReference.getAttribute("value");
  }

  public static void setCrNoteAllocReferenceOne(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    setText(DebtorsCreditNotes.txtNewCrNoteAllocReferenceOne, data);
  }

  public static void AddToAllocationCheckbox() throws FileNotFoundException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    checkCheckBox(DebtorsCreditNotes.chkAddToAllocation);

  }

  public static void getStatus(String data) throws FileNotFoundException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    verifyTextAttribute(DebtorsCreditNotes.txtStatus, data);
  }

  public static void clickDBCreditNoteAdjust() throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    clickElement(DebtorsCreditNotes.btnAdjust);
  }

  public static void clickDBCreditNoteCancelCreditNote()
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    DebtorsCreditNotes.btnCancelCreditNote.click();
  }

  public static void setCreditNoteCancelReason(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    selectDropDown(DebtorsCreditNotes.btnCancelReason, data);
  }

  public static void clickCancellationDate() throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    calCancellationDate.click();
  }

  public static void clickCancellationGLDate() throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    calCancellationGLDate.click();
  }

  public static void setComment(String data) throws FileNotFoundException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    setText(DebtorsCreditNotes.txtCancellationComment, data);

  }

  public static void saveDBAdjustCancelCreditNote()
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    highlightElement(DebtorsCreditNotes.btnCancellationSave);
    DebtorsCreditNotes.btnCancellationSave.click();
  }

  public static String getCreditNoteNumber() throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    return DebtorsCreditNotes.txtCreditNoteNumber.getAttribute("value");
  }

  public static String getCreditNoteDeparment() throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    Select oSelect = new Select(DebtorsCreditNotes.drpdnDBCrNoteDepartment);
    log.info(" DB Credit Note Department default value is "
        + oSelect.getFirstSelectedOption().getText());
    return oSelect.getFirstSelectedOption().getText();
  }

  public static String getCreditNoteSection() throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    Select oSelect = new Select(DebtorsCreditNotes.drpdnDBCrNoteSection);
    log.info(
        " DB Credit Note Section default value is " + oSelect.getFirstSelectedOption().getText());
    return oSelect.getFirstSelectedOption().getText();
  }

  public static void setAddLineChargeCode(String data) throws InterruptedException {
    setText(txtAddLineChargeCode, data);
    txtAddLineChargeCode.sendKeys(Keys.TAB);
    Thread.sleep(2000);
  }

  public static String getDBCreditLineAmount() throws InterruptedException, FileNotFoundException {
    String amoutn = null;
    waitforPanelLoad();
    boolean found = IsExist(txtDBCreditLineAmount);
    if (found) {
      Thread.sleep(3000);
      amoutn = txtDBCreditLineAmount.getAttribute("value");
    }
    return amoutn;
  }

  public static void selectDBAdjustCrNoteTransCode(String data) throws InterruptedException {
    selectDropDown(drpdnDBAdjustCrNoteTransCode, data);
  }

  public static String getDBAdjustCrNoteDate() throws InterruptedException {
    return dtDBAdjustCrNoteDate.getAttribute("value");
  }

  public static String getDBAdjustCrNoteGLDate() throws InterruptedException {
    return dtDBAdjustCrNoteGLDate.getAttribute("value");
  }

  public static String getDBAdjustCrNoteBankAccount() throws InterruptedException {
    Select oSelect = new Select(drpdnBankAccount);
    return oSelect.getFirstSelectedOption().getText();
  }

  public static void selectDBAdjustCrNoteReason(String data) throws InterruptedException {
    selectDropDown(drpdnReverseOverpaymentReason, data);
  }

  public static void selectDBAdjustCrNoteComments(String data) throws InterruptedException, FileNotFoundException {
    //setText(txtComments, data);
    CommonWorkflow.setRandomWebElementValue(msgprop.getProperty("lblinvoicenumber"), data);
  }

  public static String getDBAdjustCrNoteReferenceOne() throws InterruptedException {
    return txtReferenceOne.getAttribute("value");
  }

  public static void selectDBAdjustCrNoteAddNewDept(String data) throws InterruptedException {
    selectDropDown(drpdnNewDept, data);
  }

  public static void selectDBAdjustCrNoteNewSect(String data) throws InterruptedException {
    selectDropDown(drpdnNewSect, data);
  }

  public static void selectFindCreditNote() throws InterruptedException {
    clickElement(btnFindCreditNote);
  }

  public static void setCreditLineReference(String crNoteReference)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    setText(txtCreditNoteReference, crNoteReference);

  }

  // end of class
}
