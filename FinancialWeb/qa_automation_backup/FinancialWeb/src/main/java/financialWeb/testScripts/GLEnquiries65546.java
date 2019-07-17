package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import financialWeb.workflow.GLEnquiriesWorkflow;
import financialWeb.workflow.GLMaintenanceWorkflow;

public class GLEnquiries65546 extends GLEnquiriesWorkflow{
  
  @Test(groups = {"smoke"})
  public void  createLedgerCodeEnquiries() throws InterruptedException, ParseException, IOException, URISyntaxException {
    
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
    
    GLMaintenanceWorkflow.verifyAndcreateDetailCodeDimension(testdataprop.getProperty("detailcodedimensions"),
        testdataprop.getProperty("detailcodedimensionsdesc"),
        testdataprop.getProperty("detailcodedimensionvalue"),
        testdataprop.getProperty("detailCodeDesc"),
        orprop.getProperty("detailcodetable"));
    
    analysisCode = GLMaintenanceWorkflow.createAnalysisCode(testdataprop.getProperty("detailcodeanalysis"),
        testdataprop.getProperty("detailcodedimensionsdesc"),
        testdataprop.getProperty("detailcodeanalysisdesc"));
    
    detailCode = GLMaintenanceWorkflow.createNewDetailCode();
    
    GLMaintenanceWorkflow.createClassificationMaintenanceCode();
    
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