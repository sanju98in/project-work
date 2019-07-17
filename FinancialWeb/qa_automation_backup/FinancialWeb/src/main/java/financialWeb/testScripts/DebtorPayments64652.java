package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorPaymentsWorkflow;

public class DebtorPayments64652 extends DebtorPaymentsWorkflow {

  @Test(groups = {"smoke"})
  public void findManualPaymentUsingSearchFunctionality() throws InterruptedException, ParseException, IOException {
  
    uniqueDebtorNumber = DebtorMaintenanceWorkflow.createDebtor();
    createUnallocatedManualPayment(
        uniqueDebtorNumber,
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
    findManualPaymentUsingSearch(uniqueDebtorNumber);
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
  
}
