package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import financialWeb.workflow.GLJournalsWorkflow;

public class GLJournals65476 extends GLJournalsWorkflow{
  
  @Test(groups = {"smoke"})
  public void  maintainingPriodicTemplate() throws InterruptedException, ParseException, IOException, URISyntaxException {
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    clickHrefLink(testdataprop.getProperty("home"));
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
    
    searchText(testdataprop.getProperty("searchglpriodictemplate"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchglpriodictemplate"));
    setTemplateNo(journalTemplateNo);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    setRunsRequired(testdataprop.getProperty("noofinvoicesperremittance"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    validateGLJournalStatus(msgprop.getProperty("authorise"));
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }
}
