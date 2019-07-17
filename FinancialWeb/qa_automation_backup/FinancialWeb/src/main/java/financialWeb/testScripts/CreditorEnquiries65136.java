package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorEnquiriesWorkflow;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.CreditorPaymentsWorkflow;
import financialWeb.workflow.DebtorsAuthoriseWorkflow;

public class CreditorEnquiries65136 extends CreditorEnquiriesWorkflow{
  
  @Test(groups = {"smoke"})
  public void  transactionEnquiry() throws InterruptedException, ParseException, IOException, URISyntaxException {
            
    uniqueMaintenanceNumber=CreditorMaintenanceWorkflow.createCreditor();    
    voucherNumber = CreditorPaymentsWorkflow.createCRInvoice(testdataprop.getProperty("sundryinvoicetranscode"),
        uniqueMaintenanceNumber,
        testdataprop.getProperty("amount"),
        testdataprop.getProperty("vatamount"),
        testdataprop.getProperty("glcode"),
        testdataprop.getProperty("comment"),
        testdataprop.getProperty("amount"),
        testdataprop.getProperty("vtcode"));
    
    payCRInvoice(testdataprop.getProperty("crmanualpaymenttranscode"),
        testdataprop.getProperty("crmanualpaymentbankaccount"),
        uniqueCreditorNumber,
        testdataprop.getProperty("vatamount"),
        testdataprop.getProperty("amount"),
        voucherNumber);   
    searchText(testdataprop.getProperty("searchcrtransactionenquiry"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchcrtransactionenquiry"));
    DebtorsAuthoriseWorkflow.setDBAuthTransactionDebtorNumber(uniqueMaintenanceNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    searchTableColumn(orprop.getProperty("findinvoicetable"),testdataprop.getProperty("invoice"));
    searchTableColumn(orprop.getProperty("findinvoicetable"),msgprop.getProperty("fullypaid"));
    searchTableColumn(orprop.getProperty("findinvoicetable"),testdataprop.getProperty("transactiontypepayment"));
    searchTableColumn(orprop.getProperty("findinvoicetable"),msgprop.getProperty("allocated"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("clear"));    
    clickHrefLink(testdataprop.getProperty("home"));
    
    //signOut
    clickSignOut();   
  }

}