package financialWeb.testScripts;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorAdjustmentsWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorPaymentsWorkflow;
import financialWeb.workflow.DebtorsCreditNotesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;

public class DebtorAdjustments64843 extends DebtorAdjustmentsWorkflow {

  @Test(groups = {"smoke"})

  public void partlyAllocateReversePaymenttoanunallocatedCreditNote()
      throws InterruptedException, ParseException, IOException, URISyntaxException {
    // Create Debtor
   uniqueDebtorNumber = DebtorMaintenanceWorkflow.createDebtor();

    //Create unallocated DB CreditNote
    DebtorsCreditNotesWorkflow.createDBCreditNote();
    
    searchText(testdataprop.getProperty("searchdbadjustments"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbadjustments"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchdbDBpaymentreversals"));
    verifyLabelName(msgprop.getProperty("lblreference1"), msgprop.getProperty("lblReference2"));
    selectRandomWebElementDrpDwn(msgprop.getProperty("lbltransactioncode"),
        testdataprop.getProperty("reversalpaymenttrancode"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    setRandomWebElementValue(msgprop.getProperty("lbldebtornumber"), uniqueDebtorNumber);
    verifyLabelName(msgprop.getProperty("lbladjustmentnumber"),
        msgprop.getProperty("lblpaymentnumber"));
    setAmount(testdataprop.getProperty("allocatedamount"));
    parentHandle=driver.getWindowHandle();
    selectRandomWebElementCalendarImage(msgprop.getProperty("lbldate"));
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    selectRandomWebElementCalendarImage(msgprop.getProperty("lblgldate"));
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblpaymentmethod"),
        testdataprop.getProperty("cashpaymentmethod"));
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblreasoncode"),
        testdataprop.getProperty("refundreason"));
    setRandomWebElementValue(msgprop.getProperty("lblcomments"),
        testdataprop.getProperty("dbstylemaintenancecomments"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    Thread.sleep(3000);
    //Allocate the Reversal Payment to unallocated Credit Note
    DebtorPaymentsWorkflow.newAllocation();
    setReference1(referenceNo);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submitnewinquiry"));
    searchTableColumn(orprop.getProperty("dbpaymentallocationtable"),referenceNo);
    DebtorsCreditNotesWorkflow.findAndClickCheckbox();
    DebtorPaymentsWorkflow.clickAddToAllocation();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("complete"));

    //Validate Reversal Payment Status
    validateRandomWebElementdrpdwn(msgprop.getProperty("lblstatus"),testdataprop.getProperty("partlyallocatedpaymentreversalstatus"));

    //Validate Outstanding amount
    String allocated=getRandomWebElementText(msgprop.getProperty("lblallocated"));
    String outstanding=getRandomWebElementText(msgprop.getProperty("lbloutstanding"));
    DebtorPaymentsWorkflow.validateOutstandingAmount(outstanding,testdataprop.getProperty("allocatedamount"),allocated);

    //Verify Existing Allocations Table
    searchTableColumn(orprop.getProperty("existingallocationstable"),referenceNo);

    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
