package financialWeb.testScripts;

import java.io.FileNotFoundException;
import org.testng.annotations.Test;
import financialWeb.workflow.DBReportsWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;

public class DBReports76688 extends DBReportsWorkflow {


  @Test(groups = {"smoke"})
  public void deleteDBReportStyle() throws FileNotFoundException, InterruptedException {

    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    // creating DB Report Style
    reportStyleName = createNewDBReprtStyle();

    // Search and Select DB Report Style
    searchText(testdataprop.getProperty("searchdbreporting"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbreporting"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchdbstylemaintenance"));

    // Delete DB style report
    deleteDBStyleReport(msgprop.getProperty("lblreportmaster"),testdataprop.getProperty("debtorlist"), reportStyleName,
        testdataprop.getProperty("deletewarnmsg"));

    // Click on Home link
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
