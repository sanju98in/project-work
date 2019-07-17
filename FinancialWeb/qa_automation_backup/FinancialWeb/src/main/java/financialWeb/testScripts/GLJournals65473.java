package financialWeb.testScripts;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import financialWeb.workflow.GLJournalsWorkflow;

public class GLJournals65473 extends GLJournalsWorkflow {

  @Test(groups = {"smoke"})
  public void createReversalJournals()
      throws InterruptedException, ParseException, IOException, URISyntaxException {
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    createStandardJournalwithReversalJournal();
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
