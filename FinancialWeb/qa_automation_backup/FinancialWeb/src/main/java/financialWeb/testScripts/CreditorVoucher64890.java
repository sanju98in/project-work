package financialWeb.testScripts;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.CreditorPaymentsWorkflow;
import financialWeb.workflow.CreditorVouchersWorkflow;

public class CreditorVoucher64890 extends CreditorVouchersWorkflow {

  @Test(groups = {"smoke"})
  public void creatingSundryInvoices()
      throws InterruptedException, ParseException, IOException, URISyntaxException {

    uniqueMaintenanceNumber = CreditorMaintenanceWorkflow.createCreditor();
    CreditorPaymentsWorkflow.createCRInvoice(testdataprop.getProperty("sundryinvoicetranscode"),
        uniqueMaintenanceNumber, testdataprop.getProperty("amount"),
        testdataprop.getProperty("vatamount"), testdataprop.getProperty("glcode"),
        testdataprop.getProperty("comment"), testdataprop.getProperty("amount"),
        testdataprop.getProperty("vtcode"));
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
