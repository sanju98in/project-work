package financialWeb.testScripts;

import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.DebtorChargeCodeMaintenanceWorkflow;


public class CreditorsMaintenance64598 extends CreditorMaintenanceWorkflow{

  @Test(groups = {"smoke"})
  public void findCreditorUsingSearchFunctionality() throws Exception {
    uniqueCreditorNumber= createCreditor();
    findCreditorNumber();
    DebtorChargeCodeMaintenanceWorkflow.setDBfindChargeCode(uniqueCreditorNumber);
    setCreditorName(testdataprop.getProperty("name"));
    setCreditorAddress(testdataprop.getProperty("updatedefaultadd"));
    setCreditorPostCode(testdataprop.getProperty("updatedefaultpostcode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    searchTableColumn(orprop.getProperty("finddebtorstable"), uniqueCreditorNumber);
    searchTableColumn(orprop.getProperty("finddebtorstable"), testdataprop.getProperty("name"));
    searchTableColumn(orprop.getProperty("finddebtorstable"), testdataprop.getProperty("updatedefaultadd"));
    searchTableColumn(orprop.getProperty("finddebtorstable"), testdataprop.getProperty("updatedefaultpostcode"));
    
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();
  }
}
