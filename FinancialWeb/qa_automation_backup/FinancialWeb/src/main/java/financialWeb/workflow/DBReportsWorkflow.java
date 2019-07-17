package financialWeb.workflow;

import java.io.FileNotFoundException;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import financialWeb.pages.DBReports;

public class DBReportsWorkflow extends CommonWorkflow {


  public static void setDrpdnReportMaster(String label, String data)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    selectRandomWebElementDrpDwn(label, data);
      }

  public static void setDrpdnReportStyle(String data)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDBStyleMaintenance = new DBReports(driver);

    boolean found = IsExist(DBReports.drpdnDBStyleRprtStyle);
    if (found) {
      selectDropDown(DBReports.drpdnDBStyleRprtStyle, data);
    }
    waitforPanelLoad();
  }

  public static void deleteDBStyleReport(String dbReportLabel,String dbReportMaster, String reportStyleName,
      String errormesg) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDBStyleMaintenance = new DBReports(driver);

    // Select DB Report Master from drop-down
    setDrpdnReportMaster(dbReportLabel,dbReportMaster);

    // Select DB Report Style from drop-down
    setDrpdnReportStyle(reportStyleName);
    // Click on Load button
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    // Click on Delete button
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("delete"));
    // Verify the Delete warning message
    validateMessage(DBReports.lblDeleteWarnMsg, errormesg);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("delete"));
    // Select DB Style Report Master drop-down
    setDrpdnReportMaster(dbReportLabel,dbReportMaster);
    // Verify the Deleted Report Style Name in Drop-down.
    validateDrpDwnValue(reportStyleName);
    waitforPanelLoad();

  }

  public static void validateDrpDwnValue(String data)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDBStyleMaintenance = new DBReports(driver);

    boolean found = IsExist(DBReports.drpdnDBStyleRprtStyle);
    if (found) {
      verifyListSelection(DBReports.drpdnDBStyleRprtStyle, data);
    }

  }

  public static void setDrpdnReportFolder(String data)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDBStyleMaintenance = new DBReports(driver);

    boolean found = IsExist(DBReports.drpdnDBStyleRprtMstr);
    if (found) {
      selectDropDown(DBReports.drpdnDBStyleRprtMstr, data);
    }
    waitforPanelLoad();
  }

  public static void setDBStyleName(String label,String data)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    setRandomWebElementValue(label,data);

  }

  public static void setDBStyleDescription(String label, String data)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    setRandomWebElementValue(label,data);
  }

  public static void selectExportFileCheckBox() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    setRandomWebElementChkbx(msgprop.getProperty("lblexportfile"));
  }

  public static void clickDBStyleFields() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDBStyleMaintenance = new DBReports(driver);

    boolean found = IsExist(DBReports.btndrpdnDBStyleFields);
    if (found) {
      clickElement(DBReports.btndrpdnDBStyleFields);
    }
    waitforPanelLoad();
  }

  public static void clickDBStyleParameters() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDBStyleMaintenance = new DBReports(driver);

    boolean found = IsExist(DBReports.btnDBStyleParameters);
    if (found) {
      clickElement(DBReports.btnDBStyleParameters);
    }
    waitforPanelLoad();
  }

  public static void setDrpdnExportFrmt(String label,String data)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    selectRandomWebElementDrpDwn(label, data);
  }

  public static void selectEmailwhenFinishedchkbx(String data)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    selectDBStyleCheckbox(data, orprop.getProperty("dbstyledetailcheckbox"));

  }

  public static void selectEmailasAttachmentchkbx(String data)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    selectDBStyleCheckbox(data, orprop.getProperty("dbstyledetailcheckbox"));

  }

  public static void setDBStyleMaintComments(String data)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    setRandomWebElementValue(msgprop.getProperty("lblcomments"), data);
    /*
     * objDBStyleMaintenance = new DBReports(driver); boolean found =
     * IsExist(DBReports.txtDBStyleMaintComments); if (found) {
     * setText(DBReports.txtDBStyleMaintComments, data); } waitforPanelLoad();
     */
  }


  public static void setDBJobRequestValue(String data)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDBStyleMaintenance = new DBReports(driver);
    // waitforPanelLoad();
    boolean found = IsExist(DBReports.txtDBJobRequestCritVlue);
    if (found) {
      setText(DBReports.txtDBJobRequestCritVlue, data);
    }
    waitforPanelLoad();
  }

  public static void setDBReportViewerJobNo(String data)
      throws InterruptedException, FileNotFoundException {

    objDBStyleMaintenance = new DBReports(driver);
    waitforPanelElement(DBReports.txtDBReportViewerJobNo);
    boolean found = IsExist(DBReports.txtDBReportViewerJobNo);
    if (found) {
      setText(DBReports.txtDBReportViewerJobNo, data);
    }
    waitforPanelLoad();
  }

  public static void selectHyprlinkJobDetails(String data)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDBStyleMaintenance = new DBReports(driver);
    boolean found = IsExist(getRandomElement(data));
    if (found) {
      click(getRandomElement(data));
    }
    waitforPanelLoad();
  }

  public static void verifyJobDetailsTable(String data, String orstringprop)
      throws FileNotFoundException, InterruptedException {
    waitForPageLoad();
    List<WebElement> jobdetails = driver.findElements(By.xpath(orstringprop));
    for (WebElement jobgridtable : jobdetails) {
      searchTableColumn(jobgridtable, data);
    }
  }


  public static String getJobNo(String btnName) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    String jobNo = null;
    try {
      callEvent(orprop.getProperty("button"), btnName);
    } catch (UnhandledAlertException f) {
      try {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String[] splitStr = alertText.split("\\s+");
        jobNo = splitStr[2];
        Thread.sleep(1000);
        alert.accept();

      } catch (NoAlertPresentException e) {
        e.printStackTrace();
      }
    }
    return jobNo;
  }

  public static void selectDBStyleFildNmeChkBox(String data)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    parentHandle = driver.getWindowHandle();
    objDBStyleMaintenance = new DBReports(driver);
    boolean found;
    selectDBStyleCheckbox(data, orprop.getProperty("dbstylefield"));
    getHandles();
    found = IsExist(DBReports.pnlDBStylePinnedItem);
    if (found) {
      found = IsExist(DBReports.btnDBStyleAddToReportCriteria);
      clickElement(DBReports.btnDBStyleAddToReportCriteria);
      found = false;
    }
    // waitforPanelLoad();
    switchToParentWindow(parentHandle);
    waitforPanelLoad();
  }


  public static WebElement getRandomElement(String labelName)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    WebElement testMe = null;
    String combinedString = orprop.getProperty("containspart1").trim() + labelName.trim()
        + orprop.getProperty("containspart2").trim();
    List<WebElement> findMes = driver.findElements(By.xpath(combinedString));
    for (WebElement findMe : findMes) {
      boolean found = IsExist(findMe);
      if (found) {
        testMe = findMe;
        break;
      }
    }
    waitforPanelLoad();
    return testMe;
  }

  public static WebElement getRandomElement(String labelName, String xpathPart)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    WebElement testMe = null;
    String combinedString = orprop.getProperty("containspart1").trim() + labelName.trim()
        + orprop.getProperty("containspart2").trim() + xpathPart.trim();
    List<WebElement> findMes = driver.findElements(By.xpath(combinedString));
    for (WebElement findMe : findMes) {
      boolean found = IsExist(findMe);
      if (found) {
        testMe = findMe;
        break;
      }
      waitforPanelLoad();
    }
    return testMe;
    // return findMe;
  }

  public static void selectDBStyleCheckbox(String data, String part3)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    String combinedString = orprop.getProperty("containspart1").trim() + data.trim()
        + orprop.getProperty("containspart2").trim() + part3;
    WebElement findMe = driver.findElement(By.xpath(combinedString));
    boolean found = IsExist(findMe);
    if (found) {
      checkCheckBox(findMe);
    }
    waitforPanelLoad();
  }

  /*public static void selectUserEditableCheckBox()
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDBStyleMaintenance = new DBReports(driver);
    selectDBStyleCheckbox(testdataprop.getProperty("dbstyleaccountnumber"),
        orprop.getProperty("dbusereditable"));
  }*/

  public static void clickDBStylDetails() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDBStyleMaintenance = new DBReports(driver);
    boolean found = IsExist(DBReports.btnDBStyleDetails);
    if (found) {
      clickElement(DBReports.btnDBStyleDetails);
    }
    waitforPanelLoad();
  }

  public static void closeTab(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDBStyleMaintenance = new DBReports(driver);
    String[] datalist = data.split("CR");
    for (String s : datalist) {
      log.info("string data:" + s);
    }
    String combinedString = orprop.getProperty("containspart1").trim() + data.trim()
        + orprop.getProperty("containspart2").trim() + orprop.getProperty("closetabicon");
    log.info(combinedString);
    boolean found = IsExist(driver.findElement(By.xpath(combinedString)));
    if (found) {
      clickElement(driver.findElement(By.xpath(combinedString)));
    }
    waitforPanelLoad();
  }

  public static String createNewDBReprtStyle() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDBStyleMaintenance = new DBReports(driver);
    searchText(testdataprop.getProperty("searchdbreporting"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbreporting"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchdbstylemaintenance"));
    // select report master drop-down
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblreportmaster"),
        testdataprop.getProperty("debtorlist"));
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
    clickDBStyleFields();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addfileds"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    selectDBStyleFildNmeChkBox(testdataprop.getProperty("dbstyleaccountnumber"));
    selectDBStyleCheckbox(testdataprop.getProperty("dbstyleaccountnumber"),
        orprop.getProperty("dbusereditable"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    clickDBStylDetails();
    waitforPanelLoad();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    String dbReportStyle = getRandomWebElementValue(msgprop.getProperty("lblname"));
    clickHrefLink(testdataprop.getProperty("home"));
    waitforPanelLoad();
    return dbReportStyle;

  }

  public static String validateReportStyleName()
      throws FileNotFoundException, InterruptedException {
    objDBStyleMaintenance = new DBReports(driver);
    return DBReports.getTxtReportStyleName();
  }

  public static String createReportJobNumber(String styleReport, String jobRequestcode)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    // Search and Select DB Report Style
    searchText(testdataprop.getProperty("searchdbreporting"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbreporting"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchdbjobrequest"));
    // Select Debtor List
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblreportmaster"),
        testdataprop.getProperty("debtorlist"));
    // Select DB Report Style from drop-down
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblreporstyle"), styleReport);
    // Click on Load button
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    // Click on Add Criteria button
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addcriteria"));
    // Click on submit button
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    // Select Account_Number
    selectDBStyleFildNmeChkBox(testdataprop.getProperty("dbstyleaccountnumber"));
    // Enter DB Job Request value
    setDBJobRequestValue(jobRequestcode);
    // Click on RunJob button and get JobNumber
    dbJobNumber = getJobNo(testdataprop.getProperty("runjob"));
    waitforPanelLoad();
    return dbJobNumber;

  }

  public static void verifyJobNo(String jobRequestcode, String jobNo)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    // Search and Select DB Report Viewer
    searchText(testdataprop.getProperty("searchdbreportviewer"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbreportviewer"));
    // Enter Job number
    setDBReportViewerJobNo(jobNo);
    // Click on submit button
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    // Click on Job No hyperlink
    selectHyprlinkJobDetails(jobNo);
    // Verify the Account_Number and Unique Number
    verifyJobDetailsTable(testdataprop.getProperty("dbstyleaccountnumber"),
        orprop.getProperty("gridjobdetailstable"));
    verifyJobDetailsTable(jobRequestcode, orprop.getProperty("gridjobdetailstable"));
    CreditorVouchersWorkflow.closePopup();
  }
}

// end of class
