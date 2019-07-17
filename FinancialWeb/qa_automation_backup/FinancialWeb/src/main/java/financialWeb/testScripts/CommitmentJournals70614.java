package financialWeb.testScripts;

import org.testng.annotations.Test;
import financialWeb.workflow.CommitementJournalsWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;

public class CommitmentJournals70614 extends CommitementJournalsWorkflow {


  @Test(groups = {"smoke"})
  public void findStandardCommitmentUsingSearchFunctionality() throws Exception {

    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    
    journalNumber = createStandardCommitements();
    searchText(testdataprop.getProperty("searchglstdcommitment"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchglstdcommitment"));
    waitforPanelLoad();
    clickFindButton(orprop.getProperty("findjournalno"));
    setRandomWebElementValue(msgprop.getProperty("lbljournalnumber"), journalNumber);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    waitforPanelLoad();
    searchAndClickAnchorTextInTableColumn(orprop.getProperty("tbldbfindcrnotegrid"), journalNumber);
    waitforPanelLoad();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("clear"));
    // Click on Home link
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
