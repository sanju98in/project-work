package financialWeb.testScripts;

import java.io.FileNotFoundException;
import org.testng.annotations.Test;
import financialWeb.workflow.CRReportsWorkflow;
import financialWeb.workflow.DBReportsWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;

public class CRReports76678 extends CRReportsWorkflow {


  @Test(groups = {"smoke"})
   public void amendCRReportStyle() throws FileNotFoundException, InterruptedException {

    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    // Create CR Report Style
    reportStyleName = createNewCRReprtStyle();
    // Amend CR Report Style
    searchText(testdataprop.getProperty("searchcrreporting"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchcrreporting"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchcrstylemaintenance"));
    // Select CR Report Master from drop-down
    DBReportsWorkflow.setDrpdnReportMaster(msgprop.getProperty("lblreportmaster"),testdataprop.getProperty("payments"));
    // Select CR Report Style from drop-down
    DBReportsWorkflow.setDrpdnReportStyle(reportStyleName);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    // This method is used to Select Email When Finish checkbox
    DBReportsWorkflow.selectEmailwhenFinishedchkbx(testdataprop.getProperty("dbstyleemailwhenfinished"));
    // This method is used to  Select Email as Attachment checkbox
    DBReportsWorkflow.selectEmailasAttachmentchkbx(testdataprop.getProperty("dbstyleemailasattachment"));
    // This method is used to  Enter CR Style maintenance comments 
    DBReportsWorkflow.setDBStyleMaintComments(testdataprop.getProperty("dbstylemaintenancecomments"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
