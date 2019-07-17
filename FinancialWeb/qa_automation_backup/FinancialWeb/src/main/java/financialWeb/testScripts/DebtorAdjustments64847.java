package financialWeb.testScripts;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorAdjustmentsWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;

public class DebtorAdjustments64847 extends DebtorAdjustmentsWorkflow {

  @Test(groups = {"smoke"})
  
  public void cancelPaymentReversal()
      throws InterruptedException, ParseException, IOException, URISyntaxException {
    // Create Debtor
    uniqueDebtorNumber = DebtorMaintenanceWorkflow.createDebtor();
    // Debtor - Create Unallocated Payment Reversal
    adjustmentNumber = getAdjustmentNumber(uniqueDebtorNumber);
   
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("adjust"));
    clickCancelPaymentReversal();
        
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
