package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.pages.DebtorMaintenance;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;

public class DebtorMaintenance63956 extends DebtorMaintenanceWorkflow {

  @Test(groups = {"smoke"})
  public void findDebtorUsingSearchFunctionality()
      throws InterruptedException, ParseException, IOException {

    createDebtor();
    clickFindButton(orprop.getProperty("finddebtorno"));
    // callEvent(orprop.getProperty("button"),testdataprop.getProperty("clickdbnumber"));
    setDebtorNumber(uniqueMaintenanceNumber);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    searchAndClickLatestRecordInTable(orprop.getProperty("finddebtorstable"),
        uniqueMaintenanceNumber);
    verifyTextAttribute(DebtorMaintenance.txtFirstName, firstName);
    verifyTextAttribute(DebtorMaintenance.txtAddressLine1, lastName);
    CreditorMaintenanceWorkflow.validateTableData(orprop.getProperty("tableaddress"), addressOne);
    CreditorMaintenanceWorkflow.validateTableData(orprop.getProperty("tableaddress"), postCode);
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
