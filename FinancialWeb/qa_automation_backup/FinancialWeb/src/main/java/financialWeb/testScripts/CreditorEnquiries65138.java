package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorEnquiriesWorkflow;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.DebtorChargeCodeMaintenanceWorkflow;

public class CreditorEnquiries65138 extends CreditorEnquiriesWorkflow{
  
  @Test(groups = {"smoke"})
  public void  creditorDetailsEnquiry() throws InterruptedException, ParseException, IOException, URISyntaxException {
            
    uniqueMaintenanceNumber=CreditorMaintenanceWorkflow.createCreditor();    
    
    searchText(testdataprop.getProperty("searchccractmaint"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchccractmaint"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchccrcreditormaint"));
    CreditorMaintenanceWorkflow.setCrNumber(uniqueMaintenanceNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    CreditorMaintenanceWorkflow.setAccountNumber(testdataprop.getProperty("bankaccountnumber"));
    CreditorMaintenanceWorkflow.setAccountSortCode(testdataprop.getProperty("bankaccountcode"));
    setTypeOfBankAccount(testdataprop.getProperty("qtyforpim"));
    CreditorMaintenanceWorkflow.setAccountName(testdataprop.getProperty("bankaccountname"));
    setBankRefNumber(testdataprop.getProperty("bankrefrencenumber"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    //clickOkBtnPopup();
    DebtorChargeCodeMaintenanceWorkflow.validateChargeCodeTextPopup();
   // callEvent(orprop.getProperty("button"),testdataprop.getProperty("ok"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    CreditorMaintenanceWorkflow.validatetxtCreditorMaintenanceStatus(msgprop.getProperty("changedandreadyforsupervisor"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("authorise"));
    CreditorMaintenanceWorkflow.validatetxtCreditorMaintenanceStatus(msgprop.getProperty("authorise"));
    searchText(testdataprop.getProperty("searchcrdetailsenquiry"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchcrdetailsenquiry"));
    setCrNumber(uniqueMaintenanceNumber);
    submitDetails();
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),uniqueMaintenanceNumber);
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),testdataprop.getProperty("name"));
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),msgprop.getProperty("authorise"));
    clickBankDetailsTab();
    searchTableColumn(orprop.getProperty("crenquirybankdetailstable"),testdataprop.getProperty("bankaccountnumber"));
    searchTableColumn(orprop.getProperty("crenquirybankdetailstable"),testdataprop.getProperty("bankaccountcode"));
    searchTableColumn(orprop.getProperty("crenquirybankdetailstable"),testdataprop.getProperty("bankaccountname"));
    searchTableColumn(orprop.getProperty("crenquirybankdetailstable"),testdataprop.getProperty("bankrefrencenumber"));
    clickHrefLink(testdataprop.getProperty("home"));
    
    //signOut
    clickSignOut();   
  }

}