package financialWeb.workflow;

import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import financialWeb.pages.CreditorEnquiries;
import financialWeb.pages.DBReports;
import util.GenUtil;

public class CreditorEnquiriesWorkflow extends CommonWorkflow {

  static CreditorEnquiries objCreditorEnquiries;

  public static void setDrpdnDepartment(String data)
      throws InterruptedException, FileNotFoundException {
    objCreditorEnquiries = new CreditorEnquiries(driver);
    CreditorEnquiries.setDrpdnDepartment(data);
  }

  public static void verifyGrossAmt() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objCreditorEnquiries = new CreditorEnquiries(driver);
    amount = "£" + testdataprop.getProperty("amount");
    searchTableColumn(orprop.getProperty("findinvoicetable"), amount);
  }

  public static void setManualPaymentDate() throws FileNotFoundException, InterruptedException {
    objCreditorEnquiries = new CreditorEnquiries(driver);
    CreditorEnquiries.setDtManualPaymentDate();
  }

  public static void setTransactionCode(String data)
      throws FileNotFoundException, InterruptedException {
    objCreditorEnquiries = new CreditorEnquiries(driver);
    CreditorEnquiries.setDrpdnTransactionCode(data);
  }

  public static String getTxtExchangeRate() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorEnquiries = new CreditorEnquiries(driver);
    return CreditorEnquiries.getTxtExchangeRate();
  }
  public static String getTxtAmount() throws FileNotFoundException, InterruptedException {
    //getRandomWebElementValue(msgprop.getProperty("lblamount"));txtAmount
    waitforPanelLoad();
    objCreditorEnquiries = new CreditorEnquiries(driver);
    waitforPanelElement(CreditorEnquiries.txtAmount);
    Thread.sleep(4000);
    return CreditorEnquiries.getTxtAmont();
  }

  public static void setManualPaymentGlDate() throws FileNotFoundException, InterruptedException {
    objCreditorEnquiries = new CreditorEnquiries(driver);
    CreditorEnquiries.setDtManualPaymentGlDate();
  }

  public static void setExchangeRate(String data)
      throws FileNotFoundException, InterruptedException {
    objCreditorEnquiries = new CreditorEnquiries(driver);
    CreditorEnquiries.setTxtExchangeRate(data);
  }

  public static void setCrNumber(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorEnquiries = new CreditorEnquiries(driver);
    waitforPanelElement(CreditorEnquiries.txtCrNumber);
    CreditorEnquiries.setTxtCrNumber(data);
  }

  public static void setPaymentAmount(String data)
      throws FileNotFoundException, InterruptedException {
    objCreditorEnquiries = new CreditorEnquiries(driver);
    CreditorEnquiries.setTxtPaymentAmount(data);
  }

  public static void setTypeOfBankAccount(String data)
      throws FileNotFoundException, InterruptedException {
    objCreditorEnquiries = new CreditorEnquiries(driver);
    CreditorEnquiries.setTxtTypeOfBankAccount(data);
  }

  public static void setBankRefNumber(String data)
      throws FileNotFoundException, InterruptedException {
    objCreditorEnquiries = new CreditorEnquiries(driver);
    CreditorEnquiries.setTxtBankRefNumber(data);
  }

  public static void submitDetails() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objCreditorEnquiries = new CreditorEnquiries(driver);
    waitforPanelElement(CreditorEnquiries.btnSubmit);
    CreditorEnquiries.setBtnSubmit();
    waitforPanelLoad();
  }

  public static void clickBankDetailsTab() throws InterruptedException, FileNotFoundException {
    objCreditorEnquiries = new CreditorEnquiries(driver);
    waitforPanelElement(CreditorEnquiries.lblBankDetailsTab);
    CreditorEnquiries.setLblBankDetailsTab();
  }

  /*
   * public static void clickOkBtnPopup() throws InterruptedException, FileNotFoundException {
   * WebElement ok = driver.findElement(By.xpath(orprop.getProperty("popupok"))); boolean found =
   * IsExist(ok); if (found) { clickElement(ok); } }
   */

  public static String getManualPaymentNo() throws InterruptedException, FileNotFoundException {
    objCreditorEnquiries = new CreditorEnquiries(driver);
    return CreditorEnquiries.getTxtManualPaymentNo();
  }

  public static void validateCrManualpaymentStatus(String data)
      throws FileNotFoundException, InterruptedException {
    objCreditorEnquiries = new CreditorEnquiries(driver);

    String actuals = getRandomWebElementDrpDwn(msgprop.getProperty("lblstatus"));
    StringTokenizer tokenizer = new StringTokenizer(actuals, " ");
    while (tokenizer.hasMoreTokens()) {
      String tokeknVal = tokenizer.nextToken();
      if (tokeknVal.trim().equalsIgnoreCase(data.trim())) {
        log.info(KEYWORD_PASS + " Find : " + tokeknVal);
        break;
      } else
        log.info(KEYWORD_FAIL + " Cannot Find " + tokeknVal);
    }
  }

  public static String payCRInvoice(String transCode, String bankCode, String crNumber,
      String exchangeRate, String paymentAmt, String voucherNo)
      throws InterruptedException, FileNotFoundException {
    objCreditorEnquiries = new CreditorEnquiries(driver);
    searchText(testdataprop.getProperty("searchcrmanualpayment"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchcrmanualpayment"));
    waitforPanelLoad();
    selectRandomWebElementDrpDwn(msgprop.getProperty("lbltransactioncode"), transCode);
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblbankcode"), bankCode);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    waitforPanelLoad();
    setRandomWebElementValue(msgprop.getProperty("lblcreditorno"), crNumber);
    waitforPanelLoad();
    currentDate =
        GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle = driver.getWindowHandle();
    setManualPaymentDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    setManualPaymentGlDate();
    DebtorsVouchersWorkflow.selectDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    setExchangeRate(exchangeRate);
    setPaymentAmount(paymentAmt);

    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("match"));
    setRandomWebElementValue(msgprop.getProperty("lblvouchernumber"), voucherNo);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submitnewquery"));
    CreditorPaymentsWorkflow.setTransCodeCheckbox();
    selectDBStyleFildNmeChkBox(testdataprop.getProperty("addtomatchedpayment"));
    // callEvent(orprop.getProperty("button"),testdataprop.getProperty("addtomatchedpayment"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    validateCrManualpaymentStatus(testdataprop.getProperty("defaultcreditorstatus"));
    waitforPanelElement(CreditorEnquiries.txtManualPaymentNo);
    String crManualPaymentNo = CreditorEnquiries.getTxtManualPaymentNo();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("complete"));
    validateCrManualpaymentStatus(msgprop.getProperty("allocated"));
    return crManualPaymentNo;
  }

  public static void selectDBStyleFildNmeChkBox(String data)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    parentHandle = driver.getWindowHandle();
    objDBStyleMaintenance = new DBReports(driver);
    boolean found;

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

  // end of class
}
