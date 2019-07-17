package financialWeb.workflow;

import java.io.FileNotFoundException;
import financialWeb.pages.CommitmentJournals;
import util.GenUtil;

public class CommitementJournalsWorkflow extends CommonWorkflow{

  static CommitmentJournals objCommitmentJournals;
  
  protected String createStandardCommitements() throws Exception {
  waitforPanelLoad();
  searchText(testdataprop.getProperty("searchglstdcommitment"));
  searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
      testdataprop.getProperty("searchglstdcommitment"));
  waitforPanelLoad();
  selectRandomWebElementDrpDwn(msgprop.getProperty("lbltransaction"),testdataprop.getProperty("commitment"));
  callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
  validateRandomWebElementdrpdwn(msgprop.getProperty("lbldepartment"),testdataprop.getProperty("departmentandsection"));
  validateRandomWebElementdrpdwn(msgprop.getProperty("lblsection"),testdataprop.getProperty("departmentandsection"));

  String currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
  parentHandle=driver.getWindowHandle();
  DebtorsInvoiceWorkflow.setDBInvoiceGLDate();
  getHandles();
  DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
  
  callEvent(orprop.getProperty("button"), testdataprop.getProperty("addline"));
  
  GLJournalsWorkflow.setStandardJournalLedgerCode(testdataprop.getProperty("glcode"));
  GLJournalsWorkflow.setStandardJournalDebit(testdataprop.getProperty("gldebit"));
  setComType(testdataprop.getProperty("order"));
  
  callEvent(orprop.getProperty("button"), testdataprop.getProperty("addline"));

  GLJournalsWorkflow.setStandardJournalLedgerCodeCredit(testdataprop.getProperty("glcode"));
  GLJournalsWorkflow.setStandardJournalCredit(testdataprop.getProperty("gldebit"));
  setComTypeSecondGrid(testdataprop.getProperty("order"));
  
  callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
  journalNumber = getRandomWebElementValue(msgprop.getProperty("lbljournalnumber"));
  callEvent(orprop.getProperty("button"), testdataprop.getProperty("complete"));
  validateRandomWebElementdrpdwn(msgprop.getProperty("lblstatus"),testdataprop.getProperty("authorisedcreditorstatus"));
  
  return journalNumber;
  }
  
  protected String createReversalCommitments(String journalNumber) throws Exception {
    waitforPanelLoad();
    searchText(testdataprop.getProperty("searchglrvrslcommitment"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchglrvrslcommitment"));
    waitforPanelLoad();
    selectRandomWebElementDrpDwn(msgprop.getProperty("lbltransaction"),testdataprop.getProperty("commitmentreversal"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    
    String currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    setGLReversalCommitmentDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    randomValue = getRandomString();
    setRandomWebElementValue(msgprop.getProperty("narrative"), randomValue);
    
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("reversal"));
    setRandomWebElementValue(msgprop.getProperty("lbljournalnumber"), journalNumber);
    waitforPanelLoad();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    searchAndClickAnchorTextInTableColumn(orprop.getProperty("tbldbfindcrnotegrid"), journalNumber);
    
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    txtJournalNoToRvrs = getRandomWebElementValue(msgprop.getProperty("lbljournalnumber"));
    validateRandomWebElementdrpdwn(msgprop.getProperty("lblstatus"),testdataprop.getProperty("defaultcreditorstatus"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("complete"));
    validateRandomWebElementdrpdwn(msgprop.getProperty("lblstatus"),testdataprop.getProperty("authorisedcreditorstatus"));
    waitforPanelLoad();
    return txtJournalNoToRvrs;
  }
  
  protected String getJournalNoToReverse() throws FileNotFoundException, InterruptedException {
    waitForPageLoad();
    objCommitmentJournals = new CommitmentJournals(driver);
    highlightElement(CommitmentJournals.txtJournalNoToRvrs);
    String value =CommitmentJournals.txtJournalNoToRvrs.getAttribute("value");
    return value;
  }
  
  protected void setComType(String data) throws InterruptedException, FileNotFoundException {
    //waitforPanelLoad();
    objCommitmentJournals = new CommitmentJournals(driver);
    selectDropDown(CommitmentJournals.drpdnComType, data);
  }
  
  protected void setComTypeSecondGrid(String data) throws InterruptedException, FileNotFoundException {
   // waitforPanelLoad();
    objCommitmentJournals = new CommitmentJournals(driver);
    selectDropDown(CommitmentJournals.drpdnComTypeScndGrid, data);
  }
  
  protected void setGLReversalCommitmentDate() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCommitmentJournals = new CommitmentJournals(driver);
    clickElement(CommitmentJournals.dtDate);
    Thread.sleep(2000);
  }
  
  protected void findJournalNo() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCommitmentJournals = new CommitmentJournals(driver);
    waitforPanelElement(CommitmentJournals.btnFindJournalNo);
    clickElement(CommitmentJournals.btnFindJournalNo);
    Thread.sleep(6000);
    waitforPanelLoad();
  }
}//end of class
