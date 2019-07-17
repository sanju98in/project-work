package financialWeb.workflow;

import java.io.FileNotFoundException;
import financialWeb.pages.DebtorsAuthorise;

public class DebtorsAuthoriseWorkflow extends CommonWorkflow{

  static DebtorsAuthorise objDebtorsAuthorise;
  
  public static void setDBAuthTransactionDebtorNumber(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorsAuthorise = new DebtorsAuthorise(driver);
     waitforPanelElement(DebtorsAuthorise.txtDebtorNumber);
    DebtorsAuthorise.setDBAuthorizreDebtorNumber(data);
  }
  
  public static void setDBAuthTransactionReferenceOne(String data) throws FileNotFoundException, InterruptedException {
    objDebtorsAuthorise = new DebtorsAuthorise(driver);
    waitforPanelElement(DebtorsAuthorise.txtRefernceOne);
    DebtorsAuthorise.setDBAuthorizeReferneceOne(data);
  }
 
  public static void selectAuthorize() throws FileNotFoundException, InterruptedException {
    waitForPageLoad();
    objDebtorsAuthorise = new DebtorsAuthorise(driver);
     waitforPanelElement(DebtorsAuthorise.chkAuthorise);
    DebtorsAuthorise.selectCheckboxAuthorize();
  }
  
  public static void setValReferenceOne(String data) throws FileNotFoundException, InterruptedException {
    DebtorsAuthorise.setDBFindCrNoteReferneceOne(data);
  }

  public static void selectTransDate() throws FileNotFoundException, InterruptedException {
    DebtorsAuthorise.selectCheckboxAuthorize();  
  }

  //end of class
}