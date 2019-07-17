package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import financialWeb.workflow.GLJournalsWorkflow;
import util.GenUtil;

public class GLJournals65464 extends GLJournalsWorkflow{

  @Test(groups = {"smoke"})
  public void  findJournalHeader() throws InterruptedException, ParseException, IOException, URISyntaxException {
    
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    
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
    validateStandardJournalStatus(testdataprop.getProperty("authorisedcreditorstatus"));

    //find Journal Header
    searchJournalHeader(journalNumber);
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }
}
