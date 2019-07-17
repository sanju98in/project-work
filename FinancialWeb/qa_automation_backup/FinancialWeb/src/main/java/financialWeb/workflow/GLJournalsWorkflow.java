package financialWeb.workflow;

import java.io.FileNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import financialWeb.pages.DebtorVouchersSalesInvoices;
import financialWeb.pages.GLJournals;
import util.GenUtil;

public class GLJournalsWorkflow extends CommonWorkflow {

  public void setDrpdnTransaction(String data)
      throws InterruptedException, FileNotFoundException {
    objGLJournals = new GLJournals(driver);
    selectDropDown(GLJournals.drpdnTransaction, data);
  }
  
  public void setDrpdnReversalJournalTransaction(String data)
      throws InterruptedException, FileNotFoundException {
   objGLJournals = new GLJournals(driver);
    selectDropDown(GLJournals.drpdnRevarsalJournalTransaction, data);
  }

  public void validateStandardJournalDepartment(String data)
      throws FileNotFoundException, InterruptedException {
   objGLJournals = new GLJournals(driver);
    waitforPanelElement(GLJournals.drpdnStandardJournalDepartment);
    String actuals = GLJournals.getDrpdnStandardJournalDepartment();
    if (actuals.equalsIgnoreCase(data)) {
      log.info("Pass: Department field value is " + actuals);
      highlightElement(GLJournals.drpdnStandardJournalDepartment);
    } else
      log.info("Fail: Department field value is " + actuals);
  }

  public void validateStandardJournalSection(String data)
      throws FileNotFoundException, InterruptedException {
   objGLJournals = new GLJournals(driver);
    waitforPanelElement(GLJournals.drpdnStandardJournalSection);
    String actuals = GLJournals.getDrpdnStandardJournalSection();
    if (actuals.equalsIgnoreCase(data)) {
      log.info("Pass: Section field value is " + actuals);
      highlightElement(GLJournals.drpdnStandardJournalSection);
    } else
      log.info("Fail: Section field value is " + actuals);
  }

  protected void clickFindLedgerCode() throws FileNotFoundException, InterruptedException {
   objGLJournals = new GLJournals(driver);
    clickElement(GLJournals.btnFindLedgerCode);
    waitforPanelLoad();
  }
  
  protected void clickStandardJournalDate() throws FileNotFoundException, InterruptedException {
   objGLJournals = new GLJournals(driver);
    clickElement(GLJournals.dtStandardJournalDate);
    Thread.sleep(2000);
  }

  protected static void setStandardJournalLedgerCode(String data)
      throws FileNotFoundException, InterruptedException {
   objGLJournals = new GLJournals(driver);
    //waitforPanelLoad();
    waitforPanelElement(GLJournals.txtFindLedgerCodeDebit);
    setText(GLJournals.txtFindLedgerCodeDebit, data);
    waitforPanelLoad();
  }
  
  protected static void setStandardJournalLedgerCodeCredit(String data)
      throws FileNotFoundException, InterruptedException {
   objGLJournals = new GLJournals(driver);
    waitforPanelLoad();
    waitforPanelElement(GLJournals.txtFindLedgerCodeCredit);
    setText(GLJournals.txtFindLedgerCodeCredit, data);
    waitforPanelLoad();
  }

  protected static void setStandardJournalDebit(String data)
      throws FileNotFoundException, InterruptedException {
   objGLJournals = new GLJournals(driver);
    //waitforPanelLoad();
    waitforPanelElement(GLJournals.txtFindDebit);
    setText(GLJournals.txtFindDebit, data);
    waitforPanelLoad();
  }

  protected static void setStandardJournalCredit(String data)
      throws FileNotFoundException, InterruptedException {
   objGLJournals = new GLJournals(driver);
    waitforPanelLoad();
    waitforPanelElement(GLJournals.txtFindCredit);
    setText(GLJournals.txtFindCredit, data);
    waitforPanelLoad();
  }

  public String validateStandardJournalNumber()
      throws FileNotFoundException, InterruptedException {
   objGLJournals = new GLJournals(driver);
    waitforPanelElement(GLJournals.txtJournalNumber);
    String JournalNumber = GLJournals.getStandardJournalNumber();
    return JournalNumber;
  }

  protected void validateStandardJournalStatus(String data)
      throws FileNotFoundException, InterruptedException {
   objGLJournals = new GLJournals(driver);
    waitForElementDisappear();
    waitforPanelElement(GLJournals.txtStandardJournalStatus);
   validateMessageByTag(GLJournals.txtStandardJournalStatus, data);
  } 
  public void setDrpdnFindTransaction(String data)
      throws InterruptedException, FileNotFoundException {
   objGLJournals = new GLJournals(driver);
    selectDropDown(GLJournals.drpdnFindTransaction, data);
  }

  public void setDrpdnFindJournalType(String data)
      throws InterruptedException, FileNotFoundException {
   objGLJournals = new GLJournals(driver);
    selectDropDown(GLJournals.drpdnFindJournalType, data);
  }
  
  protected void setJournalNumberforReversal(String data)
      throws FileNotFoundException, InterruptedException {
   objGLJournals = new GLJournals(driver);
    waitforPanelLoad();
    waitforPanelElement(GLJournals.txtFindJournalHeaderforReversalNumber);
    setText(GLJournals.txtFindJournalHeaderforReversalNumber, data);
    waitforPanelLoad();
  }
  
  public void validateJournalNoToReverse(String data)
      throws FileNotFoundException, InterruptedException {
   objGLJournals = new GLJournals(driver);
    waitforPanelElement(GLJournals.txtJournaltoReverseNumber);
    String actuals = GLJournals.getJournalNotoReversal();
    if (actuals.equalsIgnoreCase(data)) {
      log.info("Pass: Section field value is " + actuals);
      highlightElement(GLJournals.txtJournaltoReverseNumber);
    } else
      log.info("Fail: Section field value is " + actuals);
  }
  
  protected void validateReversalJournalStatus(String data)
      throws FileNotFoundException, InterruptedException {
   objGLJournals = new GLJournals(driver);
    waitForElementDisappear();
    waitforPanelElement(GLJournals.txtJournaltoReverseStatus);
    reversalJournalStatus = GLJournals.getReversalJournalStatus();
    if (reversalJournalStatus.equalsIgnoreCase(data)) {
      highlightElement(GLJournals.txtJournaltoReverseStatus);
      log.info("Pass: Creditor status field value is " + reversalJournalStatus);
    } else
      log.info("Fail: Creditor status field value is " + reversalJournalStatus);
  }
  
  protected void searchJournalHeader(String journalNumber ) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
   objGLJournals = new GLJournals(driver);
    searchText(testdataprop.getProperty("findjournalheader"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("findjournalheader"));
    setDrpdnFindTransaction(testdataprop.getProperty("gltransactiontype"));
    setDrpdnFindJournalType(testdataprop.getProperty("journaltype"));
    GLJournalsWorkflow.findJournalNumber(journalNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    GLMaintenanceWorkflow.validateGridIsAdded(orprop.getProperty("tablerevoverygroup"),journalNumber.trim());
    waitforPanelLoad();
  }
  
  protected void selectGLJournalHeaderTemplateTransaction(String data) throws FileNotFoundException, InterruptedException {
   objGLJournals = new GLJournals(driver);
   selectDropDown(GLJournals.drpdnJournalTransaction, data);
  }
  
  protected static  void findJournalNumber(String data) throws FileNotFoundException, InterruptedException {
    objGLJournals = new GLJournals(driver);
    setText(GLJournals.txtFindJournalNumber, data);
    waitforPanelLoad();
  }
  
protected void validateGLJournalHeaderTemplateDepartment(String data) throws FileNotFoundException, InterruptedException {
    objGLJournals = new GLJournals(driver);
    Select oSelect = new Select(GLJournals.drpdnDepartment);
    if(oSelect.getFirstSelectedOption().getText().trim().equalsIgnoreCase(data.trim())){
      highlightElement(GLJournals.drpdnDepartment);
      log.info(KEYWORD_PASS + "Dropdown selected option is " + oSelect.getFirstSelectedOption().getText().trim());
      }else {
        log.info(KEYWORD_FAIL + "Dropdown selected option is " + oSelect.getFirstSelectedOption().getText().trim());
    }
  }
  
  protected void validateGLJournalHeaderTemplateSection(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad(); 
    objGLJournals = new GLJournals(driver);
    Select oSelect = new Select(GLJournals.drpdnSection);
    if(oSelect.getFirstSelectedOption().getText().trim().equalsIgnoreCase(data.trim())){
      highlightElement(GLJournals.drpdnSection);
      log.info(KEYWORD_PASS + "Dropdown selected option is " + oSelect.getFirstSelectedOption().getText().trim());
      }else {
        log.info(KEYWORD_FAIL + "Dropdown selected option is " + oSelect.getFirstSelectedOption().getText().trim());
    }
  }
  protected void selectNextDate(String nextDate) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objGLJournals = new GLJournals(driver);
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    parentHandle = driver.getWindowHandle();
    nextDate = GenUtil.additionalDayOfDateFromCurrentDate(nextDate);
    clickElement(GLJournals.dtNextDate);
    switchToFrame(orprop.getProperty("dateframe"));
    dateTimePicker(nextDate,DebtorVouchersSalesInvoices.calDateClass,DebtorVouchersSalesInvoices.calDrpDnMonth,DebtorVouchersSalesInvoices.calDrpDnYear);
    switchToParentWindow(parentHandle);
    waitforPanelLoad();
  }
  
  protected void selectFrequency(String data) throws InterruptedException, FileNotFoundException {
    objGLJournals = new GLJournals(driver);
    selectDropDown(GLJournals.drpdnFrequency, data);
  }
  
  protected void setRunsRequired(String data) throws InterruptedException, FileNotFoundException {
    objGLJournals = new GLJournals(driver);
    waitforPanelElement(GLJournals.txtRunsRequired);
    setText(GLJournals.txtRunsRequired, data);
  }
  
  protected void glJournalHeaderAddNewLine(String fieldLedgerCode,String fieldDebitValue, String ledgerCodeVal,String debitVal) throws FileNotFoundException, InterruptedException {
    objGLJournals = new GLJournals(driver);
    WebElement ledgerCode = driver.findElement(By.xpath(fieldLedgerCode));
    WebElement debitValue = driver.findElement(By.xpath(fieldDebitValue));
    ledgerCode.sendKeys(ledgerCodeVal);
    ledgerCode.sendKeys(Keys.TAB);
    debitValue.sendKeys(debitVal);
    debitValue.sendKeys(Keys.TAB);
  }
  
  protected String validateAndStoreGLJournalTemplateNo() throws FileNotFoundException, InterruptedException{
    objGLJournals = new GLJournals(driver);
    waitforPanelElement(GLJournals.txtTemplate);
    String templateNo = GLJournals.txtTemplate.getAttribute("value");
    if(Integer.parseInt(templateNo) > 0) {
      highlightElement(GLJournals.txtTemplate);
      log.info(KEYWORD_PASS + " Template no is " + templateNo);
    }
    return templateNo;
  }
  
  protected void setTemplateNo(String data) throws FileNotFoundException, InterruptedException{
    objGLJournals = new GLJournals(driver);

    waitforPanelElement(GLJournals.txtTemplate);
    setText(GLJournals.txtTemplate, data);
  }
  
  protected void findTemplateNo(String data) throws FileNotFoundException, InterruptedException{
    objGLJournals = new GLJournals(driver);

    waitforPanelElement(GLJournals.txtFindTemplate);
    setText(GLJournals.txtFindTemplate, data);
  }
  
  protected void selectShowHideTemplateReadyToRun() throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objGLJournals = new GLJournals(driver);
    waitforPanelElement(GLJournals.chkshowHideTemplateReadyToRun);
    unCheckCheckBox(GLJournals.chkshowHideTemplateReadyToRun);
    
  }
  
  protected void validateGLJournalStatus(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objGLJournals = new GLJournals(driver);
    Select oSelect = new Select(GLJournals.drpdnStatus);
     if(oSelect.getFirstSelectedOption().getText().equalsIgnoreCase(data.trim())) {
      highlightElement(GLJournals.drpdnStatus);
      log.info(KEYWORD_PASS + " Status field value is " + oSelect.getFirstSelectedOption().getText());
    }
    else
      log.info(KEYWORD_FAIL + " Status field value is " + oSelect.getFirstSelectedOption().getText());
  }
  
  protected String createGLPriodicTemplate() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objGLJournals = new GLJournals(driver);
    searchText(testdataprop.getProperty("searchglpriodictemplate"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchglpriodictemplate"));
    selectGLJournalHeaderTemplateTransaction(testdataprop.getProperty("gljournalheadertransaction"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    validateGLJournalHeaderTemplateDepartment(msgprop.getProperty("chiefexecutive"));
    validateGLJournalHeaderTemplateSection(msgprop.getProperty("chiefexecutive"));
    parentHandle=driver.getWindowHandle();
    selectNextDate(testdataprop.getProperty("levellimit"));
    selectFrequency(testdataprop.getProperty("daily"));
    setRunsRequired(testdataprop.getProperty("qtyforpim"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addline"));
    glJournalHeaderAddNewLine(orprop.getProperty("ledgercoderowone"),orprop.getProperty("debitvaluerowone"),testdataprop.getProperty("glcode"),testdataprop.getProperty("gldebit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addline"));
    glJournalHeaderAddNewLine(orprop.getProperty("ledgercoderowtwo"),orprop.getProperty("creditvaluerowtwo"),testdataprop.getProperty("glcode"),testdataprop.getProperty("gldebit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    journalTemplateNo = validateAndStoreGLJournalTemplateNo();
    validateGLJournalStatus(msgprop.getProperty("poinvoiceentered"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    validateGLJournalStatus(msgprop.getProperty("authorise"));
    return journalTemplateNo;
  }
  
  protected String createStandardJournalwithReversalJournal() throws FileNotFoundException, InterruptedException {
    
    searchText(testdataprop.getProperty("searchglstandardjournal"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchglstandardjournal"));
    setDrpdnTransaction(testdataprop.getProperty("glstandardjournaltransaction"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    validateStandardJournalDepartment(testdataprop.getProperty("departmentandsection"));
    validateStandardJournalSection(testdataprop.getProperty("departmentandsection"));
    currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    clickStandardJournalDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addline"));
    setStandardJournalLedgerCode(testdataprop.getProperty("glcode"));
    setStandardJournalDebit(testdataprop.getProperty("gldebit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addline"));
    setStandardJournalLedgerCodeCredit(testdataprop.getProperty("glcode"));
    setStandardJournalCredit(testdataprop.getProperty("gldebit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    String journalNumber = validateStandardJournalNumber();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete")); 
    validateStandardJournalStatus(msgprop.getProperty("readyforsupervisor"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete")); 
    validateStandardJournalStatus(msgprop.getProperty("authorise"));
    searchText(testdataprop.getProperty("searchglreversaljournal"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchglreversaljournal"));
    setDrpdnReversalJournalTransaction(testdataprop.getProperty("reversaljournaltransaction"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("reversal"));
    setJournalNumberforReversal(journalNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    searchAndClickLatestRecordInTable(orprop.getProperty("glfindjournalreversaltable"), journalNumber);
    validateJournalNoToReverse(journalNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    validateReversalJournalStatus(testdataprop.getProperty("defaultcreditorstatus"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    validateReversalJournalStatus(testdataprop.getProperty("glreversaljournalstatus"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    validateReversalJournalStatus(testdataprop.getProperty("authorisedcreditorstatus"));
    return journalNumber;
    
  }

  
  
protected String createStandardJournal() throws FileNotFoundException, InterruptedException {
    
    searchText(testdataprop.getProperty("searchglstandardjournal"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchglstandardjournal"));
    setDrpdnTransaction(testdataprop.getProperty("glstandardjournaltransaction"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    validateStandardJournalDepartment(testdataprop.getProperty("departmentandsection"));
    validateStandardJournalSection(testdataprop.getProperty("departmentandsection"));
    currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    clickStandardJournalDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addline"));
    setStandardJournalLedgerCode(testdataprop.getProperty("glcode"));
    setStandardJournalDebit(testdataprop.getProperty("gldebit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addline"));
    setStandardJournalLedgerCodeCredit(testdataprop.getProperty("glcode"));
    setStandardJournalCredit(testdataprop.getProperty("gldebit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    String journalNumber = validateStandardJournalNumber();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete")); 
    validateStandardJournalStatus(msgprop.getProperty("readyforsupervisor"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete")); 
    validateStandardJournalStatus(msgprop.getProperty("authorise"));
    return journalNumber;
    
  }

  
  
  protected void setJournalNo(String data) throws InterruptedException, FileNotFoundException {
    objGLJournals = new GLJournals(driver);
    waitforPanelElement(GLJournals.txtJournalNumber);
    setText(GLJournals.txtJournalNumber, data);
  }
}

// end of class
