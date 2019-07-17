package financialWeb.testScripts;

import java.io.FileNotFoundException;
import org.testng.annotations.Test;
import financialWeb.workflow.DBReportsWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import financialWeb.workflow.GLReportsWorkflow;

public class GLReportStyle76680 extends GLReportsWorkflow {

  
  @Test(groups = {"smoke"})
  public void amendGLReportStyle() throws FileNotFoundException, InterruptedException {

   // objGLStyleMaintenanceWorkflow = new GLStyleMaintenanceWorkflow();
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    // creating GL Report Style
    reportStyleName = createNewGLReprtStyle();
    // Amend GL Report Style
    searchText(testdataprop.getProperty("searchglreporting"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchglreporting"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchglstylemaintenance"));
    // Select GL Style Report Master drop-down
    DBReportsWorkflow.setDrpdnReportMaster(msgprop.getProperty("lblreportmaster"),testdataprop.getProperty("detailcode"));
    // Select GL Style Report Style drop-down
    DBReportsWorkflow.setDrpdnReportStyle(reportStyleName);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    // This method is used to Select Email When Finish checkbox
    DBReportsWorkflow
        .selectEmailwhenFinishedchkbx(testdataprop.getProperty("dbstyleemailwhenfinished"));
    // This method is used to Select Email as Attachment checkbox
    DBReportsWorkflow
        .selectEmailasAttachmentchkbx(testdataprop.getProperty("dbstyleemailasattachment"));
    // This method is used to Enter DB Style maintenance comments
    DBReportsWorkflow.setDBStyleMaintComments(getRandomComment());
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
