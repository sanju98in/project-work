package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsEnquiriesWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;

public class DebtorEnquiries64655 extends DebtorsEnquiriesWorkflow{
  
  @Test(groups = {"smoke"})
  public void  viewTheDebtorDetailsEnquiry() throws InterruptedException, ParseException, IOException, URISyntaxException {
      
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    uniqueDebtorNumber = DebtorMaintenanceWorkflow.createDebtor();
    
    searchText(testdataprop.getProperty("searchdbenquiry"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbenquiry"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchdbdetailsenquiries"));
    waitforPanelLoad();
    setDebtorEnquiriesDebtorNumber(uniqueDebtorNumber);
    submit();
    waitforPanelLoad();
    validateTableColumns(orprop.getProperty("tbldbcrnoteenquiry"), fullName);
    validateTableTagValue(orprop.getProperty("tableaddress"),(testdataprop.getProperty("updatedefaultadd") +", "+testdataprop.getProperty("addressline2")+", " +
        testdataprop.getProperty("addressline3")+", "+ testdataprop.getProperty("addressline4") +", " +
        testdataprop.getProperty("postcode") +", " + testdataprop.getProperty("country")));
   
    validateTableColumns(orprop.getProperty("tableaddress"), testdataprop.getProperty("postcode"));
    
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }
}