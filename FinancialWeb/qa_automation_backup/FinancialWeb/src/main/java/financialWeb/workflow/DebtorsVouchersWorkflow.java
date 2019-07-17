package financialWeb.workflow;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import financialWeb.pages.DebtorsInvoice;
import financialWeb.pages.DebtorsVouchers;
import financialWeb.pages.CreditorPayments;
import util.GenUtil;

public class DebtorsVouchersWorkflow extends CommonWorkflow {

  static DebtorsVouchers objDebtorsVouchers;
  static DebtorsInvoice objDebtorsInvoice;

  public static void setTransactionCode(String data)
      throws InterruptedException, FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitforPanelElement(DebtorsVouchers.drpdnDBCreditNoteTransCode);
    DebtorsVouchers.setDBCreditNoteTransCode(data);

  }

  protected String getTransactionCode() throws InterruptedException, FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitforPanelElement(DebtorsVouchers.drpdnDBCreditNoteTransCode);
    return DebtorsVouchers.getDBCreditNoteTransCode();
  }

  public static void clickGLDate() throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitforPanelElement(DebtorsVouchers.dtCrSundryGlDate);
    clickElement(DebtorsVouchers.dtCrSundryGlDate);
  }

  protected void validateDBCreditNoteTransCode(String transCode)
      throws InterruptedException, FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitforPanelElement(DebtorsVouchers.drpdnDBCreditNoteTransCode);
    Select oSelect = new Select(DebtorsVouchers.drpdnDBCreditNoteTransCode);
    if (oSelect.getFirstSelectedOption().getText().trim().equalsIgnoreCase(transCode.trim())) {
      highlightElement(oSelect.getFirstSelectedOption());
      log.info(KEYWORD_PASS + " Find element " + oSelect.getFirstSelectedOption().getText());
    } else {
      log.info(KEYWORD_FAIL + " Find element " + oSelect.getFirstSelectedOption().getText());
    }
  }

  protected void validateDBInvoiceAmount(String amt)
      throws InterruptedException, FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    verifyTextAttribute(DebtorsInvoice.txtDBInvoiceAmount, amt);
  }

  protected void validateDBDescription(String desc)
      throws InterruptedException, FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    verifyTextAttribute(DebtorsVouchers.txtDescription, desc);
  }

  protected void validateDBQty(String qty) throws InterruptedException, FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    verifyTextAttribute(DebtorsVouchers.txtQty, qty);
  }

  protected void validateDbCreditLinePrice(String price)
      throws InterruptedException, FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    verifyTextAttribute(DebtorsVouchers.txtPrice, price);
  }

  protected void validateDBCreditLineVat(String vatcode)
      throws InterruptedException, FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    Select oSelect = new Select(DebtorsVouchers.drpdnVatCodex);
    if (oSelect.getFirstSelectedOption().getText().trim().equalsIgnoreCase(vatcode.trim())) {
      highlightElement(oSelect.getFirstSelectedOption());
      log.info(KEYWORD_PASS + " Find element " + oSelect.getFirstSelectedOption().getText());
    } else {
      log.info(KEYWORD_FAIL + " Find element " + oSelect.getFirstSelectedOption().getText());

    }
  }

  public static void setCreditNoteDebtorNumber(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitforPanelElement(DebtorsVouchers.txtDBCreditNoteDebtorNo);
    DebtorsVouchers.setDBCreditNoteDebtorNo(data);
  }

  public static void clickTaxPointDatepicker() throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitforPanelElement(DebtorsVouchers.dtTaxPoint);
    clickElement(DebtorsVouchers.dtTaxPoint);
  }

  public static void clickGLDatepicker() throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitforPanelLoad();
    clickElement(DebtorsVouchers.dtGLDate);
  }

  public static void selectReasonForCredit(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    DebtorsVouchers.setDrpdnReasonForCredit(data);
  }

  public static void setDescription(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    DebtorsVouchers.setDBCreditLineDescription(data);
  }

  public static String getDescription() throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    return DebtorsVouchers.getDBCreditLineDescription();
  }

  public static void setDBCreditLineQty(String data) throws FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    DebtorsVouchers.creditLineQty(data);
  }

  public static String getDBCreditLineQty() throws FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    return DebtorsVouchers.getcreditLineQty();
  }

  public static void setDBCreditLinePrice(String data) throws FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    DebtorsVouchers.CreditLinePrice(data);
  }

  public static String getDBCreditLinePrice() throws FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    return DebtorsVouchers.getCreditLinePrice();
  }

  public static void setDBCreditLineVat(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    DebtorsVouchers.creditLineVat(data);
  }

  public static String getDBCreditLineVat() throws FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    return DebtorsVouchers.getcreditLineVat();
  }

  public static void setDBCreditLineGLCode(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    DebtorsVouchers.setGLCode(data);
  }

  public static void selectDate(String startDate, String parentHandle, String todayDate)
      throws FileNotFoundException, InterruptedException {
    waitForPageLoad();
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitForPageLoad();
    driver.switchTo().frame(DebtorsVouchers.dtFrame);
    click(DebtorsVouchers.lnkTodayDate);
    Thread.sleep(1000);
    switchToParentWindow(parentHandle);
  }

  public static void dbCreditNoteLoad() throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    clickElement(DebtorsVouchers.btnLoad);
  }

  public static String storeReferenceNo() throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitforPanelElement(DebtorsVouchers.txtReference);
    referenceNo = DebtorsVouchers.getReference();
    return referenceNo;
  }

  public static void setDBAuthTransactionReferenceOne(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitforPanelElement(DebtorsVouchers.txtReference);
    DebtorsVouchers.setDBCreditNoteReference(data);

  }

  public static void validateDBCreditNoteAuthorizeStatus(String expected)
      throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    String actuals = DebtorsVouchers.getStatus();
    if (actuals.equalsIgnoreCase(expected)) {
      log.info(KEYWORD_PASS + " Status is " + actuals);
    } else {
      log.info(KEYWORD_FAIL + " Status is " + actuals);
    }
  }

  public static void setDBInvoiceDebtorNumber(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitforPanelElement(DebtorsVouchers.txtDBNumber);
    DebtorsVouchers.setCrCreditNoteNumber(data);
  }

  public static void setDtGlDate() throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    DebtorsVouchers.setDtGlDate();;
  }

  public static String createDBInvoice() throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    objCreditorPayments = new CreditorPayments(driver);
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchcdbinvoice"));
    waitforPanelLoad();
    setTransactionCode(testdataprop.getProperty("inv001transactioncode"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    waitforPanelLoad();
    waitforPanelElement(CreditorPayments.txtCrNumber);
    CreditorPayments.setTxtCrNumber(uniqueMaintenanceNumber);
    String currentDate =
        GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle = driver.getWindowHandle();
    // set tax point data
    DebtorsInvoice.setDBInvoiceGLDate();
    getHandles();
    selectDate(currentDate, parentHandle, testdataprop.getProperty("todaydate"));
    DebtorsVouchers.setDtGlDate();
    selectDate(currentDate, parentHandle, testdataprop.getProperty("todaydate"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addline"));
    setDescription(testdataprop.getProperty("comment"));
    setDBCreditLineQty(testdataprop.getProperty("qty"));
    setDBCreditLinePrice(testdataprop.getProperty("rndtelephonelimit"));
    setDBCreditLineVat(testdataprop.getProperty("vtcode"));
    DebtorsInvoice.setGLCode(testdataprop.getProperty("glcode"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    dbInvoiceAmount = getDBInvoiceAmount();
    dbAuthorisedDBInvoiceAmount = getDBInvoiceAmount();
    validateDBVoucherAmount(dbInvoiceAmount, testdataprop.getProperty("qty"),
        testdataprop.getProperty("rndtelephonelimit"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("complete"));
    referenceNo = storeReferenceNo();
    DebtorsInvoiceWorkflow.validateDBInvoiceAuthorizeStatus(msgprop.getProperty("authorise"));
    return referenceNo;

  }

  public static String getDBInvoiceAmount() throws FileNotFoundException, InterruptedException {
    objDebtorsInvoice = new DebtorsInvoice(driver);
    boolean found = false;
    waitforPanelElement(DebtorsInvoice.txtDBInvoiceAmount);
    String getVal = DebtorsInvoice.txtDBInvoiceAmount.getAttribute("value");
    int size = getVal.length();
    while (!found) {
      if (size <= 0) {
        Thread.sleep(2000);
        waitforPanelLoad();
        getVal = DebtorsInvoice.txtDBInvoiceAmount.getAttribute("value");
        size = getVal.length();

      } else {
        log.info(KEYWORD_PASS + " Amount is " + getVal);
        found = true;
        break;
      }
    }
    return getVal;
  }

  public static String createUnauthorisedDBInvoice()
      throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    objDebtorsInvoice = new DebtorsInvoice(driver);
    objCreditorPayments = new CreditorPayments(driver);
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchcdbinvoice"));
    waitforPanelLoad();
    setTransactionCode(testdataprop.getProperty("inv001transactioncode"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    waitforPanelLoad();
    waitforPanelElement(CreditorPayments.txtCrNumber);
    CreditorPayments.setTxtCrNumber(uniqueMaintenanceNumber);
    String currentDate =
        GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle = driver.getWindowHandle();
    // set tax point data
    DebtorsInvoice.setDBInvoiceGLDate();
    getHandles();
    selectDate(currentDate, parentHandle, testdataprop.getProperty("todaydate"));
    DebtorsVouchers.setDtGlDate();
    selectDate(currentDate, parentHandle, testdataprop.getProperty("todaydate"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addline"));
    setDescription(testdataprop.getProperty("comment"));
    setDBCreditLineQty(testdataprop.getProperty("qty"));
    setDBCreditLinePrice(testdataprop.getProperty("rndtelephonelimit"));
    setDBCreditLineVat(testdataprop.getProperty("vtcode"));
    DebtorsInvoice.setGLCode(testdataprop.getProperty("glcode"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    waitforPanelElement(DebtorsInvoice.txtDBInvoiceAmount);
    String amount = getDBInvoiceAmount();
    dbUnauthorisedDBInvoiceAmount = getDBInvoiceAmount();
    validateDBVoucherAmount(amount, testdataprop.getProperty("qty"),
        testdataprop.getProperty("rndtelephonelimit"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("complete"));
    waitforPanelElement(DebtorsVouchers.txtReference);
    referenceNo = storeReferenceNo();
    return referenceNo;

  }

  public static String createUnauthorisedDBInvoiceForDebtorEnquiries()
      throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    objDebtorsInvoice = new DebtorsInvoice(driver);
    objCreditorPayments = new CreditorPayments(driver);
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchcdbinvoice"));
    waitforPanelLoad();
    setTransactionCode(testdataprop.getProperty("inv001transactioncode"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    waitforPanelLoad();
    waitforPanelElement(CreditorPayments.txtCrNumber);
    CreditorPayments.setTxtCrNumber(uniqueMaintenanceNumber);
    String currentDate =
        GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle = driver.getWindowHandle();
    // set tax point data
    DebtorsInvoice.setDBInvoiceGLDate();
    getHandles();
    selectDate(currentDate, parentHandle, testdataprop.getProperty("todaydate"));
    DebtorsVouchers.setDtGlDate();
    selectDate(currentDate, parentHandle, testdataprop.getProperty("todaydate"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addline"));
    setDescription(testdataprop.getProperty("comment"));
    setDBCreditLineQty(testdataprop.getProperty("qty"));
    setDBCreditLinePrice(testdataprop.getProperty("rndtelephonelimit"));
    setDBCreditLineVat(testdataprop.getProperty("vtcode"));
    DebtorsInvoice.setGLCode(testdataprop.getProperty("glcode"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    waitforPanelElement(DebtorsInvoice.txtDBInvoiceAmount);
    String amount = getDBInvoiceAmount();
    validateDBVoucherAmount(amount, testdataprop.getProperty("qty"),
        testdataprop.getProperty("rndtelephonelimit"));
    // callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    waitforPanelElement(DebtorsVouchers.txtReference);
    referenceNo = storeReferenceNo();
    return referenceNo;

  }

  protected void setInvoice(String data) throws FileNotFoundException, InterruptedException {
    // objDebtorsVouchers = new DebtorsVouchers(driver);
    // waitforPanelElement(DebtorsVouchers.txtInvoice);
    // DebtorsVouchers.setDBCreditNoteInvoice(data);
    waitforPanelLoad();
    setRandomWebElementValue(msgprop.getProperty("lblinvoicenumber"), data);
  }

  public static void validateDBVoucherAmount(String amount, String qty, String price)
      throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitforPanelLoad();
    boolean found = validateAmount(amount, qty, price);
    if (found) {
      log.info(KEYWORD_PASS + " Amount matched ");
      highlightElement(DebtorsVouchers.txtDBInvoiceAmount);
    }
  }

  public static void clickCompleteDBCreditNote()
      throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    DebtorsVouchers.btnCompleteDBCreditNote.click();
    switchandAcceptPopupMessageBox(driver);
  }

  public static void clickAuthorise() throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitforPanelElement(DebtorsVouchers.btnAuthorise);
    DebtorsVouchers.btnAuthorise.click();
    switchandAcceptPopupMessageBox(driver);
  }

  public static void validateDBCreditNoteAmount(String amount, String qty, String price)
      throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    boolean found = validateAmount(amount, qty, price);
    if (found)
      highlightElement(DebtorsVouchers.txtAmount);
    else
      log.info(KEYWORD_FAIL + " Element not found");

  }

  public void setTypeOfSupply(String data) throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    selectDropDown(DebtorsVouchers.drpdnTypeOfSupply, data);
  }

  public void setDBInvoiceTypeOfSupply(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    selectDropDown(DebtorsVouchers.drpdnDBInvoiceTypeOfSupply, data);
  }

  public void setCommentForInvoice(String data) throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    DebtorsVouchers.setTxtCommentForInvoice(data);
  }

  public static String getTypeOfSupply() throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitforPanelElement(DebtorsVouchers.drpdnTypeOfSupply);
    return DebtorsVouchers.getDropdnTypeOfSupply();
  }

  public static String getDBInvoiceTypeOfSupply()
      throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitforPanelElement(DebtorsVouchers.drpdnDBInvoiceTypeOfSupply);
    return DebtorsVouchers.getDropdnDBInvoiceTypeOfSupply();
  }

  public static String getCommentForInvoice() throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    return DebtorsVouchers.getTxtCommentForInvoice();
  }

  protected void validateTypeOfSupply(String data)
      throws InterruptedException, FileNotFoundException {
     WebElement typeofsupply= getRandomWebElement(msgprop.getProperty("lbltypeofsupply"), orprop.getProperty("typeofsupply"));
    boolean found=IsExist(typeofsupply);
    if(found) {
     verifyListSelection(typeofsupply, data);
    }
  }

  protected void validateCommentForInvoice(String data)
      throws InterruptedException, FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    verifyTextAttribute(DebtorsVouchers.txtCommentForInvoice, data);
  }

  // DB Recovery Group
  public static void groupDate() throws InterruptedException, FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    DebtorsVouchers.clickGroupDate();

  }

  public static void setComments(String data) throws InterruptedException, FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    DebtorsVouchers.setRecoveryGroupComment(data);
  }

  public static void selectAllRecoveryGroupCheckBox() throws FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    DebtorsVouchers.selectAllCheckBox();
  }

  public static void validateGroupStatus(String expected)
      throws InterruptedException, FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitForPageLoad();
    waitforPanelElement(DebtorsVouchers.txtGroupStatus);
    validateMessageByTag(DebtorsVouchers.txtGroupStatus, expected);
  }

  public static void insertInvoices() throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitforPanelElement(DebtorsVouchers.btnInsert);
    DebtorsVouchers.insert();
    waitforPanelLoad();
  }

  public static void clickAuthorize() throws InterruptedException, FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    DebtorsVouchers.authorize();
    switchandAcceptPopupMessageBox(driver);
  }

  protected void validateNewTransactionMsg(String data)
      throws InterruptedException, FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    verifyText(DebtorsVouchers.lblWarningMsg, data);
  }

  public static void createDBRecoveryGroup(String oldReferenceNo)
      throws FileNotFoundException, InterruptedException {
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchcdbrevoverygroup"));
    DebtorsCreditNotesWorkflow
        .setCreditLineTransCode(testdataprop.getProperty("tanscodedbrecoverygroup"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    DebtorsCreditNotesWorkflow.setCreditLineDebtorNo(uniqueMaintenanceNumber);
    String currentDate =
        GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle = driver.getWindowHandle();
    DebtorsVouchersWorkflow.groupDate();
    getHandles();
    selectDate(currentDate, parentHandle, testdataprop.getProperty("todaydate"));
    DebtorsVouchersWorkflow.setComments(testdataprop.getProperty("comment"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addinvoices"));
    DebtorsVouchersWorkflow.selectAllRecoveryGroupCheckBox();
    addToRecoveryGroup();
    // callEvent(orprop.getProperty("button"),testdataprop.getProperty("addtorecoverygroup"));
    DebtorsVouchersWorkflow.insertInvoices();
    waitforPanelLoad();
    crNoteReference = DebtorsCreditNotesWorkflow.getRefernece();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("complete"));
    DebtorsVouchersWorkflow.validateGroupStatus(msgprop.getProperty("readyforsupervisor"));
    searchText(testdataprop.getProperty("searchdbauthorise"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbauthorise"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchcdbauthrevoverygroups"));
    waitForPageLoad();
    waitForElementDisappear();
    DebtorsAuthoriseWorkflow.setDBAuthTransactionDebtorNumber(uniqueMaintenanceNumber);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    DebtorsAuthoriseWorkflow.selectAuthorize();
    DebtorsVouchersWorkflow.clickAuthorize();
    waitForPageLoad();
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchcdbrevoverygroup"));
    DebtorsCreditNotesWorkflow.setRefernceOneForDBRecorveryGroup(crNoteReference);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    searchInvoicesInTableColumn(orprop.getProperty("tbleinvoicesrcvrygrp"),
        testdataprop.getProperty("authorisedcreditorstatus"));
  }

  public static void selectChangeRecoveryRoute() throws FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    checkCheckBox(DebtorsVouchers.chkChangeRcvryRoute);
  }

  public static void selectRoute(String data) throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    selectDropDown(DebtorsVouchers.drpdnRoute, data);
    waitforPanelLoad();
  }

  public static void selectStage(String data) throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    selectDropDown(DebtorsVouchers.drpdnStage, data);

  }

  public static void selectDateStage() throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitforPanelElement(DebtorsVouchers.dtStageDate);
    DebtorsVouchers.dtStageDate.click();
  }

  public static void validateProvRoute(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    Select oSelect = new Select(DebtorsVouchers.drpdnProvRoute);
    String actuals = oSelect.getFirstSelectedOption().getText();
    if (actuals.equalsIgnoreCase(data)) {
      log.info(KEYWORD_PASS + " Element Found ");
      highlightElement(DebtorsVouchers.drpdnProvRoute);
    } else {
      log.info(KEYWORD_FAIL + " Element not Found ");
    }
  }

  public static void validateProvStage(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    Select oSelect = new Select(DebtorsVouchers.drpdnProvStage);
    String actuals = oSelect.getFirstSelectedOption().getText();
    if (actuals.equalsIgnoreCase(data)) {
      log.info(KEYWORD_PASS + " Element Found ");
      highlightElement(DebtorsVouchers.drpdnProvStage);
    } else {
      log.info(KEYWORD_FAIL + " Element not Found ");
    }
  }

  public static void selectMessage(String data) throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    DebtorsVouchers.setMessage(data);
  }

  public static void switchToTabDBNotesForRecorveryGroup()
      throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitforPanelElement(DebtorsVouchers.tabDBNotesForRcvryGroup);
    DebtorsVouchers.tabDBNotesForRcvryGroup.click();
  }

  public static void setDebtorInvoice(String data)
      throws FileNotFoundException, InterruptedException {
       setRandomWebElementValue(msgprop.getProperty("lbldebtornumber"), data);
   }

  protected static void addToRecoveryGroup() throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    DebtorsVouchers.btnAddTpRcvryGroup.click();
    waitforPanelLoad();
  }
  
  protected static void existingAllocation(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    List<WebElement> table = driver.findElements(By.xpath(orprop.getProperty("existingallocation")));
    for(WebElement myTable:table) {
      if(myTable.getText().trim().equalsIgnoreCase(data.trim())) {
        highlightElement(myTable);
        log.info(KEYWORD_PASS + " Element find.");
      }else {
        log.info(KEYWORD_FAIL + " Cannot find element.");
      }
    }
  }
  public static String allocateDBCreditNoteToAnInvoiceFully()
      throws FileNotFoundException, InterruptedException {
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchcdbcreditnote"));
    //DebtorsCreditNotesWorkflow.setCreditLineTransCode(testdataprop.getProperty("crnotetransactioncode"));
    selectRandomWebElementDrpDwn(msgprop.getProperty("lbltransactioncode"), testdataprop.getProperty("crnotetransactioncode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    DebtorsCreditNotesWorkflow.setDebtorNumber(uniqueDebtorNumber);
    DebtorsCreditNotesWorkflow.setReverseOverpaymentComment(referenceNo);
    String currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    //DebtorsCreditNotesWorkflow.clickGLDate();
    selectRandomWebElementCalendarImage(msgprop.getProperty("lbltaxpoint"));
    getHandles();
    selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    //DebtorsCreditNotesWorkflow.setDtCrNoteGLDate();
    selectRandomWebElementCalendarImage(msgprop.getProperty("lblgldate"));
    selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    //DebtorsCreditNotesWorkflow.selectReasonForCredit(testdataprop.getProperty("reasonforcredit"));
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblreasonforcredit"), testdataprop.getProperty("reasonforcredit"));
    setRandomWebElementChkbx(msgprop.getProperty("lbltakedetailsfrominvoice"));
    //DebtorsCreditNotesWorkflow.selectTakeDetailsFromInvoice();
    //DebtorsCreditNotesWorkflow.AllocateCreditToInvoice();
    setRandomWebElementChkbx(msgprop.getProperty("allocatecredittoinvoice"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    //Thread.sleep(5000);
    existingAllocation(msgprop.getProperty("existingallocations"));
    //searchTableColumn(orprop.getProperty("tabtable"),msgprop.getProperty("existingallocations"));
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String strDate= formatter.format(date);
    searchTableColumn(orprop.getProperty("existingallocationtabledata"),strDate);
    searchTableColumn(orprop.getProperty("existingallocationtabledata"),referenceNo);
    searchTableColumn(orprop.getProperty("existingallocationtabledata"),msgprop.getProperty("outstandingamount"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    //crNoteReference = storeReferenceNo();
    crNoteReference=getRandomWebElementValue(msgprop.getProperty("lblreference"));
    return crNoteReference;
   }
  
  protected void findReference() throws InterruptedException, FileNotFoundException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitforPanelLoad();
    clickElement(DebtorsVouchers.btnFindReference);
    waitforPanelLoad();
  }
}
