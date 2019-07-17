package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorPaymentsWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import financialWeb.workflow.GLJournalsWorkflow;


public class GLJournals65474 extends GLJournalsWorkflow{
  
  @Test(groups = {"removedfromv19.5"})
  public void  maintainingReversalJournals() throws InterruptedException, ParseException, IOException, URISyntaxException {
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    clickHrefLink(testdataprop.getProperty("home"));
    journalNumber = createStandardJournalwithReversalJournal();
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
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("auditinfo"));
    DebtorPaymentsWorkflow.searchTabs(orprop.getProperty("auditinfotable"),testdataprop.getProperty("auditinfotabs"));
    searchTableColumn(orprop.getProperty("auditinfocreatedtabtable"),journalNumber);
    searchTableColumn(orprop.getProperty("auditinfocreatedtabtable"),testdataprop.getProperty("departmentandsection"));
    closeAuditInfoPopup();
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }
}
