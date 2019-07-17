package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorVouchersSalesInvoicesWorkflow;
import financialWeb.workflow.DebtorsInvoiceWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;

public class DebtorsVouchers64150 extends DebtorVouchersSalesInvoicesWorkflow {

  @Test(groups = {"smoke"})
  public void adjustInvoiceByWriteOffInvoice()
      throws InterruptedException, ParseException, IOException {

    uniqueDebtorNumber = DebtorMaintenanceWorkflow.createDebtor();
    DebtorsVouchersWorkflow.createDBInvoice();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("adjust"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("writeoffinvoice"));
    setTransactionCodeWriteOff(testdataprop.getProperty("transactioncodewriteoff"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    setReasonWriteOff(testdataprop.getProperty("writeoffreason"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    waitforPanelLoad();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("close"));
    DebtorsInvoiceWorkflow
        .validateDBInvoiceAuthorizeStatus(msgprop.getProperty("selectedformatching"));
    clickHrefLink(testdataprop.getProperty("home"));

    // signOut
    clickSignOut();
  }
}
