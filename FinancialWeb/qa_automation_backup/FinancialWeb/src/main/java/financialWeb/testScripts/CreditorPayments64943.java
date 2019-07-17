package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorPaymentsWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;

public class CreditorPayments64943 extends CreditorPaymentsWorkflow{
  
  @Test(groups = {"smoke"})
  public void  viewPaymentRunsForCreditor() throws InterruptedException, ParseException, IOException, URISyntaxException {
        
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    clickHrefLink(testdataprop.getProperty("home"));
    waitforPanelLoad();
    searchText(testdataprop.getProperty("searchcrpaymentruncontrol"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchcrpaymentruncontrol"));
    verifyInProgressCheckbox();
    checkFinishedCheckbox();
    checkFailedCheckbox();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    verifyCrPaymentRunControlTableExist();
    verifyCrPaymentColumnHeaders(testdataprop.getProperty("crpaymentruncontroltableheaders"));       
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }
}