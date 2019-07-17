package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsEnquiriesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;

public class DebtorsEnquiries64658 extends DebtorsEnquiriesWorkflow {

  @Test(groups = {"smoke"})
  public void viewtheDBFilteredTransactionsEnquiryOutstandingTransactions()
      throws InterruptedException, ParseException, IOException {
    // Create Debtor
    uniqueMaintenanceNumber = DebtorMaintenanceWorkflow.createDebtor();
    // Debtor - Create DB Invoice
    String dbInvoice = DebtorsVouchersWorkflow.createDBInvoice();
    // Debtor - Create Unauthorised DB Invoice
    String unauthorisedDBInvoice = DebtorsVouchersWorkflow.createUnauthorisedDBInvoice();
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
    // Click on the Total Value of the Outstanding transactions
    click(getRandomWebElement(msgprop.getProperty("lbltotaloutstandinginvoices"),
        orprop.getProperty("unnauthorisedinvoices")));

    // Verify the Reference 1 of the both the Invoices in the grid
    searchTableColumn(orprop.getProperty("findinvoicetable"), dbInvoice);
    searchTableColumn(orprop.getProperty("findinvoicetable"), unauthorisedDBInvoice);
    // Verify the Amount of both the transactions in the grid
    searchTableColumn(orprop.getProperty("findinvoicetable"), getPoundAmount(dbInvoiceAmount));
    searchTableColumn(orprop.getProperty("findinvoicetable"), getPoundAmount(dbInvoiceAmount));
    // Verify the Amount above the grid = Sum of the values under the Column Amount in the grid
    verifyAmountorBalance(msgprop.getProperty("lblamount"),
        DebtorsEnquiriesWorkflow.getSumAmount());
    // Verify the Balance above the grid = Sum of the values under the Balance Amount in the grid
    verifyAmountorBalance(msgprop.getProperty("lblbalance"),
        DebtorsEnquiriesWorkflow.getSumAmount());
    // Verify the status of one invoice(created in step 2) will be 'Authorised' and other(created in
    // step 3) will not be 'Authorised'
    searchTableColumn(orprop.getProperty("findinvoicetable"),
        testdataprop.getProperty("authorise"));
    searchTableColumn(orprop.getProperty("findinvoicetable"), testdataprop.getProperty("entered"));
    // Click on the Home Link
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
