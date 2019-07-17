package financialWeb.workflow;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.StringTokenizer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import financialWeb.pages.DebtorEnquiries;
import financialWeb.pages.DebtorVouchersSalesInvoices;
import util.GenUtil;

public class DebtorsEnquiriesWorkflow extends CommonWorkflow {

  static DebtorEnquiries objDebtorsEnquiries;


  public static void verifyNotYetDueAmount(String table, String amount)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    String data = "£" + testdataprop.getProperty("amount");
    // String amount = DebtorsVouchersWorkflow.getDBInvoiceAmount();
    amount = "£" + amount;
    if (amount.equalsIgnoreCase(data)) {
      searchTableColumn(table, data);
      log.info(KEYWORD_PASS + "Amount Matched");
    } else
      log.info(KEYWORD_FAIL + "Amount Not Matched");
  }

  public static void calculateTotalOutStandingAmt(String table)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    float addMe = (float) 0.00;
    String cellValue = null;
    List<WebElement> tableValue = driver.findElements(By.xpath(table));
    for (int i = 2; i < tableValue.size() - 2; i++) {
      String cellText = tableValue.get(i).getText();
      int length = cellText.length();
      log.info(length);
      cellValue = cellText.substring(1, length);
      addMe = Float.parseFloat(cellValue) + addMe;
    }
    String expected = "£" + String.valueOf(addMe) + "0";
    for (int i = tableValue.size() - 1; i <= tableValue.size() - 1;) {
      log.info(tableValue.get(i).getText());
      if (tableValue.get(i).getText().equalsIgnoreCase(String.valueOf(expected))) {
        highlightElement(tableValue.get(i));
        log.info(KEYWORD_PASS + " Value matches ");
        break;
      }
    }
  }


  public static void calculateOutStandingTransactionAmt(String table, int startIndex, int endIndex,
      int index) throws InterruptedException, FileNotFoundException {
    waitForElementDisappear();
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    float addMe = (float) 0.00;
    String cellValue = null;
    String expected = null;
    int length = 0;
    List<WebElement> tableValue = driver.findElements(By.xpath(table));
    for (int i = startIndex; i < tableValue.size(); i++) {
      String cellText = tableValue.get(i).getText();
      length = cellText.length();
      if (cellText.contains("-")) {
        cellValue = cellText.substring(2, length);
        cellValue = "-" + cellValue;
      } else {
        cellValue = cellText.substring(1, length);
      }
      addMe = Float.parseFloat(cellValue) + addMe;
      if (String.valueOf(i).equalsIgnoreCase(String.valueOf(endIndex))) {
        log.info(KEYWORD_PASS + " Value matches");
        break;
      }
    }
    if (addMe < 0) {
      String checkNegative = String.valueOf(addMe).substring(1, String.valueOf(addMe).length());
      expected = "-£" + String.valueOf(checkNegative) + "0";
    } else {
      expected = "£" + String.valueOf(addMe) + "0";
    }
    for (int i = index; i <= tableValue.size(); i++) {
      log.info(tableValue.get(i).getText());
      if (tableValue.get(i).getText().equalsIgnoreCase(String.valueOf(expected))) {
        highlightElement(tableValue.get(i));
        log.info(KEYWORD_PASS + " Value matches ");
        break;
      }
    }
  }

  public static void setDtDueDate() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    DebtorEnquiries.setDtDueDate();
  }

  public static void setTxtPostCode(String data)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    DebtorEnquiries.setTxtPostCode(data);
  }

  public static void setDepartment(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    DebtorEnquiries.setDrpdnDepartment(data);
  }

  public static void setSection(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    DebtorEnquiries.setDrpdnSection(data);
  }

  public static void setDBInvoiceSection(String data)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    DebtorEnquiries.setDrpdnDBInvoiceSection(data);
  }

  public static void setReferenceone(String data)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    DebtorEnquiries.setTxtReferenceone(data);
  }

  public static void setTransDateFrom() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    DebtorEnquiries.setDtTransDateFrom();
  }

  public static void setTransDateTo() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    DebtorEnquiries.setDtTransDateTo();
  }

  public static String getDate() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    return DebtorEnquiries.getTxtDate();
  }

  public static String getGLDate() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    return DebtorEnquiries.getTxtGLDate();
  }

  public static String getStartDate() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    return DebtorEnquiries.getTxtStartDate();
  }

  public static String getNextDate() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    return DebtorEnquiries.getTxtNextDate();
  }

  public static String getEndDate() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    return DebtorEnquiries.getTxtEndDate();
  }

  public static void verifyNotYetDueAmountForEducation(String amount)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    String data = "£" + testdataprop.getProperty("amount");
    // String amount = DebtorsVouchersWorkflow.getDBInvoiceAmount();
    amount = "£" + amount;
    if (amount.equalsIgnoreCase(data)) {
      searchTableColumn(orprop.getProperty("dbageddebtenquirydeptleveltable"), data);
      log.info(KEYWORD_PASS + "Amount Matched");
    } else
      log.info(KEYWORD_FAIL + "Amount Not Matched");
    calculateTotalOutStandingAmt(orprop.getProperty("dbageddebtenquiryforeducationtable"));
  }

  protected static void setDebtorEnquiriesDebtorNumber(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsEnquiries = new DebtorEnquiries(driver);
    waitforPanelElement(DebtorEnquiries.txtDebtorNumber);
    DebtorEnquiries.setDebtorNumber(data);
  }

  protected static void submit() throws InterruptedException, FileNotFoundException {
    objDebtorsEnquiries = new DebtorEnquiries(driver);
    clickElement(DebtorEnquiries.btnSubmit);
    waitForElementDisappear();
  }

  public static void validateDebtorDetails(String location, String typeOfDebtor)
      throws FileNotFoundException, InterruptedException {
    objDebtorsEnquiries = new DebtorEnquiries(driver);
    validateMessageByTag(DebtorEnquiries.txtTitle, title);
    validateMessageByTag(DebtorEnquiries.txtFirstName, firstName);
    validateMessageByTag(DebtorEnquiries.txtFirstName, lastName);
    Select oSelect = new Select(DebtorEnquiries.drpdnLocation);
    if (oSelect.getFirstSelectedOption().getText().equalsIgnoreCase(location)) {
      log.info(KEYWORD_PASS + " Find Element" + oSelect.getFirstSelectedOption().getText());
      highlightElement(DebtorEnquiries.drpdnLocation);
    }
    oSelect = new Select(DebtorEnquiries.drpdnTypeOfDebtor);
    if (oSelect.getFirstSelectedOption().getText().equalsIgnoreCase(location)) {
      log.info(KEYWORD_PASS + " Find Element" + oSelect.getFirstSelectedOption().getText());
      highlightElement(DebtorEnquiries.drpdnTypeOfDebtor);
    }

  }

  public static void verifyNegativeAmount(WebElement element, String amount)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    // String amount = DebtorsVouchers.getAmount();
    String expected = "-£" + amount;
    String actual = element.getText();
    if (actual.equalsIgnoreCase(expected)) {
      highlightElement(element);
      log.info(KEYWORD_PASS + "Amount Matched");
    } else {
      log.info(KEYWORD_FAIL + "Amount Not Matched");
    }
  }

  
  
  public static void verifyCreditsAmount(String amount) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    verifyNegativeAmount(DebtorEnquiries.lbldbcreditsColumn, amount);
  }

  public static void verifyCreditAmount(String amount) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    verifyNegativeAmount(DebtorEnquiries.lbldbcreditsColumn, amount);
  }
  public static void verifyPayAdjAmount() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    verifyNegativeAmount(DebtorEnquiries.lbldbPayAdjColumn, DebtorPaymentsWorkflow.getDBAmount());
  }

  public static void verifyOutstandingAmount(String data)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    verifyNegativeAmount(DebtorEnquiries.lblOutstandingAmt, data);
  }

  public static void createUnallocatedManualPaymentForDebtorEnquiries(
      String uniqueMaintenanceNumber, String transcode, String lblRef1, String lblRef2,
      String updatedlblRef1, String updatedlblRef2, String amount, String paymentMethod,
      String comment, String status) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    searchText(testdataprop.getProperty("searchdbpayments"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbpayments"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchdbmanualpayments"));
    waitforPanelLoad();
    validateMessage(DebtorEnquiries.lblForReferenceOne, lblRef1);
    String label = DebtorEnquiries.lblForReferenceTwo.getText();
    if (label.equalsIgnoreCase(lblRef2)) {
      highlightElement(DebtorEnquiries.lblForReferenceTwo);
      log.info(KEYWORD_PASS + "Find element ");
    } else {
      log.info(KEYWORD_FAIL + "Cannot find element ");
    }
    DebtorEnquiries.setTransactionCode(transcode);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    validateMessage(DebtorEnquiries.lblForReferenceOne, updatedlblRef1);
    label = DebtorEnquiries.lblForReferenceTwo.getText();
    if (label.equalsIgnoreCase(updatedlblRef2)) {
      highlightElement(DebtorEnquiries.lblForReferenceTwo);
      log.info(KEYWORD_PASS + "Find element ");
    } else {
      log.info(KEYWORD_FAIL + "Cannot find element ");
    }
    DebtorEnquiries.setTxtDebtorNumber(uniqueMaintenanceNumber);
    DebtorEnquiries.setAmount(amount);
    String currentDate =
        GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle = driver.getWindowHandle();
    DebtorEnquiries.clickDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    DebtorEnquiries.clickGLDate();
    DebtorsVouchersWorkflow.selectDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    DebtorEnquiries.setPaymentMethod(paymentMethod);
    DebtorEnquiries.setComment(comment);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    paymentNo = DebtorEnquiries.getReferenceOne();
    alternatePaymentNo = DebtorEnquiries.getReferenceTwo();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("complete"));
    waitforPanelLoad();
  }

  public static void createUnauthorisedUnallocatedManualPaymentForDebtorEnquiries(
      String uniqueMaintenanceNumber, String transcode, String lblRef1, String lblRef2,
      String updatedlblRef1, String updatedlblRef2, String amount, String paymentMethod,
      String comment, String status) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    searchText(testdataprop.getProperty("searchdbpayments"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbpayments"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchdbmanualpayments"));
    waitforPanelLoad();
    validateMessage(DebtorEnquiries.lblForReferenceOne, lblRef1);
    String label = DebtorEnquiries.lblForReferenceTwo.getText();
    if (label.equalsIgnoreCase(lblRef2)) {
      highlightElement(DebtorEnquiries.lblForReferenceTwo);
      log.info(KEYWORD_PASS + "Find element ");
    } else {
      log.info(KEYWORD_FAIL + "Cannot find element ");
    }
    DebtorEnquiries.setTransactionCode(transcode);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    validateMessage(DebtorEnquiries.lblForReferenceOne, updatedlblRef1);
    label = DebtorEnquiries.lblForReferenceTwo.getText();
    if (label.equalsIgnoreCase(updatedlblRef2)) {
      highlightElement(DebtorEnquiries.lblForReferenceTwo);
      log.info(KEYWORD_PASS + "Find element ");
    } else {
      log.info(KEYWORD_FAIL + "Cannot find element ");
    }
    DebtorEnquiries.setTxtDebtorNumber(uniqueMaintenanceNumber);
    DebtorEnquiries.setAmount(amount);
    String currentDate =
        GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle = driver.getWindowHandle();
    DebtorEnquiries.clickDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    DebtorEnquiries.clickGLDate();
    DebtorsVouchersWorkflow.selectDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    DebtorEnquiries.setPaymentMethod(paymentMethod);
    DebtorEnquiries.setComment(comment);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    paymentNo = DebtorEnquiries.getReferenceOne();
    alternatePaymentNo = DebtorEnquiries.getReferenceTwo();
    waitforPanelLoad();
  }

  public static void verifyOutstandingTransactionAmtDetails(String table, String actual)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    actual = "£" + actual;
    searchTableColumn(table, actual);
  }

  public static void verifyCreditNoteAndPaymentDetails(String expect, String actual)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    String expectValue = "-£" + expect;
    if (actual.equalsIgnoreCase(expectValue)) {
      log.info(KEYWORD_PASS + "Amount matced ");
    } else {
      log.info(KEYWORD_PASS + "Amount Not matched ");
    }
    verifyNotYetDueAmount(orprop.getProperty("outstandingtransactiontoolstable"), actual);
  }

  public static void setDueDateAsOneMonthOlderDate(String data)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorEnquiries = new DebtorEnquiries(driver);
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    boolean foundCalendar = DebtorVouchersSalesInvoices.Calendarclass.isDisplayed();
    if (foundCalendar) {
      String pastDate = GenUtil.subtractDayOfDateFromCurrentDate(data);
      switchToFrame(orprop.getProperty("dateframe"));
      dateTimePicker(pastDate, DebtorVouchersSalesInvoices.calDateClass,
          DebtorVouchersSalesInvoices.calDrpDnMonth, DebtorVouchersSalesInvoices.calDrpDnYear);
    }
  }

  public static String getAmount() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    String amount = null;
    amount = getRandomWebElementText(msgprop.getProperty("lblamount"));
    return amount;
    /*
     * waitforPanelLoad(); objDebtorsVouchers = new DebtorsVouchers(driver); boolean found = false;
     * String amount = null; while (!found) { waitforPanelLoad(); found =
     * DebtorsVouchers.txtAmount.isDisplayed(); } if (found) {
     * highlightElement(DebtorsVouchers.txtAmount); amount =
     * DebtorsVouchers.txtAmount.getAttribute("value"); found = true; } return amount;
     */
  }
  
  public static void verifyAmountorBalance(String expectedDetails, String value)       
      throws InterruptedException, FileNotFoundException {      
    objDebtorEnquiries = new DebtorEnquiries(driver);       
    String nxtToken = null;     
    String amount = DebtorEnquiries.getGridValue();     
    String expDetails = expectedDetails + ":";      
    StringTokenizer tr = new StringTokenizer(amount, " ");      
    while (tr.hasMoreTokens()) {        
      nxtToken = tr.nextToken();        
          
      if (nxtToken.equalsIgnoreCase(expDetails.trim()))        
      {     
        nxtToken = tr.nextToken();      
        if (nxtToken.equalsIgnoreCase(value.trim()))       
        {       
          log.info(KEYWORD_PASS+"Amount matched");
          break;
        }       
        else        
        {       
          log.info(KEYWORD_FAIL+"Amount Not matched");       
        }       
      }      
    }       
  }
  
  public static String getSumAmount() throws FileNotFoundException, InterruptedException {
    Double dbAuthorizeAmount = Double.parseDouble(dbAuthorisedDBInvoiceAmount);
    Double dbunAuthorizeAmount = Double.parseDouble(dbUnauthorisedDBInvoiceAmount);
    Double sumAmount = dbAuthorizeAmount + dbunAuthorizeAmount;
    log.info("sumAmount:" + sumAmount);
    String amnt = "£" + sumAmount;
    return amnt;
  }

  /*
   * public static String getTextAmount() throws FileNotFoundException, InterruptedException {
   * waitforPanelLoad(); String amount = null; amount =
   * getRandomWebElementText(msgprop.getProperty("lblamount"), orprop.getProperty("txtspanvalue"));
   * return amount; }
   */

}// end of class
