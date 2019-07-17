package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsEnquiriesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;

public class DebtorsEnquiries64656 extends DebtorsEnquiriesWorkflow {

  @Test(groups = {"smoke"})
  public void viewtheDBFilteredTransactionsEnquiryAuthorisedTransactions()
      throws InterruptedException, ParseException, IOException {

    // Create Debtor
    uniqueMaintenanceNumber = DebtorMaintenanceWorkflow.createDebtor();
    // Debtor - Create authorised DB Invoice
    String unauthorisedDBInvoice = DebtorsVouchersWorkflow.createDBInvoice();
    // Enter 'DB Enquiries' in the search text box and click on Go
    searchText(testdataprop.getProperty("searchdbenquiry"));
    // Navigate to DB Enquiries >> DB Details Enquiry
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbenquiry"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchdbdetailsenquiries"));
    waitforPanelLoad();

    // Enter the Debtor Number(saved in shared steps) and click on Submit
    setRandomWebElementValue(msgprop.getProperty("lbldebtornumber"), uniqueMaintenanceNumber);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    // Click on the Total Value of the authorised transactions
    click(getRandomWebElement(msgprop.getProperty("lblauthorisedinvoices"),
        orprop.getProperty("unnauthorisedinvoices")));

    // Verify the Reference 1 of the the Invoice in the grid
     searchTableColumn(orprop.getProperty("findinvoicetable"), unauthorisedDBInvoice);
    // Verify the Amount of the transaction in the grid
    searchTableColumn(orprop.getProperty("findinvoicetable"), getPoundAmount(dbInvoiceAmount));
    // Verify the Amount above the grid = Sum of the values under the Column Amount in the grid
    verifyAmountorBalance(msgprop.getProperty("lblamount"), getPoundAmount(dbInvoiceAmount));
    // Verify the Balance above the grid = Sum of the values under the Balance Amount in the grid
    verifyAmountorBalance(msgprop.getProperty("lblbalance"), getPoundAmount(dbInvoiceAmount));
    // Verify the Status should not be 'Authorised'
    searchTableColumn(orprop.getProperty("findinvoicetable"),
        testdataprop.getProperty("authorise"));
    // Click on the Home Link
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
