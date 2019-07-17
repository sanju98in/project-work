package financialWeb.workflow;

import java.io.FileNotFoundException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import financialWeb.pages.DebtorsCreditNotes;
import financialWeb.pages.DebtorsVouchers;
import util.GenUtil;

public class DebtorsCreditNotesWorkflow extends CommonWorkflow {

  static DebtorsCreditNotes objDebtorsCreditNotes;
  static DebtorsVouchers objDebtorsVouchers;

  public static void selectCreditReason(String data)
      throws FileNotFoundException, InterruptedException {
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblreasonforcredit"), data);
    // DebtorsCreditNotes.selectDBCreditNoteReasonForCredit(data);
  }

  public static void selectTakeDetailsFromInvoice() throws FileNotFoundException {
    DebtorsCreditNotes.selectInvoice();
  }

  public static void AllocateCreditToInvoice() throws FileNotFoundException {
    DebtorsCreditNotes.selectAllocateInvoice();
  }

  public static void selectReasonForCredit(String data)
      throws FileNotFoundException, InterruptedException {
    DebtorsCreditNotes.selectReasonForCredit(data);
  }

  public static void setDebtorNumber(String data)
      throws FileNotFoundException, InterruptedException {
    DebtorsCreditNotes.setDebtorNumber(data);
    //setRandomWebElementValue(msgprop.getProperty("lbldebtornumber"), data);
  }

  public static String getDBCreditLineAmount(String labelName)
      throws FileNotFoundException, InterruptedException {
    String creditAmount = null;
    WebElement creditNote = getRandomWebElement(labelName, orprop.getProperty("creditnotvalue"));
    boolean found = IsExist(creditNote);
    if (found) {
      creditAmount = creditNote.getText();
    }
    return creditAmount;
  }

  public static String verifyAuthorisedCreditNotesVlues()
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    return DebtorsCreditNotes.getTxtAuthorisedCreditNotes();
  }


  public static void setDtCrNoteGLDate() throws FileNotFoundException, InterruptedException {
    DebtorsCreditNotes.setDtCrNoteGLDate();
  }

  public static void setCreditLineTransCode(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    waitforPanelElement(DebtorsCreditNotes.drpdnTransactionCode);
    DebtorsCreditNotes.setDBCreditLineTransCode(data);
  }

  public static void setTransCode(String data) throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    DebtorsCreditNotes.setDBTransCode(data);
  }

  public static void setCreditLineDebtorNo(String data)
      throws FileNotFoundException, InterruptedException {
    // objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    // waitforPanelElement(DebtorsCreditNotes.txtCreditNoteDebtorNo);
    waitforPanelLoad();
    setRandomWebElementValue(msgprop.getProperty("lbldebtornumber"), data);
    // DebtorsCreditNotes.setDBCreditLineDebtorNumber(data);
  }

  public static void clickTaxPointDate() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    DebtorsCreditNotes.clickDBCreditNoteTaxPointDatepicker();
  }

  public static void clickGLDate() throws FileNotFoundException, InterruptedException {
    DebtorsCreditNotes.clickDBCreditNoteGLDatepicker();
  }

  public static void setDescription(String data)
      throws FileNotFoundException, InterruptedException {
    DebtorsCreditNotes.setDBCreditLineDesc(data);
  }

  public static void setQty(String data) throws FileNotFoundException, InterruptedException {
    DebtorsCreditNotes.setDBCreditLineQty(data);
  }

  public static void setPrice(String data) throws FileNotFoundException, InterruptedException {
    DebtorsCreditNotes.setDBCreditLinePrice(data);
  }

  public static void setVatCodex(String data) throws FileNotFoundException, InterruptedException {
    DebtorsCreditNotes.setDBCreditLineVatCodex(data);
  }

  public static void setGLCode(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    WebElement element = driver.findElement(By.xpath(orprop.getProperty("txtglcode")));
    boolean found = IsExist(element);
    if (found)
      setText(element, data);
  }

  public static String getRefernece() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    Thread.sleep(5000);
    waitforPanelElement(DebtorsCreditNotes.txtCreditNoteReference);
    crNoteReference = DebtorsCreditNotes.getCreditLineReference();
    return crNoteReference;
  }

  public static void setRefernceOne(String referenceNo)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    waitforPanelElement(DebtorsCreditNotes.txtNewCrNoteAllocReferenceOne);
    DebtorsCreditNotes.setCrNoteAllocReferenceOne(referenceNo);
  }

  public static void setRefernceOneForDBRecorveryGroup(String crNoteReference)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    waitforPanelElement(DebtorsCreditNotes.txtCreditNoteReference);
    DebtorsCreditNotes.setCreditLineReference(crNoteReference);
  }


  public static void selectDBNewCrLineAllocationCheckbox()
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    waitforPanelElement(DebtorsCreditNotes.chkAddToAllocation);
    DebtorsCreditNotes.AddToAllocationCheckbox();
  }

  public static void findAndClickCheckbox() throws InterruptedException {
    List<WebElement> htmlTable =
        driver.findElements(By.xpath(orprop.getProperty("tbldbnewcrnotealloc")));
    for (WebElement findCheckboxElement : htmlTable) {
      log.info(findCheckboxElement.getAttribute("type"));
      if (findCheckboxElement.getAttribute("type").equalsIgnoreCase("checkbox")) {
        clickElement(findCheckboxElement);
      }
    }
  }

  public static void validatePartiallyAllocatedStatus(String data) throws FileNotFoundException {
    DebtorsCreditNotes.getStatus(data);
  }

  public static void createDBCreditNote() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchcdbcreditnote"));
    waitforPanelLoad();
    DebtorsCreditNotesWorkflow.setTransCode(testdataprop.getProperty("crnotetransactioncode"));

    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));

    DebtorsVouchers.setDBCreditNoteDebtorNo(uniqueDebtorNumber);
    String currentDate =
        GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle = driver.getWindowHandle();
    DebtorsVouchersWorkflow.clickTaxPointDatepicker();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    DebtorsVouchersWorkflow.clickGLDatepicker();
    DebtorsVouchersWorkflow.selectDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    DebtorsVouchersWorkflow.selectReasonForCredit(testdataprop.getProperty("reasonforcredit"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addline"));
    DebtorsVouchersWorkflow.setDescription(testdataprop.getProperty("dbcreditlinedesc"));
    DebtorsVouchersWorkflow.setDBCreditLineQty(testdataprop.getProperty("qty"));
    DebtorsVouchersWorkflow.setDBCreditLinePrice(testdataprop.getProperty("rndtelephonelimit"));
    DebtorsVouchersWorkflow.setDBCreditLineVat(testdataprop.getProperty("vtcode"));
    DebtorsVouchersWorkflow.setDBCreditLineGLCode(testdataprop.getProperty("glcode"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    //DebtorsVouchersWorkflow.clickCompleteDBCreditNote();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("complete"));
    waitforPanelElement(DebtorsCreditNotes.drpdnDBCrNoteDepartment);
    dbCrNoteDpt = DebtorsCreditNotes.getCreditNoteDeparment();
    dbCrNoteSec = DebtorsCreditNotes.getCreditNoteSection();
    referenceNo = DebtorsVouchersWorkflow.storeReferenceNo();
    amount = DebtorsEnquiriesWorkflow.getAmount();
  }

  public static void clickAdjust() throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    waitforPanelElement(DebtorsCreditNotes.btnAdjust);
    DebtorsCreditNotes.clickDBCreditNoteAdjust();
  }

  public static void clickCancelCreditNotes() throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    waitforPanelElement(DebtorsCreditNotes.btnCancelCreditNote);
    DebtorsCreditNotes.clickDBCreditNoteCancelCreditNote();
  }

  public static void setCancelReason(String data)
      throws FileNotFoundException, InterruptedException {
    waitforPanelElement(DebtorsCreditNotes.btnCancelReason);
    DebtorsCreditNotes.setCreditNoteCancelReason(data);
  }

  public static void selectCancellationDate(String currentDate, String parentHandle,
      String property) throws InterruptedException {
    driver.switchTo().frame(DebtorsVouchers.dtFrame);
    click(DebtorsVouchers.lnkTodayDate);
    switchToParentWindow(parentHandle);
  }

  public static void selectCancellationGLDate(String currentDate, String parentHandle,
      String property) throws InterruptedException, FileNotFoundException {
    driver.switchTo().frame(DebtorsVouchers.dtFrame);
    click(DebtorsVouchers.lnkTodayDate);
    switchToParentWindow(parentHandle);
  }

  public static void clickCancellationDate() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    DebtorsCreditNotes.clickCancellationDate();
  }

  public static void clickCancellationGLDate() throws FileNotFoundException, InterruptedException {
    waitForPageLoad();
    DebtorsCreditNotes.clickCancellationGLDate();
  }

  public static void selectCancellationComment(String data)
      throws FileNotFoundException, InterruptedException {
    DebtorsCreditNotes.setComment(data);
  }

  public static void saveCancellation() throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    waitforPanelElement(DebtorsCreditNotes.btnCancellationSave);
    DebtorsCreditNotes.saveDBAdjustCancelCreditNote();
    waitforPanelLoad();
  }

  public static void validateCancellationFieldsAreDisabled(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);

    validateDisabled(data);
  }

  public static void validateDisabled(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    waitforPanelElement(DebtorsCreditNotes.btnCancellationClose);
    Thread.sleep(2000);
    data = "true";
    String chkCancellationDateIsDisable =
        DebtorsCreditNotes.calCancellationDate.getAttribute("disabled");
    String chkGLDateIsDisable = DebtorsCreditNotes.calCancellationGLDate.getAttribute("disabled");
    String chkCommentIsDisable = DebtorsCreditNotes.txtCancellationComment.getAttribute("disabled");
    if (chkCancellationDateIsDisable.equalsIgnoreCase(data)
        && chkGLDateIsDisable.equalsIgnoreCase(data)
        && chkCommentIsDisable.equalsIgnoreCase(data)) {
      highlightElement(DebtorsCreditNotes.calCancellationDate);
      highlightElement(DebtorsCreditNotes.calCancellationGLDate);
      highlightElement(DebtorsCreditNotes.txtCancellationComment);
      log.info(KEYWORD_PASS + " All fields are disabled ");
    } else {
      log.info(KEYWORD_FAIL + " All fields are not disabled ");
    }
    DebtorsCreditNotes.btnCancellationClose.click();
    waitforPanelLoad();
  }

  public static void validateCancelledStatus(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitforPanelElement(DebtorsVouchers.txtStatus);
    String isCancelled = DebtorsVouchers.getStatus();
    if (isCancelled.equalsIgnoreCase(data)) {
      highlightElement(DebtorsVouchers.txtStatus);
      log.info(KEYWORD_PASS + " Status is cancelled" + isCancelled);
    } else {
      log.info(KEYWORD_FAIL + " Status is not Cancelled" + isCancelled);
    }
  }

  public static void validateCancelledCreditNoteStatus(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitforPanelElement(DebtorsVouchers.txtDBCreditNoteStatus);
    String isCancelled = DebtorsVouchers.getCRNoteStatus();
    if (isCancelled.equalsIgnoreCase(data)) {
      highlightElement(DebtorsVouchers.txtDBCreditNoteStatus);
      log.info(KEYWORD_PASS + " Status is cancelled" + isCancelled);
    } else {
      log.info(KEYWORD_FAIL + " Status is not Cancelled" + isCancelled);
    }
  }

  public static void validateDBCreditNoteEnquiryNumber(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    String crNotNumber = DebtorsCreditNotes.getCreditNoteNumber();
    if (crNotNumber.equalsIgnoreCase(data)) {
      highlightElement(DebtorsCreditNotes.txtCreditNoteNumber);
    }
  }

  public static void setChargeCodeDBCreditLine(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    waitforPanelElement(DebtorsCreditNotes.txtAddLineChargeCode);
    DebtorsCreditNotes.setAddLineChargeCode(data);
  }
  // end of class

  public static String getAmount() throws FileNotFoundException, InterruptedException {
    //objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    waitforPanelLoad();
    
    String amount = getRandomWebElementValue(msgprop.getProperty("lblamount"));
    //getRandomWebElementValue(labelname)
    return amount;
  }

  public static void validateDBCreditNoteStatus(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    waitforPanelElement(DebtorsCreditNotes.txtStatus);
    DebtorsCreditNotes.getStatus(data);

  }

  public static void validateCreditNoteStatus(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    waitforPanelElement(DebtorsVouchers.txtStatus);
    verifyTextAttribute(DebtorsVouchers.txtStatus, data);
  }

  public static String storeReference() throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    return referenceNo = DebtorsCreditNotes.getCreditLineReference();
  }

  public static String storeDBCreditNoteDepartment()
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    return dbCrNoteDpt = DebtorsCreditNotes.getCreditNoteDeparment();
  }

  public static String storeDBCreditNoteSection()
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    return dbCrNoteSec = DebtorsCreditNotes.getCreditNoteSection();
  }

  public static void setAdjustCrNoteTransactionCode(String data)
      throws InterruptedException, FileNotFoundException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    DebtorsCreditNotes.selectDBAdjustCrNoteTransCode(data);
  }

  public static void validateDBAdjustCrNoteDates(String currentDate) throws FileNotFoundException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    verifyTextAttribute(DebtorsCreditNotes.dtDBAdjustCrNoteDate, currentDate);
    verifyTextAttribute(DebtorsCreditNotes.dtDBAdjustCrNoteGLDate, currentDate);
  }

  public static void validateDefaultSelectedBankAccount(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    String bankAccount = DebtorsCreditNotes.getDBAdjustCrNoteBankAccount();
    if (bankAccount.equalsIgnoreCase(data)) {
      log.info(KEYWORD_PASS + " Default bank account select is " + bankAccount);
    } else {
      log.info(KEYWORD_FAIL + " Default bank account select is " + bankAccount);
    }
  }

  public static void selectReverseOverpaymentReason(String data)
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    DebtorsCreditNotes.selectDBAdjustCrNoteReason(data);
  }

  public static void setReverseOverpaymentComment(String data)
      throws InterruptedException, FileNotFoundException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    DebtorsCreditNotes.selectDBAdjustCrNoteComments(data);
  }

  public static String storeDBAdjustCrNoteReferenceOneAndClose()
      throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    boolean found = false;
    waitforPanelElement(DebtorsCreditNotes.btnClose);
    String dbAdjustCrNoteReferenceOne = null;
    found = DebtorsCreditNotes.btnClose.isDisplayed();
    while (!found) {
      found = IsElementDisplayed(DebtorsCreditNotes.btnClose);
      if (found) {
        dbAdjustCrNoteReferenceOne = DebtorsCreditNotes.getDBAdjustCrNoteReferenceOne();
        break;
      }
    }
    if (found) {
      dbAdjustCrNoteReferenceOne = DebtorsCreditNotes.getDBAdjustCrNoteReferenceOne();
      clickElement(DebtorsCreditNotes.btnClose);

    }
    return dbAdjustCrNoteReferenceOne;
  }

  public static void setAdjustCrNoteNewDept(String data)
      throws InterruptedException, FileNotFoundException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    DebtorsCreditNotes.selectDBAdjustCrNoteAddNewDept(data);
  }

  public static void setAdjustCrNoteNewSect(String data)
      throws InterruptedException, FileNotFoundException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    DebtorsCreditNotes.selectDBAdjustCrNoteNewSect(data);
  }

  public static void validateUpdateDataOnDBCreditNote(String actual, String expected)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    if (actual.trim().equalsIgnoreCase(expected.trim())) {
      log.info(KEYWORD_PASS + " data is updated correctly " + expected);
    } else {
      log.info(KEYWORD_FAIL + " data is not updated correctly" + expected);
    }
  }

  public static void clickFindReference() throws FileNotFoundException, InterruptedException {
    objDebtorsCreditNotes = new DebtorsCreditNotes(driver);
    DebtorsCreditNotes.selectFindCreditNote();

  }
}
