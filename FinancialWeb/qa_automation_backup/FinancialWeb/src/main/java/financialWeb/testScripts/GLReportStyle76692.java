package financialWeb.testScripts;

import java.io.FileNotFoundException;
import org.testng.annotations.Test;
import financialWeb.workflow.DBReportsWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import financialWeb.workflow.GLReportsWorkflow;

public class GLReportStyle76692 extends GLReportsWorkflow {


  @Test(groups = {"smoke"})
  public void deleteGLReportStyle() throws FileNotFoundException, InterruptedException {


    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    // Create GL Report Style
    reportStyleName = createNewGLReprtStyle();
    
    // Search and Select GL Report Style
    searchText(testdataprop.getProperty("searchglreporting"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchglreporting"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchglstylemaintenance"));

    // Delete GR style report
    DBReportsWorkflow.deleteDBStyleReport(msgprop.getProperty("lblreportmaster"),testdataprop.getProperty("detailcode"),
        reportStyleName, testdataprop.getProperty("deletewarnmsg"));

    // Click on Home link
    clickHrefLink(testdataprop.getProperty("home"));
    // SignOut
    clickSignOut();
  }
}
