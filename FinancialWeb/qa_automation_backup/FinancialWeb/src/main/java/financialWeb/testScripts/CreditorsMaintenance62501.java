package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;

public class CreditorsMaintenance62501 extends CreditorMaintenanceWorkflow{

  @Test(groups = {"smoke"})
  public void createNewContact() throws InterruptedException, ParseException, IOException {

    createCreditor();
    setCreditorNumber(uniqueMaintenanceNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    insertContact();
    //callEvent(orprop.getProperty("button"),testdataprop.getProperty("insertcontact"));
    setContactName(testdataprop.getProperty("name"));
    setJobTitle(testdataprop.getProperty("jobtitle"));
    setTelDescription(testdataprop.getProperty("home"));
    telephoneNumber= getRandomNumber(testdataprop.getProperty("rndtelephonelimit"));
    setTelehoneNumber(telephoneNumber);
    setInsertContactEmailAddress(testdataprop.getProperty("emailaddress"));
    setComment(testdataprop.getProperty("comment"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    validateTableData(orprop.getProperty("contacttable"),testdataprop.getProperty("name"));
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();
  }
}
