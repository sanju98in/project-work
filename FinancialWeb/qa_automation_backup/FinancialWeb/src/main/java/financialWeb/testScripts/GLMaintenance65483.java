package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorVouchersSalesInvoicesWorkflow;
import financialWeb.workflow.GLMaintenanceWorkflow;

public class GLMaintenance65483 extends GLMaintenanceWorkflow{
  
  @Test(groups = {"smoke"})
  public void  addNotestIntoClassificationCode() throws InterruptedException, ParseException, IOException, URISyntaxException {
       
    classificationCode = createClassificationMaintenanceCode();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("creditornotes"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("new"));
    setRandomWebElementValue(msgprop.getProperty("lblmessage"), testdataprop.getProperty("creditornotes"));
    //CreditorNotesWorkflow.setUpdatedMsg(testdataprop.getProperty("creditornotes"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addattachment"));
    uploadNewAttachment();
    DebtorVouchersSalesInvoicesWorkflow.clickBrowseAndUploadFile();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    closePopup();
    String searchForTab = testdataprop.get("notesfor").toString().trim() + classificationCode.trim();
    searchAndClickTableData(orprop.getProperty("breadtable"),searchForTab);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submitnewinquiry"));
    validateGridIsAdded(orprop.getProperty("tablerevoverygroup"),classificationCode.trim());
    //signOut
    clickSignOut();   
  }
}

