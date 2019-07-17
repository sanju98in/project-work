package financialWeb.testScripts;

import org.testng.annotations.Test;
import financialWeb.workflow.CommitementJournalsWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import util.GenUtil;

public class CommitmentJournals66222 extends CommitementJournalsWorkflow {


  @Test(groups = {"smoke"})
  public void creatingReversalCommitments() throws Exception {

    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    //GL - Create Standard commitments
    journalNumber = createStandardCommitements();
    //In the search box enter 'GL Reversal Commitment' and click on 'Go' button 
    searchText(testdataprop.getProperty("searchglrvrslcommitment"));
    //Click on 'GL Reversal Commitment'
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchglrvrslcommitment"));
    waitforPanelLoad();
    //From Transaction drop down select 'Comm Rev(Commitment reversal journal) and Click on 'Load' button
    selectRandomWebElementDrpDwn(msgprop.getProperty("lbltransaction"),testdataprop.getProperty("commitmentreversal"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    //Select today's date in Date
    String currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    setGLReversalCommitmentDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
   //Enter Narrative - 'testing notes for this journal'
    randomValue = getRandomString();
    setRandomWebElementValue(msgprop.getProperty("narrative"), randomValue);
    //Click on 'Reversal' button in bottom (wait for atleast 10 sec)
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("reversal"));
    setRandomWebElementValue(msgprop.getProperty("lbljournalnumber"), journalNumber);
    waitforPanelLoad();
    //Enter the Journal No( saved in shared steps) and Click on 'Submit' button
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    //Click on Journal Number in the list and Verify the field 'Journal No to Reverse'   
    searchAndClickAnchorTextInTableColumn(orprop.getProperty("tbldbfindcrnotegrid"), journalNumber);
    //Click on 'Insert' button
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    //Verify the first journal line has amount value 50.00 in Credit column
     searchTableColumn(orprop.getProperty("dbageddebtenquirydeptleveltable"),getPoundAmount(testdataprop.getProperty("gldebit")));
     //Verify the second journal line has amount value 50.00 in Debit column
     searchTableColumn(orprop.getProperty("dbageddebtenquirydeptleveltable"),getPoundAmount(testdataprop.getProperty("gldebit")));
   //Verify the state 'Entered' 
    validateRandomWebElementdrpdwn(msgprop.getProperty("lblstatus"),testdataprop.getProperty("defaultcreditorstatus"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("complete"));
    validateRandomWebElementdrpdwn(msgprop.getProperty("lblstatus"),testdataprop.getProperty("authorisedcreditorstatus"));
    waitforPanelLoad();
    txtJournalNoToRvrs = getRandomWebElementValue(msgprop.getProperty("lbljournalnumber"));
    // Click on Home link
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
