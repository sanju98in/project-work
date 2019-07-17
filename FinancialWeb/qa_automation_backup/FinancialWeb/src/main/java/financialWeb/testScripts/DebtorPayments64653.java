package financialWeb.testScripts;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorPaymentsWorkflow;
import financialWeb.workflow.DebtorVouchersSalesInvoicesWorkflow;

public class DebtorPayments64653 extends DebtorPaymentsWorkflow {

@Test(groups = {"smoke"})
  public void addNotesWithAttachmentToAManualPayment() throws InterruptedException, ParseException, IOException, URISyntaxException {
  
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
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("notes")); 
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("new"));
    DebtorVouchersSalesInvoicesWorkflow.setMsgField(testdataprop.getProperty("comment"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addattachment"));
    uploadNewAttachment();
    DebtorVouchersSalesInvoicesWorkflow.clickBrowseAndUploadFile();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    String searchForTab = testdataprop.getProperty("dbnotesfor").toString().trim() + " "+dbPaymentNo.trim();
    searchAndClickTableData(orprop.getProperty("breadtable"),searchForTab);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submitnewinquiry"));
    searchTableColumn(orprop.getProperty("finddebtorstable"),msgprop.getProperty("paymenttype"));
    validateImageIsAttached();
    searchTableColumn(orprop.getProperty("finddebtorstable"),testdataprop.getProperty("comment"));
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
  
}
