package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.pages.DebtorsNotes;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorVouchersSalesInvoicesWorkflow;
import financialWeb.workflow.DebtorsNotesWorkflow;

public class DebtorsNotes65114 extends DebtorsNotesWorkflow{
  
  @Test(groups = {"smoke"})
  public void  createDebtorNotesWithReminderAndAttachment() throws InterruptedException, ParseException, IOException, URISyntaxException {
            
    uniqueMaintenanceNumber= DebtorMaintenanceWorkflow.createDebtor();
    CreditorMaintenanceWorkflow.setCrNumber(uniqueMaintenanceNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("notes"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addresstypeforinsertaddress"));    
    setTxtMsgField(testdataprop.getProperty("msgfieldforinvoice"));
    setReminder();
    DebtorsNotes.setReminderDate();
    parentHandle = driver.getWindowHandle();
    DebtorVouchersSalesInvoicesWorkflow.setNextDate();
    setSendToSelfChkBox();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addattachment"));
    uploadNewAttachment();
    DebtorVouchersSalesInvoicesWorkflow.clickBrowseAndUploadFile();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    clickDbNotesDebtorTab();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submitnewinquiry"));
    searchTableColumn(orprop.getProperty("findinvoicetable"),testdataprop.getProperty("typeofnote"));
    searchTableColumn(orprop.getProperty("findinvoicetable"),uniqueMaintenanceNumber);
    searchTableColumn(orprop.getProperty("findinvoicetable"),DebtorsNotes.getTxtMsg());
    searchTableColumn(orprop.getProperty("findinvoicetable"),DebtorsNotes.getTxtReminderDate());
    clickHrefLink(testdataprop.getProperty("home"));
    
    //signOut
    clickSignOut();   
  }
}