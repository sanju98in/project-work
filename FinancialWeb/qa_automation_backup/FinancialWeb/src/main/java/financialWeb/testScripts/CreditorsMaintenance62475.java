package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;

public class CreditorsMaintenance62475 extends CreditorMaintenanceWorkflow {

  @Test(groups = {"smoke"})
  public void createCreditorUsingInsertCreditors() throws InterruptedException, ParseException, IOException {
    createCreditor(
        testdataprop.getProperty("name"), testdataprop.getProperty("testpaymentmethod"),
        testdataprop.getProperty("printmethod"), testdataprop.getProperty("emailaddress"),
        testdataprop.getProperty("accesslevel3"),
        testdataprop.getProperty("locationwithincouncilboundary"),
        testdataprop.getProperty("companytypeofcreditor"),
        testdataprop.getProperty("defaultaddcode"), testdataprop.getProperty("defaultaddtype"),
        testdataprop.getProperty("newadd"), testdataprop.getProperty("updatedefaultpostcode"));
    searchText(testdataprop.getProperty("searchccrcreditormaint"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchccrcreditormaint"));
    DebtorMaintenanceWorkflow.setCreditorNumber(uniqueMaintenanceNumber);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    validateInsertCustomerName(testdataprop.getProperty("name"));
    validateCRInsertEmailAddress(testdataprop.getProperty("emailaddress"));
    validateInsertCreditorStatus(testdataprop.getProperty("newreadytosuprvcreditorstatus"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("authorise"));
    validateCrMaintenanceStatus(testdataprop.getProperty("authorisedcreditorstatus"));
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
