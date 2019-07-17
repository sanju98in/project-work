package financialWeb.testScripts;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;

public class DebtorsVouchers64152 extends DebtorsVouchersWorkflow {
 

  @Test(groups = {"smoke"})
  public void addNotesWithAttachmentToADBRecorveryGroup() throws InterruptedException, ParseException, IOException, URISyntaxException {
  //Create Debtor
    uniqueMaintenanceNumber = DebtorMaintenanceWorkflow.createDebtor();
   // Create two DB Invoice
    String oldReferenceNo = createDBInvoice();
    referenceNo = createDBInvoice();
    //Create DB Recovery Group
    createDBRecoveryGroup(oldReferenceNo);
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
