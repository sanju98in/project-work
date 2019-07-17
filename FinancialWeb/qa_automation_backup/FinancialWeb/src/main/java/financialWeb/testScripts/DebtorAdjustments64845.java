package financialWeb.testScripts;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorAdjustmentsWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;

public class DebtorAdjustments64845 extends DebtorAdjustmentsWorkflow {

 @Test(groups = {"smoke"})
  public void findPaymentReversalbysearchfunctionality()
      throws InterruptedException, ParseException, IOException, URISyntaxException {
    // Create Debtor
    uniqueDebtorNumber = DebtorMaintenanceWorkflow.createDebtor();
    // Debtor - Create Unallocated Payment Reversal
    adjustmentNumber = getAdjustmentNumber(uniqueDebtorNumber);
    // Enter 'DB Adjustments' in the search text box and click on GO
    searchText(testdataprop.getProperty("searchdbadjustments"));
   // Navigate to DB Adjustments 
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbadjustments"));
    // DB Payment Reversals
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchdbDBpaymentreversals"));
  
    // Click on the search box(...) next to Reference1
    clickReference1();
    //Enter the Debtor Number, Reference 1(Adjustment No) and today's date in Transaction date From and To
    dbFindAdjustment(uniqueDebtorNumber, adjustmentNumber);
    // Click on Submit button
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    
    searchTableColumn(orprop.getProperty("debtorenquirytable"),uniqueDebtorNumber);
    searchTableColumn(orprop.getProperty("debtorenquirytable"),adjustmentNumber);
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
