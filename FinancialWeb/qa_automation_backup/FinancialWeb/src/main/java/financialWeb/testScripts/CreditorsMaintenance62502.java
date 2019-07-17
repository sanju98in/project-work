package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;


public class CreditorsMaintenance62502 extends CreditorMaintenanceWorkflow{

  @Test(groups = {"smoke"})
  public void amendingContact() throws InterruptedException, ParseException, IOException {
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
    validateAndClickTableData(orprop.getProperty("contacttable"),testdataprop.getProperty("name"));
    setContactName(testdataprop.getProperty("updatedname"));
    setComment(testdataprop.getProperty("updatedcomment"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    validateTableData(orprop.getProperty("contacttable"),testdataprop.getProperty("updatedname"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    validateStatus(testdataprop.getProperty("readytosuprvcreditorstatus"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("authorise"));
    validateStatus(testdataprop.getProperty("authorisedcreditorstatus"));
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();
  }
}
