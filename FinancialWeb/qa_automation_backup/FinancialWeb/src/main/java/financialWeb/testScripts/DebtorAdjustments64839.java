package financialWeb.testScripts;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorAdjustmentsWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;

public class DebtorAdjustments64839 extends DebtorAdjustmentsWorkflow {

  @Test(groups = {"smoke"})
  public void createReversePaymentwithoutAuthorisationbySupervisor()
      throws InterruptedException, ParseException, IOException, URISyntaxException {
    uniqueDebtorNumber = DebtorMaintenanceWorkflow.createDebtor();
    
    getAdjustmentNumber(uniqueDebtorNumber);
   
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
