package financialWeb.testScripts;
import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorVouchersSalesInvoicesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;

public class DebtorsVouchers63969 extends DebtorsVouchersWorkflow{

  @Test(groups = {"smoke"})
  public void amendDbInvoice() throws InterruptedException, ParseException, IOException {
        
    DebtorMaintenanceWorkflow.createDebtor();
    createDBInvoice();
    setDBInvoiceTypeOfSupply(testdataprop.getProperty("typeofsupply"));
    DebtorVouchersSalesInvoicesWorkflow.setCommentForPIM(testdataprop.getProperty("comment"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    String typeofsupply = getDBInvoiceTypeOfSupply(); 
    validateTypeOfSupply(typeofsupply);
    String comment = DebtorVouchersSalesInvoicesWorkflow.getCommentForPIM();
    validateCommentForInvoice(comment);
    clickHrefLink(testdataprop.getProperty("home"));
       
    //signOut
    clickSignOut();    
  }
}