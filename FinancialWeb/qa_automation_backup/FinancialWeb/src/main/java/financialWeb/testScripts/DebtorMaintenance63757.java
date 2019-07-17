package financialWeb.testScripts;
import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;


public class DebtorMaintenance63757 extends DebtorMaintenanceWorkflow{

 @Test(groups = {"smoke"})
   public void amendingAddressForDebtor() throws InterruptedException, ParseException, IOException {
        
    createDebtor();
    CreditorMaintenanceWorkflow.setCreditorNumber(uniqueMaintenanceNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    insertAdd();
    //callEvent(orprop.getProperty("button"),testdataprop.getProperty("insertaddress"));
    setFirstNameForDbInsertDebtor(testdataprop.getProperty("addresscodeforinsertaddress"));
    CreditorMaintenanceWorkflow.setAddressType(testdataprop.getProperty("addresstypeforinsertaddress"));
    insertAddress();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("manualaddress")); 
    
    // set value for Name At Address  
    setFirstName(testdataprop.getProperty("firstname"));
    
    // Insert Value for Address lines
    updateAddressDetailsForDebtorMaintenance(
        testdataprop.getProperty("newadd"),
        testdataprop.getProperty("addressline2"),
        testdataprop.getProperty("addressline3"),
        testdataprop.getProperty("addressline4"),
        testdataprop.getProperty("country"),
        testdataprop.getProperty("postcode"));
        
    // set value for telephone number description
    setVatCode(testdataprop.getProperty("home"));
    
    // set value for telephonenumber1
    telephoneNumber= getRandomNumber(testdataprop.getProperty("rndtelephonelimit"));
    setNameAtAddress(telephoneNumber); 
    
    // set value for mobile number description
    setTelephoneNumberDesc(testdataprop.getProperty("telephonenumberdesc"));
    
    mobileNumber = getRandomNumber(testdataprop.getProperty("rndtelephonelimit"));
    setAddressLine2ForDbInsertDebtor(mobileNumber);
    
    // set value for alternate number description
    setalternateTelephoneNumberDesc(testdataprop.getProperty("alternatetelephonedec"));
    
    alternateNumber= getRandomNumber(testdataprop.getProperty("rndtelephonelimit"));
    setAddressLine4ForDbInsertDebtor(alternateNumber);
    
    //set value for email
    setCountryForDbInsertDebtor(testdataprop.getProperty("emailaddress"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert")); 
    searchAndClickLatestRecordInTable(orprop.getProperty("tableaddress"),testdataprop.getProperty("newadd"));
    setFirstName(testdataprop.getProperty("updatedfirstname"));
    setComment(testdataprop.getProperty("comment"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    CreditorMaintenanceWorkflow.validateTableData(orprop.getProperty("tableaddress"),firstName);
    CreditorMaintenanceWorkflow.validateTableData(orprop.getProperty("tableaddress"),comment);  
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    validateDebtorMaintenanceStatus(testdataprop.getProperty("completestatus"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("authorise"));
    validateDebtorMaintenanceStatus(testdataprop.getProperty("authorisedstatus"));
    clickHrefLink(testdataprop.getProperty("home"));
       
    //signOut
    clickSignOut();    
  }
}