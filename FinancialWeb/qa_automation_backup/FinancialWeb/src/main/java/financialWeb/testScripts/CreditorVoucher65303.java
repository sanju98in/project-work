package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.CreditorVouchersWorkflow;

public class CreditorVoucher65303 extends CreditorVouchersWorkflow {

  @Test(groups = {"smoke"})
  public void creditorAuditInfo() throws InterruptedException, ParseException, IOException {
    uniqueCreditorNumber = CreditorMaintenanceWorkflow.createCreditor();
    CreditorMaintenanceWorkflow.setCrNumber(uniqueCreditorNumber);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("auditinfo"));
    validateTableColumns(orprop.getProperty("auditinfotab"),
        testdataprop.getProperty("auditinfopopuptabs"));
    validateTableColumns(orprop.getProperty("autditinfofieldtable"),
        testdataprop.getProperty("auditinfopopupfields"));
    closePopup();
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
