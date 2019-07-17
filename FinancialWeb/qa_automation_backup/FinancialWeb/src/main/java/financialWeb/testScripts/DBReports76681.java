package financialWeb.testScripts;

import java.io.FileNotFoundException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorVouchersWorkflow;
import financialWeb.workflow.DBReportsWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;

public class DBReports76681 extends DBReportsWorkflow {


  @Test(groups = {"smoke"})
  public void verifyTheDBJobDetails() throws FileNotFoundException, InterruptedException {

    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();

    // Create Debtor
    uniqueDebtorNumber = DebtorMaintenanceWorkflow.createDebtor();

    // Create DB Report Style
    reportStyleName = createNewDBReprtStyle();
    
    // Search and Select DB Report Style
    searchText(testdataprop.getProperty("searchdbreporting"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbreporting"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchdbjobrequest"));

    // Select Debtor List
    setDrpdnReportMaster(msgprop.getProperty("lblreportmaster"),testdataprop.getProperty("debtorlist"));

    // Select DB Report Style from drop-down
    setDrpdnReportStyle(reportStyleName);


    // Click on Load button
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));

    // Click on Add Criteria button
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addcriteria"));

    // Click on submit button
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));

    waitforPanelLoad();
    // Select Account_Number
    selectDBStyleFildNmeChkBox(testdataprop.getProperty("dbstyleaccountnumber"));

    // Enter DB Job Request value
    setDBJobRequestValue(uniqueDebtorNumber);


    // Click on RunJob button and get JobNumber
    dbJobNumber = getJobNo(testdataprop.getProperty("runjob"));

    // Search and Select DB Report Viewer
    searchText(testdataprop.getProperty("searchdbreportviewer"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbreportviewer"));


    // Enter Job number
    setDBReportViewerJobNo(dbJobNumber);

    // Click on submit button
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));

    // Click on Job No hyperlink
    selectHyprlinkJobDetails(dbJobNumber);
    

    // Verify the Account_Number and Unique Number
    verifyJobDetailsTable(testdataprop.getProperty("dbstyleaccountnumber"),orprop.getProperty("gridjobdetailstable"));
    verifyJobDetailsTable(uniqueDebtorNumber,orprop.getProperty("gridjobdetailstable"));

    CreditorVouchersWorkflow.closePopup();
    
    // Click on Home link
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
