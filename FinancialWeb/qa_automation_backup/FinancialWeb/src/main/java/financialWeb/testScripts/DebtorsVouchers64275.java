package financialWeb.testScripts;
import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;

public class DebtorsVouchers64275 extends DebtorsVouchersWorkflow{

  @Test(groups = {"smoke"})
  public void deleteDbInvoice() throws InterruptedException, ParseException, IOException {
        
    DebtorMaintenanceWorkflow.createDebtor();
    createUnauthorisedDBInvoice();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("delete"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("delete"));
    setDBAuthTransactionReferenceOne(referenceNo);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    validateNewTransactionMsg(testdataprop.getProperty("warningmsg"));
    clickHrefLink(testdataprop.getProperty("home"));
       
    //signOut
    clickSignOut();    
  }
}