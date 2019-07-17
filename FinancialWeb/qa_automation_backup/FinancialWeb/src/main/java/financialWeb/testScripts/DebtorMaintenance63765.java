package financialWeb.testScripts;
import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;


public class DebtorMaintenance63765 extends DebtorMaintenanceWorkflow{

  @Test(groups = {"removedfromv19.5"})
  public void viewTheUpdatedChangesOfDebtor() throws InterruptedException, ParseException, IOException {
        
    createDebtor();
    CreditorMaintenanceWorkflow.setCreditorNumber(uniqueMaintenanceNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    setFirstName(testdataprop.getProperty("updatedfirstname"));
    updateTypeOfDebtor(testdataprop.getProperty("updatedtypeofdebtor"));
    setAccessLevelValue(testdataprop.getProperty("accesslevel3"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    validateDebtorMaintenanceStatus(testdataprop.getProperty("validatedebtormaintenanceStatus"));
    validateErrorMsg();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    validateDebtorMaintenanceStatus(testdataprop.getProperty("completestatus"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("authorise"));
    validateDebtorMaintenanceStatus(testdataprop.getProperty("authorisedstatus"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("viewchanges"));
    verifyUpdatedFields();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    verifyActionColumn();
    verifyTypeColumn();  
    clickHrefLink(testdataprop.getProperty("home"));
       
    //signOut
    clickSignOut();    
  }
}