package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.pages.DebtorVouchersSalesInvoices;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorVouchersSalesInvoicesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;

public class DebtorsVouchers64277 extends DebtorVouchersSalesInvoicesWorkflow{
  

  @Test(groups = {"smoke"}) 
  public void addNotesWithAttachmenttoDBInvoice() throws InterruptedException, ParseException, IOException, URISyntaxException {
        
    DebtorMaintenanceWorkflow.createDebtor();
    DebtorsVouchersWorkflow.createDBInvoice();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("notes"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addresstypeforinsertaddress"));
    setMsgField(testdataprop.getProperty("msgfieldforinvoice"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addattachment"));
    uploadNewAttachment();
    clickBrowseAndUploadFile();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    clickDbNotesTab();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submitnewinquiry"));
    searchTableColumn(orprop.getProperty("finddebtorstable"),testdataprop.getProperty("invoice"));
    searchTableColumn(orprop.getProperty("finddebtorstable"),referenceNo);
    String notes = DebtorVouchersSalesInvoices.getTxtMsg();
    searchTableColumn(orprop.getProperty("finddebtorstable"),notes);
    clickHrefLink(testdataprop.getProperty("home"));
       
    //signOut
    clickSignOut();    
  }
}