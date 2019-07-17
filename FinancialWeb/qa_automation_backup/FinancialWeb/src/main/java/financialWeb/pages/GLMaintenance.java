package financialWeb.pages;

import java.io.FileNotFoundException;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;
public class GLMaintenance extends CommonPage {

  public static final Logger log= Logger.getLogger(GLMaintenance.class.getName());
  public static WebDriver driver;

  static GLMaintenance objGLMaintenance;
  //Page Factory - OR:
  
  @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsTest0_tvDatat0']/a")
  public static WebElement lnkControlCentrAnalysis;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsTest1_tvDatat0']/a")
  public static WebElement lnkDetailCodeDimensions;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsTest2_tvDatat0']/a")
  public static WebElement lnkDetailCodeAnalysis;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_1']")
  public static WebElement txtClasificationCode;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WCFinancialsTest0$proxy_txt_1']")
  public static WebElement txtGlFindLedgerCode;

  @FindBy(xpath="//*[@name='ctl00$Main$WCFinancialsFind0$proxy_txt_1']")
  public static WebElement txtSetFindClasificationCode;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_find_1']")
  public static WebElement txtFindClasificationCode;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_1']")
  public static WebElement txtLedgerCode;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WCFinancialsFind0$proxy_txt_2']")
  public static WebElement txtAnalysisCode;
  
 // @FindBy(xpath="//*[@name='ctl00$Main$WCFinancialsFind0$proxy_txt_3']")
  @FindBy(xpath="//*[text()='Analysis Code']/parent::td/following-sibling::td//input[@title='use % or _ as wildcards']")
  public static WebElement txtFindCostAnalysisCode;

  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_4']")
  public static WebElement txtClassificationCodeMaintDesc;

  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_5']")
  public static WebElement txtLevel;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_5']")
  public static WebElement txtSetNewClasificationCode;

  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_6']")
  public static WebElement txtDesc;

  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_6']")
  public static WebElement txtClassificationCodeMaintNewDesc;

  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_7']")
  public static WebElement txtClassificationCodeMaintNewComment;
 
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_7']")
  public static WebElement txtCode;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_8']")
  public static WebElement txtControlDataMaintCode;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_9']")
  public static WebElement txtControlDataMaintDimensionSets;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_13']")
  public static WebElement txtMsg;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_16']")
  public static WebElement txtGlNoteMsg;

  @FindBy(xpath="//*[@name='ctl00$Main$WCFinancialsTest1$WC_Fin_Combo_1$cboCombo']")
  public static WebElement drpdnControlDataType;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WCFinancialsTest2$WC_Fin_Combo_1$cboCombo']")
  public static WebElement drpdnAnalysisSet;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WCFinancialsTest0$WC_Fin_Combo_1$cboCombo']")
  public static WebElement drpdnCostCentreAnalysisSet;  
 
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_5$cboCombo']")
  public static WebElement drpdnAnalysisLevel;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_6$cboCombo']")
  public static WebElement drpdnUnits;

  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_7$cboCombo']")
  public static WebElement drpdnAssetType;

  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_8$cboCombo']")
  public static WebElement drpdnLevel;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_24$cboCombo']")
  public static WebElement drpdnDimensionSet;
  
  //@FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_btnFind_DETAIL_INVERTED_1_5']")
  @FindBy(xpath="//input[starts-with(@id, 'ctl00_Main_WC_FIN_Grid_Upd') and contains(@id,'_btnFind_DETAIL_INVERTED_1_5')]")

  public static WebElement btnFindAnalysisLevel;
  
 // @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_btnFind_DETAIL_INVERTED_1_7']")
  @FindBy(xpath="//input[starts-with(@id, 'ctl00_Main_WC_FIN_Grid_Upd') and contains(@id,'_btnFind_DETAIL_INVERTED_1_7')]")
  public static WebElement txtFindAnalysisCode;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsFind0_inputtableminimise']")
  public static WebElement imgClose;

  @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsFind0_inputtableminimise']/a[2]")
  public static WebElement imgClosePopup;

  @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsFind0_ErrorLabel']")
  public static WebElement lblDeleteMessage;

  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_ErrorLabel']")
  public static WebElement lblInsertionMessage;

  @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsFind0_ErrorLabel']")
  public static WebElement lblErrorMessage;

  @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsFind0_ResultsTable']/tbody/tr/td")
  public static List<WebElement> tblFindDetailLevels; 
 
  @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsTest1_pnlDHS']/table/tbody")
  public static WebElement tblGLControlData;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsFind0_ResultsTable']/tbody")
  public static WebElement tblGLNotesForDetailCode;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsTest2_tvData']/div/table/tbody")
  public static WebElement tblGLCostCenterDimensions;   
   
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$btn_Table_Results' and @type='button']")
  public static WebElement btnInsert;
  
 // @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_btnFind_COST_CODE_INVERTED_1_6' and @type='button']")
  @FindBy(xpath="//input[starts-with(@id, 'ctl00_Main_WC_FIN_Grid_Upd') and contains(@id,'_btnFind_COST_CODE_INVERTED_1_6')]")
  public static WebElement btnLevel;
  
 // @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_btnFind_COST_CODE_INVERTED_1_8' and @type='button']")
 // @FindBy(xpath="//input[starts-with(@id, 'ctl00_Main_WC_FIN_Grid_Upd') and contains(@id,'_btnFind_DETAIL_INVERTED_1_7')]")
  @FindBy(xpath="//input[@title='Find Analysis Code']")
  public static WebElement btnAnalysisCode;
  
  @FindBy(xpath="//input[starts-with(@id,'ctl00_Main_WC_FIN_Grid_Upd') and contains(@id,'_btnFind_COST_CODE_INVERTED_1_8')]")
  public static WebElement btnAnalysisCod;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsTest2_tvDatat1']/a")
  public static WebElement lnkCostCentreDimentions;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsFind0_proxy_txt_1']")
  public static WebElement txtGLFindCode;
  
  /*@FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Combo_5_cboCombo']")
  public static WebElement drpdnTransaction;
  
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
  public static WebElement drpdnJournalTransaction;*/
  
  
  /*public static String getDrpdnStandardJournalDepartment() {
    Select oSelect = new Select(GLMaintenance.drpdnStandardJournalDepartment);
    String standardJournalDepartment = oSelect.getFirstSelectedOption().getText();
    return standardJournalDepartment;
  }
  
  public static String getDrpdnStandardJournalSection() {
    Select oSelect = new Select(GLMaintenance.drpdnStandardJournalSection);
    String standardJournalDepartment = oSelect.getFirstSelectedOption().getText();
    return standardJournalDepartment;
  }
  
  public static String getStandardJournalNumber() {
    return txtJournalNumber.getAttribute("value");
  }
  
  public static String getTxtStandardJournalStatus() {
    Select oSelect = new Select(GLMaintenance.txtStandardJournalStatus);
    String journalStatus = oSelect.getFirstSelectedOption().getText();
    return journalStatus;
  }
  
  public static String getJournalNotoReversal() {
    return txtJournalNotoReverse.getAttribute("value");
  }
  
  public static String getReversalJournalStatus() {
    Select oSelect = new Select(GLMaintenance.txtReversalJournalStatus);
    String standardJournalDepartment = oSelect.getFirstSelectedOption().getText();
    return standardJournalDepartment;
  }*/
   
  //parameterize constructor to initalize driver and page factory web element
  public GLMaintenance(WebDriver driver) throws FileNotFoundException{
    driver=TestBase.driver;
    PageFactory.initElements(driver, this);
  }

  public GLMaintenance()  throws FileNotFoundException{
  }
}
