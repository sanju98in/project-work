package financialWeb.pages;

import java.io.FileNotFoundException;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;
public class GLEnquiries extends CommonPage {

  public static final Logger log= Logger.getLogger(GLEnquiries.class.getName());
  public static WebDriver driver;

  static GLEnquiries objGLEnquiries;
  //Page Factory - OR:
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Combo_10_cboCombo']")
  public static WebElement drpdnDimensionOne; 
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Combo_12_cboCombo']")
  public static WebElement drpdnDCLevel; 
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_proxy_find_15']")
  public static WebElement btnFindDetailCode;
  
  @FindBy(xpath="//*[@title='use % or _ as wildcards']")
  public static WebElement txtAnalysisCode;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_15']")
  public static WebElement txtDetailCode;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_chk_35']")
  public static WebElement chkCreateCopyOfEnquiry;

  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_36']")
  public static WebElement txtCreateCopyOfEnquiryName;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_2']")
  public static WebElement txtEnquiryName;

  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_find_2']")
  public static WebElement txtFindEnquiryName;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WCFinancialsFind0$proxy_txt_2']")
  public static WebElement txtEnquiryFindName;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsFind0_ResultsTable']/tbody/tr/td")
  public static List <WebElement> tblFindHighLevelEnquiryData;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_4']")
  public static WebElement txtEnquiryDesc;
  
  //@FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_find_13']")
@FindBy(xpath="//label[contains(text(),'Code')]/parent::td/following-sibling::td//input[@value='...' and @title='Find Cost Code']")
  public static WebElement btnFindCostCentre;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WCFinancialsFind0$proxy_txt_1']")
  public static WebElement txtCostCode;
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_proxy_chk_33']")
  public static WebElement chkCopyOfEnquiry;
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_34']")
  public static WebElement txtCopyOfEnquiryName;
  
  
  //parameterize constructor to initalize driver and page factory web element
  public GLEnquiries(WebDriver driver) throws FileNotFoundException{
    driver=TestBase.driver;
    PageFactory.initElements(driver, this);
  }

  public GLEnquiries()  throws FileNotFoundException{
  }
  
  
}
