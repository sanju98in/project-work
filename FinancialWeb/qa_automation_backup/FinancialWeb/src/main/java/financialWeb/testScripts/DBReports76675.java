package financialWeb.testScripts;

import java.io.FileNotFoundException;
import org.testng.annotations.Test;
import financialWeb.workflow.CRReportsWorkflow;
import financialWeb.workflow.DBReportsWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;

public class DBReports76675 extends DBReportsWorkflow {


  @Test(groups = {"smoke"})
  public void createDBReportStyle() throws FileNotFoundException, InterruptedException {

    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
   //Create DB Report Style
    searchText(testdataprop.getProperty("searchdbreporting"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbreporting"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchdbstylemaintenance"));
    // Select DB Report Master from drop-down
    setDrpdnReportMaster(msgprop.getProperty("lblreportmaster"),testdataprop.getProperty("debtorlist"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addnew"));
    // This method is using to enter random name in DB name textbox
    setDBStyleName(msgprop.getProperty("lblname"),getRandomAlphaNumericValue(testdataprop.getProperty("rndvalue")));
    // This method is using to enter random description in DB description textbox
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
    // This method is used to select account number checkbook
    selectDBStyleFildNmeChkBox(testdataprop.getProperty("dbstyleaccountnumber"));
    // This method is used to select user edit checkbox
    //selectUserEditableCheckBox();
    CRReportsWorkflow.selectUserEditableCheckBox(testdataprop.getProperty("dbstyleaccountnumber"),orprop.getProperty("dbusereditable"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    // This method is used to click DB details tab
    clickDBStylDetails();
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();
  }
}
