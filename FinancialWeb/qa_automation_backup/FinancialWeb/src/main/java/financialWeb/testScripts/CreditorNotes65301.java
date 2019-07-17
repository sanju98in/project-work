package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.pages.CreditorNotes;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.CreditorNotesWorkflow;

public class CreditorNotes65301 extends CreditorNotesWorkflow{
  
  @Test(groups = {"smoke"})
  public void  amendingNotesForCreditor() throws InterruptedException, ParseException, IOException, URISyntaxException {
            
    uniqueMaintenanceNumber= CreditorMaintenanceWorkflow.createCreditor();
    CreditorMaintenanceWorkflow.setCrNumber(uniqueMaintenanceNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("creditornotes"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addresstypeforinsertaddress"));
    setMsgForCreditor(testdataprop.getProperty("comment"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    searchText(testdataprop.getProperty("searchccractmaint"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchccractmaint"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchccrcreditormaint"));
    CreditorMaintenanceWorkflow.setCrNumber(uniqueMaintenanceNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("notes"));
    searchAndClickLatestRecordInTable(orprop.getProperty("findinvoicetable"),CreditorNotes.getTxtMsg());  
    setUpdatedMsg(testdataprop.getProperty("updatedcomment"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));    
    clickHrefLink(testdataprop.getProperty("home"));   
    //signOut
    clickSignOut();   
  }
}