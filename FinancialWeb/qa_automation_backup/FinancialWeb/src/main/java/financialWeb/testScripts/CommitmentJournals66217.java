package financialWeb.testScripts;
import org.testng.annotations.Test;
import financialWeb.workflow.CommitementJournalsWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;

public class CommitmentJournals66217 extends CommitementJournalsWorkflow{
  
  @Test(groups = {"smoke"})
  public void  createStandardCommitments() throws Exception {
    
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    
    journalNumber = createStandardCommitements();
    clickHrefLink(testdataprop.getProperty("home"));
    
    //signOut
    clickSignOut();   
  }
}
