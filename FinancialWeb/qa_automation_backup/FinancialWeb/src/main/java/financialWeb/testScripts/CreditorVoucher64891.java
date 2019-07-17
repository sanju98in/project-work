package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.CreditorPaymentsWorkflow;
import financialWeb.workflow.CreditorVouchersWorkflow;

public class CreditorVoucher64891 extends CreditorVouchersWorkflow{
  
  @Test(groups = {"smoke"})
  public void  maintainingSundryInvoices() throws InterruptedException, ParseException, IOException, URISyntaxException {
    uniqueMaintenanceNumber=CreditorMaintenanceWorkflow.createCreditor();    
    voucherNumber = CreditorPaymentsWorkflow.createCRInvoice(testdataprop.getProperty("sundryinvoicetranscode"),
        uniqueMaintenanceNumber,
        testdataprop.getProperty("amount"),
        testdataprop.getProperty("vatamount"),
        testdataprop.getProperty("glcode"),
        testdataprop.getProperty("comment"),
        testdataprop.getProperty("amount"),
        testdataprop.getProperty("vtcode"));
    setSUndryInvoiceVoucherNo(voucherNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    setSUndryInvoiceComment(testdataprop.getProperty("comment"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    clickHrefLink(testdataprop.getProperty("home"));
   //signOut
    clickSignOut();   
  }
}