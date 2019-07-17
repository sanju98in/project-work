package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import financialWeb.workflow.GLEnquiriesWorkflow;
import financialWeb.workflow.GLMaintenanceWorkflow;

public class GLEnquiries65542 extends GLEnquiriesWorkflow{
  
  @Test(groups = {"smoke"})
  public void  amendExistingCodeLevelEnquiries() throws InterruptedException, ParseException, IOException, URISyntaxException {
    
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    
    GLMaintenanceWorkflow.verifyAndcreateControlData(testdataprop.getProperty("controldataset"),
        testdataprop.getProperty("detailcodedimensionvalue"),
        testdataprop.getProperty("searchorcreatecontroldata"),
        orprop.getProperty("tablecontroldatamaintenance"));
    
    GLMaintenanceWorkflow.verifyAndCreateCostCenterDimensions(testdataprop.getProperty("searchorcreatecontroldata"),
        testdataprop.getProperty("detailcodedimensionvalue"),
        testdataprop.getProperty("costcentredimensiondesc"));
    
    analysisCode=GLMaintenanceWorkflow.createCostCentreAnalysis(testdataprop.getProperty("costcentreanalysissetcode"),
      testdataprop.getProperty("testcostcentredimensiondesc"),
      testdataprop.getProperty("costcentreanalysisdesc"));

    costCentreCode =GLMaintenanceWorkflow.createGLCostCenter();
    
    String enquiryName = createCodeLevelEnquiry();

    waitforPanelLoad();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("clear"));
    findHighLevelEnquiryName(enquiryName);
    setHighLevelDesctiption(testdataprop.getProperty("glhighlevelenquirydesc"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    validateHighLevelDesctiption(testdataprop.getProperty("glhighlevelenquirydesc"));
    
    //signOut
    clickSignOut();
      
  }
}