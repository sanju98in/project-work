package financialWeb.testScripts;
import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;


public class DebtorMaintenance63759 extends DebtorMaintenanceWorkflow{

  @Test(groups = {"smoke"})
  public void creatingNewContactForDebtor() throws InterruptedException, ParseException, IOException {
        
    uniqueDebtorNumber = createDebtor();
    CreditorMaintenanceWorkflow.setCreditorNumber(uniqueDebtorNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    insertContact();
    //callEvent(orprop.getProperty("button"),testdataprop.getProperty("insertcontact"));
    
    // set contact name for insert contact
    setTitleForDbInsertDebtor(testdataprop.getProperty("contactname"));
    
    // set job title for insert contact
    setFirstNameForDbInsertDebtor(testdataprop.getProperty("jobtitle"));
    
    // set value for telephone number description
    setTypeOfDebtorForDbInsertDebtor(testdataprop.getProperty("home"));
    
    telephoneNumber= getRandomNumber(testdataprop.getProperty("rndtelephonelimit"));
    setTelephonenumForInsertContact(telephoneNumber); 
    
    // set value for mobile number description
    setTypeOfDebtor(testdataprop.getProperty("telephonenumberdesc"));
    
    mobileNumber = getRandomNumber(testdataprop.getProperty("rndtelephonelimit"));
    setMobilenumForInsertContact(mobileNumber);
    
    // set value for alternate number description
    CreditorMaintenanceWorkflow.setInsertAccessLevel(testdataprop.getProperty("alternatetelephonedec"));

    alternateNumber= getRandomNumber(testdataprop.getProperty("rndtelephonelimit"));
    setAlternateNumber(alternateNumber);
    setEmailForInsertContact(testdataprop.getProperty("emailaddress"));
    setCommentsForInsertContact(testdataprop.getProperty("comment"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    CreditorMaintenanceWorkflow.validateTableData(orprop.getProperty("contacttable"),contactName);
    CreditorMaintenanceWorkflow.validateTableData(orprop.getProperty("contacttable"),addressCode);
    CreditorMaintenanceWorkflow.validateTableData(orprop.getProperty("contacttable"),testdataprop.getProperty("emailaddress"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    validateDebtorMaintenanceStatus(testdataprop.getProperty("completestatus"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("authorise"));
    validateDebtorMaintenanceStatus(testdataprop.getProperty("authorisedstatus"));
    clickHrefLink(testdataprop.getProperty("home"));
       
    //signOut
    clickSignOut();    
  }
}