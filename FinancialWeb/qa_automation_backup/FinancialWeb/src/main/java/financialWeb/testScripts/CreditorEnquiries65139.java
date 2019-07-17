package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorEnquiriesWorkflow;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.CreditorPaymentsWorkflow;
import financialWeb.workflow.DebtorsAuthoriseWorkflow;

public class CreditorEnquiries65139 extends CreditorEnquiriesWorkflow{
  
  @Test(groups = {"smoke"})
  public void  invoiceByDepartment() throws InterruptedException, ParseException, IOException, URISyntaxException {
            
    uniqueMaintenanceNumber=CreditorMaintenanceWorkflow.createCreditor();    
    CreditorPaymentsWorkflow.createCRInvoice(testdataprop.getProperty("sundryinvoicetranscode"),
        uniqueMaintenanceNumber,
        testdataprop.getProperty("amount"),
        testdataprop.getProperty("vatamount"),
        testdataprop.getProperty("glcode"),
        testdataprop.getProperty("comment"),
        testdataprop.getProperty("amount"),
        testdataprop.getProperty("vtcode"));
    searchText(testdataprop.getProperty("searchcrinvoicebydept"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchcrinvoicebydept"));
    DebtorsAuthoriseWorkflow.setDBAuthTransactionDebtorNumber(uniqueMaintenanceNumber);
    setDrpdnDepartment(testdataprop.getProperty("crinvpicedeptenquiry"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    searchTableColumn(orprop.getProperty("findinvoicetable"),uniqueMaintenanceNumber);
    searchTableColumn(orprop.getProperty("findinvoicetable"),testdataprop.getProperty("name"));
    searchTableColumn(orprop.getProperty("findinvoicetable"),testdataprop.getProperty("departmentandsection"));
    verifyGrossAmt();     
    clickHrefLink(testdataprop.getProperty("home"));
    
    //signOut
    clickSignOut();   
  }

}