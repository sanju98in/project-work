package financialWeb.testScripts;

import java.io.FileNotFoundException;
import org.testng.annotations.Test;
import financialWeb.workflow.CRReportsWorkflow;
import financialWeb.workflow.DBReportsWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;

public class CRReports76690 extends CRReportsWorkflow {


  @Test(groups = {"smoke"})
  public void deleteCRReportStyle() throws FileNotFoundException, InterruptedException {

    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    // Creating CR Report Style
    reportStyleName = createNewCRReprtStyle();
    
    // Search and Select CR Report Style
    searchText(testdataprop.getProperty("searchcrreporting"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchcrreporting"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchcrstylemaintenance"));

    // Delete CR style report
    DBReportsWorkflow.deleteDBStyleReport(msgprop.getProperty("lblreportmaster"),testdataprop.getProperty("payments"),
        reportStyleName, testdataprop.getProperty("deletewarnmsg"));

    // Click on Home link
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
