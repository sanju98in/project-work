package financialWeb.pages;

import java.io.FileNotFoundException;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.TestBase;

/**
 * Some common methods which can be used for any page actions.
 */

public class DebtorVouchersSalesInvoices extends TestBase {

  public static DebtorVouchersSalesInvoices objDebtorVouchersSalesInvoices;

  @FindBy(xpath = "//*[@name='ctl00$Main$WCFinancialsTest1$proxy_txt_8']")
  public static WebElement txtInvoiceNumber;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_8']")
  public static WebElement txtDebtorNumber;

  // @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd2_proxy_txt_14']")
  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_proxy_txt_14']")
  public static WebElement txtMsg;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_23']")
  public static WebElement txtInvToGenerate;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_24']")
  public static WebElement txtPIMInvToGenerate;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_25']")
  public static WebElement txtInstalmentStatus;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_42']")
  public static WebElement txtInvoiceStatus;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_42']")
  public static WebElement txtCommentForPIM;

  // @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd2_WC_Fin_Combo_7_cboCombo']")
  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Combo_7_cboCombo']")
  public static WebElement drpdnTransactionCodePayment;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_8$cboCombo']")
  public static WebElement drpdnTransactionCodeWriteOff;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_10$cboCombo']")
  public static WebElement drpdnNewDept;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_12$cboCombo']")
  public static WebElement drpdnNewDeptTransfer;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_13$cboCombo']")
  public static WebElement drpdnSection;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_14$cboCombo']")
  public static WebElement drpdnInvoiceSection;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_16$cboCombo']")
  public static WebElement drpdnReasonWriteOff;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_21$cboCombo']")
  public static WebElement drpdnFrequency;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_22$cboCombo']")
  public static WebElement drpdnPIMFrequency;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_27$cboCombo']")
  public static WebElement drpdnInstalmentFrequency;

  @FindBy(xpath = "//*[@id='ctl00_Main_WCFinancialsTest1_WC_Fin_Date_11_imgDte']")
  public static WebElement dtEntryDate;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Date_14_imgDte']")
  public static WebElement dtTaxPointDate;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Date_15_imgDte']")
  public static WebElement dtGlDate;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Date_16_imgDte']")
  public static WebElement dtInvoiceGlDate;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Date_28_imgDte']")
  public static WebElement dtFirstDate;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_32_imgDte']")
  public static WebElement dtStartPimDate;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_35_imgDte']")
  public static WebElement dtStartDBPimDate;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_34_imgDte']")
  public static WebElement dtNextPimDate;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_36_imgDte']")
  public static WebElement dtEndPimDate;

  @FindBy(xpath = "//*[@name='ctl00_Main_WC_FIN_Grid_Upd1_txtPIN_CHARGE_LINES_1_8']")
  public static WebElement txtAddLineChargeCode;

  @FindBy(xpath = "//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_CHARGE_LINES_1_24']")
  public static WebElement txtPIMGlCode;

  //@FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Curr_23$txtCurr']")
  @FindBy(xpath = "//*[contains(text(),'Amount')]/parent::td/following-sibling::td//input[@type='text' and @class='currfield']")
  public static WebElement txtAmount;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Curr_29$txtCurr']")
  public static WebElement txtNoOfInstalments;

  @FindBy(xpath = "//*[@id='brd_ctl00_Main_WC_FIN_Grid_Upd0']")
  public static WebElement dbInvoiceTab;

  @FindBy(xpath = "//*[@id='brd_ctl00_Main_WCFinancialsFind0']")
  public static WebElement dbNotesTab;

  @FindBy(xpath = "//*[@id='fuFile']")
  public static WebElement btnBrowser;

  @FindBy(xpath = "//*[@id='btnUpload']")
  public static WebElement btnUpload;

  @FindBy(xpath = "//*[@id='cMonth']")
  public static WebElement calDrpDnMonth;

  @FindBy(xpath = "//*[@id='cYear']")
  public static WebElement calDrpDnYear;

  @FindBy(xpath = "//*[@type='button' and @style='color:Black;font-weight:normal;']")
  public static List<WebElement> calDateClass;

  @FindBy(xpath = "//*[@type='button' and @style='color:Red;font-weight:normal;']")
  public static List<WebElement> calEndDateClass;

  @FindBy(xpath = "//*[@id='divDatePicker']")
  public static WebElement Calendarclass;

  public static void setTxtCommentForPIM(String data) {
    setText(DebtorVouchersSalesInvoices.txtCommentForPIM, data);
  }

  public static String getTxtCommentForPIM() {
    return DebtorVouchersSalesInvoices.txtCommentForPIM.getAttribute("value");
  }

  public static void setDbNotesTab() throws InterruptedException {
    DebtorVouchersSalesInvoices.dbNotesTab.click();
    waitForPageLoad();
  }

  public static void getTxtInvoiceStatus(String data) {
    verifyTextAttribute(DebtorVouchersSalesInvoices.txtInvoiceStatus, data);
  }

  public static String getTxtAmount() {
    return txtAmount.getAttribute("value");
  }

  static WebElement getTxtAddLineChargeCode() {
    return txtAddLineChargeCode;
  }

  public static void setTxtAddLineChargeCode(String data) throws InterruptedException {
    setText(DebtorVouchersSalesInvoices.txtAddLineChargeCode, data);
    DebtorVouchersSalesInvoices.txtAddLineChargeCode.sendKeys(Keys.TAB);
    Thread.sleep(2000);
  }

  static WebElement getDtTaxPointDate() {
    return dtTaxPointDate;
  }

  public static void setDtTaxPointDate() throws InterruptedException {
    clickElement(DebtorVouchersSalesInvoices.dtTaxPointDate);
  }

  static WebElement getDtGlDate() {
    return dtGlDate;
  }

  public static void setDtGlDate() throws InterruptedException {
    clickElement(DebtorVouchersSalesInvoices.dtGlDate);
    Thread.sleep(3000);
  }

  public static void setDtInvoiceGlDate() throws InterruptedException {
    clickElement(DebtorVouchersSalesInvoices.dtInvoiceGlDate);
  }

  static WebElement getTxtDebtorNumber() {
    return txtDebtorNumber;
  }

  public static void setTxtDebtorNumber(String data) throws InterruptedException {
    setText(DebtorVouchersSalesInvoices.txtDebtorNumber, data);
    DebtorVouchersSalesInvoices.txtDebtorNumber.sendKeys(Keys.TAB);
    Thread.sleep(2000);
  }

  static WebElement getTxtInvToGenerate() {
    return txtInvToGenerate;
  }

  public static void setTxtInvToGenerate(String data) {
    setText(DebtorVouchersSalesInvoices.txtInvToGenerate, data);
  }


  static WebElement getTxtPIMInvToGenerate() {
    return txtPIMInvToGenerate;
  }

  public static void setTxtPIMInvToGenerate(String data) {
    setText(DebtorVouchersSalesInvoices.txtPIMInvToGenerate, data);
  }

  static WebElement getDrpdnFrequency() {
    return drpdnFrequency;
  }

  public static void setDrpdnFrequency(String data) throws InterruptedException {
    selectDropDown(DebtorVouchersSalesInvoices.drpdnFrequency, data);
  }

  static WebElement getDrpdnPIMFrequency() {
    return drpdnPIMFrequency;
  }

  public static void setDrpdnPIMFrequency(String data) throws InterruptedException {
    selectDropDown(DebtorVouchersSalesInvoices.drpdnPIMFrequency, data);
  }

  static WebElement getTxtInvoiceNumber() {
    return txtInvoiceNumber;
  }

  public static void setTxtInvoiceNumber(String data) {
    setText(DebtorVouchersSalesInvoices.txtInvoiceNumber, data);
  }

  static WebElement getDrpdnReasonWriteOff() {
    return drpdnReasonWriteOff;
  }

  public static void setDrpdnReasonWriteOff(String data) throws InterruptedException {
    selectDropDown(DebtorVouchersSalesInvoices.drpdnReasonWriteOff, data);
  }

  static WebElement getDrpdnTransactionCodeWriteOff() {
    return drpdnTransactionCodeWriteOff;
  }

  public static void setDrpdnTransactionCodeWriteOff(String data) throws InterruptedException {
    selectDropDown(DebtorVouchersSalesInvoices.drpdnTransactionCodeWriteOff, data);
  }

  static WebElement getDrpdnTransactionCodePayment() {
    return drpdnTransactionCodePayment;
  }

  public static void setDrpdnTransactionCodePayment(String data) throws InterruptedException {
    selectDropDown(DebtorVouchersSalesInvoices.drpdnTransactionCodePayment, data);
  }

  static WebElement getDtStartPimDate() {
    return dtStartPimDate;
  }

  public static void setDtStartPimDate() throws InterruptedException {
    //clickElement(DebtorVouchersSalesInvoices.dtStartPimDate);
  }

  public static String getTxtMsg() {
    return txtMsg.getAttribute("value");
  }

  public static void setTxtMsg(String data) {
    setText(DebtorVouchersSalesInvoices.txtMsg, data);
  }

  public static void setDtNextPimDate() throws InterruptedException {
    clickElement(DebtorVouchersSalesInvoices.dtNextPimDate);
  }

  public static void setDtStartDBPimDate() throws InterruptedException {
    clickElement(DebtorVouchersSalesInvoices.dtStartDBPimDate);
  }

  static WebElement getDrpdnInstalmentFrequency() {
    return drpdnInstalmentFrequency;
  }

  public static void setDrpdnInstalmentFrequency(String data) throws InterruptedException {
    selectDropDown(DebtorVouchersSalesInvoices.drpdnInstalmentFrequency, data);
  }

  static WebElement getDtEndPimDate() {
    return dtEndPimDate;
  }

  static WebElement getTxtPIMGlCode() {
    return txtPIMGlCode;
  }

  public static void setTxtPIMGlCode(String data) throws InterruptedException {
    setText(DebtorVouchersSalesInvoices.txtPIMGlCode, data);
    DebtorVouchersSalesInvoices.txtPIMGlCode.sendKeys(Keys.TAB);
    Thread.sleep(2000);
  }

  public static void setDtEndPimDate() {
    click(DebtorVouchersSalesInvoices.dtEndPimDate);
  }

  static WebElement getDtFirstDate() {
    return dtFirstDate;
  }

  public static void setDtFirstDate() {
    click(DebtorVouchersSalesInvoices.dtFirstDate);
  }

  static WebElement getTxtNoOfInstalments() {
    return txtNoOfInstalments;
  }

  public static void setTxtNoOfInstalments(String data) {
    setText(DebtorVouchersSalesInvoices.txtNoOfInstalments, data);
  }

  public static String getTxtInstalmentStatus() {
    return txtInstalmentStatus.getAttribute("value");
  }

  public static void setDrpdnNewDept(String data) throws InterruptedException {
    selectDropDown(DebtorVouchersSalesInvoices.drpdnNewDept, data);
    DebtorVouchersSalesInvoices.drpdnNewDept.sendKeys(Keys.TAB);
  }

  public static String getDrpdnSection() {
    Select oSelect = new Select(DebtorVouchersSalesInvoices.drpdnSection);
    String value = oSelect.getFirstSelectedOption().getText();
    return value;
  }

  public static String getDrpdnInvoiceSection() {
    Select oSelect = new Select(DebtorVouchersSalesInvoices.drpdnInvoiceSection);
    return oSelect.getFirstSelectedOption().getText();
  }

  public static String getdrpdnNewDeptTransfer() {
    Select oSelect = new Select(DebtorVouchersSalesInvoices.drpdnNewDeptTransfer);
    return oSelect.getFirstSelectedOption().getText();
  }

  public DebtorVouchersSalesInvoices(WebDriver driver) throws FileNotFoundException {
    driver = TestBase.driver;
    PageFactory.initElements(driver, this);
  }

  public DebtorVouchersSalesInvoices() throws FileNotFoundException {
  }

}// end of class
