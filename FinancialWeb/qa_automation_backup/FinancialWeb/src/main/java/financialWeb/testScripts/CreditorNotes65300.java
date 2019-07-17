package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.pages.CreditorNotes;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.CreditorNotesWorkflow;

public class CreditorNotes65300 extends CreditorNotesWorkflow{
  
  @Test(groups = {"smoke"})
  public void  creatingNotesForCreditor() throws InterruptedException, ParseException, IOException, URISyntaxException {
            
    uniqueCreditorNumber= CreditorMaintenanceWorkflow.createCreditor();
    CreditorMaintenanceWorkflow.setCrNumber(uniqueCreditorNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("creditornotes"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addresstypeforinsertaddress"));
    setMsgForCreditor(testdataprop.getProperty("comment"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    searchText(testdataprop.getProperty("searchccractmaint"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchccractmaint"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchccrcreditormaint"));
    CreditorMaintenanceWorkflow.setCrNumber(uniqueCreditorNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("notes"));
    searchTableColumn(orprop.getProperty("findinvoicetable"),testdataprop.getProperty("creditortype"));
    searchTableColumn(orprop.getProperty("findinvoicetable"),uniqueCreditorNumber);
    searchTableColumn(orprop.getProperty("findinvoicetable"),CreditorNotes.getTxtMsg());
    
    
    clickHrefLink(testdataprop.getProperty("home"));
    
    //signOut
    clickSignOut();   
  }
}