package financialWeb.workflow;

import java.io.FileNotFoundException;
import financialWeb.pages.DBReports;

public class CRReportsWorkflow extends CommonWorkflow {



  public static String createNewCRReprtStyle() throws FileNotFoundException, InterruptedException {
   
    waitforPanelLoad();
    // Create DB Report Style
    searchText(testdataprop.getProperty("searchcrreporting"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchcrreporting"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchcrstylemaintenance"));
    
    
    // select report master drop-down
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblreportmaster"),
        testdataprop.getProperty("payments"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addnew"));
    // this method is using to enter random name in DB name textbox
    setRandomWebElementValue(msgprop.getProperty("lblname"),
        getRandomAlphaNumericValue(testdataprop.getProperty("rndvalue")));
    // this method is using to enter random description in DB description textbox
    setRandomWebElementValue(msgprop.getProperty("lbldescription"),
        getRandomAlphaNumericValue(testdataprop.getProperty("rndvalue")));
    setRandomWebElementChkbx(msgprop.getProperty("lblexportfile"));
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblexportformat"),
        testdataprop.getProperty("pdf"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    DBReportsWorkflow.clickDBStyleFields();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addfileds"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("continue")); 
    DBReportsWorkflow.selectDBStyleFildNmeChkBox(testdataprop.getProperty("crstylecreditornumber" ));
    selectUserEditableCheckBox(testdataprop.getProperty("crstylecreditornumber"),
        orprop.getProperty("dbusereditable"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    DBReportsWorkflow.clickDBStylDetails();
    waitforPanelLoad();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
     String dbReportStyle = getRandomWebElementValue(msgprop.getProperty("lblname"));
    clickHrefLink(testdataprop.getProperty("home"));
    waitforPanelLoad();
    return dbReportStyle;
  
  }
  public static void selectUserEditableCheckBox(String label,String data)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDBStyleMaintenance = new DBReports(driver);
    DBReportsWorkflow.selectDBStyleCheckbox(label,data);
        //testdataprop.getProperty("crstylecreditornumber"),
        //orprop.getProperty("dbusereditable"));
  }
  public static String validateReportStyleName()
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDBStyleMaintenance = new DBReports(driver);
    return DBReports.getTxtReportStyleName();
  }

  public static String createReportJobNumber(String styleReport, String creditorNo)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    // Search and Select DB Report Style
    searchText(testdataprop.getProperty("searchcrreporting"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchcrreporting"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchcrjobrequest"));
    // Select Debtor List
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblreportmaster"),
        testdataprop.getProperty("payments"));
    // Select DB Report Style from drop-down
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblreporstyle"), styleReport);
    // Click on Load button
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    // Click on Add Criteria button
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addcriteria"));
    // Click on submit button
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    // Select Account_Number
    DBReportsWorkflow.selectDBStyleFildNmeChkBox(testdataprop.getProperty("crstylecreditornumber"));
    // Enter DB Job Request value
    DBReportsWorkflow.setDBJobRequestValue(creditorNo);
    // Click on RunJob button and get JobNumber
    String dbJobNumber = DBReportsWorkflow.getJobNo(testdataprop.getProperty("runjob"));
    return dbJobNumber;

  }

  public static void verifyJobNo(String creditorNo, String jobNo)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    // Search and Select DB Report Viewer
    searchText(testdataprop.getProperty("searchcrreportviewer"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchcrreportviewer"));
    // Enter Job number
    DBReportsWorkflow.setDBReportViewerJobNo(jobNo);
    // Click on submit button
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    // Click on Job No hyperlink
    DBReportsWorkflow.selectHyprlinkJobDetails(jobNo);
    // Verify the Account_Number and Unique Number
    DBReportsWorkflow.verifyJobDetailsTable(testdataprop.getProperty("crstylecreditornumber"),
        orprop.getProperty("gridjobdetailstable"));
    DBReportsWorkflow.verifyJobDetailsTable(creditorNo,
        orprop.getProperty("gridjobdetailstable"));
    CreditorVouchersWorkflow.closePopup();
  }

}

// end of class
