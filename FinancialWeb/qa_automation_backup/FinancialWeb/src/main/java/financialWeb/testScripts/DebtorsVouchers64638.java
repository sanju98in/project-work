package financialWeb.testScripts;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorVouchersSalesInvoicesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;

public class DebtorsVouchers64638 extends DebtorsVouchersWorkflow {
 

  @Test(groups = {"smoke"})
  public void addNotesWithAttachmentToADBRecorveryGroup() throws InterruptedException, ParseException, IOException, URISyntaxException {
  
    uniqueMaintenanceNumber = DebtorMaintenanceWorkflow.createDebtor();
    String oldReferenceNo = createDBInvoice();
    referenceNo = createDBInvoice();
    createDBRecoveryGroup(oldReferenceNo);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("notes"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("new"));
    DebtorsVouchersWorkflow.selectMessage(testdataprop.getProperty("comment"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addattachment"));
    uploadNewAttachment();
    DebtorVouchersSalesInvoicesWorkflow.clickBrowseAndUploadFile(); 
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    DebtorsVouchersWorkflow.switchToTabDBNotesForRecorveryGroup();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submitnewquery"));
    searchTableColumn(orprop.getProperty("tablerevoverygroup"), msgprop.getProperty("recoverygroup"));
    searchTableColumn(orprop.getProperty("tablerevoverygroup"), testdataprop.getProperty("comment"));
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
