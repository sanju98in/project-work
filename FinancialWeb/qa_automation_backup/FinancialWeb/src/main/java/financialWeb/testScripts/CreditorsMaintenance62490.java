package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;

public class CreditorsMaintenance62490 extends CreditorMaintenanceWorkflow {

  @Test(groups = {"removedfromv19.5"})
  public void mantainCreditorsCheckListTabAndCISDetails() throws InterruptedException, ParseException, IOException {
    uniqueMaintenanceNumber= createCreditor();
    setCrNumber(uniqueMaintenanceNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("checklistflags"));
    setLiableReason(testdataprop.getProperty("liablereason"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("cisdetails"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("defaultaddtype"));
    validateCreditStatus(msgprop.getProperty("changed"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    validateCreditStatus(msgprop.getProperty("changedandreadyforsupervisor"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("authorise"));
    validateCreditStatus(msgprop.getProperty("authorise"));
    clickHrefLink(testdataprop.getProperty("home"));

    // signOut
    clickSignOut();
  }
}
