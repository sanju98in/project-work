package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;

public class CreditorsMaintenance62498 extends CreditorMaintenanceWorkflow{

  @Test(groups = {"smoke"})
  public void deletingAnAddress() throws InterruptedException, ParseException, IOException {
    createCreditor();
    setCreditorNumber(uniqueMaintenanceNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    insertAdd();
    //callEvent(orprop.getProperty("button"),testdataprop.getProperty("insertaddress"));
    //setContactName method has the same locator of address code
    setContactName(testdataprop.getProperty("addresscode"));
    setAddressType(testdataprop.getProperty("addresstype"));
    insertAddress();
    postCode = getRandomNumber(testdataprop.getProperty("rndfieldlimit"));
    setPostCode(postCode);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("manualaddress"));
    UpdateDefaultAddedAddress(testdataprop.getProperty("newadd"));
    UpdateDefaultAddedPostCode(testdataprop.getProperty("updatedefaultpostcode"));
    setAddComment(testdataprop.getProperty("comment"));
    UpdateDefaultAddedEmailAddress(testdataprop.getProperty("emailaddress"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    searchAndClickLatestRecordInTable(orprop.getProperty("addresstable"),testdataprop.getProperty("delete"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("delete"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    validateStatus(testdataprop.getProperty("readytosuprvcreditorstatus"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("authorise"));
    validateStatus(testdataprop.getProperty("authorisedcreditorstatus"));
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();
    }
}
