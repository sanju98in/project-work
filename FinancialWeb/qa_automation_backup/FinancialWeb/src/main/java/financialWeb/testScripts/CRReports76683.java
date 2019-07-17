package financialWeb.testScripts;

import java.io.FileNotFoundException;
import org.testng.annotations.Test;
import financialWeb.workflow.CRReportsWorkflow;
import financialWeb.workflow.CreditorEnquiriesWorkflow;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.CreditorPaymentsWorkflow;
import financialWeb.workflow.DBReportsWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;

public class CRReports76683 extends DBReportsWorkflow {



  @Test(groups = {"removedfromv19.5"})

  public void verifytheCRJobDetails() throws FileNotFoundException, InterruptedException {

    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();

    // Create Creditor
    uniqueCreditorNumber = CreditorMaintenanceWorkflow.createCreditor();
    // Create CR Invoice
    voucherNumber = CreditorPaymentsWorkflow.createCRInvoice(
        testdataprop.getProperty("sundryinvoicetranscode"), uniqueCreditorNumber,
        testdataprop.getProperty("amount"), testdataprop.getProperty("vatamount"),
        testdataprop.getProperty("glcode"), testdataprop.getProperty("comment"),
        testdataprop.getProperty("amount"), testdataprop.getProperty("vtcode"));
    // Creditor - Manual Payment
    crManualPaymentNo = CreditorEnquiriesWorkflow.payCRInvoice(
        testdataprop.getProperty("crmanualpaymenttranscode"),
        testdataprop.getProperty("crmanualpaymentbankaccount"), uniqueCreditorNumber,
        testdataprop.getProperty("vatamount"), testdataprop.getProperty("amount"), voucherNumber);
    // Create DB Report Style
    reportStyleName = CRReportsWorkflow.createNewCRReprtStyle();
    // Create the Job Details
    dbJobNumber = CRReportsWorkflow.createReportJobNumber(reportStyleName, uniqueCreditorNumber);
    // verify the job number
    CRReportsWorkflow.verifyJobNo(uniqueCreditorNumber, dbJobNumber);
    // Click on Home link
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
