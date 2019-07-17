package financialWeb.testScripts;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsEnquiriesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;

public class DebtorEnquiries64834 extends DebtorsEnquiriesWorkflow{
  
  @Test(groups = {"smoke"})
  public void  VerifyOutstandingTransactionsDBDetailsEnquiryPage () throws Exception {
            
    uniqueDebtorNumber=DebtorMaintenanceWorkflow.createDebtor();    
    DebtorsVouchersWorkflow.createDBInvoice();
    DebtorsVouchersWorkflow.createUnauthorisedDBInvoice();   
    searchText(testdataprop.getProperty("searchdbenquiry"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbenquiry"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchdbdetailsenquiries"));
    waitforPanelLoad();
    setDebtorEnquiriesDebtorNumber(uniqueDebtorNumber);
    submit();
    waitforPanelLoad();
    verifyOutstandingTransactionAmtDetails(orprop.getProperty("outstandingtransactiontoolstable"),testdataprop.getProperty("allocatedamount"));
    verifyOutstandingTransactionAmtDetails(orprop.getProperty("outstandingtransactiontoolstable"),testdataprop.getProperty("vatamount"));
    calculateOutStandingTransactionAmt(orprop.getProperty("outstandingtransactionsumtable"),
        Integer.parseInt(testdataprop.getProperty("currentdate")),
        Integer.parseInt(testdataprop.getProperty("noofinvoicesperremittance")),
        Integer.parseInt(testdataprop.getProperty("accesslevel3")));  
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }

}