package financialWeb.testScripts;
import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;

public class DebtorMaintenance63763 extends DebtorMaintenanceWorkflow{
  @Test(groups = {"smoke"})
  public void createDebtorViaDBInsertDebtorForm() throws InterruptedException, ParseException, IOException {
        
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    searchText(testdataprop.getProperty("dbaccountmaintenance"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("dbaccountmaintenance"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("dbinsertdebtor"));    
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load")); 
    setTitleForDbInsertDebtor(testdataprop.getProperty("title"));
    setFirstNameForDbInsertDebtor(testdataprop.getProperty("firstname"));
    
    // Title, lastname and addressLine1 have same locator
    
    setTitle(testdataprop.getProperty("lastname"));
    setLocationForDbInsertDebtor(testdataprop.getProperty("locationfordbinsertdebtor"));
    setTypeOfDebtorForDbInsertDebtor(testdataprop.getProperty("typeofdebtorfordbinsertdebtor")); 
    setAddressCode(testdataprop.getProperty("addresscodefordbinsertdebtor"));
    
    insertAddressForDebtor();
    
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("manualaddress"));   
    setNameAtAddress(testdataprop.getProperty("firstname"));
    setAddressLine1ForDbInsertDebtor(testdataprop.getProperty("updatedefaultadd"));
    setAddressLine2ForDbInsertDebtor(testdataprop.getProperty("addressline2"));
    setAddressLine3ForDbInsertDebtor(testdataprop.getProperty("addressline3"));
    setAddressLine4ForDbInsertDebtor(testdataprop.getProperty("addressline4"));
    setCountryForDbInsertDebtor(testdataprop.getProperty("country"));
    setPostCodeForDbInsertDebtor(testdataprop.getProperty("postcode"));
    setTelephoneNumber(testdataprop.getProperty("telephonenumber"));
    setEmailForDebtor(testdataprop.getProperty("emailaddress"));
    setWebsiteForDebtor(testdataprop.getProperty("website"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    validateDebtorStatus(testdataprop.getProperty("defaultcreditorstatus"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("updatemode"));   
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("authorise"));
    uniqueMaintenanceNumber = storeUniqueDebtorMaintenanceNumber();
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();    
  }
}
