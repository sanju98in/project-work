package financialWeb.testScripts;

import java.io.FileNotFoundException;
import org.testng.annotations.Test;
import financialWeb.workflow.CRReportsWorkflow;
import financialWeb.workflow.DBReportsWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;

public class CRReports76677 extends DBReportsWorkflow {


  @Test(groups = {"smoke"})
  public void createCRReportStyle() throws FileNotFoundException, InterruptedException {

    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    // Create CR Report Style
    searchText(testdataprop.getProperty("searchcrreporting"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchcrreporting"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchcrstylemaintenance"));
    // Select CR Report Master from drop-down
    setDrpdnReportMaster(msgprop.getProperty("lblreportmaster"),testdataprop.getProperty("payments"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addnew"));
    // This method is using to enter random name in CR name textbox
    setDBStyleName(msgprop.getProperty("lblname"),getRandomAlphaNumericValue(testdataprop.getProperty("rndvalue")));
    // This method is using to enter random description in CR description textbox
    setDBStyleDescription(msgprop.getProperty("lbldescription"),getRandomAlphaNumericValue(testdataprop.getProperty("rndvalue")));
    // This method is used to Select Export File Checkbox
    selectExportFileCheckBox();
    // This method is used to Select Export Format drop-down
    setDrpdnExportFrmt(msgprop.getProperty("lblexportformat"),testdataprop.getProperty("pdf"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    // This method is used to click on Fields tab
    clickDBStyleFields();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addfileds"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("continue"));
    // This method is used to select credit_number checkbook
    selectDBStyleFildNmeChkBox(testdataprop.getProperty("crstylecreditornumber"));
    // This method is used to select user edit checkbox
    CRReportsWorkflow.selectUserEditableCheckBox(testdataprop.getProperty("crstylecreditornumber"),orprop.getProperty("dbusereditable"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    // This method is used to click CR details tab
    clickDBStylDetails();

    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }

}
