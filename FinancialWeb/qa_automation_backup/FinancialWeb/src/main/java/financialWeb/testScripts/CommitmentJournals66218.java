package financialWeb.testScripts;
import org.testng.annotations.Test;
import financialWeb.workflow.CommitementJournalsWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;

public class CommitmentJournals66218 extends CommitementJournalsWorkflow{
  
  @Test(groups = {"smoke"})
  public void  verifyTheCommitmentLinesOfStandaradCommitment() throws Exception {
    
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    
    journalNumber = createStandardCommitements();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("lineenquiry"));
    searchTableColumn(orprop.getProperty("tbldbfindcrnotegrid"), journalNumber);
    clickHrefLink(testdataprop.getProperty("home"));
    
    //signOut
    clickSignOut();   
  }
}
