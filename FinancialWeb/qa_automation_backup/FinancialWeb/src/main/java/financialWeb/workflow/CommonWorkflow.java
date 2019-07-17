package financialWeb.workflow;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import financialWeb.pages.CommonPage;
import financialWeb.pages.CreditorEnquiries;
import financialWeb.pages.CreditorMaintenance;
import financialWeb.pages.CreditorNotes;
import financialWeb.pages.CreditorPayments;
import financialWeb.pages.CreditorVouchers;
import financialWeb.pages.DBReports;
import financialWeb.pages.DebtorAdjustments;
import financialWeb.pages.DebtorChargeCodeMaintenance;
import financialWeb.pages.DebtorEnquiries;
import financialWeb.pages.DebtorMaintenance;
import financialWeb.pages.DebtorPayments;
import financialWeb.pages.DebtorVouchersSalesInvoices;
import financialWeb.pages.DebtorsAuthorise;
import financialWeb.pages.DebtorsCreditNotes;
import financialWeb.pages.DebtorsNotes;
import financialWeb.pages.DebtorsVouchers;
import financialWeb.pages.FinancialWebHomepage;
import financialWeb.pages.FinancialWebLoginpage;
import financialWeb.pages.GLEnquiries;
import financialWeb.pages.GLJournals;
import financialWeb.pages.GLMaintenance;
import util.GenUtil;


public class CommonWorkflow extends CommonPage {

  static FinancialWebLoginpage objFinWebLoginPage;
  static FinancialWebHomepage objFinWebHomePage;
  static CreditorMaintenance objCreditorMaintenance;
  static DebtorMaintenance objDebtorMaintenance;
  static FinancialWebHomepageWorkflow objFinWebHomePageWorkflow;
  static DebtorsVouchers objDebtorsVouchers;
  static DebtorsAuthorise objDebtorsAuthorise;
  static DebtorsCreditNotes objDebtorsCreditNotes;
  static DebtorChargeCodeMaintenance objDebtorChargeCodeMaintenance;
  static DebtorPayments objDebtorPayments;
  static DebtorVouchersSalesInvoices objDebtorVouchersSalesInvoices;
  static DebtorsNotes objDebtorsNotes;
  static CreditorNotes objCreditorNotes;
  static CreditorPayments objCreditorPayments;
  static GLMaintenance objGLMaintenance;
  static CreditorEnquiries objCreditorEnquiries;
  static DebtorEnquiries objDebtorEnquiries;
  static CreditorVouchers objCreditorVouchers;
  static GLEnquiries objEnquiries;
  static GLJournals objGLJournals;
  static DBReports objDBStyleMaintenance;
  static DBReportsWorkflow objDBStyleMaintenanceWorkflow;
  static CRReportsWorkflow objCRStyleMaintenanceWorkflow;
  static GLReportsWorkflow objGLStyleMaintenanceWorkflow;
  static DebtorAdjustments objDebtorAdjustments;


  protected static String chargeCode = null;
  protected static String searchedMenuLinkText = null;
  protected static String postCode = null;
  protected static String creditorStatus = null;
  protected static String debtorStatus = null;
  protected static String uniqueMaintenanceNumber = null;
  protected static String uniqueDebtorNumber = null;
  protected static String uniqueCreditorNumber = null;
  protected static String uniqueInvoiceNo = null;
  protected static String telephoneNumber = null;
  protected static String referenceNo = null;
  protected static String crNoteReference = null;
  protected static String mobileNumber = null;
  protected static String alternateNumber = null;
  protected static String fullName = null;
  protected static String title = null;
  protected static String firstName = null;
  protected static String lastName = null;
  protected static String comment = null;
  protected static String addressType = null;
  protected static String addressCode = null;
  protected static String contactName = null;
  protected static String dbCrNoteDpt = null;
  protected static String dbCrNoteSec = null;
  protected static String dbInvoiceDpt = null;
  protected static String dbInvoiceSec = null;
  protected static String amount = null;
  protected static String crNoteAddress = null;
  protected static String addressOne = null;
  protected static String addressTwo = null;
  protected static String addressThree = null;
  protected static String addressFour = null;
  protected static String country = null;
  protected static String paymentNo = null;
  protected static String alternatePaymentNo = null;
  protected static String currentDate = null;
  protected static String[] formFields;
  protected static String randomNumber = null;
  protected static String randomValue = null;
  protected static String randomComment = null;
  protected static String voucherNumber = null;
  protected static String classificationCode = null;
  protected static String crManualPaymentNo = null;
  protected static String detailCode = null;
  protected static String level = null;
  protected static String analysisCode = null;
  protected static String costCentreCode = null;
  protected static String newEnquiryName = null;
  protected static String standardJournalStatus = null;
  protected static String reversalJournalStatus = null;
  protected static String journalTemplateNo = null;
  protected static String journalNumber = null;
  protected static String reportStyleName = null;
  protected static String dbReportDescription = null;
  protected static String dbJobNumber = null;
  protected static String adjustmentNumber = null;
  protected static String txtJournalNoToRvrs = null;
  protected static String dbInvoiceAmount = null;
  protected static String dbCreditNoteAmount = null;
  protected static String dbPaymentNo = null;
  protected static String dbUnauthorisedDBInvoiceAmount = null;
  protected static String dbAuthorisedDBInvoiceAmount = null;

  public static void selectMenu(String data) throws InterruptedException, FileNotFoundException {
    waitForPageLoad();
    objFinWebHomePage = new FinancialWebHomepage(driver);
    for (WebElement element : FinancialWebHomepage.listMenu) {
      if (element.getText().equals(data)) {
        log.info("Test Pass: Find Element " + element);
        Actions action = new Actions(driver);
        action.click(element).build().perform();
        waitForPageLoad();
        break;
      }
    }
  }

  protected void closeAuditInfoPopup() throws FileNotFoundException, InterruptedException {
    objGLJournals = new GLJournals(driver);
    clickElement(GLJournals.btnCloseAuditInfo);
    waitforPanelLoad();
  }

  protected static String searchAndClickLink(List<WebElement> element, String data)
      throws InterruptedException, FileNotFoundException {
    waitForPageLoad();
    for (WebElement el : element) {
      if (el.getText().trim().equalsIgnoreCase(data.trim())) {
        searchedMenuLinkText = el.getText().trim();
        log.info(el.getText().trim());
        el.click();
        break;
      }
    }
    waitforPanelLoad();
    return searchedMenuLinkText;
  }

  protected static void navigateToFinancialWeb()
      throws InterruptedException, FileNotFoundException {
    log("navigateToFinancialWeb Started");
    navigateWithWindowsAuthentication(testdataprop.getProperty("financialwebusername"),
        testdataprop.getProperty("financialwebpassword"), envprop.getProperty("url"));
    log("navigateToFinancialWeb Finished");
  }


  protected static void validateMessage(WebElement element, String msg)
      throws FileNotFoundException, InterruptedException {
    log("validateMessage Started");
    waitforPanelLoad();
    containsText(element, msg.trim());
    log("validateMessage Finished");
  }

  protected static void validateMessageByTag(WebElement element, String data)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    verifyTextAttribute(element, data.trim());

  }

  protected static void selectDropdownOption(WebElement selectDrpDn, String expectedOption)
      throws FileNotFoundException, InterruptedException {
    log("selectDropdownOption Started");
    waitforPanelLoad();
    Select select = new Select(selectDrpDn);
    select.selectByValue(expectedOption);
    log("selectDropdownOption Finished");
  }

  protected static boolean findHTMLTableData(List<WebElement> table, String data)
      throws InterruptedException, FileNotFoundException {
    boolean matches = false;
    waitforPanelLoad();
    for (WebElement tdElement : table) {
      if (tdElement.getAttribute("value").trim().equalsIgnoreCase(data)) {
        matches = true;
        if (matches) {
          highlightElement(tdElement);
          log.info(KEYWORD_PASS + " Find the text " + data + " in given string " + matches);
          break;
        }
      }
    }
    waitForPageLoad();
    return matches;
  }

  protected static boolean findAndClickHTMLTableElement(List<WebElement> table, String data)
      throws InterruptedException, FileNotFoundException {
    boolean matches = false;
    waitforPanelLoad();
    for (WebElement tdElement : table) {
      if (tdElement.isDisplayed()) {
        log.info(tdElement.getText());
        matches = tdElement.getText().contains(data);
        if (matches) {
          highlightElement(tdElement);
          clickElement(tdElement);
          log.info(KEYWORD_PASS + " Find the text " + data + " in given string " + matches);
        }
      }
    }
    waitforPanelLoad();
    return matches;
  }

  protected static String findAndClickLinkText(List<WebElement> table, String data)
      throws InterruptedException, FileNotFoundException {
    boolean matches = false;
    waitforPanelLoad();
    for (WebElement tdElement : table) {
      if (tdElement.isDisplayed()) {
        log.info(tdElement.getText());
        matches = tdElement.getText().equalsIgnoreCase(data);
        if (matches) {
          List<WebElement> anchors = tdElement.findElements(By.tagName("a"));
          for (WebElement a : anchors) {
            log.info(a.getText());
            if (a.getText().trim().equalsIgnoreCase(data.trim())) {
              highlightElement(a);
              searchedMenuLinkText = a.getText().trim();
              clickElement(a);
              matches = true;
              log.info(KEYWORD_PASS + " Find the text " + data + " in given string " + matches);
              break;
            }
          }
          if (matches) {
            break;
          }
        }
      }
    }
    Thread.sleep(2500);
    return searchedMenuLinkText;
  }

  public static void clickSignOut() throws FileNotFoundException, InterruptedException {
    objFinWebHomePage = new FinancialWebHomepage(driver);
    waitForPageLoad();
    clickElement(FinancialWebHomepage.signOut);
    waitForPageLoad();
  }

  protected static void clickCalendar(WebElement calendarControl)
      throws InterruptedException, FileNotFoundException {
    Thread.sleep(500);
    clickElement(calendarControl);
    Thread.sleep(500);
  }

  // Function to select the day of the month in the date time picker.
  protected static void dateTimePicker(String date, List<WebElement> calDateClass,
      WebElement calDrpDnMonth, WebElement calDrpDnYear)
      throws InterruptedException, FileNotFoundException {
    // updated method to handle stale element issue.
    // Below we are not using parameters (except date) instead using orprop to find element at run
    // time.

    String date_ent1[] = date.split("/");
    String day = date_ent1[0];
    String year = date_ent1[2];
    if (day.equals("01") || day.equals("02") || day.equals("03") || day.equals("04")
        || day.equals("05") || day.equals("06") || day.equals("07") || day.equals("08")
        || day.equals("09")) {

      day = (day.substring(1));
    }
    String month = date_ent1[1];
    if (month.equals("01") || month.equals("02") || month.equals("03") || month.equals("04")
        || month.equals("05") || month.equals("06") || month.equals("07") || month.equals("08")
        || month.equals("09")) {

      month = (month.substring(1));
    }
    boolean found = true;
    if (found) {
      calDrpDnMonth = driver.findElement(By.xpath(orprop.getProperty("calendarmonth")));
      Thread.sleep(1500);
      Select oSelect = new Select(calDrpDnMonth);
      oSelect.selectByVisibleText(month);
      // selectDropDown(calDrpDnMonth, month);
      Thread.sleep(1500);
      calDrpDnYear = driver.findElement(By.xpath(orprop.getProperty("calendaryear")));
      Thread.sleep(1500);
      // selectDropDown(calDrpDnYear, year);
      oSelect = new Select(calDrpDnYear);
      oSelect.selectByVisibleText(year);
      Thread.sleep(1500);
      List<WebElement> selDate = driver.findElements(By.xpath(orprop.getProperty("calendarclass")));
      for (WebElement dt : selDate) {
        if (dt.getAttribute("value").equalsIgnoreCase(day)) {
          highlightElement(dt);
          click(dt);
          log.info("hello");
          break;
        }
      }
    }
    switchToParentWindow(parentHandle);
    waitForPageLoad();

  }

  protected static void searchTableColumn(WebElement htmltable, String findElement)
      throws InterruptedException, FileNotFoundException {
    log("searchTableColumn Started");
    waitforPanelLoad();
    List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
    // int size = rows.size();
    // ArrayList<String> rowValue = new ArrayList<String>();
    for (int rnum = 0; rnum < rows.size(); rnum++) {
      List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
      for (int cnum = 0; cnum < columns.size(); cnum++) {
        if (columns.get(cnum).getText().trim().equalsIgnoreCase(findElement.trim())) {
          highlightElement(columns.get(cnum));
        }
      }
    }
    // locateElement(findElement);
    // log("searchTableColumn Finished");
    // return size;
  }

  protected static int searchTableColumn(WebElement htmltable, WebElement findElement)
      throws InterruptedException, FileNotFoundException {
    log("searchTableColumn Started");
    waitforPanelLoad();
    List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
    int size = rows.size();
    ArrayList<String> rowValue = new ArrayList<String>();
    for (int rnum = 0; rnum < 1; rnum++) {
      List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
      for (int cnum = 0; cnum < columns.size(); cnum++) {
        rowValue.add(columns.get(cnum).getText());
      }
    }
    locateElement(findElement);
    log("searchTableColumn Finished");
    return size;
  }

  protected static void locateElement(WebElement element) {
    log.debug("Checking existance of element");
    try {
      if (!element.isDisplayed()) {
        highlightElement(element);
      }
      {
        log.info(KEYWORD_PASS + " Object exist ");
        highlightElement(element);
      }
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Object doest not exist ");
    }
  }

  protected static void clickClose(WebElement element)
      throws FileNotFoundException, InterruptedException {
    clickElement(element);
    waitforPanelLoad();
  }

  protected void validateTableRecords(String table, String dataSet)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    List<WebElement> tableData = driver.findElements(By.xpath((orprop.getProperty("table"))));
    StringTokenizer tr = new StringTokenizer(dataSet, ",");
    while (tr.hasMoreTokens()) {
      findHTMLTableData(tableData, tr.nextToken());
    }
  }

  protected void validateTableColumns(String table, String dataSet)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    StringTokenizer tr = new StringTokenizer(dataSet, ",");
    while (tr.hasMoreTokens()) {
      searchTableColumn(table, tr.nextToken());
    }
  }

  protected void validateTableTagValue(String table, String dataSet)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    searchTableColumnTagValue(table, dataSet);
  }

  public static void searchText(String data) throws FileNotFoundException, InterruptedException {
    waitForPageLoad();
    objFinWebHomePage = new FinancialWebHomepage(driver);
    // waitForPageLoad();
    waitforPanelElement(FinancialWebHomepage.txtMenuSearchBox);
    setText(FinancialWebHomepage.txtMenuSearchBox, data);
    clickElement(FinancialWebHomepage.btnGo);
    // WaitForElementDisapper();
    waitforPanelLoad();
  }

  public static void clickSearchResultsLinkText(String htmlTable, String myMenuLink)
      throws FileNotFoundException, InterruptedException {
    waitForPageLoad();
    objFinWebHomePage = new FinancialWebHomepage(driver);
    List<WebElement> myMenuSearchResultList = driver.findElements(By.xpath(htmlTable));
    searchedMenuLinkText = findAndClickLinkText(myMenuSearchResultList, myMenuLink);
    waitforPanelLoad();
    // WaitForElementDisapper();
  }

  public static void backToParentPanel() throws InterruptedException, FileNotFoundException {
    waitForPageLoad();
    objFinWebHomePage = new FinancialWebHomepage(driver);
    clickElement(FinancialWebHomepage.backToFinancialsWebMainMenu);
    Thread.sleep(500);
  }

  public static void searchedTextAndValidateSearchMenuResult(String table, String data)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    verifySearchListItem(table, data);
    boolean isModuleLoaded = false;
    isModuleLoaded = FinancialWebHomepage.pnlModuleLoader.isDisplayed();
    while (!isModuleLoaded) {
      isModuleLoaded = FinancialWebHomepage.pnlModuleLoader.isDisplayed();
      if (isModuleLoaded) {
        highlightElement(FinancialWebHomepage.pnlModuleLoader);
        log.info(KEYWORD_PASS + " Page is loaded ");
        waitforPanelLoad();
        Thread.sleep(2000);
        break;
      }
    } // WaitForElementDisapper();
    waitforPanelLoad();
    Thread.sleep(2000);
  }

  public static void verifySearchListItem(String table, String data)
      throws InterruptedException, FileNotFoundException {
    waitForPageLoad();
    objFinWebHomePage = new FinancialWebHomepage(driver);
    waitforPanelElement(FinancialWebHomepage.searchLists);
    List<WebElement> el = driver.findElements(By.xpath(table));
    for (WebElement e : el) {
      if (e.getText().equalsIgnoreCase(data)) {
        e.click();
        // waitforPanelLoad();
        break;
      }
    } // Thread.sleep(1000);
  }

  protected static void searchTableColumn(String table, String findElement)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    List<WebElement> htmlTables = driver.findElements(By.xpath(table));
    for (WebElement htmlTable : htmlTables) {
      List<WebElement> rows = htmlTable.findElements(By.tagName("tr"));
      int size = rows.size();
      boolean found = false;
      waitforPanelLoad();
      for (int rnum = 0; rnum < size; rnum++) {
        List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
        for (int cnum = 0; cnum < columns.size(); cnum++) {
          if (columns.get(cnum).getText().trim().equalsIgnoreCase(findElement.trim())) {
            highlightElement(columns.get(cnum));
            found = true;
            break;
          }
          if (found)
            break;
        }
        if (found)
          break;
      }
    }
  }

  protected static void searchTableColumnTagValue(String table, String findElement)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    WebElement htmlTable = driver.findElement(By.xpath(table));
    List<WebElement> rows = htmlTable.findElements(By.tagName("tr"));
    int size = rows.size();
    boolean found = false;
    new ArrayList<String>();
    for (int rnum = 0; rnum < size; rnum++) {
      List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
      for (int cnum = 0; cnum < columns.size(); cnum++) {
        log.info(columns.get(cnum).getAttribute("title").trim());
        log.info(columns.get(cnum).getAttribute("title").trim());
        if (columns.get(cnum).getAttribute("title").trim().equalsIgnoreCase(findElement.trim())) {
          highlightElement(columns.get(cnum));
          found = true;
          break;
        }
      }
      if (found)
        break;
    }
  }

  protected static void searchInvoicesInTableColumn(String table, String findElement)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    boolean found = false;
    WebElement htmlTable = driver.findElement(By.xpath(table));
    List<WebElement> rows = htmlTable.findElements(By.tagName("tr"));
    int size = rows.size();
    for (int rnum = 0; rnum < size; rnum++) {
      List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
      for (int cnum = 0; cnum < columns.size(); cnum++) {
        List<WebElement> inputs = rows.get(rnum).findElements(By.tagName("input"));
        for (WebElement input : inputs) {
          if (input.getAttribute("value").equalsIgnoreCase(findElement)) {
            highlightElement(input);
            found = true;
            break;
          }
          List<WebElement> spans = rows.get(rnum).findElements(By.tagName("span"));
          for (WebElement span : spans) {

            if (span.getText().equalsIgnoreCase(findElement)) {
              highlightElement(span);
              found = true;
              break;
            }
            if (found)
              break;

          }
          if (found)
            break;
        }
      }
      if (found)
        break;
    }
  }

  protected static void searchAnchorTextInTableColumn(String table, String findElement)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    WebElement htmlTable = driver.findElement(By.xpath(table));
    List<WebElement> rows = htmlTable.findElements(By.tagName("tr"));
    int size = rows.size();
    for (int rnum = 0; rnum < size; rnum++) {
      List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
      for (int cnum = 0; cnum < columns.size(); cnum++) {
        List<WebElement> anchors = rows.get(rnum).findElements(By.tagName("a"));
        for (WebElement anchor : anchors) {
          if (anchor.getText().equalsIgnoreCase(findElement)) {
            highlightElement(anchor);
            break;
          }
        }
      }
    }
  }

  protected static void searchAndClickAnchorTextInTableColumn(String table, String findElement)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    WebElement htmlTable = driver.findElement(By.xpath(table));
    List<WebElement> rows = htmlTable.findElements(By.tagName("tr"));
    int size = rows.size();
    for (int rnum = 0; rnum < size; rnum++) {
      List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
      for (int cnum = 0; cnum < columns.size(); cnum++) {
        List<WebElement> anchors = rows.get(rnum).findElements(By.tagName("a"));
        for (WebElement anchor : anchors) {
          if (anchor.getText().equalsIgnoreCase(findElement)) {
            // highlightElement(anchor);
            clickElement(anchor);
            waitforPanelLoad();
            break;
          }
        }
      }
    }
    Thread.sleep(1000);
  }

  protected static void findTableData(List<WebElement> table, String data)
      throws InterruptedException, FileNotFoundException {
    boolean matches = false;
    waitforPanelLoad();
    for (WebElement tdElement : table) {
      if (tdElement.isDisplayed()) {
        log.info(tdElement.getText());
        matches = tdElement.getText().contains(data);
        if (matches) {
          highlightElement(tdElement);
          matches = true;
          log.info(KEYWORD_PASS + " Find the text " + data + " in given string " + matches);
        }
      }
    }
  }

  public static void callEvent(String table, String butName)
      throws InterruptedException, FileNotFoundException {
    waitForPageLoad();
    objFinWebHomePage = new FinancialWebHomepage(driver);
    boolean found = false;
    Thread.sleep(500);
    waitForElementDisappear();
    // waitForPageLoad();
    List<WebElement> findButton = driver.findElements(By.xpath(table));
    for (WebElement myButton : findButton) {
      if (myButton.isDisplayed() && myButton.isEnabled()
          && myButton.getAttribute("value").trim().equalsIgnoreCase(butName.trim())) {
        found = findAndClickElementWithTextAttribute(myButton, butName);
        if (found) {
          found = waitForElementDisappear();
          if (found) {
            // waitForPageLoad();
            break;
          }
        }
      }
      if (found)
        break;
    }
    // WaitForElementDisapper();
    waitforPanelLoad();
    Thread.sleep(1500);
  }


  public static void waitforPanelLoad() throws InterruptedException, FileNotFoundException {
    waitForElementDisappear();
    boolean found = false;
    while (!found) {
      // WebElement findPanel = driver.findElement(By.xpath(orprop.getProperty("panelload")));
      WebElement uniquePanel = driver.findElement(By.xpath(orprop.getProperty("uniquepanelload")));
      // WebElement authentcatePanel =
      // driver.findElement(By.xpath(orprop.getProperty("uniquepanelload")));

      // boolean isPanelEnabled = findPanel.isDisplayed();
      boolean isUniquePanelEnabled = uniquePanel.isDisplayed();
      // boolean isAuthPanelEnabled = authentcatePanel.isDisplayed();

      // isPanelEnabled = IsElementDisplayed(findPanel);
      isUniquePanelEnabled = IsElementDisplayed(uniquePanel);
      // isAuthPanelEnabled = IsElementDisplayed(authentcatePanel);
      if (isUniquePanelEnabled) {
        found = true;
        Thread.sleep(800);
        break;
      } else if (!isUniquePanelEnabled) {
        WebElement reAuth = driver.findElement(By.xpath(orprop.getProperty("authpanelload")));
        found = IsElementDisplayed(reAuth);
        if (found) {
          log.info("*******************Hurrey***************");
          callEvent(orprop.getProperty("button"), testdataprop.getProperty("continue"));
          break;
        }
      } else {
        found = false;
        Thread.sleep(500);
      }
    }
  }

  public static boolean waitForElementDisappear()
      throws InterruptedException, FileNotFoundException {
    boolean found = false;

    while (!found) {
      Thread.sleep(600);
      WebElement loading = driver.findElement(By.xpath(orprop.getProperty("loading")));
      boolean isPanelEnabled = loading.isDisplayed();
      if (isPanelEnabled) {
        highlightElement(loading);
        Thread.sleep(800);
      } else {
        found = true;
        Thread.sleep(800);
        break;
      }
    }
    reAuthenticationPopup();
    Thread.sleep(500);
    return found;
  }

  public static boolean findAndClickElementWithTextAttribute(WebElement element, String text)
      throws InterruptedException, FileNotFoundException {
    boolean found = false;
    String actual = element.getAttribute("value").trim();
    String expected = text.trim();

    if (actual.equalsIgnoreCase(expected)) {
      highlightElement(element);
      log.info(KEYWORD_PASS + " Find the element " + element);
      clickElement(element);
      log.info("");
      found = true;
    }
    waitForElementDisappear();
    return found;
  }

  protected static void validateFieldIsEnabled()
      throws FileNotFoundException, InterruptedException {
    waitForPageLoad();
    objCreditorMaintenance = new CreditorMaintenance(driver);
    waitforPanelElement(CreditorMaintenance.txtCreditorNumber);
    boolean status = CreditorMaintenance.txtCreditorNumber.isEnabled();
    if (status) {
      highlightElement(CreditorMaintenance.txtCreditorNumber);
      log.info("Pass : Creditor Number field is enabled");
    } else
      log.info("Fail : Creditor Number field is Disabled");
  }

  public static void insertAddress() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objCreditorMaintenance = new CreditorMaintenance(driver);
    clickElement(CreditorMaintenance.btnInsertAddress);
    waitforPanelLoad();
  }

  protected static void validateStatus(String data)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorMaintenance = new CreditorMaintenance(driver);
    creditorStatus = CreditorMaintenance.txtCreditorStatus.getAttribute("value");
    if (creditorStatus.equalsIgnoreCase(data)) {
      highlightElement(CreditorMaintenance.txtCreditorStatus);
      log.info("Pass: Creditor status field value is " + creditorStatus);
    } else
      log.info("Fail: Creditor status field value is " + creditorStatus);
  }

  protected static void clearDetails() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objCreditorMaintenance = new CreditorMaintenance(driver);
    waitforPanelElement(CreditorMaintenance.btnClear);
    clickElement(CreditorMaintenance.btnClear);
    waitforPanelLoad();
  }

  protected static void searchAndClickLatestRecordInTable(String table, String findElement)
      throws InterruptedException, FileNotFoundException {
    boolean found = false;
    waitforPanelLoad();
    List<WebElement> htmlTable = driver.findElements(By.xpath(table));
    for (WebElement htmltabl : htmlTable) {
      List<WebElement> rows = htmltabl.findElements(By.tagName("tr"));
      int size = rows.size();
      for (int rnum = size - 1; rnum > 0; rnum--) {
        List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
        for (int cnum = 0; cnum < columns.size(); cnum++) {
          List<WebElement> anchors = columns.get(cnum).findElements(By.tagName("a"));
          for (WebElement a : anchors) {
            log.info(a.getText());
            if (a.getText().equalsIgnoreCase(findElement)) {
              highlightElement(a);
              a.click();
              found = true;
              Thread.sleep(2000);
              break;
            }
          }
          if (found)
            break;
        }
        if (found)
          break;
      }
      if (found)
        break;
    }
    waitforPanelLoad();
    // Thread.sleep(2000);
  }

  public static void checkAllEmailOrFaxOptionsCheckbox()
      throws FileNotFoundException, InterruptedException {
    objDebtorMaintenance = new DebtorMaintenance(driver);
    waitforPanelLoad();
    List<WebElement> listCheckBoxes = driver.findElements(By.xpath("//*[@type='checkbox']"));
    for (WebElement optionIsEnabled : listCheckBoxes) {
      if (optionIsEnabled.isDisplayed()) {
        highlightElement(optionIsEnabled);
        clickElement(optionIsEnabled);
      }
    }
  }

  public static boolean validateTableExist(WebElement element)
      throws InterruptedException, FileNotFoundException {
    boolean found = true;
    waitforPanelLoad();
    while (found) {
      found = element.isDisplayed();
      if (found) {
        highlightElement(element);
        // found=false;
        break;
      }
    }
    return found;
  }

  public static boolean validateAmount(String amt, String qty, String price)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorsVouchers = new DebtorsVouchers(driver);
    boolean found = false;
    String newQty = qty.substring(0, 2);
    float amount = Float.valueOf(newQty) * Float.valueOf(price);
    String value = amt;
    String newAmount = String.valueOf(amount);
    value = value.substring(0, 3);
    newAmount = newAmount.substring(0, 3);
    if (newAmount.equalsIgnoreCase(value)) {
      log.info(KEYWORD_PASS + " Amount matched ");
      found = true;
    } else {
      log.info(KEYWORD_FAIL + " Amount does not matched ");
      found = false;
    }
    return found;
  }

  public static boolean waitforPanelElement(WebElement element)
      throws InterruptedException, FileNotFoundException {
    boolean found = false;
    waitforPanelLoad();
    while (!found) {
      found = element.isDisplayed();
      if (found) {
        highlightElement(element);
        break;
      } else {
        found = false;
        Thread.sleep(600);
      }
    }
    return found;
  }

  public static void clickComplete() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objFinWebHomePage = new FinancialWebHomepage(driver);
    clickElement(FinancialWebHomepage.btnComplete);
    switchandAcceptPopupMessageBox(driver);
    waitforPanelElement(FinancialWebHomepage.btnComplete);
  }

  public static String getRandomComment() {
    return randomComment = testdataprop.getProperty("comment")
        + GenUtil.getRandomNumber(testdataprop.getProperty("lengthlimit"));
  }

  public static boolean validateTableData(WebElement element, String code, String desc,
      String table) throws InterruptedException, FileNotFoundException {
    boolean found = false;
    objCreditorVouchers = new CreditorVouchers(driver);
    List<WebElement> rows = element.findElements(By.tagName("tr"));
    int size = rows.size();
    for (int rnum = 0; rnum < size; rnum++) {
      List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
      for (int i = 0; i < columns.size(); i++) {
        if (columns.get(i).getText().trim().equalsIgnoreCase(code)) {
          highlightElement(columns.get(i));
          WebElement editLink = driver.findElement(By.xpath(table));
          clickElement(editLink);
          waitforPanelElement(CreditorVouchers.btnCloseAuditInfoPopup);
          setText(GLMaintenance.txtControlDataMaintDimensionSets, desc);
          callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
          waitforPanelLoad();
          found = true;
          break;
        }
      }
      if (found)
        break;
    }
    return found;
  }

  protected static void reAuthenticationPopup() throws InterruptedException, FileNotFoundException {
    boolean found = false;
    boolean foundAuthenticationPopup = false;
    boolean foundFramePopup = false;
    boolean foundSubmit = false;
    Thread.sleep(500);
    parentHandle = driver.getWindowHandle();
    while (!found) {
      WebElement foundReauthenticationPopup =
          driver.findElement(By.xpath(orprop.getProperty("reauthenticationpopup")));
      foundAuthenticationPopup = foundReauthenticationPopup.isDisplayed();
      if (!foundAuthenticationPopup) {
        // do nothing
        break;
      } else {
        WebElement foundFrame =
            driver.findElement(By.xpath(orprop.getProperty("reauthenticationpopupframe")));
        foundFramePopup = foundFrame.isDisplayed();
        if (foundFramePopup) {
          switchToFrame(orprop.getProperty("reauthenticationpopupframename"));
          WebElement findContinue =
              driver.findElement(By.xpath(orprop.getProperty("reauthenticationcontinue")));
          foundSubmit = findContinue.isDisplayed();
          if (foundSubmit) {
            log.info(
                "====================re authentication popup method called.....=========================");
            findContinue.click();
            switchToParentWindow(parentHandle);
            waitforPanelLoad();
            found = true;
            break;
          }
          if (found)
            break;
        }
        if (found)
          break;
      }
      if (found)
        break;
    }
    Thread.sleep(700);
  }

  static void waitforSignOut() throws InterruptedException, FileNotFoundException {
    boolean found = false;
    WebElement lnkRefresh;
    boolean foundSignout;
    int i = 0;
    while (i < 10) {
      if (driver.getTitle().trim().equalsIgnoreCase(msgprop.getProperty("logintitle").trim())) {
        Thread.sleep(2000);

      } else {
        if (driver.getTitle().trim()
            .equalsIgnoreCase(msgprop.getProperty("homepagetitle").trim())) {
          found = true;
          Thread.sleep(2000);
          break;
        }
      }
      i++;
    }

    while (!found) {
      if (driver.getTitle().trim().equalsIgnoreCase(msgprop.getProperty("logintitle").trim())) {
        lnkRefresh = driver.findElement(By.xpath(orprop.getProperty("signin")));
        if (lnkRefresh.getText().trim()
            .equalsIgnoreCase(testdataprop.getProperty("changepassword").trim())) {
          WebElement logout = driver.findElement(By.xpath(orprop.getProperty("signout")));
          foundSignout = logout.isDisplayed();
          if (foundSignout) {
            highlightElement(logout);
            found = true;
            break;
          }
        } else {
          // Thread.sleep(8000);
          lnkRefresh.click();
        }
        Thread.sleep(8000);
      }
      if (driver.getTitle().trim().equalsIgnoreCase(msgprop.getProperty("homepagetitle").trim())) {
        found = true;
        break;
      }
    }
    waitForElementDisappear();
  }

  protected static void searchAndClickTableData(String table, String data)
      throws FileNotFoundException, InterruptedException {
    List<WebElement> htmlTable = driver.findElements(By.xpath(table));
    searchAndClickLink(htmlTable, data);
  }

  /*
   * This method set webelement value in textbox. This method validate the tagname = label it will
   * fail in other cases(tag name). This method get the value of 'for' attribute.
   */
  public static void setRandomWebElementValue(String labelname, String data)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    boolean found = false;
    String combinedString = orprop.getProperty("containspart1").trim() + labelname.trim()
        + orprop.getProperty("containspart2").trim();
    List<WebElement> findMe = driver.findElements(By.xpath(combinedString));
    for (WebElement myElement : findMe) {
      found = IsExist(myElement);
      if (found && myElement.getText().trim().equalsIgnoreCase(labelname.trim())) {
        String myElementForText = myElement.getAttribute("for");
        WebElement myTextBox = driver.findElement(By.id(myElementForText));
        found = myTextBox.isDisplayed();
        if (found) {
          setText(myTextBox, data);
          waitforPanelLoad();
          break;
        }
      }
    }
    waitforPanelLoad();
  }

  /*
   * This get value webelement in textbox. This method validate the tagname = label it will fail in
   * other cases(tag name). This method get the value of 'for' attribute
   */
  protected static String getRandomWebElementValue(String labelname)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    String myLastElement = null;
    boolean found = false;
    String combinedString = orprop.getProperty("containspart1").trim() + labelname.trim()
        + orprop.getProperty("containspart2").trim();
    waitforPanelLoad();
    List<WebElement> findMe = driver.findElements(By.xpath(combinedString));
    for (WebElement myElement : findMe) {
      found = IsExist(myElement);
      if (found && myElement.getText().trim().equalsIgnoreCase(labelname.trim())) {
        String myElementForText = myElement.getAttribute("for");
        WebElement myTextBox = driver.findElement(By.id(myElementForText));
        found = myTextBox.isDisplayed();
        if (found) {
          highlightElement(myTextBox);
          myLastElement = myTextBox.getAttribute("value");
          break;
        }
      }
    }
    return myLastElement;
  }
  /*
   * This method will checked webelement checkbox. This method validate the tagname = label it will
   * fail in other cases(tag name). This method get the value of 'for' attribute.
   */

  protected static void setRandomWebElementChkbx(String labelname)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    boolean found = false;
    String combinedString = orprop.getProperty("containspart1").trim() + labelname.trim()
        + orprop.getProperty("containspart2").trim();
    List<WebElement> findMe = driver.findElements(By.xpath(combinedString));
    for (WebElement myElement : findMe) {
      found = IsExist(myElement);
      if (found) {
        String myElementForText = myElement.getAttribute("for");
        WebElement myTextBox = driver.findElement(By.id(myElementForText));
        found = IsExist(myTextBox);
        if (found) {
          click(myTextBox);
          waitforPanelLoad();
          break;
        }
      }
    }
  }

  /*
   * It will select webelement drop-down. This method create xpath using label text. This method get
   * id of drop-down.
   */
  protected static void selectRandomWebElementDrpDwn(String labelname, String dropdwnValue)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    boolean found = false;
    String combinedString = orprop.getProperty("containspart1").trim() + labelname.trim()
        + orprop.getProperty("containspart2").trim() + orprop.getProperty("commondropdown").trim();
    List<WebElement> findMe = driver.findElements(By.xpath(combinedString));
    for (WebElement myElement : findMe) {
      found = myElement.isDisplayed();
      if (found) {
        String myElementForText = myElement.getAttribute("id");
        WebElement myTextBox = driver.findElement(By.id(myElementForText));
        found = myTextBox.isDisplayed();
        if (found) {
          selectDropDown(myTextBox, dropdwnValue);
          break;
        }
      }

    }
  }

  /*
   * This method create xpath using label text. This method get id of drop-down. It will Return text
   * available in option of webelement drop-down.
   */
  protected static String getRandomWebElementDrpDwn(String dropdwnValue)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    String myLastElement = null;
    boolean found = false;
    String combinedString = orprop.getProperty("containspart1").trim() + dropdwnValue.trim()
        + orprop.getProperty("containspart2").trim() + orprop.getProperty("commondropdown").trim();
    List<WebElement> findMe = driver.findElements(By.xpath(combinedString));
    for (WebElement myElement : findMe) {
      found = IsExist(myElement);
      if (found) {
        String myElementForText = myElement.getAttribute("id");
        WebElement myTextBox = driver.findElement(By.id(myElementForText));
        found = IsExist(myTextBox);
        if (found) {
          highlightElement(myTextBox);
          myLastElement = myTextBox.getText();
          // log.info(KEYWORD_PASS + " Find value " +myLastElement);
          break;
        }
      }
    }
    return myLastElement;
  }

  /*
   * This method create xpath using label text. This method get id of drop-down. It will Return text
   * available in textbox webelement.
   */
  protected static void validateRandomWebElementValue(String data)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    String myLastElement = null;
    boolean found = false;
    String combinedString = orprop.getProperty("containspart1").trim() + data.trim()
        + orprop.getProperty("containspart2").trim();
    waitforPanelLoad();
    List<WebElement> findMe = driver.findElements(By.xpath(combinedString));
    for (WebElement myElement : findMe) {
      found = IsExist(myElement);
      if (found && myElement.getText().trim().equalsIgnoreCase(data.trim())) {
        highlightElement(myElement);
        String myElementForText = myElement.getAttribute("for");
        WebElement myTextBox = driver.findElement(By.id(myElementForText));
        found = IsExist(myTextBox);
        if (found) {
          myLastElement = myTextBox.getAttribute("value");
          if (myLastElement.trim().equalsIgnoreCase(data.trim())) {
            log.info(KEYWORD_PASS + "Find Element ");
            highlightElement(myTextBox);
            break;
          }

        }
      }
    }
    waitforPanelLoad();
  }

  /*
   * This method create xpath using label text. This method get id of drop-down. It will Return text
   * available in option of webelement drop-down. Verify the Selected text of drop-down.
   */
  protected static String validateRandomWebElementdrpdwn(String lblStatus, String expectedData)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    boolean found = false;
    String defaultItem = null;
    String combinedString = orprop.getProperty("containspart1").trim() + lblStatus.trim()
        + orprop.getProperty("containspart2").trim() + orprop.getProperty("commondropdown").trim();
    List<WebElement> findMe = driver.findElements(By.xpath(combinedString));
    for (WebElement myElement : findMe) {
      found = IsExist(myElement);
      if (found) {
        String myElementForText = myElement.getAttribute("id");
        WebElement myTextBox = driver.findElement(By.id(myElementForText));
        found = IsExist(myTextBox);
        if (found) {
          Select select = new Select(myTextBox);
          WebElement option = select.getFirstSelectedOption();
          defaultItem = option.getText();
          if (defaultItem.trim().equalsIgnoreCase(expectedData.trim())) {
            highlightElement(option);
            log.info(KEYWORD_PASS + " Find : " + defaultItem.trim());
            break;
          } else
            log.info(KEYWORD_FAIL + " Cannot Find " + defaultItem.trim());
        }

      }
    }
    return defaultItem;
  }

  /*
   * It will select webelement drop-down. This method create xpath using label text. This method get
   * id of drop-down.
   */
  protected static void selectRandomWebElementCalendarImage(String labelname)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    boolean found = false;
    String combinedString = orprop.getProperty("containspart1").trim() + labelname.trim()
        + orprop.getProperty("containspart2").trim() + orprop.getProperty("calimage").trim();
    List<WebElement> findMe = driver.findElements(By.xpath(combinedString));
    for (WebElement myElement : findMe) {
      found = IsExist(myElement);
      if (found) {
        String myElementForText = myElement.getAttribute("id");
        WebElement myTextBox = driver.findElement(By.id(myElementForText));
        found = IsExist(myTextBox);
        if (found) {
          // selectDropDown(myTextBox, dropdwnValue);
          clickElement(myTextBox);
          break;
        }
      }

    }
  }

  protected static WebElement getRandomWebElement(String labelName)
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

  protected static WebElement getRandomWebElement(String labelName, String xpathPart)
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
  }

  // This method is used to get WebElement of Span lable
  protected static String getRandomWebElementText(String labelName)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    boolean found = false;
    String myElementForText = null;
    String combinedString = orprop.getProperty("textpart1").trim() + labelName.trim()
        + orprop.getProperty("textpart2").trim() + orprop.getProperty("txtspanvalue").trim();
    List<WebElement> findMe = driver.findElements(By.xpath(combinedString));
    for (WebElement myElement : findMe) {
      found = IsExist(myElement);
      if (found) {
        myElementForText = myElement.getAttribute("value");
        if (myElementForText != null) {
          highlightElement(myElement);
          log.info(KEYWORD_PASS + " Find : " + myElementForText.trim());
          break;
        } else {
          found = false;
          log.info(KEYWORD_FAIL + " Text value : " + myElementForText);
        }
      }
    }
    return myElementForText;
  }


  // This method is used to set WebElement of Span label
  protected static void setRandomWebElementText(String labelName, String data)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    boolean found = false;
    String combinedString = orprop.getProperty("containspart1").trim() + labelName.trim()
        + orprop.getProperty("containspart2").trim() + orprop.getProperty("txtspanvalue").trim();
    List<WebElement> findMe = driver.findElements(By.xpath(combinedString));
    for (WebElement myElement : findMe) {
      found = IsExist(myElement);
      if (found) {
        highlightElement(myElement);
        setText(myElement, data);
        log.info(KEYWORD_PASS + " Find : " + myElement.getText());
        break;
      } else {
        found = false;
        log.info(KEYWORD_FAIL + " Text value : " + myElement.getText());
      }
    }
    // return myElementForText;
  }


  protected static void uploadNewAttachment() throws InterruptedException, FileNotFoundException {
    objFinWebHomePage = new FinancialWebHomepage(driver);
    clickElement(FinancialWebHomepage.btnUploadNewAttachment);
    waitforPanelLoad();
  }

  public static void unexpectedAlertAccept(String btnName)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    try {
      callEvent(orprop.getProperty("button"), btnName);
    } catch (UnhandledAlertException f) {
      try {
        Alert alert = driver.switchTo().alert();
        alert.accept();
      } catch (NoAlertPresentException e) {
        e.printStackTrace();
      }
    }
  }

  protected static void clickFindButton(String data)
      throws FileNotFoundException, InterruptedException {
    WebElement find = driver.findElement(By.xpath(data));
    boolean found = IsExist(find);
    if (found) {
      find.click();
      Thread.sleep(4000);
    }
    waitforPanelLoad();
  }

  // orprop.getProperty("finddebtorno")
  protected static void closePopup() throws FileNotFoundException, InterruptedException {
    objCreditorVouchers = new CreditorVouchers(driver);
    waitforPanelElement(CreditorVouchers.btnCloseAuditInfoPopup);
    CreditorVouchers.btnCloseAuditInfoPopup.click();
    waitforPanelLoad();
  }

  protected static void insertAdd() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objFinWebHomePage = new FinancialWebHomepage(driver);
    clickElement(FinancialWebHomepage.btnInsertAddress);
    waitforPanelLoad();
  }

  protected static void insertContact() throws InterruptedException, FileNotFoundException {
    objFinWebHomePage = new FinancialWebHomepage(driver);
    clickElement(FinancialWebHomepage.btnInsertContact);
    waitforPanelLoad();
  }

  public static String getPoundAmount(String amount)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    String amnt = "£" + amount;
    log.info(amnt);
    return amnt;
  }

  // This method is used to get WebElement of Span lable
  /*
   * protected static String getRandomElement(String labelName, String xpathPart, String data)
   * throws FileNotFoundException, InterruptedException { waitforPanelLoad(); boolean found = false;
   * String myElementForText = null; String combinedString = orprop.getProperty("textpart1").trim()
   * + labelName.trim() + orprop.getProperty("textpart2").trim() +
   * orprop.getProperty("randomelementpath").trim(); List<WebElement> findMe =
   * driver.findElements(By.xpath(combinedString)); for (WebElement myElement : findMe) { found =
   * IsExist(myElement); if(found) { found = findElementTag(myElement,data); log.info("test");
   * log.info("test"); break; }
   * 
   * }return myElementForText; } protected static boolean findElementTag(WebElement myElement,
   * String data) throws InterruptedException { boolean found = false; String elementTagValue =
   * null; String elementTCheckboxagValue = null; while(!found) { elementTagValue =
   * myElement.getTagName(); elementTCheckboxagValue = myElement.getAttribute("type"); found =
   * elementOnScreen(myElement, elementTagValue, elementTCheckboxagValue, data); //return found; }
   * return found; } protected static boolean elementOnScreen(WebElement myElement, String
   * myElementText,String elementTCheckboxagValue, String data) throws InterruptedException { //
   * switch statement boolean found=false; switch(myElementText) { // case statements // values must
   * be of same type of expression case "Select" : Select oSelect = new Select(myElement);
   * oSelect.selectByVisibleText("CN1 (Credit Note)"); found= true; break; // break is optional
   * 
   * case "input" : if(!elementTCheckboxagValue.equalsIgnoreCase("checkbox")) { setText(myElement,
   * data); found= true; break; // break is optional }else { click(myElement); break; }
   * 
   * 
   * // We can have any number of case statements // below is default statement, used when none of
   * the cases is true. // No break is needed in the default case. default : // Statements
   * 
   * } return found; }
   */
}// end of class
