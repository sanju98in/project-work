package financialWeb.testScripts;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorAdjustmentsWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorPaymentsWorkflow;
import financialWeb.workflow.DebtorVouchersSalesInvoicesWorkflow;

public class DebtorAdjustments64870 extends DebtorAdjustmentsWorkflow {

  @Test(groups = {"smoke"})
  
  public void addNoteswithAttachmenttoaPaymentReversal()
      throws InterruptedException, ParseException, IOException, URISyntaxException {
    // Create Debtor
    uniqueDebtorNumber = DebtorMaintenanceWorkflow.createDebtor();
    // Debtor - Create Unallocated Payment Reversal
    adjustmentNumber = getAdjustmentNumber(uniqueDebtorNumber);
    // Add Notes to the Payment Reversal
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("notes")); 
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("new"));
    DebtorVouchersSalesInvoicesWorkflow.setMsgField(testdataprop.getProperty("comment"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addattachment"));
    uploadNewAttachment();
    DebtorVouchersSalesInvoicesWorkflow.clickBrowseAndUploadFile();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    String searchForTab = testdataprop.getProperty("dbnotesforReversalPayment").toString().trim() + " "+adjustmentNumber.trim();
    searchAndClickTableData(orprop.getProperty("breadtable"),searchForTab);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submitnewinquiry"));
    searchTableColumn(orprop.getProperty("finddebtorstable"),msgprop.getProperty("paymenttype"));
    DebtorPaymentsWorkflow.validateImageIsAttached();
    searchTableColumn(orprop.getProperty("finddebtorstable"),testdataprop.getProperty("comment"));
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
        
  }
}
