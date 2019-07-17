package financialWeb.testScripts;
import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorVouchersSalesInvoicesWorkflow;
import financialWeb.workflow.DebtorsCreditNotesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;

public class DebtorsVouchers64615 extends DebtorVouchersSalesInvoicesWorkflow{
  
  @Test(groups = {"smoke"})
  public void  transferInvoiceToNewDepartmentAndSection() throws InterruptedException, ParseException, IOException {
        
    DebtorMaintenanceWorkflow.createDebtor();
    DebtorsVouchersWorkflow.createDBInvoice();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("adjust"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("transfertonewdeptorsect"));   
    setNewDept(testdataprop.getProperty("housing"));   
    DebtorsCreditNotesWorkflow.setAdjustCrNoteNewDept(testdataprop.getProperty("development"));
    DebtorsCreditNotesWorkflow.saveCancellation();
    waitforPanelLoad();
    dbInvoiceDpt = validateRandomWebElementdrpdwn(msgprop.getProperty("lbldepartment"),testdataprop.getProperty("housing"));
    //dbInvoiceDpt =  getSection();
    dbInvoiceSec = validateRandomWebElementdrpdwn(msgprop.getProperty("lblsection"),testdataprop.getProperty("development"));
    //dbInvoiceSec =  getInvoiceSection();
    //DebtorsCreditNotesWorkflow.validateUpdateDataOnDBCreditNote(dbInvoiceDpt,testdataprop.getProperty("housing"));
    //DebtorsCreditNotesWorkflow.validateUpdateDataOnDBCreditNote(dbInvoiceSec,testdataprop.getProperty("development"));
    clickHrefLink(testdataprop.getProperty("home"));
    
    //signOut
    clickSignOut();   
  }
}