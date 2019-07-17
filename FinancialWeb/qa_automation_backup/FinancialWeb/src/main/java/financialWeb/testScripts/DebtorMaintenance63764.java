package financialWeb.testScripts;
import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;


public class DebtorMaintenance63764 extends DebtorMaintenanceWorkflow{

  @Test(groups = {"removedfromv19.5"})
  public void maintainDebtorTabs() throws InterruptedException, ParseException, IOException {
        
    createDebtor();
    CreditorMaintenanceWorkflow.setCreditorNumber(uniqueMaintenanceNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    setFirstName(testdataprop.getProperty("updatedfirstname"));
    updateTypeOfDebtor(testdataprop.getProperty("updatedtypeofdebtor"));
    setAccessLevelValue(testdataprop.getProperty("accesslevel3"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("debtordetails"));
    CreditorMaintenanceWorkflow.setTelDescription(testdataprop.getProperty("paymentterms"));
    setVatCode(testdataprop.getProperty("vatcode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("suspenddetails"));
    checkSuspendRecoveryCheckBox();
    CreditorMaintenanceWorkflow.setAddressType(testdataprop.getProperty("reason"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("emailorfaxoptions"));
    checkAllEmailOrFaxOptionsCheckbox();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("interestdetails"));
    CreditorMaintenanceWorkflow.setAddressType(testdataprop.getProperty("interesttype"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("defaultaddtype "));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    validateDebtorMaintenanceStatus(testdataprop.getProperty("completestatus"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("authorise"));
    validateDebtorMaintenanceStatus(testdataprop.getProperty("authorisedstatus"));
    clickHrefLink(testdataprop.getProperty("home"));
       
    //signOut
    clickSignOut();    
  }
}