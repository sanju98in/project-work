package financialWeb.testScripts;
import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.pages.DebtorsInvoice;
import financialWeb.pages.DebtorsVouchers;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;

public class DebtorsVouchers64276 extends DebtorsVouchersWorkflow{
  

  @Test(groups = {"smoke"})
  public void viewTheDBInvoiceEnquiry() throws InterruptedException, ParseException, IOException {
        
    DebtorMaintenanceWorkflow.createDebtor();
    DebtorsVouchersWorkflow.createDBInvoice();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("invoiceenquiry"));
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),referenceNo);
    String Status = DebtorsInvoice.getDBInvoiceStatus();
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),Status); 
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),testdataprop.getProperty("departmentandsection")); 
    String amount = dbInvoiceAmount;
    amount = "£"+ amount;
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),amount);    
    searchTableColumn(orprop.getProperty("tblcrnoteenquirydebtordetails"),uniqueMaintenanceNumber);
    searchTableColumn(orprop.getProperty("tbldbcrnotechargelineenquiry"),testdataprop.getProperty("comment"));
    String qty = DebtorsVouchersWorkflow.getDBCreditLineQty();
    searchTableColumn(orprop.getProperty("tbldbcrnotechargelineenquiry"),qty);
    String unitPrice = DebtorsVouchers.getCreditLinePrice(); 
    unitPrice = "£"+ unitPrice;
    searchTableColumn(orprop.getProperty("tbldbcrnotechargelineenquiry"),unitPrice);
    searchTableColumn(orprop.getProperty("tbldbcrnotechargelineenquiry"),amount);
    clickHrefLink(testdataprop.getProperty("home"));
       
    //signOut
    clickSignOut();    
  }
}