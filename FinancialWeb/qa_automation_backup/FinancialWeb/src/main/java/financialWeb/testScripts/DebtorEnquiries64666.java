package financialWeb.testScripts;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorChargeCodeMaintenanceWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsEnquiriesWorkflow;

public class DebtorEnquiries64666 extends DebtorsEnquiriesWorkflow{
  
  @Test(groups = {"smoke"})
  public void  searchDebtorsViaDBFindDebtors () throws Exception {
            
    uniqueDebtorNumber=DebtorMaintenanceWorkflow.createDebtor();     
    searchText(testdataprop.getProperty("searchdbenquiry"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbenquiry"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchdbfinddebtors"));
    DebtorChargeCodeMaintenanceWorkflow.setDBfindChargeCode(uniqueDebtorNumber);
    setTxtPostCode(testdataprop.getProperty("postcode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    String[] dataSet = {fullName,uniqueDebtorNumber,testdataprop.getProperty("postcode"),msgprop.getProperty("authorise")};
    DebtorMaintenanceWorkflow.reviewDetails(orprop.getProperty("finddebtorstable"),dataSet);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("clear"));
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }

}