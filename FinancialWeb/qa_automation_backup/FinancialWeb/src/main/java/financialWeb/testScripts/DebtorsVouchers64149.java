package financialWeb.testScripts;
import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorVouchersSalesInvoicesWorkflow;
import financialWeb.workflow.DebtorsInvoiceWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;

public class DebtorsVouchers64149 extends DebtorsVouchersWorkflow{

  @Test(groups = {"smoke"})
  public void adjustInvoiceByPayInvoice() throws InterruptedException, ParseException, IOException {
        
    DebtorMaintenanceWorkflow.createDebtor();
    createDBInvoice();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("adjust"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("payinvoice"));
    DebtorVouchersSalesInvoicesWorkflow.setTransactionCodePayment(testdataprop.getProperty("transactioncodepayment"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("close"));
    DebtorsInvoiceWorkflow.validateDBInvoiceAuthorizeStatus(msgprop.getProperty("fullypaid"));
    clickHrefLink(testdataprop.getProperty("home"));
       
    //signOut
    clickSignOut();    
  }
}