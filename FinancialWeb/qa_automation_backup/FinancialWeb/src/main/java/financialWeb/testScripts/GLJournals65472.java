package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import financialWeb.workflow.GLJournalsWorkflow;

public class GLJournals65472 extends GLJournalsWorkflow{
  
  @Test(groups = {"smoke"})
  public void  maintainingStandardJournals() throws InterruptedException, ParseException, IOException, URISyntaxException {
 
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    
   journalNumber = createStandardJournal();
   clickHrefLink(testdataprop.getProperty("home"));
   //maintaing standard journals
   searchText(testdataprop.getProperty("searchglstandardjournal"));
   searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchglstandardjournal"));
   setJournalNo(journalNumber);
   callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
   callEvent(orprop.getProperty("button"),testdataprop.getProperty("auditinfo"));
   validateTableColumns(orprop.getProperty("auditinfotab"), testdataprop.getProperty("auditinfopopuptabs"));
   searchTableColumn(orprop.getProperty("auditinfocreatedtabtable"),journalNumber);
   searchTableColumn(orprop.getProperty("auditinfocreatedtabtable"),testdataprop.getProperty("departmentandsection"));
   closeAuditInfoPopup();
   clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }
}
