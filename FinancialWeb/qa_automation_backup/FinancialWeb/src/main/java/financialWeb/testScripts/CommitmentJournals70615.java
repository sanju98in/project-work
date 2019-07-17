package financialWeb.testScripts;

import org.testng.annotations.Test;
import financialWeb.workflow.CommitementJournalsWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;

public class CommitmentJournals70615 extends CommitementJournalsWorkflow {


  @Test(groups = {"smoke"})
  public void findReversalCommitmentUsingSearchFunctionality() throws Exception {

    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    
    journalNumber = createStandardCommitements();
    txtJournalNoToRvrs = createReversalCommitments(journalNumber);
    
    searchText(testdataprop.getProperty("searchglrvrslcommitment"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchglrvrslcommitment"));
    waitforPanelLoad();
    findJournalNo();
    setRandomWebElementValue(msgprop.getProperty("lbljournalnumber"), txtJournalNoToRvrs);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    waitforPanelLoad();
    searchAndClickAnchorTextInTableColumn(orprop.getProperty("dbageddebtenquirydeptleveltable"), txtJournalNoToRvrs);
    waitforPanelLoad();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("clear"));
    // Click on Home link
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
