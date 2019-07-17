package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;

public class CreditorsMaintenance62493 extends CreditorMaintenanceWorkflow {

  @Test(groups = {"smoke"})
  public void mantainCreditorOtherDetailsTab() throws InterruptedException, ParseException, IOException {
    uniqueMaintenanceNumber= createCreditor();
    setCrNumber(uniqueMaintenanceNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    selectCreditorDetailsTab(testdataprop.getProperty("purchasingdetails"));
    //callEvent(orprop.getProperty("button"),testdataprop.getProperty("purchasingdetails"));
    isPurchasingSupplierPresent();
    selectCreditorDetailsTab(testdataprop.getProperty("otherdetails"));
    //callEvent(orprop.getProperty("button"),testdataprop.getProperty("otherdetails"));
    setOtherEmailAddress(testdataprop.getProperty("emailaddress"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    selectCreditorDetailsTab(testdataprop.getProperty("defaultaddtype"));
    validateStatus(msgprop.getProperty("changed"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    validateStatus(msgprop.getProperty("changedandreadyforsupervisor"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("authorise"));
    validateStatus(msgprop.getProperty("authorise"));
    
    clickHrefLink(testdataprop.getProperty("home"));

    // signOut
    clickSignOut();
  }
}
