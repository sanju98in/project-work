package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorVouchersSalesInvoicesWorkflow;
import financialWeb.workflow.GLMaintenanceWorkflow;

public class GLMaintenance65485 extends GLMaintenanceWorkflow{
  
  @Test(groups = {"smoke"})
  public void  amendNotestIntoClassificationCode() throws InterruptedException, ParseException, IOException, URISyntaxException {
       
    classificationCode = createClassificationMaintenanceCode();
    //steps to create note into classification code
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("creditornotes"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("new"));
    setRandomWebElementValue(msgprop.getProperty("lblmessage"), testdataprop.getProperty("creditornotes"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addattachment"));
    uploadNewAttachment();
    DebtorVouchersSalesInvoicesWorkflow.clickBrowseAndUploadFile();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    closePopup();
    String searchForTab = testdataprop.getProperty("notesfor").toString().trim() + classificationCode.trim() + " ";
    searchAndClickTableData(orprop.getProperty("breadtable"),searchForTab);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submitnewinquiry"));
    validateGridIsAdded(orprop.getProperty("tablerevoverygroup"),classificationCode.trim());
    
    //steps to amend note into classification code maintenance
    searchAndClickTableData(orprop.getProperty("breadtable"),testdataprop.getProperty("glclassificationcodemainttab"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("creditornotes"));
    searchAndClickTableData(orprop.getProperty("glclassificationnote"),testdataprop.getProperty("creditornotes"));
    setRandomWebElementValue(msgprop.getProperty("lblmessage"), testdataprop.getProperty("updatesnotes"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    closePopup();
    searchAndClickTableData(orprop.getProperty("breadtable"),searchForTab);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submitnewinquiry"));
    validateGridIsAdded(orprop.getProperty("finddebtorstablebody"),testdataprop.getProperty("updatesnotes"));
    //signOut
    clickSignOut();   
  }
}
