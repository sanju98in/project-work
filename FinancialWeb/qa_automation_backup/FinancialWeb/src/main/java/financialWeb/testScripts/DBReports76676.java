package financialWeb.testScripts;

import java.io.FileNotFoundException;
import org.testng.annotations.Test;
import financialWeb.workflow.DBReportsWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;

public class DBReports76676 extends DBReportsWorkflow {


  @Test(groups = {"smoke"})
  public void amendDBReportStyle() throws FileNotFoundException, InterruptedException {

    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
   // Create DB Report Style
    reportStyleName=createNewDBReprtStyle();
    // Amend DB Report Style
    searchText(testdataprop.getProperty("searchdbreporting"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbreporting"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchdbstylemaintenance"));
    // Select DB Style Report Master drop-down
    setDrpdnReportMaster(msgprop.getProperty("lblreportmaster"),testdataprop.getProperty("debtorlist"));
    // Select DB Style Report Style drop-down
    setDrpdnReportStyle(reportStyleName);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    // This method is used to Select Email When Finish checkbox
    selectEmailwhenFinishedchkbx(testdataprop.getProperty("dbstyleemailwhenfinished"));
    // This method is used to Select Email as Attachment checkbox
    selectEmailasAttachmentchkbx(testdataprop.getProperty("dbstyleemailasattachment"));
    // This method is used to  Enter DB Style maintenance comments 
    setDBStyleMaintComments(testdataprop.getProperty("dbstylemaintenancecomments"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    clickHrefLink(testdataprop.getProperty("home"));
    
    //signOut
    clickSignOut();
  }
}
