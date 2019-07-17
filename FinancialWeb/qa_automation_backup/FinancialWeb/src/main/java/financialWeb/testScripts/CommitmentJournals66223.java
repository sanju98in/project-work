package financialWeb.testScripts;
import org.testng.annotations.Test;
import financialWeb.workflow.CommitementJournalsWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;

public class CommitmentJournals66223 extends CommitementJournalsWorkflow{

  @Test(groups = {"smoke"})
  public void  verifyTheCommitmentLinesOfReversalCommitment() throws Exception {

    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();

    journalNumber = createStandardCommitements();
    txtJournalNoToRvrs = createReversalCommitments(journalNumber);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("lineenquiry"));
    searchTableColumn(orprop.getProperty("dbageddebtenquirydeptleveltable"), txtJournalNoToRvrs);
    searchTableColumn(orprop.getProperty("dbageddebtenquirydeptleveltable"), testdataprop.getProperty("gldebit"));
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }
}
