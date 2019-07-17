package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;

public class CreditorsMaintenance62474 extends CreditorMaintenanceWorkflow {

  @Test(groups = {"smoke"})
  public void creatingACreditorViaCRCreditorMaintenanceForm() throws InterruptedException, ParseException, IOException {
    createCreditor();
    // signOut
    clickSignOut();
  }
}
