package financialWeb.testScripts;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorPaymentsWorkflow;
import financialWeb.workflow.DebtorsAuthoriseWorkflow;
import financialWeb.workflow.DebtorsEnquiriesWorkflow;

public class DebtorEnquiries64830 extends DebtorsEnquiriesWorkflow{
  
  @Test(groups = {"smoke"})
  public void   viewTheDBAgedDebtEnquiryPayAdj () throws Exception {
            
    uniqueDebtorNumber=DebtorMaintenanceWorkflow.createDebtor();     
    DebtorPaymentsWorkflow.createUnallocatedManualPayment(
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
    searchText(testdataprop.getProperty("searchdbenquiry"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbenquiry"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchdbageddebtenquiry"));   
    DebtorsAuthoriseWorkflow.setDBAuthTransactionDebtorNumber(uniqueDebtorNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    searchTableColumn(orprop.getProperty("findinvoicetable"),uniqueDebtorNumber);
    searchTableColumn(orprop.getProperty("findinvoicetable"),fullName);
    verifyPayAdjAmount();
    verifyOutstandingAmount(DebtorPaymentsWorkflow.getDBAmount());
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }

}