package financialWeb.workflow;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import financialWeb.pages.CreditorPayments;
import util.GenUtil;

public class CreditorPaymentsWorkflow extends CommonWorkflow {

  static CreditorPayments objCreditorPayments;

  protected void creditorNewPayment(String templateValue, String paymentrunstatusinprogress,
      String paymentrunstatuscomplete) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorPayments = new CreditorPayments(driver);
    boolean found = false;
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    clickHrefLink(testdataprop.getProperty("home"));
    waitForElementDisappear();
    waitforPanelLoad();
    waitForElementDisappear();
    searchText(testdataprop.getProperty("searchcrnewpaymentrun"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchcrnewpaymentrun"));
    CreditorPayments.selectTemplate(templateValue);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String myDate = df.format(new Date()).toString();
    waitforPanelLoad();
    waitforPanelElement(CreditorPayments.txtDueDate);
    validateMessageByTag(CreditorPayments.txtDueDate, myDate);
    validateMessageByTag(CreditorPayments.txtPaymentDate, myDate);
    validateMessageByTag(CreditorPayments.txtGLPostingDate, myDate);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    waitForElementDisappear();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("start"));
    waitForElementDisappear();
    boolean checkTable = false;
    while (!checkTable) {
      waitForElementDisappear();
      waitforPanelLoad();
      waitForElementDisappear();
      waitforPanelElement(CreditorPayments.btnRefresh);
      clickElement(CreditorPayments.btnRefresh);
      waitForElementDisappear();
      Thread.sleep(3000);
      waitforPanelElement(CreditorPayments.btnRefresh);
      clickElement(CreditorPayments.btnRefresh);
      waitForElementDisappear();
      waitforPanelElement(CreditorPayments.btnRefresh);
      waitForElementDisappear();
      Thread.sleep(4000);
      clickElement(CreditorPayments.btnRefresh);
      waitForElementDisappear();
      waitforPanelLoad();
      waitforPanelElement(CreditorPayments.btnRefresh);
      Thread.sleep(2000);
      checkTable = IsElementDisplayed(CreditorPayments.tblProcess);
      if (checkTable) {
        break;
      }
    }

    for (WebElement span : CreditorPayments.lstSpan) {
      if (span.getText().trim().equalsIgnoreCase(paymentrunstatusinprogress.trim())) {
        highlightElement(span);
        callEvent(orprop.getProperty("button"), testdataprop.getProperty("refresh"));
        found = true;
      }
      if (found)
        break;
    }
    found = false;
    while (!found) {
      objCreditorPayments = new CreditorPayments(driver);
      List<WebElement> lstspan = driver.findElements(By.xpath(orprop.getProperty("lstspan")));
      for (WebElement span : lstspan) {
        if (span.isDisplayed()) {
          String isStatusChanged = span.getText().trim();
          log.info(isStatusChanged);
          if (isStatusChanged.trim().equalsIgnoreCase(paymentrunstatuscomplete)) {
            highlightElement(span);
            found = true;
            break;
          } else {
            found = true;
            break;
          }
        }
      }
      if (found)
        break;
    }
    paymentNo = CreditorPayments.getPaymentNo();
  }

  protected static void setTemplatename() throws FileNotFoundException, InterruptedException {
    objCreditorPayments = new CreditorPayments(driver);
    String tmpName = testdataprop.getProperty("payrun").trim()
        + getRandomNumber(testdataprop.getProperty("templatenamelimit"));
    waitforPanelElement(CreditorPayments.txtTemplatename);
    CreditorPayments.setTxtTemplatename(tmpName);
  }


  protected static String getTemplatename() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorPayments = new CreditorPayments(driver);
    return CreditorPayments.getTxtTemplatename();
  }

  protected static void setDueDate() throws FileNotFoundException {
    objCreditorPayments = new CreditorPayments(driver);
    CreditorPayments.setDtDueDate();
  }

  public static void setTransactionCodeForPOInvoice(String templateValue)
      throws FileNotFoundException, InterruptedException {
    objCreditorPayments = new CreditorPayments(driver);
    CreditorPayments.selectTemplate(templateValue);
  }

  protected static void setPaymentDate() throws FileNotFoundException {
    objCreditorPayments = new CreditorPayments(driver);
    CreditorPayments.setDtPaymentDate();
  }

  protected static void setGlPostingDate() throws FileNotFoundException {
    objCreditorPayments = new CreditorPayments(driver);
    CreditorPayments.setDtGlPostingDate();
  }

  protected static void setBankAccount(String data)
      throws FileNotFoundException, InterruptedException {
    objCreditorPayments = new CreditorPayments(driver);
    CreditorPayments.setDrpdnBankAccount(data);
  }

  protected static void setCrPaymentTransCode(String data)
      throws FileNotFoundException, InterruptedException {
    objCreditorPayments = new CreditorPayments(driver);
    waitforPanelElement(CreditorPayments.drpdnCrPaymentTransCode);
    CreditorPayments.setDrpdnCrPaymentTransCode(data);
  }

  protected static void setBankCode(String data)
      throws FileNotFoundException, InterruptedException {
    objCreditorPayments = new CreditorPayments(driver);
    CreditorPayments.setDrpdnBankCode(data);
  }

  protected static void setNoOfInvoicesPerRemittance(String data)
      throws FileNotFoundException, InterruptedException {
    objCreditorPayments = new CreditorPayments(driver);
    CreditorPayments.setTxtNoOfInvoicesPerRemittance(data);
  }

  protected static void setManualPaymentCrNumber(String data)
      throws FileNotFoundException, InterruptedException {
    objCreditorPayments = new CreditorPayments(driver);
    waitforPanelElement(CreditorPayments.txtManualPaymentCrNumber);
    CreditorPayments.setTxtManualPaymentCrNumber(data);
  }

  protected static void setManualPaymentDate() throws FileNotFoundException, InterruptedException {
    objCreditorPayments = new CreditorPayments(driver);
    waitforPanelElement(CreditorPayments.dtManualPaymentDate);
    CreditorPayments.setDtManualPaymentDate();
  }

  protected static void setManualPaymentGlDate()
      throws FileNotFoundException, InterruptedException {
    objCreditorPayments = new CreditorPayments(driver);
    CreditorPayments.setDtManualPaymentGlDate();
  }

  protected static void setExchangeRate(String data)
      throws FileNotFoundException, InterruptedException {
    objCreditorPayments = new CreditorPayments(driver);
    CreditorPayments.setTxtExchangeRate(data);
  }

  protected static void setPaymentAmount(String data)
      throws FileNotFoundException, InterruptedException {
    objCreditorPayments = new CreditorPayments(driver);
    CreditorPayments.setTxtPaymentAmount(data);
  }

  protected static void setVoucherNo(String data)
      throws FileNotFoundException, InterruptedException {
    objCreditorPayments = new CreditorPayments(driver);
    waitforPanelElement(CreditorPayments.txtVoucherNo);
    CreditorPayments.setTxtVoucherNo(data);
  }

  protected static void setTransCodeCheckbox() throws FileNotFoundException, InterruptedException {
    objCreditorPayments = new CreditorPayments(driver);
    waitforPanelElement(CreditorPayments.chkTransCodeCheckbox);
    CreditorPayments.setChkTransCodeCheckbox();
  }

  protected static void verifyInProgressCheckbox()
      throws FileNotFoundException, InterruptedException {
    objCreditorPayments = new CreditorPayments(driver);
    waitforPanelElement(CreditorPayments.chkInProgressCheckbox);
    IsCheckBoxSelected(CreditorPayments.chkInProgressCheckbox);
  }

  protected static void checkFinishedCheckbox() throws FileNotFoundException {
    objCreditorPayments = new CreditorPayments(driver);
    CreditorPayments.setChkFinishedCheckbox();
  }

  protected static void checkFailedCheckbox() throws FileNotFoundException {
    objCreditorPayments = new CreditorPayments(driver);
    CreditorPayments.setChkFailedCheckbox();
  }

  protected static void verifyCrPaymentRunControlTableExist()
      throws FileNotFoundException, InterruptedException {
    objCreditorPayments = new CreditorPayments(driver);
    waitforPanelElement(CreditorPayments.tblCrPaymentRunControl);
    validateTableExist(CreditorPayments.tblCrPaymentRunControl);
  }

  protected static void verifyCrPaymentColumnHeaders(String dataSet)
      throws FileNotFoundException, InterruptedException {
    objCreditorPayments = new CreditorPayments(driver);
    StringTokenizer tokenizer = new StringTokenizer(dataSet, ",");
    while (tokenizer.hasMoreTokens()) {
      findTableData(CreditorPayments.lblCrPaymentColumnHeaders, tokenizer.nextToken());
    }
  }

  public static String createCRInvoice(String transCode, String crNumber, String groosAmt,
      String vatAmt, String glCode, String analysisCode, String goodsAmt, String vatCode)
      throws FileNotFoundException, InterruptedException {

    waitforPanelLoad();
    objCreditorPayments = new CreditorPayments(driver);
    searchText(testdataprop.getProperty("searchcrsundryinvoice"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchcrsundryinvoice"));
    waitForElementDisappear();
    waitforPanelLoad();
    waitforPanelElement(CreditorPayments.drpdnTransCode);
    CreditorPayments.setDrpdnTransCode(transCode);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    waitforPanelElement(CreditorPayments.txtCrNumber);
    CreditorPayments.setTxtCrNumber(crNumber);
    String invoiceNumber = getRandomNumber(testdataprop.getProperty("lengthlimit"));
    CreditorPayments.setTxtInvoiceNumber(invoiceNumber);
    CreditorPayments.setTxtGrossAmount(groosAmt);
    CreditorPayments.setTxtVatAmount(vatAmt);
    currentDate =
        GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle = driver.getWindowHandle();
    CreditorPayments.setDtInvoiceDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    DebtorsVouchersWorkflow.clickGLDate();
    DebtorsVouchersWorkflow.selectDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addline"));
    waitforPanelLoad();
    CreditorPayments.setTxtGlCode(glCode);
    CreditorPayments.setTxtAnalysisCode(analysisCode);
    CreditorPayments.setTxtGoodsAmt(goodsAmt);
    CreditorPayments.setDrpdnVatCode(vatCode);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    waitforPanelElement(CreditorPayments.txtVoucherNumber);
    voucherNumber = CreditorPayments.getTxtVoucherNumber();
    validateSundryInvoiceStatus(testdataprop.getProperty("defaultcreditorstatus"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("complete"));
    validateSundryInvoiceStatus(msgprop.getProperty("poinvoicereadyforpayments"));
    DebtorChargeCodeMaintenanceWorkflow.btnClear();
    waitforPanelLoad();
    return voucherNumber;
  }

  protected static void validateSundryInvoiceStatus(String data)
      throws FileNotFoundException, InterruptedException {
    objCreditorPayments = new CreditorPayments(driver);
    waitforPanelElement(CreditorPayments.drpdnSundryInvoiceStatus);
    String actuals = CreditorPayments.getDrpdnSundryInvoiceStatus();
    if (actuals.equalsIgnoreCase(data)) {
      log.info("Pass: Creditor status field value is " + actuals);
      highlightElement(CreditorPayments.drpdnSundryInvoiceStatus);
    } else
      log.info("Fail: Creditor status field value is " + actuals);
  }

  protected static void validateCrManualpaymentStatus(String data)
      throws FileNotFoundException, InterruptedException {
    objCreditorPayments = new CreditorPayments(driver);
    waitforPanelElement(CreditorPayments.drpdnCrManualpaymentStatus);
    String actuals = CreditorPayments.getDrpdnCrManualpaymentStatus();
    if (actuals.equalsIgnoreCase(data)) {
      log.info("Pass: Creditor status field value is " + actuals);
      highlightElement(CreditorPayments.drpdnCrManualpaymentStatus);
    } else
      log.info("Fail: Creditor status field value is " + actuals);
  }

  public static void setUniqueNumber(String data)
      throws InterruptedException, FileNotFoundException {
    objCreditorPayments = new CreditorPayments(driver);
    CreditorPayments.setTxtCrNumber(data);
  }
  // end of class
}
