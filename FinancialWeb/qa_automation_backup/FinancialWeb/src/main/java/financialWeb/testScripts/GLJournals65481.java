package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import financialWeb.workflow.GLJournalsWorkflow;

public class GLJournals65481 extends GLJournalsWorkflow{
  
  @Test(groups = {"smoke"})
  public void  findPriodicTemplate() throws InterruptedException, ParseException, IOException, URISyntaxException {
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    clickHrefLink(testdataprop.getProperty("home"));
    journalTemplateNo = createGLPriodicTemplate();
    searchText(testdataprop.getProperty("searchglpriodicjournaltemplate"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchglpriodicjournaltemplate"));
    findTemplateNo(journalTemplateNo);
    selectShowHideTemplateReadyToRun();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    searchTableColumn(orprop.getProperty("finddebtorstablebody"), journalTemplateNo);
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }
}
