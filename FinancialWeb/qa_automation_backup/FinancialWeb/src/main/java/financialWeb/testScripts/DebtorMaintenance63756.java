package financialWeb.testScripts;
import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;


public class DebtorMaintenance63756 extends DebtorMaintenanceWorkflow{

  @Test(groups = {"smoke"})
  public void creatingNewAddressForDebtor() throws InterruptedException, ParseException, IOException {
        
    uniqueDebtorNumber = createDebtor();
    CreditorMaintenanceWorkflow.setCreditorNumber(uniqueDebtorNumber);
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
        testdataprop.getProperty("updatedefaultadd"),
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
    
    // set value for telephone number description
    setTelephoneNumberDesc(testdataprop.getProperty("telephonenumberdesc"));
    
    // set value for telephonenumber2
    mobileNumber = getRandomNumber(testdataprop.getProperty("rndtelephonelimit"));
    setAddressLine2ForDbInsertDebtor(mobileNumber);
    
    // set value for telephone number description
    setalternateTelephoneNumberDesc(testdataprop.getProperty("alternatetelephonedec"));
    
    //set value for telephonenumber3
    alternateNumber= getRandomNumber(testdataprop.getProperty("rndtelephonelimit"));
    setAddressLine4ForDbInsertDebtor(alternateNumber);
    
    //set value for email
    setCountryForDbInsertDebtor(testdataprop.getProperty("emailaddress"));
    
    //set value for website
    setWebsiteForInsertAddress(testdataprop.getProperty("website"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert")); 
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    validateDebtorMaintenanceStatus(testdataprop.getProperty("completestatus"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("authorise"));
    validateDebtorMaintenanceStatus(testdataprop.getProperty("authorisedstatus"));
    clickHrefLink(testdataprop.getProperty("home"));
       
    //signOut
    clickSignOut();    
  }
}