package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorPaymentsWorkflow;

public class DebtorPayments64650 extends DebtorPaymentsWorkflow {

 @Test(groups = {"smoke"})
  public void cancelManualPayment() throws InterruptedException, ParseException, IOException {
  
    uniqueMaintenanceNumber = DebtorMaintenanceWorkflow.createDebtor();
    createUnallocatedManualPayment(
        uniqueMaintenanceNumber,
        testdataprop.getProperty("paymenttranscode"),
        msgprop.getProperty("referenceone"),
        msgprop.getProperty("referencetwo"),
        msgprop.getProperty("updatedreferenceone"),
        msgprop.getProperty("updatedreferencetwo"),
        testdataprop.getProperty("amount"),
        testdataprop.getProperty("cashpaymentmethod"),
        testdataprop.getProperty("comment"),
        msgprop.getProperty("authorisedformatchingstatus")
        );
    
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("adjust"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("cancelpayment"));
    selectCancellationReason(testdataprop.getProperty("cancelreason"));
    selectCancellationMessage(testdataprop.getProperty("cancelmessage"));
    cancellationSave();
    validateStatus(msgprop.getProperty("cancelled"));
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }

  
    
}
