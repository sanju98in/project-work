package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;

public class CreditorsMaintenance62484 extends CreditorMaintenanceWorkflow {

  @Test(groups = {"smoke"})
  public void mentainingCreditorsMainTab() throws InterruptedException, ParseException, IOException {
    uniqueMaintenanceNumber= createCreditor();
    setCrNumber(uniqueMaintenanceNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    setAccountNumber(testdataprop.getProperty("crbankaccountnumber"));
    setAccountSortCode(testdataprop.getProperty("bankaccountcode"));
    setAccountName(testdataprop.getProperty("bankaccountname"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    validatetxtCreditorMaintenanceStatus(msgprop.getProperty("changed"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    validatetxtCreditorMaintenanceStatus(msgprop.getProperty("changedandreadyforsupervisor"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("authorise"));
    validatetxtCreditorMaintenanceStatus(msgprop.getProperty("authorise"));
    clickHrefLink(testdataprop.getProperty("home"));

    // signOut
    clickSignOut();
  }
}
