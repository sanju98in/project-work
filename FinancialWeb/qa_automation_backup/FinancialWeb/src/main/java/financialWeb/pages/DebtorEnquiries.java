package financialWeb.pages;

import java.io.FileNotFoundException;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;

public class DebtorEnquiries extends CommonPage {


  public static final Logger log = Logger.getLogger(DebtorEnquiries.class.getName());
  public static WebDriver driver;

  static DebtorEnquiries objDebtorsEnquiries;
  // Page Factory - OR:

  @FindBy(xpath = "//*[@id='ctl00_Main_WCFinancialsTest1_WC_Fin_Date_12_imgDte']")
  public static WebElement dtTransDateFrom;

  @FindBy(xpath = "//*[@id='ctl00_Main_WCFinancialsTest1_WC_Fin_Date_12_imgDteTo']")
  public static WebElement dtTransDateTo;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd2_WC_Fin_Date_20_imgDte']")
  public static WebElement dtDate;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd2_WC_Fin_Date_22_imgDte']")
  public static WebElement dtGLDate;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_30_imgDte']")
  public static WebElement dtDueDate;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Date_20$txtDate']")
  public static WebElement txtDate;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Date_22$txtDate']")
  public static WebElement txtGLDate;



  /*
   * @FindBy( xpath =
   * "//span[contains(text(),'Start Date')]/parent::td/following-sibling::td//input[@type='text' and @class='datefield']"
   * ) public static WebElement txtStrtDate;
   * 
   * 
   * @FindBy( xpath =
   * "//span[contains(text(),'End Date')]/parent::td/following-sibling::td//input[@type='text' and @class='datefield']"
   * ) public static WebElement txtEndDte;
   * 
   * @FindBy( xpath =
   * "//span[contains(text(),'Next Date')]/parent::td/following-sibling::td//input[@type='text' and @class='datefield']"
   * ) public static WebElement txtNxtDate;
   */


  // @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Date_32$txtDate']")
  @FindBy( xpath = "//span[contains(text(),'Start Date')]/parent::td/following-sibling::td//input[@type='text' and @class='datefield']")
  public static WebElement txtStartDate;

  // @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Date_34$txtDate']")
  @FindBy( xpath = "//span[contains(text(),'Next Date')]/parent::td/following-sibling::td//input[@type='text' and @class='datefield']")
  public static WebElement txtNextDate;

  // @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Date_36$txtDate']")
  @FindBy(xpath = "//span[contains(text(),'End Date')]/parent::td/following-sibling::td//input[@type='text' and @class='datefield']")
  public static WebElement txtEndDate;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Enq0$proxy_txt_1']")
  public static WebElement txtDebtorNumber;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_4']")
  public static WebElement txtTitle;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_5']")
  public static WebElement txtFirstName;

  @FindBy(xpath = "//*[@name='ctl00$Main$WCFinancialsFind0$proxy_txt_5']")
  public static WebElement txtPostCode;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd2$proxy_txt_5']")
  public static WebElement txtReferenceOne;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_6']")
  public static WebElement txtLastName;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd2$proxy_txt_9']")
  public static WebElement txtDebtorNo;

  @FindBy(xpath = "//*[@name='ctl00$Main$WCFinancialsTest1$proxy_txt_10']")
  public static WebElement txtReferenceone;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd2$proxy_txt_16']")
  public static WebElement txtReferenceTwo;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd2$proxy_txt_34']")
  public static WebElement txtCommentBox;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd2$WC_Fin_Curr_19$txtCurr']")
  public static WebElement txtAmount;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd2$WC_Fin_Combo_4$cboCombo']")
  private static WebElement drpdnTransCode;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$WC_Fin_Combo_8$cboCombo']")
  public static WebElement drpdnLocation;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$WC_Fin_Combo_9$cboCombo']")
  public static WebElement drpdnTypeOfDebtor;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_12$cboCombo']")
  public static WebElement drpdnDepartment;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_13$cboCombo']")
  public static WebElement drpdnSection;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_14$cboCombo']")
  public static WebElement drpdnDBInvoiceSection;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd2$WC_Fin_Combo_27$cboCombo']")
  public static WebElement drpdnPaymentMethod;

  @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd2$WC_Fin_Combo_35$cboCombo']")
  public static WebElement txtStatus;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd2_proxy_lbl_5']")
  public static WebElement lblForReferenceOne;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd2_proxy_lbl_16']")
  public static WebElement lblForReferenceTwo;

  @FindBy(xpath = "//*[@type='submit' and @value='Submit']")
  public static WebElement btnSubmit;

  @FindBy(xpath = "//*[@id='ctl00_Main_WCFinancialsTest1_ResultsTable']/tbody/tr[2]/td[9]")
  public static WebElement lbldbcreditsColumn;

  @FindBy(xpath = "//*[@id='ctl00_Main_WCFinancialsTest1_ResultsTable']/tbody/tr[2]/td[10]")
  public static WebElement lbldbPayAdjColumn;

  @FindBy(xpath = "//*[@id='ctl00_Main_WCFinancialsTest1_ResultsTable']/tbody/tr[2]/td[11]")
  public static WebElement lblOutstandingAmt;
  
  @FindBy(xpath = "//*[@id='ctl00_Main_WCFinancialsTest1_lbl_RecordCount']")
  public static WebElement lblAbouveGrid;
  

  public static String getReferenceOne() throws InterruptedException {
    highlightElement(txtReferenceOne);
    return txtReferenceOne.getAttribute("value");
  }
  
  public static String getGridValue() throws InterruptedException {
    highlightElement(lblAbouveGrid);
    return lblAbouveGrid.getText();
  }

  public static String getReferenceTwo() throws InterruptedException {
    highlightElement(txtReferenceTwo);
    return txtReferenceTwo.getAttribute("value");
  }

  public static void setComment(String data) throws InterruptedException {
    setText(txtCommentBox, data);
  }

  public static void setPaymentMethod(String data) throws InterruptedException {
    selectDropDown(drpdnPaymentMethod, data);
  }

  public static void clickDate() throws InterruptedException {
    clickElement(dtDate);
  }

  public static void clickGLDate() throws InterruptedException {
    clickElement(dtGLDate);
  }

  public static void setAmount(String data) throws InterruptedException {
    setText(txtAmount, data);
  }

  public static String getAmount() throws InterruptedException {
    return txtAmount.getAttribute("value");
  }

  public static void setTxtDebtorNumber(String data) throws InterruptedException {
    txtDebtorNo.sendKeys(data);
    txtDebtorNo.sendKeys(Keys.TAB);
    Thread.sleep(3000);
  }

  public static void setTransactionCode(String data) throws InterruptedException {
    selectDropDown(drpdnTransCode, data);
  }

  public static String getLabelForReferenceOne() throws InterruptedException {
    return lblForReferenceOne.getText();
  }

  public static String getLabelForReferenceTwo() throws InterruptedException {
    return lblForReferenceOne.getText();
  }

  public static void setDtDueDate() throws InterruptedException {
    DebtorEnquiries.dtDueDate.click();
    Thread.sleep(1000);
  }

  public static void setTxtPostCode(String data) {
    setText(DebtorEnquiries.txtPostCode, data);
  }

  /*
   * public static String getTxtStartDate() { return txtStrtDate.getAttribute("value"); } public
   * static String getTxtNextDate() { return txtNextDate.getAttribute("value");} public static
   * String getTxtEndDate() {return txtEndDate.getAttribute("value");}
   */

  public static String getTxtStartDate() throws InterruptedException {
    highlightElement(txtStartDate);
    return txtStartDate.getAttribute("value");
  }

  public static String getTxtNextDate() throws InterruptedException {
    highlightElement(txtNextDate);
    return txtNextDate.getAttribute("value");
  }

  public static String getTxtEndDate() throws InterruptedException {
    highlightElement(txtEndDate);
    return txtEndDate.getAttribute("value");
  }



  public static String getTxtDate() {
    return txtDate.getAttribute("value");
  }

  public static String getTxtGLDate() {
    return txtGLDate.getAttribute("value");
  }

  public static void setDtTransDateFrom() throws InterruptedException {
    DebtorEnquiries.dtTransDateFrom.click();
    Thread.sleep(1000);
  }

  public static void setDtTransDateTo() {
    DebtorEnquiries.dtTransDateTo.click();
  }

  public static void setTxtReferenceone(String data) {
    setText(DebtorEnquiries.txtReferenceone, data);
  }

  public static WebElement getDrpdnSection() {
    return drpdnSection;
  }

  public static WebElement getDrpdnDBInvoiceSection() {
    return drpdnDBInvoiceSection;
  }

  public static void setDrpdnSection(String data) throws InterruptedException {
    selectDropDown(DebtorEnquiries.drpdnSection, data);
    DebtorEnquiries.drpdnSection.sendKeys(Keys.TAB);
    Thread.sleep(2000);
  }

  public static void setDrpdnDBInvoiceSection(String data) throws InterruptedException {
    selectDropDown(DebtorEnquiries.drpdnDBInvoiceSection, data);
    DebtorEnquiries.drpdnDBInvoiceSection.sendKeys(Keys.TAB);
    Thread.sleep(2000);
  }

  public static WebElement getDrpdnDepartment() {
    return drpdnDepartment;
  }

  public static void setDrpdnDepartment(String data) throws InterruptedException {
    selectDropDown(DebtorEnquiries.drpdnDepartment, data);
    DebtorEnquiries.drpdnDepartment.sendKeys(Keys.TAB);
    Thread.sleep(2000);
  }

  // parameterize constructor to initalize driver and page factory web element
  public DebtorEnquiries(WebDriver driver) throws FileNotFoundException {
    driver = TestBase.driver;
    PageFactory.initElements(driver, this);
  }

  public DebtorEnquiries() throws FileNotFoundException {

  }

  public static void setDebtorNumber(String data) {
    setText(txtDebtorNumber, data);
  }

  public static String getTitle() {
    return txtTitle.getAttribute("value");
  }

  public static String getFirstName() {
    return txtFirstName.getAttribute("value");
  }

  public static String getLastName() {
    return txtLastName.getAttribute("value");
  }
}
