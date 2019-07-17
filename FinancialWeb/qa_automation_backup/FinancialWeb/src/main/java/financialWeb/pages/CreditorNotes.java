package financialWeb.pages;

import java.io.FileNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;
public class CreditorNotes extends CommonPage {
  
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_13']")
    public static WebElement txtMsg;
  
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_13']")
    public static WebElement txtUpdatedMsg;
    
    public static String getTxtUpdatedMsg() {
      return txtUpdatedMsg.getAttribute("value");
    }

    public static void setTxtUpdatedMsg(String data) {
      setText(CreditorNotes.txtUpdatedMsg,data);
    }

    public static String getTxtMsg() {
      return txtMsg.getAttribute("value");
    }

    public static void setTxtMsg(String data) {
      setText(CreditorNotes.txtMsg,data);
    }

  //parameterize constructor to initalize driver and page factory web element
    public CreditorNotes(WebDriver driver) throws FileNotFoundException{
          driver=TestBase.driver;
          PageFactory.initElements(driver, this);
    }
    
    public CreditorNotes()  throws FileNotFoundException{
      
    }
   
}
