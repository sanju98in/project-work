package financialWeb.testScripts;

import java.io.FileNotFoundException;
import org.testng.annotations.Test;
import financialWeb.workflow.DBReportsWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import financialWeb.workflow.GLReportsWorkflow;

public class GLReportStyle76679 extends GLReportsWorkflow {


  @Test(groups = {"smoke"})
  public void createGLReportStyle() throws FileNotFoundException, InterruptedException {

    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();


    // creating GL Report Style
    searchText(testdataprop.getProperty("searchglreporting"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchglreporting"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchglstylemaintenance"));
    // select report master drop-down
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblreportmaster"),
        testdataprop.getProperty("detailcode"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addnew"));
    // this method is using to enter random name in GL name textbox
    setRandomWebElementValue(msgprop.getProperty("lblname"),
        getRandomAlphaNumericValue(testdataprop.getProperty("rndvalue")));
    // this method is using to enter random description in GL description textbox
    setRandomWebElementValue(msgprop.getProperty("lbldescription"),
        getRandomAlphaNumericValue(testdataprop.getProperty("rndvalue")));
    // Select Export File checkbox
    setRandomWebElementChkbx(msgprop.getProperty("lblexportfile"));
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblexportformat"),
        testdataprop.getProperty("pdf"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    DBReportsWorkflow.clickDBStyleFields();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addfileds"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    // this method is using to check credit_number checkbook
    DBReportsWorkflow.selectDBStyleFildNmeChkBox(testdataprop.getProperty("glstyledetailname"));
    selectGLStyleParmterChkBox(testdataprop.getProperty("glstyledetailname"),
        orprop.getProperty("dbusereditable"));
    DBReportsWorkflow.clickDBStyleParameters();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addparameters"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    // this method is using to click GL details tab
    selectGLStyleParmterChkBox(testdataprop.getProperty("glstylereportatlevel"),
        orprop.getProperty("glparameternamechkbx"));
    setGLParameterValue(getRandomNumber(testdataprop.getProperty("rndnumber")));
    DBReportsWorkflow.clickDBStylDetails();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    waitforPanelLoad();
    clickHrefLink(testdataprop.getProperty("home"));


  }
}
