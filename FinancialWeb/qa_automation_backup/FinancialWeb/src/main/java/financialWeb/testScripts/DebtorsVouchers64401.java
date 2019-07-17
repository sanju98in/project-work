package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsCreditNotesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;

public class DebtorsVouchers64401 extends DebtorsVouchersWorkflow {
 

  @Test(groups = {"smoke"})
  public void viewTheDBCreditNoteEnquiry() throws InterruptedException, ParseException, IOException {
  
    DebtorMaintenanceWorkflow.createAndStoreDebtorDetails();
    DebtorsCreditNotesWorkflow.createDBCreditNote();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("creditnotenquiry"));
    DebtorsCreditNotesWorkflow.validateDBCreditNoteEnquiryNumber(referenceNo);
    searchTableColumn(orprop.getProperty("tbldbcrnoteenquiry"),referenceNo);
    searchTableColumn(orprop.getProperty("tbldbcrnoteenquiry"),dbCrNoteDpt);
    searchTableColumn(orprop.getProperty("tbldbcrnoteenquiry"),dbCrNoteSec);
    amount = "£"+ amount;
    searchTableColumn(orprop.getProperty("tbldbcrnoteenquiry"),amount);
    searchTableColumn(orprop.getProperty("tblcrnoteenquirydebtordetails"),fullName);
    searchTableColumn(orprop.getProperty("tbldbcrnotechargelineenquiry"),testdataprop.getProperty("dbcreditlinedesc"));
    searchTableColumn(orprop.getProperty("tbldbcrnotechargelineenquiry"),testdataprop.getProperty("qty"));
    searchTableColumn(orprop.getProperty("tbldbcrnotechargelineenquiry"),testdataprop.getProperty("rndtelephonelimit"));
    searchTableColumn(orprop.getProperty("tbldbcrnotechargelineenquiry"),amount);
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
