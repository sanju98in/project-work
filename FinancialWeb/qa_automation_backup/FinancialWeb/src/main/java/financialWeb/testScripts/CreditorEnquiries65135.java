package financialWeb.testScripts;

import org.testng.annotations.Test;
import financialWeb.workflow.CreditorEnquiriesWorkflow;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.DebtorChargeCodeMaintenanceWorkflow;


public class CreditorEnquiries65135 extends CreditorEnquiriesWorkflow {

  @Test(groups = {"smoke"})
  public void creditorEnquiry() throws Exception {

    uniqueMaintenanceNumber = CreditorMaintenanceWorkflow.createCreditor();
    searchText(testdataprop.getProperty("searchcrfindcreditor"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchcrfindcreditor"));
    DebtorChargeCodeMaintenanceWorkflow.setDBfindChargeCode(uniqueMaintenanceNumber);
    CreditorMaintenanceWorkflow.setCreditorName(testdataprop.getProperty("name"));
    CreditorMaintenanceWorkflow.setCreditorAddress(testdataprop.getProperty("updatedefaultadd"));
    CreditorMaintenanceWorkflow
        .setCreditorPostCode(testdataprop.getProperty("updatedefaultpostcode"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    searchTableColumn(orprop.getProperty("finddebtorstable"), testdataprop.getProperty("name"));
    searchTableColumn(orprop.getProperty("finddebtorstable"), uniqueMaintenanceNumber);
    searchTableColumn(orprop.getProperty("finddebtorstable"),
        testdataprop.getProperty("updatedefaultadd"));
    searchTableColumn(orprop.getProperty("finddebtorstable"),
        testdataprop.getProperty("updatedefaultpostcode"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("clear"));
    clickHrefLink(testdataprop.getProperty("home"));

    // signOut
    clickSignOut();
  }

}
