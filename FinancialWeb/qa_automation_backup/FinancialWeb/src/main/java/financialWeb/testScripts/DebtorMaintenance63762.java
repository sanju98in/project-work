package financialWeb.testScripts;
import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;

public class DebtorMaintenance63762 extends DebtorMaintenanceWorkflow{

  @Test(groups = {"smoke"})
  public void createDebtorViaDBDebtorMaintenanceForm() throws InterruptedException, ParseException, IOException {
        
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    searchText(testdataprop.getProperty("dbaccountmaintenance"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("dbaccountmaintenance"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("dbdebtormaintenance"));    
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load")); 
    setTitle(testdataprop.getProperty("title"));
    setFirstName(testdataprop.getProperty("firstname"));
    
    // lastname and addressLine1 have same locator
    setLastName(testdataprop.getProperty("lastname"));
    setLocationForDebtor(testdataprop.getProperty("location"));
    setTypeOfDebtor(testdataprop.getProperty("typeofdebtor"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    searchAndValidate(testdataprop.getProperty("dbdebtormaintenanceheadertabs"));
    searchAndClickLatestRecordInTable(orprop.getProperty("addresstable"),testdataprop.getProperty("address"));
    CreditorMaintenanceWorkflow.editAddress();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("manualaddress"));
    updateAddressDetailsForDebtorMaintenance(
        testdataprop.getProperty("updatedefaultadd"),
        testdataprop.getProperty("addressline2"),
        testdataprop.getProperty("addressline3"),
        testdataprop.getProperty("addressline4"),
        testdataprop.getProperty("country"),
        testdataprop.getProperty("postcode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    CreditorMaintenanceWorkflow.validateTableData(orprop.getProperty("tableaddress"),addressOne);
    CreditorMaintenanceWorkflow.validateTableData(orprop.getProperty("tableaddress"),postCode);    
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("authorise"));
    //validate and store debtor number
    uniqueMaintenanceNumber = CreditorMaintenanceWorkflow.storeuniqueMaintenanceNumber();   
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();    
  }
}