package financialWeb.testScripts;

import java.io.FileNotFoundException;
import org.testng.annotations.Test;
import financialWeb.workflow.DBReportsWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;

public class DBReports76687 extends DBReportsWorkflow {


  @Test(groups = {"smoke"})
  public void runDBReport() throws FileNotFoundException, InterruptedException {
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    // Create Debtor
    uniqueDebtorNumber = DebtorMaintenanceWorkflow.createDebtor();
    // Create DB Report Style
    reportStyleName = createNewDBReprtStyle();
    // create new Job Number
    createReportJobNumber(reportStyleName, uniqueDebtorNumber);
    // Click on Home link
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
