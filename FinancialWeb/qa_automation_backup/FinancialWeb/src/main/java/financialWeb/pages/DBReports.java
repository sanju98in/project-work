package financialWeb.pages;

import java.io.FileNotFoundException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;

public class DBReports extends CommonPage {

  public static final Logger log = Logger.getLogger(DBReports.class.getName());
  public static WebDriver driver;

  // Page Factory - OR:


  // *[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Combo_3_cboCombo']
  @FindBy( xpath = "//*[contains(text(),'Report Master')]/parent::td/following-sibling::td/div/span/select")
  public static WebElement drpdnDBStyleRprtMstr;



  // *[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Combo_5_cboCombo']
  @FindBy(
      xpath = "//*[contains(text(),'Report Style')]/parent::td/following-sibling::td/div/span/select")
  public static WebElement drpdnDBStyleRprtStyle;

  // @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_proxy_txt_11']")
  // @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_proxy_txt_11']")
  @FindBy(xpath = "//*[contains(text(),'Name')]/parent::td/following-sibling::td//*[@type='text']")
  public static WebElement txtDBStyleMaintName;

  //@FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_proxy_txt_12']")
  //@FindBy(xpath = "//*[contains(text(),'Name')]/parent::td/following-sibling::td//*[@type='text']")
  @FindBy(xpath = "//*[@id='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_12']")
  public static WebElement txtDBStyleMaintDescr;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_proxy_txt_32']")
  public static WebElement txtDBStyleMaintComments;

 // @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_proxy_chk_29']")
  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_proxy_chk_29']")
  public static WebElement chkbxDBStyleMaintExprtFile;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_List0_chk_143_Account_Number_0']")
  public static WebElement chkbxDBStyleMaintAccNo;

 // @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Combo_30_cboCombo']")
  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Combo_30_cboCombo']")
  public static WebElement drpdnDBStyleMaintExprtFrmt;

 // @FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$btnPNT_FIELDS_2']")
 // @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_btnPNT_FIELDS_2']")
  @FindBy(xpath = "//input[@value='    Fields    ']")
  public static WebElement btndrpdnDBStyleFields;

  //@FindBy(xpath = "//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$btnPNT_PARAMETERS_4']")
  @FindBy(xpath = "//input[@value='    Parameters    ']")
  public static WebElement btnDBStyleParameters;

 // @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_chkPIN_SY_REPORT_DEF_FIELDS_1_8']")
  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_chkPIN_SY_REPORT_DEF_FIELDS_1_8']")
  public static WebElement chkbxDBStyleUsrEdtble;

  @FindBy(xpath = "//input[@value='    Details    ']")
  public static WebElement btnDBStyleDetails;

  @FindBy(xpath = "//*[@id='divpinresults']")
  public static WebElement pnlDBStylePinnedItem;

  @FindBy(xpath = "//*[@id='divpinresults']/table/tbody/tr/th/input")
  public static WebElement btnDBStyleAddToReportCriteria;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_SY_REPORT_DEF_PARAMETER_1_9']")
  public static WebElement txtGLStyleParamtrValue;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_ErrorLabel']")
  public static WebElement lblDeleteWarnMsg;

  @FindBy(xpath = "//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_SY_REPORT_DEF_CRITERIA_1_12']")
  public static WebElement txtDBJobRequestCritVlue;

  @FindBy(xpath = "//*[@id='ctl00_Main_WCFinancialsTest1_proxy_txt_6']")
  public static WebElement txtDBReportViewerJobNo;

  @FindBy(xpath = "//a[@title='Job Details']")
  public static WebElement hyprlinkJobDetails;


  public static String getTxtReportStyleName() {
    boolean found = IsExist(txtDBStyleMaintName);
    String repStyleName = null;
    if (found) {
      repStyleName = txtDBStyleMaintName.getAttribute("value");
    }
    return repStyleName;
  }


  public DBReports(WebDriver driver) throws FileNotFoundException {
    driver = TestBase.driver;
    PageFactory.initElements(driver, this);
  }

  public DBReports() throws FileNotFoundException {
  }
}
