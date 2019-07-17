package financialWeb.pages;

import java.io.FileNotFoundException;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;

public class DebtorAdjustments extends CommonPage {

  public static final Logger log = Logger.getLogger(DebtorAdjustments.class.getName());
  public static WebDriver driver;

  static DebtorAdjustments objDebtorAdjustments;
  // Page Factory - OR:
  @FindBy(xpath = "//*[contains(text(),'GL Date')]/parent::td/following-sibling::td//*[@class='img_dropdown']")
  public static WebElement txtGLDate;

  @FindBy(xpath = "//*[contains(text(),'Amount')]/parent::td/following-sibling::td//input[@type='text' and @class='currfield']")
  public static WebElement txtAmount;
  
  @FindBy(xpath="//*[contains(text(),'Reference 1')]/parent::td//following-sibling::td//input[@value='...']")
  public static WebElement txtReference1Dot;
  
  @FindBy(xpath="//*[contains(text(),'Transaction Date')]/parent::td/following-sibling::td//img[1]")
  public static WebElement txtTransactionDateFrom;
  
  @FindBy(xpath="//*[contains(text(),'Transaction Date')]/parent::td/following-sibling::td//img[2]")
  public static WebElement txtTransactionDateTo;
  
  @FindBy(xpath="//*[@value='Cancel Payment Reversal']")
  public static WebElement btnCnclPaymentReversal;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Combo_6_cboCombo']")
  public static WebElement drpdwnPopupReason;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_proxy_txt_7']")
  public static WebElement drpdwnPopupComments;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_btn_Table_Results']")
  public static WebElement btnsavecancellation;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd2_txtPIN_ALLOCATION_1_9']")
  public static WebElement AllocatedAmt;

	@FindBy(xpath="//select[starts-with(@name, 'ctl00$Main$WC_FIN_Grid_Upd') and contains(@name, '$WC_Fin_Combo_9$cboCombo')]")
  public static WebElement drpdnFromDebtorShow;

  @FindBy(xpath="//select[starts-with(@name, 'ctl00$Main$WC_FIN_Grid_Upd') and contains(@name, '$WC_Fin_Combo_10$cboCombo')]")
  public static WebElement drpdnToDebtorShow;
  
  @FindBy(xpath="//input[starts-with(@name, 'ctl00_Main_WC_FIN_Grid_Upd') and contains(@name, '_chkPIN_TIDYBETWEENPL_FROM_')]")
  public static WebElement chkFromDebtorSelectForTidy;

  @FindBy(xpath="//input[starts-with(@name, 'ctl00_Main_WC_FIN_Grid_Upd') and contains(@name, '_chkPIN_TIDYBETWEENPL_TO_')]")
  public static WebElement chkToDebtorSelectForTidy;
  
  @FindBy(xpath="//input[starts-with(@name, 'ctl00_Main_WC_FIN_Grid_Upd') and contains(@name, '_chkPIN_TIDYBETWEENPLSELECTED_')]")
  public static List<WebElement> chkReverse;
  
  @FindBy(xpath="//span[@class='validationItem']//*[text()='Tidy Reference']/following-sibling::td/a[@title='Show From Adjustment Transaction']")
  public static WebElement lblFromTidyReference;
  
  @FindBy(xpath="//span[@class='validationItem']//*[text()='Tidy Reference']/following-sibling::td/a[@title='Show To Adjustment Transaction']")
  public static WebElement lblToTidyReference;
  
  @FindBy(xpath="//span[starts-with(@id, 'ctl00_Main_WC_FIN_Grid_Upd') and contains(@id, '_spHPIN_TIDYBETWEENPLSELECTED_')]")
  public static List<WebElement> lblReverse;
  
  @FindBy(xpath="//input[starts-with(@id, 'ctl00_Main_WC_FIN_Grid_Upd')  and contains(@id, '_txtPIN_TIDYBETWEENPLSELECTED_1_1')]")
  public static WebElement txtCrNoteTidyAmt;
  
  @FindBy(xpath="//input[starts-with(@id, 'ctl00_Main_WC_FIN_Grid_Upd')  and contains(@id, '_txtPIN_TIDYBETWEENPLSELECTED_2_13')]")
  public static WebElement txtInvoceTidyAmt;
  
  //input[starts-with(@id, 'ctl-10_Main_WC_FIN_Grid_Upd')   and contains(@id, '_txtPIN_TIDYBETWEENPLSELECTED_')]
  
  // parameterize constructor to initalize driver and page factory web element
  public DebtorAdjustments(WebDriver driver) throws FileNotFoundException {
    driver = TestBase.driver;
    PageFactory.initElements(driver, this);
  }

  public DebtorAdjustments() throws FileNotFoundException {
  }



}
