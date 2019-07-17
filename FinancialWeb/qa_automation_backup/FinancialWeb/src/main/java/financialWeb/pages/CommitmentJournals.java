package financialWeb.pages;

import java.io.FileNotFoundException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;
public class CommitmentJournals extends CommonPage {

  public static final Logger log= Logger.getLogger(CommitmentJournals.class.getName());
  public static WebDriver driver;

  static CommitmentJournals objCommitmentJournals;
  
  //Page Factory - OR:
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_JOURNAL_LINES_1_15']")
  public static WebElement drpdnComType; 
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_JOURNAL_LINES_2_15']")
  public static WebElement drpdnComTypeScndGrid; 
  
  @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Date_13_imgDte']")
  public static WebElement dtDate; 
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_28']")
  public static WebElement txtJournalNoToRvrs; 
  
  @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_find_7']")
  public static WebElement btnFindJournalNo;

  
  //parameterize constructor to initalize driver and page factory web element
  public CommitmentJournals(WebDriver driver) throws FileNotFoundException{
    driver=TestBase.driver;
    PageFactory.initElements(driver, this);
  }

  public CommitmentJournals()  throws FileNotFoundException{
  }
  
  
}
