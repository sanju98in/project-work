package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorVouchersSalesInvoicesWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import financialWeb.workflow.GLMaintenanceWorkflow;

public class GLMaintenance65143 extends GLMaintenanceWorkflow{
  
  @Test(groups = {"removedfromv19.5"})
  public void  addNoteInDetailCode() throws InterruptedException, ParseException, IOException, URISyntaxException {
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    verifyAndcreateDetailCodeDimension(testdataprop.getProperty("detailcodedimensions"),testdataprop.getProperty("detailcodedimensionsdesc"),testdataprop.getProperty("detailcodedimensionvalue"),testdataprop.getProperty("detailCodeDesc"),orprop.getProperty("detailcodetable"));
    analysisCode = createAnalysisCode(testdataprop.getProperty("detailcodeanalysis"),testdataprop.getProperty("detailcodedimensionsdesc"),testdataprop.getProperty("detailcodeanalysisdesc"));
    detailCode =createNewDetailCode();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("creditornotes"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("new"));
    randomComment=getRandomString();
    setGLNoteMessageForDetailsCode(randomComment);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addattachment"));
    parentHandle = driver.getWindowHandle();
    uploadNewAttachment();
    DebtorVouchersSalesInvoicesWorkflow.clickBrowseAndUploadFile();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    String searchForTab = testdataprop.get("notesfor").toString().trim() + detailCode.trim();
    searchForDetailCodeTab(orprop.getProperty("breadtable"),searchForTab);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submitnewinquiry"));
    validateGridIsAdded(orprop.getProperty("tablerevoverygroup"),randomComment);
    //signOut
    clickSignOut();   
  }
}