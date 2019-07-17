package financialWeb.pages;

import java.io.FileNotFoundException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.TestBase;
public class GLJournals extends CommonPage {

  public static final Logger log= Logger.getLogger(GLJournals.class.getName());
  public static WebDriver driver;

  static GLJournals objGLJournals;
  //Page Factory - OR:
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Combo_5_cboCombo']")
  public static WebElement drpdnTransaction;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_OBJ_Enq0_inputtableminimise']")
  public static WebElement btnCloseAuditInfo;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Combo_10_cboCombo']")
  public static WebElement drpdnStandardJournalDepartment;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Combo_11_cboCombo']")
  public static WebElement drpdnStandardJournalSection;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_btnFind_JOURNAL_LINES_1_5']")
  public static WebElement btnFindLedgerCode;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_JOURNAL_LINES_1_5']")
  public static WebElement txtFindLedgerCodeDebit;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_JOURNAL_LINES_2_5']")
  public static WebElement txtFindLedgerCodeCredit;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_JOURNAL_LINES_1_7']")
  public static WebElement txtFindDebit;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_JOURNAL_LINES_2_8']")
  public static WebElement txtFindCredit;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_proxy_txt_6']")
  public static WebElement txtJournalNumber;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Combo_32_cboCombo']")
  public static WebElement txtStandardJournalStatus;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsFind0_WC_Fin_Combo_1_cboCombo']")
  public static WebElement drpdnFindTransaction;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsFind0_WC_Fin_Combo_2_cboCombo']")
  public static WebElement drpdnFindJournalType;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsTest1_proxy_txt_3']")
  public static WebElement txtFindJournalHeaderforReversalNumber;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_proxy_txt_27']")
  public static WebElement txtJournalNotoReverse;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Combo_26_cboCombo']")
  public static WebElement txtReversalJournalStatus;

  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_13_imgDte']")
  public static WebElement dtStandardJournalDate;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Combo_5_cboCombo']")
  public static WebElement drpdnRevarsalJournalTransaction;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_2$cboCombo']")
  public static WebElement drpdnJournalTransaction;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_7$cboCombo']")
  public static WebElement drpdnDepartment;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_8$cboCombo']")
  public static WebElement drpdnSection;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_9_imgDte']")
  public static WebElement dtNextDate;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_10$cboCombo']")
  public static WebElement drpdnFrequency;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Curr_11$txtCurr']")
  public static WebElement txtRunsRequired;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_PERIODIC_LINES_1_5']")
  public static WebElement txtLedgerCode;
  
  @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_PERIODIC_LINES_1_6']")
  public static WebElement txtDebitValue;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_3']")
  public static WebElement txtTemplate;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WCFinancialsFind0$proxy_txt_3']")
  public static WebElement txtFindTemplate;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsFind0_proxy_chk_13']")
  public static WebElement chkshowHideTemplateReadyToRun;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_29$cboCombo']")
  public static WebElement drpdnStatus;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsFind0_proxy_txt_4']")
  public static WebElement txtFindJournalNumber;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_proxy_txt_27']")
  public static WebElement txtJournaltoReverseNumber;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Combo_26_cboCombo']")
  public static WebElement txtJournaltoReverseStatus;
  
 
  public static String getDrpdnStandardJournalDepartment() {
    Select oSelect = new Select(GLJournals.drpdnStandardJournalDepartment);
    String standardJournalDepartment = oSelect.getFirstSelectedOption().getText();
    return standardJournalDepartment;
  }
  
  public static String getDrpdnStandardJournalSection() {
    Select oSelect = new Select(GLJournals.drpdnStandardJournalSection);
    String standardJournalDepartment = oSelect.getFirstSelectedOption().getText();
    return standardJournalDepartment;
  }
  
  public static String getStandardJournalNumber() {
    return txtJournalNumber.getAttribute("value");
  }
  
  public static String getTxtStandardJournalStatus() {
    Select oSelect = new Select(GLJournals.txtStandardJournalStatus);
    String journalStatus = oSelect.getFirstSelectedOption().getText();
    return journalStatus;
  }
  
  public static String getJournalNotoReversal() {
    return txtJournalNotoReverse.getAttribute("value");
  }
  
  public static String getReversalJournalStatus() {
    Select oSelect = new Select(GLJournals.txtJournaltoReverseStatus);
    String standardJournalDepartment = oSelect.getFirstSelectedOption().getText();
    return standardJournalDepartment;
  }
   
  //parameterize constructor to initalize driver and page factory web element
  public GLJournals(WebDriver driver) throws FileNotFoundException{
    driver=TestBase.driver;
    PageFactory.initElements(driver, this);
  }

  public GLJournals()  throws FileNotFoundException{
  }
}
