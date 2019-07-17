package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorPaymentsWorkflow;
import financialWeb.workflow.DebtorsAuthoriseWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;

public class DebtorPayments64155 extends DebtorPaymentsWorkflow{
  
  @Test(groups = {"smoke"})
  public void  createUnallocatedManualPaymentWithAuthorisation() throws InterruptedException, ParseException, IOException, URISyntaxException {
            
    uniqueMaintenanceNumber= DebtorMaintenanceWorkflow.createDebtor();
    createUnallocatedManualPayment(
        uniqueMaintenanceNumber,
        testdataprop.getProperty("authorisedpaymenttranscode"),
        msgprop.getProperty("referenceone"),
        msgprop.getProperty("referencetwo"),
        msgprop.getProperty("updatedreferenceone"),
        msgprop.getProperty("updatedreferencetwo"),
        testdataprop.getProperty("amount"),
        testdataprop.getProperty("cashpaymentmethod"),
        testdataprop.getProperty("comment"),
        msgprop.getProperty("readyforsupervisor")
        );    
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save")); 
    searchText(testdataprop.getProperty("searchdbauthorise"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbauthorise"));    
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchdbauthorisetrans"));
    DebtorsAuthoriseWorkflow.setDBAuthTransactionDebtorNumber(uniqueMaintenanceNumber);
    DebtorsAuthoriseWorkflow.setDBAuthTransactionReferenceOne(paymentNo);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    DebtorsAuthoriseWorkflow.selectAuthorize();
    DebtorsVouchersWorkflow.clickAuthorise();
    searchText(testdataprop.getProperty("searchdbpayments"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbpayments"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchdbmanualpayments"));
    setPaymentReferenceOne(paymentNo);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    validateStatus(msgprop.getProperty("authorisedformatchingstatus"));
    clickHrefLink(testdataprop.getProperty("home"));
    
    //signOut
    clickSignOut();   
  }
}