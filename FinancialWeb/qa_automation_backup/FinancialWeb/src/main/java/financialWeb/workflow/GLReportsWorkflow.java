package financialWeb.workflow;

import java.io.FileNotFoundException;
import org.openqa.selenium.WebElement;
import financialWeb.pages.DBReports;

public class GLReportsWorkflow extends CommonWorkflow {



  public static void selectGLStyleParmterChkBox(String data, String value)
      throws FileNotFoundException, InterruptedException {
    parentHandle = driver.getWindowHandle();
    objDBStyleMaintenance = new DBReports(driver);
    boolean found;
    DBReportsWorkflow.selectDBStyleCheckbox(data, value);
    getHandles();
    found = IsExist(DBReports.pnlDBStylePinnedItem);
    if (found) {
      found = IsExist(DBReports.btnDBStyleAddToReportCriteria);
      clickElement(DBReports.btnDBStyleAddToReportCriteria);
      found = false;
    }
    waitforPanelLoad();
    switchToParentWindow(parentHandle);
  }

  public static String createNewGLReprtStyle() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
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
    String dbReportStyle = getRandomWebElementValue(msgprop.getProperty("lblname"));
    waitforPanelLoad();
    clickHrefLink(testdataprop.getProperty("home"));
    return dbReportStyle;
  }

  public static void setGLParameterValue(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDBStyleMaintenance = new DBReports(driver);
   
   WebElement txtGLStyleParamtrValue= DBReportsWorkflow.getRandomElement(testdataprop.getProperty("glstylereportatlevel"), orprop.getProperty("parametervalue"));
    boolean found = IsExist(txtGLStyleParamtrValue);
    if (found) {
      setText(txtGLStyleParamtrValue, data);
    }
  }

  public static String createGLJobNumber(String styleReport, String analysisCode)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    // Search and Select DB Report Style
    searchText(testdataprop.getProperty("searchglreporting"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchglreporting"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchgljobrequest"));
    // Select Debtor List
    DBReportsWorkflow.setDrpdnReportMaster(msgprop.getProperty("lblreportmaster"),testdataprop.getProperty("detailcode"));
    // Select DB Report Style from drop-down
    DBReportsWorkflow.setDrpdnReportStyle(styleReport);
    // Click on Load button
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    // Click on Add Criteria button
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addcriteria"));
    // Click on submit button
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    // Select Account_Number
    DBReportsWorkflow.selectDBStyleFildNmeChkBox(testdataprop.getProperty("glstyledetailname"));
    // Enter DB Job Request value
    DBReportsWorkflow.setDBJobRequestValue(analysisCode);
    // Click on RunJob button and get JobNumber
    String dbJobNumber = DBReportsWorkflow.getJobNo(testdataprop.getProperty("runjob"));
    waitforPanelLoad();
    return dbJobNumber;
  }

  public static void verifyJobNumber(String dbJobNumber, String analysisCode)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    // Search and Select DB Report Viewer
    searchText(testdataprop.getProperty("searchglreportviewer"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchglreportviewer"));
    waitforPanelLoad();
    // Enter Job number
    DBReportsWorkflow.setDBReportViewerJobNo(dbJobNumber);
    // Click on submit button
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    // Click on Job No hyperlink
    DBReportsWorkflow.selectHyprlinkJobDetails(dbJobNumber);
    // Verify the Account_Number and Unique Number
    DBReportsWorkflow.verifyJobDetailsTable(testdataprop.getProperty("glstyledetailname"),
        orprop.getProperty("gridjobdetailstable"));
    DBReportsWorkflow.verifyJobDetailsTable(analysisCode,orprop.getProperty("gridjobdetailstable"));
    CreditorVouchersWorkflow.closePopup();
    waitforPanelLoad();
  }

}

// end of class
