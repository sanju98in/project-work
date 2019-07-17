package financialWeb.testScripts;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsAuthoriseWorkflow;
import financialWeb.workflow.DebtorsEnquiriesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;


public class DebtorEnquiries64659 extends DebtorsEnquiriesWorkflow{
  
  @Test(groups = {"smoke"})
  public void  invoiceNotYetDue() throws Exception {
            
    uniqueMaintenanceNumber=DebtorMaintenanceWorkflow.createDebtor();     
    DebtorsVouchersWorkflow.createDBInvoice();
    searchText(testdataprop.getProperty("searchdbenquiry"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbenquiry"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchdbageddebtenquiry"));   
    DebtorsAuthoriseWorkflow.setDBAuthTransactionDebtorNumber(uniqueMaintenanceNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    searchTableColumn(orprop.getProperty("findinvoicetable"),uniqueMaintenanceNumber);
    searchTableColumn(orprop.getProperty("findinvoicetable"),fullName);
    verifyNotYetDueAmount(orprop.getProperty("findinvoicetable"),dbInvoiceAmount);
    calculateTotalOutStandingAmt(orprop.getProperty("debtorenquirytable"));
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }

}